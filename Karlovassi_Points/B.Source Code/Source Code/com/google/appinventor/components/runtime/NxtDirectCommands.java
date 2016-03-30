package com.google.appinventor.components.runtime;

import android.util.Log;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.util.YailList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@DesignerComponent(category=ComponentCategory.LEGOMINDSTORMS, description="A component that provides a low-level interface to a LEGO MINDSTORMS NXT robot, with functions to send NXT Direct Commands.", iconName="images/legoMindstormsNxt.png", nonVisible=true, version=1)
@SimpleObject
@UsesPermissions(permissionNames="android.permission.INTERNET")
public class NxtDirectCommands extends LegoMindstormsNxtBase
{
  public NxtDirectCommands(ComponentContainer paramComponentContainer)
  {
    super(paramComponentContainer, "NxtDirectCommands");
  }

  private void closeHandle(String paramString, int paramInt)
  {
    byte[] arrayOfByte = new byte[3];
    arrayOfByte[0] = 1;
    arrayOfByte[1] = -124;
    copyUBYTEValueToBytes(paramInt, arrayOfByte, 2);
    evaluateStatus(paramString, sendCommandAndReceiveReturnPackage(paramString, arrayOfByte), arrayOfByte[1]);
  }

  private byte[] getOutputState(String paramString, int paramInt)
  {
    byte[] arrayOfByte1 = new byte[3];
    arrayOfByte1[0] = 0;
    arrayOfByte1[1] = 6;
    copyUBYTEValueToBytes(paramInt, arrayOfByte1, 2);
    byte[] arrayOfByte2 = sendCommandAndReceiveReturnPackage(paramString, arrayOfByte1);
    if (evaluateStatus(paramString, arrayOfByte2, arrayOfByte1[1]))
    {
      if (arrayOfByte2.length == 25)
        return arrayOfByte2;
      Log.w(this.logTag, paramString + ": unexpected return package length " + arrayOfByte2.length + " (expected 25)");
    }
    return null;
  }

  private Integer openWrite(String paramString1, String paramString2, long paramLong)
  {
    byte[] arrayOfByte1 = new byte[26];
    arrayOfByte1[0] = 1;
    arrayOfByte1[1] = -127;
    copyStringValueToBytes(paramString2, arrayOfByte1, 2, 19);
    copyULONGValueToBytes(paramLong, arrayOfByte1, 22);
    byte[] arrayOfByte2 = sendCommandAndReceiveReturnPackage(paramString1, arrayOfByte1);
    if (evaluateStatus(paramString1, arrayOfByte2, arrayOfByte1[1]))
    {
      if (arrayOfByte2.length == 4)
        return Integer.valueOf(getUBYTEValueFromBytes(arrayOfByte2, 3));
      Log.w(this.logTag, paramString1 + ": unexpected return package length " + arrayOfByte2.length + " (expected 4)");
    }
    return null;
  }

  private Integer openWriteLinear(String paramString1, String paramString2, long paramLong)
  {
    byte[] arrayOfByte1 = new byte[26];
    arrayOfByte1[0] = 1;
    arrayOfByte1[1] = -119;
    copyStringValueToBytes(paramString2, arrayOfByte1, 2, 19);
    copyULONGValueToBytes(paramLong, arrayOfByte1, 22);
    byte[] arrayOfByte2 = sendCommandAndReceiveReturnPackage(paramString1, arrayOfByte1);
    if (evaluateStatus(paramString1, arrayOfByte2, arrayOfByte1[1]))
    {
      if (arrayOfByte2.length == 4)
        return Integer.valueOf(getUBYTEValueFromBytes(arrayOfByte2, 3));
      Log.w(this.logTag, paramString1 + ": unexpected return package length " + arrayOfByte2.length + " (expected 4)");
    }
    return null;
  }

