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

@DesignerComponent(category=ComponentCategory.LEGOMINDSTORMS, description="A component that provides a high-level interface to a light sensor on a LEGO MINDSTORMS NXT robot.", iconName="images/legoMindstormsNxt.png", nonVisible=true, version=1)
@SimpleObject
public class NxtLightSensor extends LegoMindstormsNxtSensor
  implements Deleteable
{
  private static final int DEFAULT_BOTTOM_OF_RANGE = 256;
  private static final String DEFAULT_SENSOR_PORT = "3";
  private static final int DEFAULT_TOP_OF_RANGE = 767;
  private boolean aboveRangeEventEnabled;
  private boolean belowRangeEventEnabled;
  private int bottomOfRange;
  private boolean generateLight;
  private Handler handler = new Handler();
  private State previousState = State.UNKNOWN;
  private final Runnable sensorReader = new Runnable()
  {
    public void run()
    {
      LegoMindstormsNxtSensor.SensorValue localSensorValue;
      NxtLightSensor.State localState;
      if ((NxtLightSensor.this.bluetooth != null) && (NxtLightSensor.this.bluetooth.IsConnected()))
      {
        localSensorValue = NxtLightSensor.this.getLightValue("");
        if (localSensorValue.valid)
        {
          if (((Integer)localSensorValue.value).intValue() >= NxtLightSensor.this.bottomOfRange)
            break label185;
          localState = NxtLightSensor.State.BELOW_RANGE;
        }
      }
      while (true)
      {
        if (localState != NxtLightSensor.this.previousState)
        {
          if ((localState == NxtLightSensor.State.BELOW_RANGE) && (NxtLightSensor.this.belowRangeEventEnabled))
            NxtLightSensor.this.BelowRange();
          if ((localState == NxtLightSensor.State.WITHIN_RANGE) && (NxtLightSensor.this.withinRangeEventEnabled))
            NxtLightSensor.this.WithinRange();
          if ((localState == NxtLightSensor.State.ABOVE_RANGE) && (NxtLightSensor.this.aboveRangeEventEnabled))
            NxtLightSensor.this.AboveRange();
        }
        NxtLightSensor.access$302(NxtLightSensor.this, localState);
        if (NxtLightSensor.this.isHandlerNeeded())
          NxtLightSensor.this.handler.post(NxtLightSensor.this.sensorReader);
        return;
        label185: if (((Integer)localSensorValue.value).intValue() > NxtLightSensor.this.topOfRange)
          localState = NxtLightSensor.State.ABOVE_RANGE;
        else
          localState = NxtLightSensor.State.WITHIN_RANGE;
      }
    }
  };
  private int topOfRange;
  private boolean withinRangeEventEnabled;

  public NxtLightSensor(ComponentContainer paramComponentContainer)
  {
    super(paramComponentContainer, "NxtLightSensor");
    SensorPort("3");
    BottomOfRange(256);
    TopOfRange(767);
    BelowRangeEventEnabled(false);
    WithinRangeEventEnabled(false);
    AboveRangeEventEnabled(false);
    GenerateLight(false);
  }

  private LegoMindstormsNxtSensor.SensorValue<Integer> getLightValue(String paramString)
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

  @SimpleEvent(description="Light level has gone above the range.")
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

  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="Whether the AboveRange event should fire when the light level goes above the TopOfRange.")
  public boolean AboveRangeEventEnabled()
  {
    return this.aboveRangeEventEnabled;
  }

  @SimpleEvent(description="Light level has gone below the range.")
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

  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="Whether the BelowRange event should fire when the light level goes below the BottomOfRange.")
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

  @DesignerProperty(defaultValue="False", editorType="boolean")
  @SimpleProperty
  public void GenerateLight(boolean paramBoolean)
  {
    this.generateLight = paramBoolean;
    if ((this.bluetooth != null) && (this.bluetooth.IsConnected()))
      initializeSensor("GenerateLight");
  }

  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="Whether the light sensor should generate light.")
  public boolean GenerateLight()
  {
    return this.generateLight;
  }

  @SimpleFunction(description="Returns the current light level as a value between 0 and 1023, or -1 if the light level can not be read.")
  public int GetLightLevel()
  {
    if (!checkBluetooth("GetLightLevel"))
      return -1;
    LegoMindstormsNxtSensor.SensorValue localSensorValue = getLightValue("GetLightLevel");
    if (localSensorValue.valid)
      return ((Integer)localSensorValue.value).intValue();
    return -1;
  }

  @DesignerProperty(defaultValue="3", editorType="lego_nxt_sensor_port")
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

  @SimpleEvent(description="Light level has gone within the range.")
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

  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="Whether the WithinRange event should fire when the light level goes between the BottomOfRange and the TopOfRange.")
  public boolean WithinRangeEventEnabled()
  {
    return this.withinRangeEventEnabled;
  }

  protected void initializeSensor(String paramString)
  {
    int i = this.port;
    if (this.generateLight);
    for (int j = 5; ; j = 6)
    {
      setInputMode(paramString, i, j, 128);
      return;
    }
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
 * Qualified Name:     com.google.appinventor.components.runtime.NxtLightSensor
 * JD-Core Version:    0.6.2
 */