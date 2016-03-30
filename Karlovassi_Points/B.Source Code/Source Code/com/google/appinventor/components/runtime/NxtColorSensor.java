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
import java.util.HashMap;
import java.util.Map;

@DesignerComponent(category=ComponentCategory.LEGOMINDSTORMS, description="A component that provides a high-level interface to a color sensor on a LEGO MINDSTORMS NXT robot.", iconName="images/legoMindstormsNxt.png", nonVisible=true, version=1)
@SimpleObject
public class NxtColorSensor extends LegoMindstormsNxtSensor
  implements Deleteable
{
  private static final int DEFAULT_BOTTOM_OF_RANGE = 256;
  private static final String DEFAULT_SENSOR_PORT = "3";
  private static final int DEFAULT_TOP_OF_RANGE = 767;
  static final int SENSOR_TYPE_COLOR_BLUE = 16;
  static final int SENSOR_TYPE_COLOR_FULL = 13;
  static final int SENSOR_TYPE_COLOR_GREEN = 15;
  static final int SENSOR_TYPE_COLOR_NONE = 17;
  static final int SENSOR_TYPE_COLOR_RED = 14;
  private static final Map<Integer, Integer> mapColorToSensorType = new HashMap();
  private static final Map<Integer, Integer> mapSensorValueToColor;
  private boolean aboveRangeEventEnabled;
  private boolean belowRangeEventEnabled;
  private int bottomOfRange;
  private boolean colorChangedEventEnabled;
  private boolean detectColor;
  private int generateColor;
  private Handler handler = new Handler();
  private int previousColor = 16777215;
  private State previousState = State.UNKNOWN;
  private final Runnable sensorReader = new Runnable()
  {
    public void run()
    {
      if ((NxtColorSensor.this.bluetooth != null) && (NxtColorSensor.this.bluetooth.IsConnected()))
      {
        if (!NxtColorSensor.this.detectColor)
          break label125;
        LegoMindstormsNxtSensor.SensorValue localSensorValue2 = NxtColorSensor.this.getColorValue("");
        if (localSensorValue2.valid)
        {
          int i = ((Integer)localSensorValue2.value).intValue();
          if (i != NxtColorSensor.this.previousColor)
            NxtColorSensor.this.ColorChanged(i);
          NxtColorSensor.access$202(NxtColorSensor.this, i);
        }
      }
      label125: LegoMindstormsNxtSensor.SensorValue localSensorValue1;
      do
      {
        if (NxtColorSensor.this.isHandlerNeeded())
          NxtColorSensor.this.handler.post(NxtColorSensor.this.sensorReader);
        return;
        localSensorValue1 = NxtColorSensor.this.getLightValue("");
      }
      while (!localSensorValue1.valid);
      NxtColorSensor.State localState;
      if (((Integer)localSensorValue1.value).intValue() < NxtColorSensor.this.bottomOfRange)
        localState = NxtColorSensor.State.BELOW_RANGE;
      while (true)
      {
        if (localState != NxtColorSensor.this.previousState)
        {
          if ((localState == NxtColorSensor.State.BELOW_RANGE) && (NxtColorSensor.this.belowRangeEventEnabled))
            NxtColorSensor.this.BelowRange();
          if ((localState == NxtColorSensor.State.WITHIN_RANGE) && (NxtColorSensor.this.withinRangeEventEnabled))
            NxtColorSensor.this.WithinRange();
          if ((localState == NxtColorSensor.State.ABOVE_RANGE) && (NxtColorSensor.this.aboveRangeEventEnabled))
            NxtColorSensor.this.AboveRange();
        }
        NxtColorSensor.access$602(NxtColorSensor.this, localState);
        break;
        if (((Integer)localSensorValue1.value).intValue() > NxtColorSensor.this.topOfRange)
          localState = NxtColorSensor.State.ABOVE_RANGE;
        else
          localState = NxtColorSensor.State.WITHIN_RANGE;
      }
    }
  };
  private int topOfRange;
  private boolean withinRangeEventEnabled;

  static
  {
    mapColorToSensorType.put(Integer.valueOf(-65536), Integer.valueOf(14));
    mapColorToSensorType.put(Integer.valueOf(-16711936), Integer.valueOf(15));
    mapColorToSensorType.put(Integer.valueOf(-16776961), Integer.valueOf(16));
    mapColorToSensorType.put(Integer.valueOf(16777215), Integer.valueOf(17));
    mapSensorValueToColor = new HashMap();
    mapSensorValueToColor.put(Integer.valueOf(1), Integer.valueOf(-16777216));
    mapSensorValueToColor.put(Integer.valueOf(2), Integer.valueOf(-16776961));
    mapSensorValueToColor.put(Integer.valueOf(3), Integer.valueOf(-16711936));
    mapSensorValueToColor.put(Integer.valueOf(4), Integer.valueOf(-256));
    mapSensorValueToColor.put(Integer.valueOf(5), Integer.valueOf(-65536));
    mapSensorValueToColor.put(Integer.valueOf(6), Integer.valueOf(-1));
  }

  public NxtColorSensor(ComponentContainer paramComponentContainer)
  {
    super(paramComponentContainer, "NxtColorSensor");
    SensorPort("3");
    DetectColor(true);
    ColorChangedEventEnabled(false);
    BottomOfRange(256);
    TopOfRange(767);
    BelowRangeEventEnabled(false);
    WithinRangeEventEnabled(false);
    AboveRangeEventEnabled(false);
    GenerateColor(16777215);
  }

  private LegoMindstormsNxtSensor.SensorValue<Integer> getColorValue(String paramString)
  {
    byte[] arrayOfByte = getInputValues(paramString, this.port);
    if ((arrayOfByte != null) && (getBooleanValueFromBytes(arrayOfByte, 4)))
    {
      int i = getSWORDValueFromBytes(arrayOfByte, 12);
      if (mapSensorValueToColor.containsKey(Integer.valueOf(i)))
        return new LegoMindstormsNxtSensor.SensorValue(true, Integer.valueOf(((Integer)mapSensorValueToColor.get(Integer.valueOf(i))).intValue()));
    }
    return new LegoMindstormsNxtSensor.SensorValue(false, null);
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
    if (this.detectColor)
      return this.colorChangedEventEnabled;
    return (this.belowRangeEventEnabled) || (this.withinRangeEventEnabled) || (this.aboveRangeEventEnabled);
  }

  @SimpleEvent(description="Light level has gone above the range. The AboveRange event will not occur if the DetectColor property is set to True or if the AboveRangeEventEnabled property is set to False.")
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

  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="Whether the AboveRange event should fire when the DetectColor property is set to False and the light level goes above the TopOfRange.")
  public boolean AboveRangeEventEnabled()
  {
    return this.aboveRangeEventEnabled;
  }

  @SimpleEvent(description="Light level has gone below the range. The BelowRange event will not occur if the DetectColor property is set to True or if the BelowRangeEventEnabled property is set to False.")
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

  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="Whether the BelowRange event should fire when the DetectColor property is set to False and the light level goes below the BottomOfRange.")
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

  @SimpleEvent(description="Detected color has changed. The ColorChanged event will not occur if the DetectColor property is set to False or if the ColorChangedEventEnabled property is set to False.")
  public void ColorChanged(int paramInt)
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(paramInt);
    EventDispatcher.dispatchEvent(this, "ColorChanged", arrayOfObject);
  }

  @DesignerProperty(defaultValue="False", editorType="boolean")
  @SimpleProperty
  public void ColorChangedEventEnabled(boolean paramBoolean)
  {
    boolean bool1 = isHandlerNeeded();
    this.colorChangedEventEnabled = paramBoolean;
    boolean bool2 = isHandlerNeeded();
    if ((bool1) && (!bool2))
      this.handler.removeCallbacks(this.sensorReader);
    if ((!bool1) && (bool2))
    {
      this.previousColor = 16777215;
      this.handler.post(this.sensorReader);
    }
  }

  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="Whether the ColorChanged event should fire when the DetectColor property is set to True and the detected color changes.")
  public boolean ColorChangedEventEnabled()
  {
    return this.colorChangedEventEnabled;
  }

  @DesignerProperty(defaultValue="True", editorType="boolean")
  @SimpleProperty
  public void DetectColor(boolean paramBoolean)
  {
    boolean bool1 = isHandlerNeeded();
    this.detectColor = paramBoolean;
    if ((this.bluetooth != null) && (this.bluetooth.IsConnected()))
      initializeSensor("DetectColor");
    boolean bool2 = isHandlerNeeded();
    if ((bool1) && (!bool2))
      this.handler.removeCallbacks(this.sensorReader);
    this.previousColor = 16777215;
    this.previousState = State.UNKNOWN;
    if ((!bool1) && (bool2))
      this.handler.post(this.sensorReader);
  }

  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="Whether the sensor should detect color or light. True indicates that the sensor should detect color; False indicates that the sensor should detect light. If the DetectColor property is set to True, the BelowRange, WithinRange, and AboveRange events will not occur and the sensor will not generate color. If the DetectColor property is set to False, the ColorChanged event will not occur.")
  public boolean DetectColor()
  {
    return this.detectColor;
  }

  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="The color that should generated by the sensor. Only None, Red, Green, or Blue are valid values. The sensor will not generate color when the DetectColor property is set to True.")
  public int GenerateColor()
  {
    return this.generateColor;
  }

  @DesignerProperty(defaultValue="&H00FFFFFF", editorType="lego_nxt_generated_color")
  @SimpleProperty
  public void GenerateColor(int paramInt)
  {
    if (mapColorToSensorType.containsKey(Integer.valueOf(paramInt)))
    {
      this.generateColor = paramInt;
      if ((this.bluetooth != null) && (this.bluetooth.IsConnected()))
        initializeSensor("GenerateColor");
      return;
    }
    this.form.dispatchErrorOccurredEvent(this, "GenerateColor", 419, new Object[0]);
  }

  @SimpleFunction(description="Returns the current detected color, or the color None if the color can not be read or if the DetectColor property is set to False.")
  public int GetColor()
  {
    if (!checkBluetooth("GetColor"))
      return 16777215;
    if (!this.detectColor)
    {
      this.form.dispatchErrorOccurredEvent(this, "GetColor", 417, new Object[0]);
      return 16777215;
    }
    LegoMindstormsNxtSensor.SensorValue localSensorValue = getColorValue("GetColor");
    if (localSensorValue.valid)
      return ((Integer)localSensorValue.value).intValue();
    return 16777215;
  }

  @SimpleFunction(description="Returns the current light level as a value between 0 and 1023, or -1 if the light level can not be read or if the DetectColor property is set to True.")
  public int GetLightLevel()
  {
    if (!checkBluetooth("GetLightLevel"))
      return -1;
    if (this.detectColor)
    {
      this.form.dispatchErrorOccurredEvent(this, "GetLightLevel", 418, new Object[0]);
      return -1;
    }
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

  @SimpleEvent(description="Light level has gone within the range. The WithinRange event will not occur if the DetectColor property is set to True or if the WithinRangeEventEnabled property is set to False.")
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

  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="Whether the WithinRange event should fire when the DetectColor property is set to False and the light level goes between the BottomOfRange and the TopOfRange.")
  public boolean WithinRangeEventEnabled()
  {
    return this.withinRangeEventEnabled;
  }

  protected void initializeSensor(String paramString)
  {
    if (this.detectColor);
    for (int i = 13; ; i = ((Integer)mapColorToSensorType.get(Integer.valueOf(this.generateColor))).intValue())
    {
      setInputMode(paramString, this.port, i, 0);
      resetInputScaledValue(paramString, this.port);
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
 * Qualified Name:     com.google.appinventor.components.runtime.NxtColorSensor
 * JD-Core Version:    0.6.2
 */