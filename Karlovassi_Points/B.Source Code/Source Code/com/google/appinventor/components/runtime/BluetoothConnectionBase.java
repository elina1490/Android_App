package com.google.appinventor.components.runtime;

import android.util.Log;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.runtime.util.BluetoothReflection;
import com.google.appinventor.components.runtime.util.YailList;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SimpleObject
public abstract class BluetoothConnectionBase extends AndroidNonvisibleComponent
  implements Component, OnDestroyListener, Deleteable
{
  private final List<BluetoothConnectionListener> bluetoothConnectionListeners = new ArrayList();
  private ByteOrder byteOrder;
  private Object connectedBluetoothSocket;
  private byte delimiter;
  private String encoding;
  private InputStream inputStream;
  protected final String logTag;
  private OutputStream outputStream;
  protected boolean secure;

  protected BluetoothConnectionBase(ComponentContainer paramComponentContainer, String paramString)
  {
    this(paramComponentContainer.$form(), paramString);
    this.form.registerForOnDestroy(this);
  }

  private BluetoothConnectionBase(Form paramForm, String paramString)
  {
    super(paramForm);
    this.logTag = paramString;
    HighByteFirst(false);
    CharacterEncoding("UTF-8");
    DelimiterByte(0);
    Secure(true);
  }

  protected BluetoothConnectionBase(OutputStream paramOutputStream, InputStream paramInputStream)
  {
    this((Form)null, (String)null);
    this.connectedBluetoothSocket = "Not Null";
    this.outputStream = paramOutputStream;
    this.inputStream = paramInputStream;
  }

  private void fireAfterConnectEvent()
  {
    Iterator localIterator = this.bluetoothConnectionListeners.iterator();
    while (localIterator.hasNext())
      ((BluetoothConnectionListener)localIterator.next()).afterConnect(this);
  }

  private void fireBeforeDisconnectEvent()
  {
    Iterator localIterator = this.bluetoothConnectionListeners.iterator();
    while (localIterator.hasNext())
      ((BluetoothConnectionListener)localIterator.next()).beforeDisconnect(this);
  }

  private void prepareToDie()
  {
    if (this.connectedBluetoothSocket != null)
      Disconnect();
  }

  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="Whether Bluetooth is available on the device")
  public boolean Available()
  {
    return BluetoothReflection.getBluetoothAdapter() != null;
  }

  @SimpleEvent(description="The BluetoothError event is no longer used. Please use the Screen.ErrorOccurred event instead.", userVisible=false)
  public void BluetoothError(String paramString1, String paramString2)
  {
  }

  @SimpleFunction(description="Returns an estimate of the number of bytes that can be received without blocking")
  public int BytesAvailableToReceive()
  {
    if (!IsConnected())
    {
      bluetoothError("BytesAvailableToReceive", 515, new Object[0]);
      return 0;
    }
    try
    {
      int i = this.inputStream.available();
      return i;
    }
    catch (IOException localIOException)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = localIOException.getMessage();
      bluetoothError("BytesAvailableToReceive", 517, arrayOfObject);
    }
    return 0;
  }

  @SimpleProperty(category=PropertyCategory.BEHAVIOR)
  public String CharacterEncoding()
  {
    return this.encoding;
  }

  @DesignerProperty(defaultValue="UTF-8", editorType="string")
  @SimpleProperty
  public void CharacterEncoding(String paramString)
  {
    try
    {
      "check".getBytes(paramString);
      this.encoding = paramString;
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      bluetoothError("CharacterEncoding", 519, new Object[] { paramString });
    }
  }

  @SimpleProperty(category=PropertyCategory.BEHAVIOR)
  public int DelimiterByte()
  {
    return this.delimiter;
  }

  @DesignerProperty(defaultValue="0", editorType="non_negative_integer")
  @SimpleProperty
  public void DelimiterByte(int paramInt)
  {
    byte b = (byte)paramInt;
    int i = paramInt >> 8;
    if ((i != 0) && (i != -1))
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(paramInt);
      bluetoothError("DelimiterByte", 511, arrayOfObject);
      return;
    }
    this.delimiter = b;
  }

  @SimpleFunction(description="Disconnect from the connected Bluetooth device.")
  public final void Disconnect()
  {
    if (this.connectedBluetoothSocket != null)
      fireBeforeDisconnectEvent();
    try
    {
      BluetoothReflection.closeBluetoothSocket(this.connectedBluetoothSocket);
      Log.i(this.logTag, "Disconnected from Bluetooth device.");
      this.connectedBluetoothSocket = null;
      this.inputStream = null;
      this.outputStream = null;
      return;
    }
    catch (IOException localIOException)
    {
      while (true)
        Log.w(this.logTag, "Error while disconnecting: " + localIOException.getMessage());
    }
  }

  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="Whether Bluetooth is enabled")
  public boolean Enabled()
  {
    Object localObject = BluetoothReflection.getBluetoothAdapter();
    return (localObject != null) && (BluetoothReflection.isBluetoothEnabled(localObject));
  }

  @DesignerProperty(defaultValue="False", editorType="boolean")
  @SimpleProperty
  public void HighByteFirst(boolean paramBoolean)
  {
    if (paramBoolean);
    for (ByteOrder localByteOrder = ByteOrder.BIG_ENDIAN; ; localByteOrder = ByteOrder.LITTLE_ENDIAN)
    {
      this.byteOrder = localByteOrder;
      return;
    }
  }

  @SimpleProperty(category=PropertyCategory.BEHAVIOR)
  public boolean HighByteFirst()
  {
    return this.byteOrder == ByteOrder.BIG_ENDIAN;
  }

  public final void Initialize()
  {
  }

  @SimpleProperty(category=PropertyCategory.BEHAVIOR)
  public final boolean IsConnected()
  {
    return this.connectedBluetoothSocket != null;
  }

  @SimpleFunction(description="Receive a signed 1-byte number from the connected Bluetooth device.")
  public int ReceiveSigned1ByteNumber()
  {
    byte[] arrayOfByte = read("ReceiveSigned1ByteNumber", 1);
    if (arrayOfByte.length != 1)
      return 0;
    return arrayOfByte[0];
  }

  @SimpleFunction(description="Receive a signed 2-byte number from the connected Bluetooth device.")
  public int ReceiveSigned2ByteNumber()
  {
    byte[] arrayOfByte = read("ReceiveSigned2ByteNumber", 2);
    if (arrayOfByte.length != 2)
      return 0;
    if (this.byteOrder == ByteOrder.BIG_ENDIAN)
      return 0xFF & arrayOfByte[1] | arrayOfByte[0] << 8;
    return 0xFF & arrayOfByte[0] | arrayOfByte[1] << 8;
  }

  @SimpleFunction(description="Receive a signed 4-byte number from the connected Bluetooth device.")
  public long ReceiveSigned4ByteNumber()
  {
    byte[] arrayOfByte = read("ReceiveSigned4ByteNumber", 4);
    if (arrayOfByte.length != 4)
      return 0L;
    if (this.byteOrder == ByteOrder.BIG_ENDIAN)
      return 0xFF & arrayOfByte[3] | (0xFF & arrayOfByte[2]) << 8 | (0xFF & arrayOfByte[1]) << 16 | arrayOfByte[0] << 24;
    return 0xFF & arrayOfByte[0] | (0xFF & arrayOfByte[1]) << 8 | (0xFF & arrayOfByte[2]) << 16 | arrayOfByte[3] << 24;
  }

  @SimpleFunction(description="Receive multiple signed byte values from the connected Bluetooth device. If numberOfBytes is less than 0, read until a delimiter byte value is received.")
  public List<Integer> ReceiveSignedBytes(int paramInt)
  {
    byte[] arrayOfByte = read("ReceiveSignedBytes", paramInt);
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; i < arrayOfByte.length; i++)
      localArrayList.add(Integer.valueOf(arrayOfByte[i]));
    return localArrayList;
  }

  @SimpleFunction(description="Receive text from the connected Bluetooth device. If numberOfBytes is less than 0, read until a delimiter byte value is received.")
  public String ReceiveText(int paramInt)
  {
    byte[] arrayOfByte = read("ReceiveText", paramInt);
    if (paramInt < 0);
    try
    {
      return new String(arrayOfByte, 0, arrayOfByte.length - 1, this.encoding);
      String str = new String(arrayOfByte, this.encoding);
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      Log.w(this.logTag, "UnsupportedEncodingException: " + localUnsupportedEncodingException.getMessage());
    }
    return new String(arrayOfByte);
  }

  @SimpleFunction(description="Receive an unsigned 1-byte number from the connected Bluetooth device.")
  public int ReceiveUnsigned1ByteNumber()
  {
    byte[] arrayOfByte = read("ReceiveUnsigned1ByteNumber", 1);
    if (arrayOfByte.length != 1)
      return 0;
    return 0xFF & arrayOfByte[0];
  }

  @SimpleFunction(description="Receive a unsigned 2-byte number from the connected Bluetooth device.")
  public int ReceiveUnsigned2ByteNumber()
  {
    byte[] arrayOfByte = read("ReceiveUnsigned2ByteNumber", 2);
    if (arrayOfByte.length != 2)
      return 0;
    if (this.byteOrder == ByteOrder.BIG_ENDIAN)
      return 0xFF & arrayOfByte[1] | (0xFF & arrayOfByte[0]) << 8;
    return 0xFF & arrayOfByte[0] | (0xFF & arrayOfByte[1]) << 8;
  }

  @SimpleFunction(description="Receive a unsigned 4-byte number from the connected Bluetooth device.")
  public long ReceiveUnsigned4ByteNumber()
  {
    byte[] arrayOfByte = read("ReceiveUnsigned4ByteNumber", 4);
    if (arrayOfByte.length != 4)
      return 0L;
    if (this.byteOrder == ByteOrder.BIG_ENDIAN)
      return 0xFF & arrayOfByte[3] | (0xFF & arrayOfByte[2]) << 8 | (0xFF & arrayOfByte[1]) << 16 | (0xFF & arrayOfByte[0]) << 24;
    return 0xFF & arrayOfByte[0] | (0xFF & arrayOfByte[1]) << 8 | (0xFF & arrayOfByte[2]) << 16 | (0xFF & arrayOfByte[3]) << 24;
  }

  @SimpleFunction(description="Receive multiple unsigned byte values from the connected Bluetooth device. If numberOfBytes is less than 0, read until a delimiter byte value is received.")
  public List<Integer> ReceiveUnsignedBytes(int paramInt)
  {
    byte[] arrayOfByte = read("ReceiveUnsignedBytes", paramInt);
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; i < arrayOfByte.length; i++)
      localArrayList.add(Integer.valueOf(0xFF & arrayOfByte[i]));
    return localArrayList;
  }

  @DesignerProperty(defaultValue="True", editorType="boolean")
  @SimpleProperty
  public void Secure(boolean paramBoolean)
  {
    this.secure = paramBoolean;
  }

  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="Whether to invoke SSP (Simple Secure Pairing), which is supported on devices with Bluetooth v2.1 or higher. When working with embedded Bluetooth devices, this property may need to be set to False. For Android 2.0-2.2, this property setting will be ignored.")
  public boolean Secure()
  {
    return this.secure;
  }

  @SimpleFunction(description="Send a 1-byte number to the connected Bluetooth device.")
  public void Send1ByteNumber(String paramString)
  {
    byte b;
    try
    {
      int i = Integer.decode(paramString).intValue();
      b = (byte)i;
      int j = i >> 8;
      if ((j != 0) && (j != -1))
      {
        bluetoothError("Send1ByteNumber", 511, new Object[] { paramString });
        return;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      bluetoothError("Send1ByteNumber", 510, new Object[] { paramString });
      return;
    }
    write("Send1ByteNumber", b);
  }

  @SimpleFunction(description="Send a 2-byte number to the connected Bluetooth device.")
  public void Send2ByteNumber(String paramString)
  {
    byte[] arrayOfByte;
    while (true)
    {
      int i;
      try
      {
        i = Integer.decode(paramString).intValue();
        arrayOfByte = new byte[2];
        if (this.byteOrder == ByteOrder.BIG_ENDIAN)
        {
          arrayOfByte[1] = ((byte)(i & 0xFF));
          j = i >> 8;
          arrayOfByte[0] = ((byte)(j & 0xFF));
          int k = j >> 8;
          if ((k == 0) || (k == -1))
            break;
          Object[] arrayOfObject = new Object[2];
          arrayOfObject[0] = paramString;
          arrayOfObject[1] = Integer.valueOf(2);
          bluetoothError("Send2ByteNumber", 512, arrayOfObject);
          return;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        bluetoothError("Send2ByteNumber", 510, new Object[] { paramString });
        return;
      }
      arrayOfByte[0] = ((byte)(i & 0xFF));
      int j = i >> 8;
      arrayOfByte[1] = ((byte)(j & 0xFF));
    }
    write("Send2ByteNumber", arrayOfByte);
  }

  @SimpleFunction(description="Send a 4-byte number to the connected Bluetooth device.")
  public void Send4ByteNumber(String paramString)
  {
    byte[] arrayOfByte;
    while (true)
    {
      long l1;
      try
      {
        l1 = Long.decode(paramString).longValue();
        arrayOfByte = new byte[4];
        if (this.byteOrder == ByteOrder.BIG_ENDIAN)
        {
          arrayOfByte[3] = ((byte)(int)(l1 & 0xFF));
          long l6 = l1 >> 8;
          arrayOfByte[2] = ((byte)(int)(l6 & 0xFF));
          long l7 = l6 >> 8;
          arrayOfByte[1] = ((byte)(int)(l7 & 0xFF));
          l4 = l7 >> 8;
          arrayOfByte[0] = ((byte)(int)(l4 & 0xFF));
          long l5 = l4 >> 8;
          if ((l5 == 0L) || (l5 == -1L))
            break;
          Object[] arrayOfObject = new Object[2];
          arrayOfObject[0] = paramString;
          arrayOfObject[1] = Integer.valueOf(4);
          bluetoothError("Send4ByteNumber", 512, arrayOfObject);
          return;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        bluetoothError("Send4ByteNumber", 510, new Object[] { paramString });
        return;
      }
      arrayOfByte[0] = ((byte)(int)(l1 & 0xFF));
      long l2 = l1 >> 8;
      arrayOfByte[1] = ((byte)(int)(l2 & 0xFF));
      long l3 = l2 >> 8;
      arrayOfByte[2] = ((byte)(int)(l3 & 0xFF));
      long l4 = l3 >> 8;
      arrayOfByte[3] = ((byte)(int)(l4 & 0xFF));
    }
    write("Send4ByteNumber", arrayOfByte);
  }

  @SimpleFunction(description="Send a list of byte values to the connected Bluetooth device.")
  public void SendBytes(YailList paramYailList)
  {
    Object[] arrayOfObject1 = paramYailList.toArray();
    byte[] arrayOfByte = new byte[arrayOfObject1.length];
    for (int i = 0; i < arrayOfObject1.length; i++)
    {
      String str = arrayOfObject1[i].toString();
      try
      {
        int j = Integer.decode(str).intValue();
        arrayOfByte[i] = ((byte)(j & 0xFF));
        int k = j >> 8;
        if ((k != 0) && (k != -1))
        {
          Object[] arrayOfObject3 = new Object[1];
          arrayOfObject3[0] = Integer.valueOf(i + 1);
          bluetoothError("SendBytes", 514, arrayOfObject3);
          return;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = Integer.valueOf(i + 1);
        bluetoothError("SendBytes", 513, arrayOfObject2);
        return;
      }
    }
    write("SendBytes", arrayOfByte);
  }

  @SimpleFunction(description="Send text to the connected Bluetooth device.")
  public void SendText(String paramString)
  {
    try
    {
      byte[] arrayOfByte2 = paramString.getBytes(this.encoding);
      arrayOfByte1 = arrayOfByte2;
      write("SendText", arrayOfByte1);
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      while (true)
      {
        Log.w(this.logTag, "UnsupportedEncodingException: " + localUnsupportedEncodingException.getMessage());
        byte[] arrayOfByte1 = paramString.getBytes();
      }
    }
  }

  void addBluetoothConnectionListener(BluetoothConnectionListener paramBluetoothConnectionListener)
  {
    this.bluetoothConnectionListeners.add(paramBluetoothConnectionListener);
  }

  protected void bluetoothError(String paramString, int paramInt, Object[] paramArrayOfObject)
  {
    this.form.dispatchErrorOccurredEvent(this, paramString, paramInt, paramArrayOfObject);
  }

  public void onDelete()
  {
    prepareToDie();
  }

  public void onDestroy()
  {
    prepareToDie();
  }

  protected final byte[] read(String paramString, int paramInt)
  {
    if (!IsConnected())
    {
      bluetoothError(paramString, 515, new Object[0]);
      return new byte[0];
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte;
    int k;
    if (paramInt >= 0)
    {
      arrayOfByte = new byte[paramInt];
      k = 0;
      if (k >= paramInt);
    }
    while (true)
    {
      try
      {
        int m = this.inputStream.read(arrayOfByte, k, arrayOfByte.length - k);
        if (m == -1)
        {
          bluetoothError(paramString, 518, new Object[0]);
          localByteArrayOutputStream.write(arrayOfByte, 0, k);
          return localByteArrayOutputStream.toByteArray();
        }
        k += m;
      }
      catch (IOException localIOException2)
      {
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = localIOException2.getMessage();
        bluetoothError(paramString, 517, arrayOfObject2);
        continue;
      }
      int i;
      label200: int j;
      do
      {
        try
        {
          i = this.inputStream.read();
          if (i != -1)
            break label200;
          bluetoothError(paramString, 518, new Object[0]);
        }
        catch (IOException localIOException1)
        {
          Object[] arrayOfObject1 = new Object[1];
          arrayOfObject1[0] = localIOException1.getMessage();
          bluetoothError(paramString, 517, arrayOfObject1);
        }
        break;
        localByteArrayOutputStream.write(i);
        j = this.delimiter;
      }
      while (i != j);
    }
  }

  void removeBluetoothConnectionListener(BluetoothConnectionListener paramBluetoothConnectionListener)
  {
    this.bluetoothConnectionListeners.remove(paramBluetoothConnectionListener);
  }

  protected final void setConnection(Object paramObject)
    throws IOException
  {
    this.connectedBluetoothSocket = paramObject;
    this.inputStream = new BufferedInputStream(BluetoothReflection.getInputStream(this.connectedBluetoothSocket));
    this.outputStream = new BufferedOutputStream(BluetoothReflection.getOutputStream(this.connectedBluetoothSocket));
    fireAfterConnectEvent();
  }

  protected void write(String paramString, byte paramByte)
  {
    if (!IsConnected())
    {
      bluetoothError(paramString, 515, new Object[0]);
      return;
    }
    try
    {
      this.outputStream.write(paramByte);
      this.outputStream.flush();
      return;
    }
    catch (IOException localIOException)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = localIOException.getMessage();
      bluetoothError(paramString, 516, arrayOfObject);
    }
  }

  protected void write(String paramString, byte[] paramArrayOfByte)
  {
    if (!IsConnected())
    {
      bluetoothError(paramString, 515, new Object[0]);
      return;
    }
    try
    {
      this.outputStream.write(paramArrayOfByte);
      this.outputStream.flush();
      return;
    }
    catch (IOException localIOException)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = localIOException.getMessage();
      bluetoothError(paramString, 516, arrayOfObject);
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.BluetoothConnectionBase
 * JD-Core Version:    0.6.2
 */