  private int writeChunk(String paramString, int paramInt1, byte[] paramArrayOfByte, int paramInt2)
    throws IOException
  {
    if (paramInt2 > 32)
      throw new IllegalArgumentException("length must be <= 32");
    byte[] arrayOfByte1 = new byte[paramInt2 + 3];
    arrayOfByte1[0] = 1;
    arrayOfByte1[1] = -125;
    copyUBYTEValueToBytes(paramInt1, arrayOfByte1, 2);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte1, 3, paramInt2);
    byte[] arrayOfByte2 = sendCommandAndReceiveReturnPackage(paramString, arrayOfByte1);
    if (evaluateStatus(paramString, arrayOfByte2, arrayOfByte1[1]))
    {
      if (arrayOfByte2.length == 6)
      {
        int i = getUWORDValueFromBytes(arrayOfByte2, 4);
        if (i != paramInt2)
        {
          Log.e(this.logTag, paramString + ": only " + i + " bytes were written " + "(expected " + paramInt2 + ")");
          throw new IOException("Unable to write file on robot");
        }
        return i;
      }
      Log.w(this.logTag, paramString + ": unexpected return package length " + arrayOfByte2.length + " (expected 6)");
    }
    return 0;
  }

  @SimpleFunction(description="Delete a file on the robot.")
  public void DeleteFile(String paramString)
  {
    if (!checkBluetooth("DeleteFile"))
      return;
    if (paramString.length() == 0)
    {
      this.form.dispatchErrorOccurredEvent(this, "DeleteFile", 406, new Object[0]);
      return;
    }
    byte[] arrayOfByte = new byte[22];
    arrayOfByte[0] = 1;
    arrayOfByte[1] = -123;
    copyStringValueToBytes(paramString, arrayOfByte, 2, 19);
    evaluateStatus("DeleteFile", sendCommandAndReceiveReturnPackage("DeleteFile", arrayOfByte), arrayOfByte[1]);
  }

  // ERROR //
  @SimpleFunction(description="Download a file to the robot.")
  public void DownloadFile(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 161
    //   3: invokevirtual 139	com/google/appinventor/components/runtime/NxtDirectCommands:checkBluetooth	(Ljava/lang/String;)Z
    //   6: ifne +4 -> 10
    //   9: return
    //   10: aload_1
    //   11: invokevirtual 145	java/lang/String:length	()I
    //   14: ifne +21 -> 35
    //   17: aload_0
    //   18: getfield 149	com/google/appinventor/components/runtime/NxtDirectCommands:form	Lcom/google/appinventor/components/runtime/Form;
    //   21: aload_0
    //   22: ldc 161
    //   24: sipush 414
    //   27: iconst_0
    //   28: anewarray 151	java/lang/Object
    //   31: invokevirtual 157	com/google/appinventor/components/runtime/Form:dispatchErrorOccurredEvent	(Lcom/google/appinventor/components/runtime/Component;Ljava/lang/String;I[Ljava/lang/Object;)V
    //   34: return
    //   35: aload_2
    //   36: invokevirtual 145	java/lang/String:length	()I
    //   39: ifne +21 -> 60
    //   42: aload_0
    //   43: getfield 149	com/google/appinventor/components/runtime/NxtDirectCommands:form	Lcom/google/appinventor/components/runtime/Form;
    //   46: aload_0
    //   47: ldc 161
    //   49: sipush 415
    //   52: iconst_0
    //   53: anewarray 151	java/lang/Object
    //   56: invokevirtual 157	com/google/appinventor/components/runtime/Form:dispatchErrorOccurredEvent	(Lcom/google/appinventor/components/runtime/Component;Ljava/lang/String;I[Ljava/lang/Object;)V
    //   59: return
    //   60: aload_0
    //   61: getfield 149	com/google/appinventor/components/runtime/NxtDirectCommands:form	Lcom/google/appinventor/components/runtime/Form;
    //   64: aload_1
    //   65: invokestatic 167	com/google/appinventor/components/runtime/util/MediaUtil:copyMediaToTempFile	(Lcom/google/appinventor/components/runtime/Form;Ljava/lang/String;)Ljava/io/File;
    //   68: astore 6
    //   70: new 169	java/io/FileInputStream
    //   73: dup
    //   74: aload 6
    //   76: invokespecial 172	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   79: astore 7
    //   81: new 174	java/io/BufferedInputStream
    //   84: dup
    //   85: aload 7
    //   87: sipush 1024
    //   90: invokespecial 177	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   93: astore 8
    //   95: aload 6
    //   97: invokevirtual 182	java/io/File:length	()J
    //   100: lstore 12
    //   102: aload_2
    //   103: ldc 184
    //   105: invokevirtual 187	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   108: ifne +12 -> 120
    //   111: aload_2
    //   112: ldc 189
    //   114: invokevirtual 187	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   117: ifeq +70 -> 187
    //   120: aload_0
    //   121: ldc 161
    //   123: aload_2
    //   124: lload 12
    //   126: invokespecial 191	com/google/appinventor/components/runtime/NxtDirectCommands:openWriteLinear	(Ljava/lang/String;Ljava/lang/String;J)Ljava/lang/Integer;
    //   129: astore 14
    //   131: aload 14
    //   133: astore 15
    //   135: aload 15
    //   137: ifnonnull +68 -> 205
    //   140: aload 8
    //   142: invokevirtual 196	java/io/InputStream:close	()V
    //   145: aload 6
    //   147: invokevirtual 200	java/io/File:delete	()Z
    //   150: pop
    //   151: return
    //   152: astore_3
    //   153: aload_0
    //   154: getfield 149	com/google/appinventor/components/runtime/NxtDirectCommands:form	Lcom/google/appinventor/components/runtime/Form;
    //   157: astore 4
    //   159: iconst_1
    //   160: anewarray 151	java/lang/Object
    //   163: astore 5
    //   165: aload 5
    //   167: iconst_0
    //   168: aload_3
    //   169: invokevirtual 203	java/io/IOException:getMessage	()Ljava/lang/String;
    //   172: aastore
    //   173: aload 4
    //   175: aload_0
    //   176: ldc 161
    //   178: sipush 416
    //   181: aload 5
    //   183: invokevirtual 157	com/google/appinventor/components/runtime/Form:dispatchErrorOccurredEvent	(Lcom/google/appinventor/components/runtime/Component;Ljava/lang/String;I[Ljava/lang/Object;)V
    //   186: return
    //   187: aload_0
    //   188: ldc 161
    //   190: aload_2
    //   191: lload 12
    //   193: invokespecial 205	com/google/appinventor/components/runtime/NxtDirectCommands:openWrite	(Ljava/lang/String;Ljava/lang/String;J)Ljava/lang/Integer;
    //   196: astore 25
    //   198: aload 25
    //   200: astore 15
    //   202: goto -67 -> 135
    //   205: bipush 32
    //   207: newarray byte
    //   209: astore 17
    //   211: lconst_0
    //   212: lstore 18
    //   214: lload 18
    //   216: lload 12
    //   218: lcmp
    //   219: ifge +56 -> 275
    //   222: ldc2_w 206
    //   225: lload 12
    //   227: lload 18
    //   229: lsub
    //   230: invokestatic 213	java/lang/Math:min	(JJ)J
    //   233: l2i
    //   234: istore 20
    //   236: aload 8
    //   238: aload 17
    //   240: iconst_0
    //   241: iload 20
    //   243: invokevirtual 217	java/io/InputStream:read	([BII)I
    //   246: pop
    //   247: aload_0
    //   248: ldc 161
    //   250: aload 15
    //   252: invokevirtual 220	java/lang/Integer:intValue	()I
    //   255: aload 17
    //   257: iload 20
    //   259: invokespecial 222	com/google/appinventor/components/runtime/NxtDirectCommands:writeChunk	(Ljava/lang/String;I[BI)I
    //   262: istore 22
    //   264: lload 18
    //   266: iload 22
    //   268: i2l
    //   269: ladd
    //   270: lstore 18
    //   272: goto -58 -> 214
    //   275: aload_0
    //   276: ldc 161
    //   278: aload 15
    //   280: invokevirtual 220	java/lang/Integer:intValue	()I
    //   283: invokespecial 224	com/google/appinventor/components/runtime/NxtDirectCommands:closeHandle	(Ljava/lang/String;I)V
    //   286: aload 8
    //   288: invokevirtual 196	java/io/InputStream:close	()V
    //   291: aload 6
    //   293: invokevirtual 200	java/io/File:delete	()Z
    //   296: pop
    //   297: return
    //   298: astore 16
    //   300: aload_0
    //   301: ldc 161
    //   303: aload 15
    //   305: invokevirtual 220	java/lang/Integer:intValue	()I
    //   308: invokespecial 224	com/google/appinventor/components/runtime/NxtDirectCommands:closeHandle	(Ljava/lang/String;I)V
    //   311: aload 16
    //   313: athrow
    //   314: astore 9
    //   316: aload 8
    //   318: invokevirtual 196	java/io/InputStream:close	()V
    //   321: aload 9
    //   323: athrow
    //   324: astore 10
    //   326: aload 6
    //   328: invokevirtual 200	java/io/File:delete	()Z
    //   331: pop
    //   332: aload 10
    //   334: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   60	70	152	java/io/IOException
    //   145	151	152	java/io/IOException
    //   291	297	152	java/io/IOException
    //   326	335	152	java/io/IOException
    //   205	211	298	finally
    //   222	264	298	finally
    //   95	120	314	finally
    //   120	131	314	finally
    //   187	198	314	finally
    //   275	286	314	finally
    //   300	314	314	finally
    //   70	95	324	finally
    //   140	145	324	finally
    //   286	291	324	finally
    //   316	324	324	finally
  }

  @SimpleFunction(description="Get the battery level for the robot. Returns the voltage in millivolts.")
  public int GetBatteryLevel()
  {
    if (!checkBluetooth("GetBatteryLevel"))
      return 0;
    byte[] arrayOfByte1 = { 0, 11 };
    byte[] arrayOfByte2 = sendCommandAndReceiveReturnPackage("GetBatteryLevel", arrayOfByte1);
    if (evaluateStatus("GetBatteryLevel", arrayOfByte2, arrayOfByte1[1]))
    {
      if (arrayOfByte2.length == 5)
        return getUWORDValueFromBytes(arrayOfByte2, 3);
      Log.w(this.logTag, "GetBatteryLevel: unexpected return package length " + arrayOfByte2.length + " (expected 5)");
    }
    return 0;
  }

  @SimpleFunction(description="Get the brick name of the robot.")
  public String GetBrickName()
  {
    if (!checkBluetooth("GetBrickName"))
      return "";
    byte[] arrayOfByte1 = { 1, -101 };
    byte[] arrayOfByte2 = sendCommandAndReceiveReturnPackage("GetBrickName", arrayOfByte1);
    if (evaluateStatus("GetBrickName", arrayOfByte2, arrayOfByte1[1]))
      return getStringValueFromBytes(arrayOfByte2, 3);
    return "";
  }

  @SimpleFunction(description="Get the name of currently running program on the robot.")
  public String GetCurrentProgramName()
  {
    if (!checkBluetooth("GetCurrentProgramName"))
      return "";
    byte[] arrayOfByte1 = { 0, 17 };
    byte[] arrayOfByte2 = sendCommandAndReceiveReturnPackage("GetCurrentProgramName", arrayOfByte1);
    int i = getStatus("GetCurrentProgramName", arrayOfByte2, arrayOfByte1[1]);
    if (i == 0)
      return getStringValueFromBytes(arrayOfByte2, 3);
    if (i == 236)
      return "";
    evaluateStatus("GetCurrentProgramName", arrayOfByte2, arrayOfByte1[1]);
    return "";
  }

  @SimpleFunction(description="Get the firmware and protocol version numbers for the robot as a list where the first element is the firmware version number and the second element is the protocol version number.")
  public List<String> GetFirmwareVersion()
  {
    if (!checkBluetooth("GetFirmwareVersion"))
      return new ArrayList();
    byte[] arrayOfByte1 = { 1, -120 };
    byte[] arrayOfByte2 = sendCommandAndReceiveReturnPackage("GetFirmwareVersion", arrayOfByte1);
    if (evaluateStatus("GetFirmwareVersion", arrayOfByte2, arrayOfByte1[1]))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(arrayOfByte2[6] + "." + arrayOfByte2[5]);
      localArrayList.add(arrayOfByte2[4] + "." + arrayOfByte2[3]);
      return localArrayList;
    }
    return new ArrayList();
  }

  @SimpleFunction(description="Reads the values of an input sensor on the robot. Assumes sensor type has been configured via SetInputMode.")
  public List<Object> GetInputValues(String paramString)
  {
    if (!checkBluetooth("GetInputValues"))
      return new ArrayList();
    try
    {
      int i = convertSensorPortLetterToNumber(paramString);
      byte[] arrayOfByte = getInputValues("GetInputValues", i);
      if (arrayOfByte != null)
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(Boolean.valueOf(getBooleanValueFromBytes(arrayOfByte, 4)));
        localArrayList.add(Boolean.valueOf(getBooleanValueFromBytes(arrayOfByte, 5)));
        localArrayList.add(Integer.valueOf(getUBYTEValueFromBytes(arrayOfByte, 6)));
        localArrayList.add(Integer.valueOf(getUBYTEValueFromBytes(arrayOfByte, 7)));
        localArrayList.add(Integer.valueOf(getUWORDValueFromBytes(arrayOfByte, 8)));
        localArrayList.add(Integer.valueOf(getUWORDValueFromBytes(arrayOfByte, 10)));
        localArrayList.add(Integer.valueOf(getSWORDValueFromBytes(arrayOfByte, 12)));
        localArrayList.add(Integer.valueOf(getSWORDValueFromBytes(arrayOfByte, 14)));
        return localArrayList;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      this.form.dispatchErrorOccurredEvent(this, "GetInputValues", 408, new Object[] { paramString });
      return new ArrayList();
    }
    return new ArrayList();
  }

  @SimpleFunction(description="Reads the output state of a motor on the robot.")
  public List<Number> GetOutputState(String paramString)
  {
    if (!checkBluetooth("GetOutputState"))
      return new ArrayList();
    try
    {
      int i = convertMotorPortLetterToNumber(paramString);
      byte[] arrayOfByte = getOutputState("GetOutputState", i);
      if (arrayOfByte != null)
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(Integer.valueOf(getSBYTEValueFromBytes(arrayOfByte, 4)));
        localArrayList.add(Integer.valueOf(getUBYTEValueFromBytes(arrayOfByte, 5)));
        localArrayList.add(Integer.valueOf(getUBYTEValueFromBytes(arrayOfByte, 6)));
        localArrayList.add(Integer.valueOf(getSBYTEValueFromBytes(arrayOfByte, 7)));
        localArrayList.add(Integer.valueOf(getUBYTEValueFromBytes(arrayOfByte, 8)));
        localArrayList.add(Long.valueOf(getULONGValueFromBytes(arrayOfByte, 9)));
        localArrayList.add(Integer.valueOf(getSLONGValueFromBytes(arrayOfByte, 13)));
        localArrayList.add(Integer.valueOf(getSLONGValueFromBytes(arrayOfByte, 17)));
        localArrayList.add(Integer.valueOf(getSLONGValueFromBytes(arrayOfByte, 21)));
        return localArrayList;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      this.form.dispatchErrorOccurredEvent(this, "GetOutputState", 407, new Object[] { paramString });
      return new ArrayList();
    }
    return new ArrayList();
  }

  @SimpleFunction(description="Keep Alive. Returns the current sleep time limit in milliseconds.")
  public long KeepAlive()
  {
    if (!checkBluetooth("KeepAlive"))
      return 0L;
    byte[] arrayOfByte1 = { 0, 13 };
    byte[] arrayOfByte2 = sendCommandAndReceiveReturnPackage("KeepAlive", arrayOfByte1);
    if (evaluateStatus("KeepAlive", arrayOfByte2, arrayOfByte1[1]))
    {
      if (arrayOfByte2.length == 7)
        return getULONGValueFromBytes(arrayOfByte2, 3);
      Log.w(this.logTag, "KeepAlive: unexpected return package length " + arrayOfByte2.length + " (expected 7)");
    }
    return 0L;
  }

  @SimpleFunction(description="Returns a list containing the names of matching files found on the robot.")
  public List<String> ListFiles(String paramString)
  {
    if (!checkBluetooth("ListFiles"))
      return new ArrayList();
    ArrayList localArrayList = new ArrayList();
    if (paramString.length() == 0)
      paramString = "*.*";
    byte[] arrayOfByte1 = new byte[22];
    arrayOfByte1[0] = 1;
    arrayOfByte1[1] = -122;
    copyStringValueToBytes(paramString, arrayOfByte1, 2, 19);
    byte[] arrayOfByte2 = sendCommandAndReceiveReturnPackage("ListFiles", arrayOfByte1);
    byte[] arrayOfByte3;
    for (int i = getStatus("ListFiles", arrayOfByte2, arrayOfByte1[1]); i == 0; i = getStatus("ListFiles", arrayOfByte2, arrayOfByte3[1]))
    {
      int j = getUBYTEValueFromBytes(arrayOfByte2, 3);
      localArrayList.add(getStringValueFromBytes(arrayOfByte2, 4));
      arrayOfByte3 = new byte[3];
      arrayOfByte3[0] = 1;
      arrayOfByte3[1] = -121;
      copyUBYTEValueToBytes(j, arrayOfByte3, 2);
      arrayOfByte2 = sendCommandAndReceiveReturnPackage("ListFiles", arrayOfByte3);
    }
    return localArrayList;
  }

  @SimpleFunction(description="Returns the count of available bytes to read.")
  public int LsGetStatus(String paramString)
  {
    if (!checkBluetooth("LsGetStatus"))
      return 0;
    try
    {
      int i = convertSensorPortLetterToNumber(paramString);
      return lsGetStatus("LsGetStatus", i);
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      this.form.dispatchErrorOccurredEvent(this, "LsGetStatus", 408, new Object[] { paramString });
    }
    return 0;
  }

  @SimpleFunction(description="Reads unsigned low speed data from an input sensor on the robot. Assumes sensor type has been configured via SetInputMode.")
  public List<Integer> LsRead(String paramString)
  {
    if (!checkBluetooth("LsRead"))
      return new ArrayList();
    ArrayList localArrayList;
    try
    {
      int i = convertSensorPortLetterToNumber(paramString);
      byte[] arrayOfByte = lsRead("LsRead", i);
      if (arrayOfByte == null)
        break label129;
      localArrayList = new ArrayList();
      int j = getUBYTEValueFromBytes(arrayOfByte, 3);
      for (int k = 0; k < j; k++)
        localArrayList.add(Integer.valueOf(0xFF & arrayOfByte[(k + 4)]));
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      this.form.dispatchErrorOccurredEvent(this, "LsRead", 408, new Object[] { paramString });
      return new ArrayList();
    }
    return localArrayList;
    label129: return new ArrayList();
  }

  @SimpleFunction(description="Writes low speed data to an input sensor on the robot. Assumes sensor type has been configured via SetInputMode.")
  public void LsWrite(String paramString, YailList paramYailList, int paramInt)
  {
    if (!checkBluetooth("LsWrite"))
      return;
    int i;
    try
    {
      i = convertSensorPortLetterToNumber(paramString);
      if (paramYailList.size() > 16)
      {
        this.form.dispatchErrorOccurredEvent(this, "LsWrite", 411, new Object[0]);
        return;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      this.form.dispatchErrorOccurredEvent(this, "LsWrite", 408, new Object[] { paramString });
      return;
    }
    Object[] arrayOfObject1 = paramYailList.toArray();
    byte[] arrayOfByte = new byte[arrayOfObject1.length];
    for (int j = 0; j < arrayOfObject1.length; j++)
    {
      String str = arrayOfObject1[j].toString();
      try
      {
        int k = Integer.decode(str).intValue();
        arrayOfByte[j] = ((byte)(k & 0xFF));
        int m = k >> 8;
        if ((m != 0) && (m != -1))
        {
          Form localForm2 = this.form;
          Object[] arrayOfObject3 = new Object[1];
          arrayOfObject3[0] = Integer.valueOf(j + 1);
          localForm2.dispatchErrorOccurredEvent(this, "LsWrite", 413, arrayOfObject3);
          return;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        Form localForm1 = this.form;
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = Integer.valueOf(j + 1);
        localForm1.dispatchErrorOccurredEvent(this, "LsWrite", 412, arrayOfObject2);
        return;
      }
    }
    lsWrite("LsWrite", i, arrayOfByte, paramInt);
  }

  @SimpleFunction(description="Read a message from a mailbox (1-10) on the robot.")
  public String MessageRead(int paramInt)
  {
    if (!checkBluetooth("MessageRead"))
      return "";
    if ((paramInt < 1) || (paramInt > 10))
    {
      Form localForm = this.form;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(paramInt);
      localForm.dispatchErrorOccurredEvent(this, "MessageRead", 409, arrayOfObject);
      return "";
    }
    int i = paramInt - 1;
    byte[] arrayOfByte1 = new byte[5];
    arrayOfByte1[0] = 0;
    arrayOfByte1[1] = 19;
    copyUBYTEValueToBytes(0, arrayOfByte1, 2);
    copyUBYTEValueToBytes(i, arrayOfByte1, 3);
    copyBooleanValueToBytes(true, arrayOfByte1, 4);
    byte[] arrayOfByte2 = sendCommandAndReceiveReturnPackage("MessageRead", arrayOfByte1);
    if (evaluateStatus("MessageRead", arrayOfByte2, arrayOfByte1[1]))
    {
      if (arrayOfByte2.length == 64)
      {
        int j = getUBYTEValueFromBytes(arrayOfByte2, 3);
        if (j != i)
          Log.w(this.logTag, "MessageRead: unexpected return mailbox: " + j + " (expected " + i + ")");
        return getStringValueFromBytes(arrayOfByte2, 5, getUBYTEValueFromBytes(arrayOfByte2, 4) - 1);
      }
      Log.w(this.logTag, "MessageRead: unexpected return package length " + arrayOfByte2.length + " (expected 64)");
    }
    return "";
  }

  @SimpleFunction(description="Write a message to a mailbox (1-10) on the robot.")
  public void MessageWrite(int paramInt, String paramString)
  {
    if (!checkBluetooth("MessageWrite"))
      return;
    if ((paramInt < 1) || (paramInt > 10))
    {
      Form localForm = this.form;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(paramInt);
      localForm.dispatchErrorOccurredEvent(this, "MessageWrite", 409, arrayOfObject);
      return;
    }
    int i = paramString.length();
    if (i > 58)
    {
      this.form.dispatchErrorOccurredEvent(this, "MessageWrite", 410, new Object[0]);
      return;
    }
    int j = paramInt - 1;
    byte[] arrayOfByte = new byte[1 + (i + 4)];
    arrayOfByte[0] = -128;
    arrayOfByte[1] = 9;
    copyUBYTEValueToBytes(j, arrayOfByte, 2);
    copyUBYTEValueToBytes(i + 1, arrayOfByte, 3);
    copyStringValueToBytes(paramString, arrayOfByte, 4, i);
    sendCommand("MessageWrite", arrayOfByte);
  }

  @SimpleFunction(description="Play a sound file on the robot.")
  public void PlaySoundFile(String paramString)
  {
    if (!checkBluetooth("PlaySoundFile"))
      return;
    if (paramString.length() == 0)
    {
      this.form.dispatchErrorOccurredEvent(this, "PlaySoundFile", 406, new Object[0]);
      return;
    }
    if (paramString.indexOf(".") == -1)
      paramString = paramString + ".rso";
    byte[] arrayOfByte = new byte[23];
    arrayOfByte[0] = -128;
    arrayOfByte[1] = 2;
    copyBooleanValueToBytes(false, arrayOfByte, 2);
    copyStringValueToBytes(paramString, arrayOfByte, 3, 19);
    sendCommand("PlaySoundFile", arrayOfByte);
  }

  @SimpleFunction(description="Make the robot play a tone.")
  public void PlayTone(int paramInt1, int paramInt2)
  {
    if (!checkBluetooth("PlayTone"))
      return;
    if (paramInt1 < 200)
    {
      Log.w(this.logTag, "frequencyHz " + paramInt1 + " is invalid, using 200.");
      paramInt1 = 200;
    }
    if (paramInt1 > 14000)
    {
      Log.w(this.logTag, "frequencyHz " + paramInt1 + " is invalid, using 14000.");
      paramInt1 = 14000;
    }
    byte[] arrayOfByte = new byte[6];
    arrayOfByte[0] = -128;
    arrayOfByte[1] = 3;
    copyUWORDValueToBytes(paramInt1, arrayOfByte, 2);
    copyUWORDValueToBytes(paramInt2, arrayOfByte, 4);
    sendCommand("PlayTone", arrayOfByte);
  }

  @SimpleFunction(description="Reset the scaled value of an input sensor on the robot.")
  public void ResetInputScaledValue(String paramString)
  {
    if (!checkBluetooth("ResetInputScaledValue"))
      return;
    try
    {
      int i = convertSensorPortLetterToNumber(paramString);
      resetInputScaledValue("ResetInputScaledValue", i);
      byte[] arrayOfByte = new byte[3];
      arrayOfByte[0] = -128;
      arrayOfByte[1] = 8;
      copyUBYTEValueToBytes(i, arrayOfByte, 2);
      sendCommand("ResetInputScaledValue", arrayOfByte);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      this.form.dispatchErrorOccurredEvent(this, "ResetInputScaledValue", 408, new Object[] { paramString });
    }
  }

  @SimpleFunction(description="Reset motor position.")
  public void ResetMotorPosition(String paramString, boolean paramBoolean)
  {
    if (!checkBluetooth("ResetMotorPosition"))
      return;
    try
    {
      int i = convertMotorPortLetterToNumber(paramString);
      byte[] arrayOfByte = new byte[4];
      arrayOfByte[0] = -128;
      arrayOfByte[1] = 10;
      copyUBYTEValueToBytes(i, arrayOfByte, 2);
      copyBooleanValueToBytes(paramBoolean, arrayOfByte, 3);
      sendCommand("ResetMotorPosition", arrayOfByte);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      this.form.dispatchErrorOccurredEvent(this, "ResetMotorPosition", 407, new Object[] { paramString });
    }
  }

  @SimpleFunction(description="Set the brick name of the robot.")
  public void SetBrickName(String paramString)
  {
    if (!checkBluetooth("SetBrickName"))
      return;
    byte[] arrayOfByte = new byte[18];
    arrayOfByte[0] = 1;
    arrayOfByte[1] = -104;
    copyStringValueToBytes(paramString, arrayOfByte, 2, 15);
    evaluateStatus("SetBrickName", sendCommandAndReceiveReturnPackage("SetBrickName", arrayOfByte), arrayOfByte[1]);
  }

  @SimpleFunction(description="Configure an input sensor on the robot.")
  public void SetInputMode(String paramString, int paramInt1, int paramInt2)
  {
    if (!checkBluetooth("SetInputMode"))
      return;
    try
    {
      int i = convertSensorPortLetterToNumber(paramString);
      setInputMode("SetInputMode", i, paramInt1, paramInt2);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      this.form.dispatchErrorOccurredEvent(this, "SetInputMode", 408, new Object[] { paramString });
    }
  }

  @SimpleFunction(description="Sets the output state of a motor on the robot.")
  public void SetOutputState(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong)
  {
    if (!checkBluetooth("SetOutputState"))
      return;
    try
    {
      int i = convertMotorPortLetterToNumber(paramString);
      setOutputState("SetOutputState", i, paramInt1, paramInt2, paramInt3, sanitizeTurnRatio(paramInt4), paramInt5, paramLong);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      this.form.dispatchErrorOccurredEvent(this, "SetOutputState", 407, new Object[] { paramString });
    }
  }

  @SimpleFunction(description="Start execution of a previously downloaded program on the robot.")
  public void StartProgram(String paramString)
  {
    if (!checkBluetooth("StartProgram"))
      return;
    if (paramString.length() == 0)
    {
      this.form.dispatchErrorOccurredEvent(this, "StartProgram", 405, new Object[0]);
      return;
    }
    if (paramString.indexOf(".") == -1)
      paramString = paramString + ".rxe";
    byte[] arrayOfByte = new byte[22];
    arrayOfByte[0] = -128;
    arrayOfByte[1] = 0;
    copyStringValueToBytes(paramString, arrayOfByte, 2, 19);
    sendCommand("StartProgram", arrayOfByte);
  }

  @SimpleFunction(description="Stop execution of the currently running program on the robot.")
  public void StopProgram()
  {
    if (!checkBluetooth("StopProgram"))
      return;
    sendCommand("StopProgram", new byte[] { -128, 1 });
  }

  @SimpleFunction(description="Stop sound playback.")
  public void StopSoundPlayback()
  {
    if (!checkBluetooth("StopSoundPlayback"))
      return;
    sendCommand("StopSoundPlayback", new byte[] { -128, 12 });
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.NxtDirectCommands
 * JD-Core Version:    0.6.2
 */