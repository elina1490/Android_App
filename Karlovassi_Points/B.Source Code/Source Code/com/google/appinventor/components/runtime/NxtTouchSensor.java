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

@DesignerComponent(category=ComponentCategory.LEGOMINDSTORMS, description="A component that provides a high-level interface to a touch sensor on a LEGO MINDSTORMS NXT robot.", iconName="images/legoMindstormsNxt.png", nonVisible=true, version=1)
@SimpleObject
public class NxtTouchSensor extends LegoMindstormsNxtSensor
  implements Deleteable
{
  private static final String DEFAULT_SENSOR_PORT = "1";
  private Handler handler = new Handler();
  private boolean pressedEventEnabled;
  private State previousState = State.UNKNOWN;
  private boolean releasedEventEnabled;
  private final Runnable sensorReader = new Runnable()
  {
    public void run()
    {
      if ((NxtTouchSensor.this.bluetooth != null) && (NxtTouchSensor.this.bluetooth.IsConnected()))
      {
        LegoMindstormsNxtSensor.SensorValue localSensorValue = NxtTouchSensor.this.getPressedValue("");
        if (localSensorValue.valid)
          if (!((Boolean)localSensorValue.value).booleanValue())
            break label154;
      }
      label154: for (NxtTouchSensor.State localState = NxtTouchSensor.State.PRESSED; ; localState = NxtTouchSensor.State.RELEASED)
      {
        if (localState != NxtTouchSensor.this.previousState)
        {
          if ((localState == NxtTouchSensor.State.PRESSED) && (NxtTouchSensor.this.pressedEventEnabled))
            NxtTouchSensor.this.Pressed();
          if ((localState == NxtTouchSensor.State.RELEASED) && (NxtTouchSensor.this.releasedEventEnabled))
            NxtTouchSensor.this.Released();
        }
        NxtTouchSensor.access$102(NxtTouchSensor.this, localState);
        if (NxtTouchSensor.this.isHandlerNeeded())
          NxtTouchSensor.this.handler.post(NxtTouchSensor.this.sensorReader);
        return;
      }
    }
  };

  public NxtTouchSensor(ComponentContainer paramComponentContainer)
  {
    super(paramComponentContainer, "NxtTouchSensor");
    SensorPort("1");
    PressedEventEnabled(false);
    ReleasedEventEnabled(false);
  }

  private LegoMindstormsNxtSensor.SensorValue<Boolean> getPressedValue(String paramString)
  {
    byte[] arrayOfByte = getInputValues(paramString, this.port);
    if ((arrayOfByte != null) && (getBooleanValueFromBytes(arrayOfByte, 4)))
    {
      if (getSWORDValueFromBytes(arrayOfByte, 12) != 0);
      for (boolean bool = true; ; bool = false)
        return new LegoMindstormsNxtSensor.SensorValue(true, Boolean.valueOf(bool));
    }
    return new LegoMindstormsNxtSensor.SensorValue(false, null);
  }

  private boolean isHandlerNeeded()
  {
    return (this.pressedEventEnabled) || (this.releasedEventEnabled);
  }

  @SimpleFunction(description="Returns true if the touch sensor is pressed.")
  public boolean IsPressed()
  {
    if (!checkBluetooth("IsPressed"))
      return false;
    LegoMindstormsNxtSensor.SensorValue localSensorValue = getPressedValue("IsPressed");
    if (localSensorValue.valid)
      return ((Boolean)localSensorValue.value).booleanValue();
    return false;
  }

  @SimpleEvent(description="Touch sensor has been pressed.")
  public void Pressed()
  {
    EventDispatcher.dispatchEvent(this, "Pressed", new Object[0]);
  }

  @DesignerProperty(defaultValue="False", editorType="boolean")
  @SimpleProperty
  public void PressedEventEnabled(boolean paramBoolean)
  {
    boolean bool1 = isHandlerNeeded();
    this.pressedEventEnabled = paramBoolean;
    boolean bool2 = isHandlerNeeded();
    if ((bool1) && (!bool2))
      this.handler.removeCallbacks(this.sensorReader);
    if ((!bool1) && (bool2))
    {
      this.previousState = State.UNKNOWN;
      this.handler.post(this.sensorReader);
    }
  }

  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="Whether the Pressed event should fire when the touch sensor is pressed.")
  public boolean PressedEventEnabled()
  {
    return this.pressedEventEnabled;
  }

  @SimpleEvent(description="Touch sensor has been released.")
  public void Released()
  {
    EventDispatcher.dispatchEvent(this, "Released", new Object[0]);
  }

  @DesignerProperty(defaultValue="False", editorType="boolean")
  @SimpleProperty
  public void ReleasedEventEnabled(boolean paramBoolean)
  {
    boolean bool1 = isHandlerNeeded();
    this.releasedEventEnabled = paramBoolean;
    boolean bool2 = isHandlerNeeded();
    if ((bool1) && (!bool2))
      this.handler.removeCallbacks(this.sensorReader);
    if ((!bool1) && (bool2))
    {
      this.previousState = State.UNKNOWN;
      this.handler.post(this.sensorReader);
    }
  }

  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="Whether the Released event should fire when the touch sensor is released.")
  public boolean ReleasedEventEnabled()
  {
    return this.releasedEventEnabled;
  }

  @DesignerProperty(defaultValue="1", editorType="lego_nxt_sensor_port")
  @SimpleProperty(userVisible=false)
  public void SensorPort(String paramString)
  {
    setSensorPort(paramString);
  }

  protected void initializeSensor(String paramString)
  {
    setInputMode(paramString, this.port, 1, 32);
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
      PRESSED = new State("PRESSED", 1);
      RELEASED = new State("RELEASED", 2);
      State[] arrayOfState = new State[3];
      arrayOfState[0] = UNKNOWN;
      arrayOfState[1] = PRESSED;
      arrayOfState[2] = RELEASED;
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.NxtTouchSensor
 * JD-Core Version:    0.6.2
 */