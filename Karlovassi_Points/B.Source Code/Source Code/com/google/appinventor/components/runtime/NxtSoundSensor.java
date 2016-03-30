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

@DesignerComponent(category=ComponentCategory.LEGOMINDSTORMS, description="A component that provides a high-level interface to a sound sensor on a LEGO MINDSTORMS NXT robot.", iconName="images/legoMindstormsNxt.png", nonVisible=true, version=1)
@SimpleObject
public class NxtSoundSensor extends LegoMindstormsNxtSensor
  implements Deleteable
{
  private static final int DEFAULT_BOTTOM_OF_RANGE = 256;
  private static final String DEFAULT_SENSOR_PORT = "2";
  private static final int DEFAULT_TOP_OF_RANGE = 767;
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
      NxtSoundSensor.State localState;
      if ((NxtSoundSensor.this.bluetooth != null) && (NxtSoundSensor.this.bluetooth.IsConnected()))
      {
        localSensorValue = NxtSoundSensor.this.getSoundValue("");
        if (localSensorValue.valid)
        {
          if (((Integer)localSensorValue.value).intValue() >= NxtSoundSensor.this.bottomOfRange)
            break label185;
          localState = NxtSoundSensor.State.BELOW_RANGE;
        }
      }
      while (true)
      {
        if (localState != NxtSoundSensor.this.previousState)
        {
          if ((localState == NxtSoundSensor.State.BELOW_RANGE) && (NxtSoundSensor.this.belowRangeEventEnabled))
            NxtSoundSensor.this.BelowRange();
          if ((localState == NxtSoundSensor.State.WITHIN_RANGE) && (NxtSoundSensor.this.withinRangeEventEnabled))
            NxtSoundSensor.this.WithinRange();
          if ((localState == NxtSoundSensor.State.ABOVE_RANGE) && (NxtSoundSensor.this.aboveRangeEventEnabled))
            NxtSoundSensor.this.AboveRange();
        }
        NxtSoundSensor.access$302(NxtSoundSensor.this, localState);
        if (NxtSoundSensor.this.isHandlerNeeded())
          NxtSoundSensor.this.handler.post(NxtSoundSensor.this.sensorReader);
        return;
        label185: if (((Integer)localSensorValue.value).intValue() > NxtSoundSensor.this.topOfRange)
          localState = NxtSoundSensor.State.ABOVE_RANGE;
        else
          localState = NxtSoundSensor.State.WITHIN_RANGE;
      }
    }
  };
  private int topOfRange;
  private boolean withinRangeEventEnabled;

  public NxtSoundSensor(ComponentContainer paramComponentContainer)
  {
    super(paramComponentContainer, "NxtSoundSensor");
    SensorPort("2");
    BottomOfRange(256);
    TopOfRange(767);
    BelowRangeEventEnabled(false);
    WithinRangeEventEnabled(false);
    AboveRangeEventEnabled(false);
  }

  private LegoMindstormsNxtSensor.SensorValue<Integer> getSoundValue(String paramString)
  {
    byte[] arrayOfByte = getInputValues(paramString, this.port);
    if ((arrayOfByte != null) && (getBooleanValueFromBytes(arrayOfByte, 4)))
      return new LegoMindstormsNxtSensor.SensorValue(true, Integer.valueOf(getUWORDValueFromBytes(arrayOfByte, 10)));
    return new LegoMindstormsNxtSensor.SensorValue(false, null);
  }

  private boolean isHandlerNeeded()
  {
    return (this.belowRangeEventEnabled) || (this.withinRangeEventEnabled) || (this.aboveRangeEventEnabled);
  }

  @SimpleEvent(description="Sound level has gone above the range.")
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

  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="Whether the AboveRange event should fire when the sound level goes above the TopOfRange.")
  public boolean AboveRangeEventEnabled()
  {
    return this.aboveRangeEventEnabled;
  }

  @SimpleEvent(description="Sound level has gone below the range.")
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

  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="Whether the BelowRange event should fire when the sound level goes below the BottomOfRange.")
  public boolean BelowRangeEventEnabled()
  {
    return this.belowRangeEventEnabled;
  }

  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="The bottom of the range used for the BelowRange, WithinRange, and AboveRange events.")
  public int BottomOfRange()
  {
    return this.bottomOfRange;
  }

  @DesignerProperty(defaultValue="256", editorType="non_negative_integer")
  @SimpleProperty
  public void BottomOfRange(int paramInt)
  {
    this.bottomOfRange = paramInt;
    this.previousState = State.UNKNOWN;
  }

  @SimpleFunction(description="Returns the current sound level as a value between 0 and 1023, or -1 if the sound level can not be read.")
  public int GetSoundLevel()
  {
    if (!checkBluetooth("GetSoundLevel"))
      return -1;
    LegoMindstormsNxtSensor.SensorValue localSensorValue = getSoundValue("GetSoundLevel");
    if (localSensorValue.valid)
      return ((Integer)localSensorValue.value).intValue();
    return -1;
  }

  @DesignerProperty(defaultValue="2", editorType="lego_nxt_sensor_port")
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

  @DesignerProperty(defaultValue="767", editorType="non_negative_integer")
  @SimpleProperty
  public void TopOfRange(int paramInt)
  {
    this.topOfRange = paramInt;
    this.previousState = State.UNKNOWN;
  }

  @SimpleEvent(description="Sound level has gone within the range.")
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

  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="Whether the WithinRange event should fire when the sound level goes between the BottomOfRange and the TopOfRange.")
  public boolean WithinRangeEventEnabled()
  {
    return this.withinRangeEventEnabled;
  }

  protected void initializeSensor(String paramString)
  {
    setInputMode(paramString, this.port, 7, 0);
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
 * Qualified Name:     com.google.appinventor.components.runtime.NxtSoundSensor
 * JD-Core Version:    0.6.2
 */