package com.google.appinventor.components.runtime;

import android.os.Handler;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.common.ComponentCategory;

@DesignerComponent(category=ComponentCategory.LEGOMINDSTORMS, description="A component that provides a high-level interface to an ultrasonic sensor on a LEGO MINDSTORMS NXT robot.", iconName="images/legoMindstormsNxt.png", nonVisible=true, version=1)
@SimpleObject
public class NxtUltrasonicSensor extends LegoMindstormsNxtSensor
  implements Deleteable
{
  private static final int DEFAULT_BOTTOM_OF_RANGE = 30;
  private static final String DEFAULT_SENSOR_PORT = "4";
  private static final int DEFAULT_TOP_OF_RANGE = 90;
  private boolean aboveRangeEventEnabled;
  private boolean belowRangeEventEnabled;
  private int bottomOfRange;
  private Handler handler = new Handler();
  private State previousState = State.UNKNOWN;
  private final Runnable sensorReader = new Runnable()
  {
    public void run()
    {
      LegoMindstormsNxtSensor.SensorValue localSensorValue;
      NxtUltrasonicSensor.State localState;
      if ((NxtUltrasonicSensor.this.bluetooth != null) && (NxtUltrasonicSensor.this.bluetooth.IsConnected()))
      {
        localSensorValue = NxtUltrasonicSensor.this.getDistanceValue("");
        if (localSensorValue.valid)
        {
          if (((Integer)localSensorValue.value).intValue() >= NxtUltrasonicSensor.this.bottomOfRange)
            break label185;
          localState = NxtUltrasonicSensor.State.BELOW_RANGE;
        }
      }
      while (true)
      {
        if (localState != NxtUltrasonicSensor.this.previousState)
        {
          if ((localState == NxtUltrasonicSensor.State.BELOW_RANGE) && (NxtUltrasonicSensor.this.belowRangeEventEnabled))
            NxtUltrasonicSensor.this.BelowRange();
          if ((localState == NxtUltrasonicSensor.State.WITHIN_RANGE) && (NxtUltrasonicSensor.this.withinRangeEventEnabled))
            NxtUltrasonicSensor.this.WithinRange();
          if ((localState == NxtUltrasonicSensor.State.ABOVE_RANGE) && (NxtUltrasonicSensor.this.aboveRangeEventEnabled))
            NxtUltrasonicSensor.this.AboveRange();
        }
        NxtUltrasonicSensor.access$302(NxtUltrasonicSensor.this, localState);
        if (NxtUltrasonicSensor.this.isHandlerNeeded())
          NxtUltrasonicSensor.this.handler.post(NxtUltrasonicSensor.this.sensorReader);
        return;
        label185: if (((Integer)localSensorValue.value).intValue() > NxtUltrasonicSensor.this.topOfRange)
          localState = NxtUltrasonicSensor.State.ABOVE_RANGE;
        else
          localState = NxtUltrasonicSensor.State.WITHIN_RANGE;
      }
    }
  };
  private int topOfRange;
  private boolean withinRangeEventEnabled;

  public NxtUltrasonicSensor(ComponentContainer paramComponentContainer)
  {
    super(paramComponentContainer, "NxtUltrasonicSensor");
    SensorPort("4");
    BottomOfRange(30);
    TopOfRange(90);
    BelowRangeEventEnabled(false);
    WithinRangeEventEnabled(false);
    AboveRangeEventEnabled(false);
  }

  private void configureUltrasonicSensor(String paramString)
  {
    byte[] arrayOfByte = { 2, 65, 2 };
    lsWrite(paramString, this.port, arrayOfByte, 0);
  }

  private LegoMindstormsNxtSensor.SensorValue<Integer> getDistanceValue(String paramString)
  {
    byte[] arrayOfByte1 = { 2, 66 };
    lsWrite(paramString, this.port, arrayOfByte1, 1);
    for (int i = 0; i < 3; i++)
      if (lsGetStatus(paramString, this.port) > 0)
      {
        byte[] arrayOfByte2 = lsRead(paramString, this.port);
        if (arrayOfByte2 == null)
          break;
        int j = getUBYTEValueFromBytes(arrayOfByte2, 4);
        if ((j < 0) || (j > 254))
          break;
        return new LegoMindstormsNxtSensor.SensorValue(true, Integer.valueOf(j));
      }
    return new LegoMindstormsNxtSensor.SensorValue(false, null);
  }

  private boolean isHandlerNeeded()
  {
    return (this.belowRangeEventEnabled) || (this.withinRangeEventEnabled) || (this.aboveRangeEventEnabled);
  }

  @SimpleEvent(description="Distance has gone above the range.")
  public void AboveRange()
  {
    EventDispatcher.dispatchEvent(this, "AboveRange", new Object[0]);
  }

  @DesignerProperty(defaultValue="False", editorType="boolean")
  @SimpleProperty
  public void AboveRangeEventEnabled(boolean paramBoolean)
  {
    boolean bool1 = isHandlerNeeded();
    this.aboveRangeEventEnabled = paramBoolean;
    boolean bool2 = isHandlerNeeded();
    if ((bool1) && (!bool2))
      this.handler.removeCallbacks(this.sensorReader);
    if ((!bool1) && (bool2))
    {
      this.previousState = State.UNKNOWN;
      this.handler.post(this.sensorReader);
    }
  }

  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="Whether the AboveRange event should fire when the distance goes above the TopOfRange.")
  public boolean AboveRangeEventEnabled()
  {
    return this.aboveRangeEventEnabled;
  }

  @SimpleEvent(description="Distance has gone below the range.")
  public void BelowRange()
  {
    EventDispatcher.dispatchEvent(this, "BelowRange", new Object[0]);
  }

  @DesignerProperty(defaultValue="False", editorType="boolean")
  @SimpleProperty
  public void BelowRangeEventEnabled(boolean paramBoolean)
  {
    boolean bool1 = isHandlerNeeded();
    this.belowRangeEventEnabled = paramBoolean;
    boolean bool2 = isHandlerNeeded();
    if ((bool1) && (!bool2))
      this.handler.removeCallbacks(this.sensorReader);
    if ((!bool1) && (bool2))
    {
      this.previousState = State.UNKNOWN;
      this.handler.post(this.sensorReader);
    }
  }

  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="Whether the BelowRange event should fire when the distance goes below the BottomOfRange.")
  public boolean BelowRangeEventEnabled()
  {
    return this.belowRangeEventEnabled;
  }

  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="The bottom of the range used for the BelowRange, WithinRange, and AboveRange events.")
  public int BottomOfRange()
  {
    return this.bottomOfRange;
  }

  @DesignerProperty(defaultValue="30", editorType="non_negative_integer")
  @SimpleProperty
  public void BottomOfRange(int paramInt)
  {
    this.bottomOfRange = paramInt;
    this.previousState = State.UNKNOWN;
  }

  @SimpleFunction(description="Returns the current distance in centimeters as a value between 0 and 254, or -1 if the distance can not be read.")
  public int GetDistance()
  {
    if (!checkBluetooth("GetDistance"))
      return -1;
    LegoMindstormsNxtSensor.SensorValue localSensorValue = getDistanceValue("GetDistance");
    if (localSensorValue.valid)
      return ((Integer)localSensorValue.value).intValue();
    return -1;
  }

  @DesignerProperty(defaultValue="4", editorType="lego_nxt_sensor_port")
  @SimpleProperty(userVisible=false)
  public void SensorPort(String paramString)
  {
    setSensorPort(paramString);
  }

  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="The top of the range used for the BelowRange, WithinRange, and AboveRange events.")
  public int TopOfRange()
  {
    return this.topOfRange;
  }

  @DesignerProperty(defaultValue="90", editorType="non_negative_integer")
  @SimpleProperty
  public void TopOfRange(int paramInt)
  {
    this.topOfRange = paramInt;
    this.previousState = State.UNKNOWN;
  }

  @SimpleEvent(description="Distance has gone within the range.")
  public void WithinRange()
  {
    EventDispatcher.dispatchEvent(this, "WithinRange", new Object[0]);
  }

  @DesignerProperty(defaultValue="False", editorType="boolean")
  @SimpleProperty
  public void WithinRangeEventEnabled(boolean paramBoolean)
  {
    boolean bool1 = isHandlerNeeded();
    this.withinRangeEventEnabled = paramBoolean;
    boolean bool2 = isHandlerNeeded();
    if ((bool1) && (!bool2))
      this.handler.removeCallbacks(this.sensorReader);
    if ((!bool1) && (bool2))
    {
      this.previousState = State.UNKNOWN;
      this.handler.post(this.sensorReader);
    }
  }

  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="Whether the WithinRange event should fire when the distance goes between the BottomOfRange and the TopOfRange.")
  public boolean WithinRangeEventEnabled()
  {
    return this.withinRangeEventEnabled;
  }

  protected void initializeSensor(String paramString)
  {
    setInputMode(paramString, this.port, 11, 0);
    configureUltrasonicSensor(paramString);
  }

  public void onDelete()
  {
    this.handler.removeCallbacks(this.sensorReader);
    super.onDelete();
  }

  private static enum State
  {
    static
    {
      BELOW_RANGE = new State("BELOW_RANGE", 1);
      WITHIN_RANGE = new State("WITHIN_RANGE", 2);
      ABOVE_RANGE = new State("ABOVE_RANGE", 3);
      State[] arrayOfState = new State[4];
      arrayOfState[0] = UNKNOWN;
      arrayOfState[1] = BELOW_RANGE;
      arrayOfState[2] = WITHIN_RANGE;
      arrayOfState[3] = ABOVE_RANGE;
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.NxtUltrasonicSensor
 * JD-Core Version:    0.6.2
 */