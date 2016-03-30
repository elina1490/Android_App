package com.google.appinventor.components.runtime;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.common.ComponentCategory;
import java.lang.reflect.Array;
import java.util.List;

@DesignerComponent(category=ComponentCategory.INTERNAL, description="Component that can count steps.", iconName="images/pedometer.png", nonVisible=true, version=1)
@SimpleObject
@UsesPermissions(permissionNames="android.permission.ACCESS_FINE_LOCATION")
public class Pedometer extends AndroidNonvisibleComponent
  implements Component, LocationListener, SensorEventListener, Deleteable
{
  private static final int DIMENSIONS = 3;
  private static final int INTERVAL_VARIATION = 250;
  private static final int MIN_SATELLITES = 4;
  private static final int NUM_INTERVALS = 2;
  private static final float PEAK_VALLEY_RANGE = 4.0F;
  private static final String PREFS_NAME = "PedometerPrefs";
  private static final float STRIDE_LENGTH = 0.73F;
  private static final String TAG = "Pedometer";
  private static final int WIN_SIZE = 20;
  private boolean calibrateSteps;
  private final Context context;
  private Location currentLocation;
  private float distWhenGPSLost;
  private long elapsedTimestamp;
  private boolean firstGpsReading;
  private boolean foundNonStep;
  private boolean[] foundValley;
  private boolean gpsAvailable;
  private float gpsDistance;
  private long gpsStepTime;
  private int intervalPos = 0;
  private int lastNumSteps = 0;
  private float[] lastValley = new float[3];
  private float[][] lastValues;
  private final LocationManager locationManager;
  private Location locationWhenGPSLost;
  private int numStepsRaw = 0;
  private int numStepsWithFilter = 0;
  private int[] peak = new int[3];
  private boolean pedometerPaused;
  private float[] prevDiff;
  private Location prevLocation;
  private long prevStopClockTime;
  private final SensorManager sensorManager;
  private boolean startPeaking;
  private long startTime;
  private boolean statusMoving;
  private long[] stepInterval;
  private long stepTimestamp;
  private int stopDetectionTimeout = 2000;
  private float strideLength;
  private float totalDistance;
  private boolean useGps;
  private int[] valley = new int[3];
  private int winPos = 0;

  public Pedometer(ComponentContainer paramComponentContainer)
  {
    super(paramComponentContainer.$form());
    int[] arrayOfInt = { 20, 3 };
    this.lastValues = ((float[][])Array.newInstance(Float.TYPE, arrayOfInt));
    this.prevDiff = new float[3];
    this.strideLength = 0.73F;
    this.totalDistance = 0.0F;
    this.distWhenGPSLost = 0.0F;
    this.gpsDistance = 0.0F;
    this.stepInterval = new long[2];
    this.stepTimestamp = 0L;
    this.elapsedTimestamp = 0L;
    this.startTime = 0L;
    this.prevStopClockTime = 0L;
    this.gpsStepTime = 0L;
    this.foundValley = new boolean[3];
    this.startPeaking = false;
    this.foundNonStep = true;
    this.gpsAvailable = false;
    this.calibrateSteps = true;
    this.pedometerPaused = true;
    this.useGps = true;
    this.statusMoving = false;
    this.firstGpsReading = true;
    this.context = paramComponentContainer.$context();
    this.winPos = 0;
    this.startPeaking = false;
    this.numStepsWithFilter = 0;
    this.numStepsRaw = 0;
    this.firstGpsReading = true;
    this.gpsDistance = 0.0F;
    for (int i = 0; i < 3; i++)
    {
      this.foundValley[i] = true;
      this.lastValley[i] = 0.0F;
    }
    this.sensorManager = ((SensorManager)this.context.getSystemService("sensor"));
    this.locationManager = ((LocationManager)this.context.getSystemService("location"));
    this.locationManager.requestLocationUpdates("gps", 0L, 0.0F, this);
    SharedPreferences localSharedPreferences = this.context.getSharedPreferences("PedometerPrefs", 0);
    this.strideLength = localSharedPreferences.getFloat("Pedometer.stridelength", 0.73F);
    this.totalDistance = localSharedPreferences.getFloat("Pedometer.distance", 0.0F);
    this.numStepsRaw = localSharedPreferences.getInt("Pedometer.prevStepCount", 0);
    this.prevStopClockTime = localSharedPreferences.getLong("Pedometer.clockTime", 0L);
    this.numStepsWithFilter = this.numStepsRaw;
    this.startTime = System.currentTimeMillis();
    Log.d("Pedometer", "Pedometer Created");
  }

  private boolean areStepsEquallySpaced()
  {
    float f1 = 0.0F;
    int i = 0;
    for (long l : this.stepInterval)
      if (l > 0L)
      {
        i++;
        f1 += (float)l;
      }
    float f2 = f1 / i;
    long[] arrayOfLong2 = this.stepInterval;
    int m = arrayOfLong2.length;
    for (int n = 0; n < m; n++)
      if (Math.abs((float)arrayOfLong2[n] - f2) > 250.0F)
        return false;
    return true;
  }

  private void getPeak()
  {
    int i = (10 + this.winPos) % 20;
    int j = 0;
    if (j < 3)
    {
      this.peak[j] = i;
      for (int k = 0; ; k++)
        if (k < 20)
        {
          if ((k != i) && (this.lastValues[k][j] >= this.lastValues[i][j]))
            this.peak[j] = -1;
        }
        else
        {
          j++;
          break;
        }
    }
  }

  private void getValley()
  {
    int i = (10 + this.winPos) % 20;
    int j = 0;
    if (j < 3)
    {
      this.valley[j] = i;
      for (int k = 0; ; k++)
        if (k < 20)
        {
          if ((k != i) && (this.lastValues[k][j] <= this.lastValues[i][j]))
            this.valley[j] = -1;
        }
        else
        {
          j++;
          break;
        }
    }
  }

  private void setGpsAvailable(boolean paramBoolean)
  {
    if ((!this.gpsAvailable) && (paramBoolean))
    {
      this.gpsAvailable = true;
      GPSAvailable();
    }
    while ((!this.gpsAvailable) || (paramBoolean))
      return;
    this.gpsAvailable = false;
    GPSLost();
  }

  @DesignerProperty(defaultValue="true", editorType="boolean")
  @SimpleProperty(category=PropertyCategory.BEHAVIOR)
  public void CalibrateStrideLength(boolean paramBoolean)
  {
    if ((!this.gpsAvailable) && (paramBoolean))
    {
      CalibrationFailed();
      return;
    }
    if (paramBoolean)
      this.useGps = true;
    this.calibrateSteps = paramBoolean;
  }

  @SimpleProperty
  public boolean CalibrateStrideLength()
  {
    return this.calibrateSteps;
  }

  @SimpleEvent
  public void CalibrationFailed()
  {
    EventDispatcher.dispatchEvent(this, "CalibrationFailed", new Object[0]);
  }

  @SimpleProperty(category=PropertyCategory.BEHAVIOR)
  public float Distance()
  {
    return this.totalDistance;
  }

  @SimpleProperty(category=PropertyCategory.BEHAVIOR)
  public long ElapsedTime()
  {
    if (this.pedometerPaused)
      return this.prevStopClockTime;
    return this.prevStopClockTime + (System.currentTimeMillis() - this.startTime);
  }

  @SimpleEvent
  public void GPSAvailable()
  {
    EventDispatcher.dispatchEvent(this, "GPSAvailable", new Object[0]);
  }

  @SimpleEvent
  public void GPSLost()
  {
    EventDispatcher.dispatchEvent(this, "GPSLost", new Object[0]);
  }

  @SimpleProperty(category=PropertyCategory.BEHAVIOR)
  public boolean Moving()
  {
    return this.statusMoving;
  }

  @SimpleFunction
  public void Pause()
  {
    if (!this.pedometerPaused)
    {
      this.pedometerPaused = true;
      this.statusMoving = false;
      this.sensorManager.unregisterListener(this);
      Log.d("Pedometer", "Unregistered listener on pause");
      this.prevStopClockTime += System.currentTimeMillis() - this.startTime;
    }
  }

  @SimpleFunction
  public void Reset()
  {
    this.numStepsWithFilter = 0;
    this.numStepsRaw = 0;
    this.totalDistance = 0.0F;
    this.calibrateSteps = false;
    this.prevStopClockTime = 0L;
    this.startTime = System.currentTimeMillis();
  }

  @SimpleFunction
  public void Resume()
  {
    Start();
  }

  @SimpleFunction(description="Saves the pedometer state to the phone")
  public void Save()
  {
    SharedPreferences.Editor localEditor = this.context.getSharedPreferences("PedometerPrefs", 0).edit();
    localEditor.putFloat("Pedometer.stridelength", this.strideLength);
    localEditor.putFloat("Pedometer.distance", this.totalDistance);
    localEditor.putInt("Pedometer.prevStepCount", this.numStepsRaw);
    if (this.pedometerPaused)
      localEditor.putLong("Pedometer.clockTime", this.prevStopClockTime);
    while (true)
    {
      localEditor.putLong("Pedometer.closeTime", System.currentTimeMillis());
      localEditor.commit();
      Log.d("Pedometer", "Pedometer state saved.");
      return;
      localEditor.putLong("Pedometer.clockTime", this.prevStopClockTime + (System.currentTimeMillis() - this.startTime));
    }
  }

  @SimpleEvent(description="This event is run when a raw step is detected")
  public void SimpleStep(int paramInt, float paramFloat)
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Integer.valueOf(paramInt);
    arrayOfObject[1] = Float.valueOf(paramFloat);
    EventDispatcher.dispatchEvent(this, "SimpleStep", arrayOfObject);
  }

  @SimpleFunction
  public void Start()
  {
    if (this.pedometerPaused)
    {
      this.pedometerPaused = false;
      this.sensorManager.registerListener(this, (Sensor)this.sensorManager.getSensorList(1).get(0), 0);
      this.startTime = System.currentTimeMillis();
    }
  }

  @SimpleEvent
  public void StartedMoving()
  {
    EventDispatcher.dispatchEvent(this, "StartedMoving", new Object[0]);
  }

  @SimpleFunction
  public void Stop()
  {
    Pause();
    this.locationManager.removeUpdates(this);
    this.useGps = false;
    this.calibrateSteps = false;
    setGpsAvailable(false);
  }

  @SimpleProperty
  public int StopDetectionTimeout()
  {
    return this.stopDetectionTimeout;
  }

  @DesignerProperty(defaultValue="2000", editorType="non_negative_integer")
  @SimpleProperty(category=PropertyCategory.BEHAVIOR)
  public void StopDetectionTimeout(int paramInt)
  {
    this.stopDetectionTimeout = paramInt;
  }

  @SimpleEvent
  public void StoppedMoving()
  {
    EventDispatcher.dispatchEvent(this, "StoppedMoving", new Object[0]);
  }

  @SimpleProperty
  public float StrideLength()
  {
    return this.strideLength;
  }

  @DesignerProperty(defaultValue="0.73", editorType="non_negative_float")
  @SimpleProperty(category=PropertyCategory.BEHAVIOR)
  public void StrideLength(float paramFloat)
  {
    CalibrateStrideLength(false);
    this.strideLength = paramFloat;
  }

  @DesignerProperty(defaultValue="true", editorType="boolean")
  @SimpleProperty(category=PropertyCategory.BEHAVIOR)
  public void UseGPS(boolean paramBoolean)
  {
    if ((!paramBoolean) && (this.useGps))
      this.locationManager.removeUpdates(this);
    while (true)
    {
      this.useGps = paramBoolean;
      return;
      if ((paramBoolean) && (!this.useGps))
        this.locationManager.requestLocationUpdates("gps", 0L, 0.0F, this);
    }
  }

  @SimpleProperty
  public boolean UseGPS()
  {
    return this.useGps;
  }

  @SimpleEvent(description="This event is run when a walking step is detected")
  public void WalkStep(int paramInt, float paramFloat)
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Integer.valueOf(paramInt);
    arrayOfObject[1] = Float.valueOf(paramFloat);
    EventDispatcher.dispatchEvent(this, "WalkStep", arrayOfObject);
  }

  public void onAccuracyChanged(Sensor paramSensor, int paramInt)
  {
    Log.d("Pedometer", "Accelerometer accuracy changed.");
  }

  public void onDelete()
  {
    this.sensorManager.unregisterListener(this);
    this.locationManager.removeUpdates(this);
  }

  public void onLocationChanged(Location paramLocation)
  {
    if ((!this.statusMoving) || (this.pedometerPaused) || (!this.useGps))
      return;
    this.currentLocation = paramLocation;
    if (this.currentLocation.getAccuracy() > 10.0F)
    {
      setGpsAvailable(false);
      return;
    }
    setGpsAvailable(true);
    float f1;
    if (this.prevLocation != null)
    {
      f1 = this.currentLocation.distanceTo(this.prevLocation);
      if ((f1 > 0.1D) && (f1 < 10.0F))
      {
        this.totalDistance = (f1 + this.totalDistance);
        this.prevLocation = this.currentLocation;
      }
    }
    while (this.calibrateSteps)
      if (!this.firstGpsReading)
      {
        this.gpsDistance = (f1 + this.gpsDistance);
        int i = this.numStepsRaw - this.lastNumSteps;
        this.strideLength = (this.gpsDistance / i);
        return;
        if (this.locationWhenGPSLost != null)
        {
          float f2 = this.currentLocation.distanceTo(this.locationWhenGPSLost);
          this.totalDistance = (this.distWhenGPSLost + (f2 + (this.totalDistance - this.distWhenGPSLost)) / 2.0F);
        }
        this.gpsStepTime = System.currentTimeMillis();
        this.prevLocation = this.currentLocation;
        f1 = 0.0F;
      }
      else
      {
        this.firstGpsReading = false;
        this.lastNumSteps = this.numStepsRaw;
        return;
      }
    this.firstGpsReading = true;
    this.gpsDistance = 0.0F;
  }

  public void onProviderDisabled(String paramString)
  {
    this.distWhenGPSLost = this.totalDistance;
    this.locationWhenGPSLost = this.currentLocation;
    this.firstGpsReading = true;
    this.prevLocation = null;
    setGpsAvailable(false);
  }

  public void onProviderEnabled(String paramString)
  {
    setGpsAvailable(true);
  }

  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (paramSensorEvent.sensor.getType() != 1)
      return;
    float[] arrayOfFloat1 = paramSensorEvent.values;
    if (this.startPeaking)
    {
      getPeak();
      getValley();
    }
    int i;
    int j;
    if (this.prevDiff[0] > this.prevDiff[1])
    {
      i = 0;
      if (this.prevDiff[2] > this.prevDiff[i])
        i = 2;
      j = 0;
      label71: if (j >= 3)
        break label440;
      if ((this.startPeaking) && (this.peak[j] >= 0))
      {
        if ((this.foundValley[j] == 0) || (this.lastValues[this.peak[j]][j] - this.lastValley[j] <= 4.0F))
          break label429;
        if (i == j)
        {
          long l = System.currentTimeMillis();
          this.stepInterval[this.intervalPos] = (l - this.stepTimestamp);
          this.intervalPos = ((1 + this.intervalPos) % 2);
          this.stepTimestamp = l;
          if (!areStepsEquallySpaced())
            break label421;
          if (this.foundNonStep)
          {
            this.numStepsWithFilter = (2 + this.numStepsWithFilter);
            if (!this.gpsAvailable)
              this.totalDistance += 2.0F * this.strideLength;
            this.foundNonStep = false;
          }
          this.numStepsWithFilter = (1 + this.numStepsWithFilter);
          WalkStep(this.numStepsWithFilter, this.totalDistance);
          if (!this.gpsAvailable)
            this.totalDistance += this.strideLength;
          label271: this.numStepsRaw = (1 + this.numStepsRaw);
          SimpleStep(this.numStepsRaw, this.totalDistance);
          if (!this.statusMoving)
          {
            this.statusMoving = true;
            StartedMoving();
          }
        }
        this.foundValley[j] = false;
        this.prevDiff[j] = (this.lastValues[this.peak[j]][j] - this.lastValley[j]);
      }
    }
    while (true)
    {
      if ((this.startPeaking) && (this.valley[j] >= 0))
      {
        this.foundValley[j] = true;
        this.lastValley[j] = this.lastValues[this.valley[j]][j];
      }
      this.lastValues[this.winPos][j] = arrayOfFloat1[j];
      j++;
      break label71;
      i = 1;
      break;
      label421: this.foundNonStep = true;
      break label271;
      label429: this.prevDiff[j] = 0.0F;
    }
    label440: this.elapsedTimestamp = System.currentTimeMillis();
    if (this.elapsedTimestamp - this.stepTimestamp > this.stopDetectionTimeout)
    {
      if (this.statusMoving)
      {
        this.statusMoving = false;
        StoppedMoving();
      }
      this.stepTimestamp = this.elapsedTimestamp;
    }
    if (this.winPos - 1 < 0);
    for (int k = 19; ; k = this.winPos - 1)
      for (int m = 0; m < 3; m++)
        if (this.lastValues[k][m] == this.lastValues[this.winPos][m])
        {
          float[] arrayOfFloat2 = this.lastValues[this.winPos];
          arrayOfFloat2[m] = ((float)(0.001D + arrayOfFloat2[m]));
        }
    if ((this.winPos == 19) && (!this.startPeaking))
      this.startPeaking = true;
    this.winPos = ((1 + this.winPos) % 20);
  }

  public void onStatusChanged(String paramString, int paramInt, Bundle paramBundle)
  {
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.Pedometer
 * JD-Core Version:    0.6.2
 */