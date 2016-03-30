package com.google.appinventor.components.runtime;

import android.os.Handler;
import android.util.Log;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.util.BluetoothReflection;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

@DesignerComponent(category=ComponentCategory.MISC, description="Bluetooth server component", iconName="images/bluetooth.png", nonVisible=true, version=5)
@SimpleObject
@UsesPermissions(permissionNames="android.permission.BLUETOOTH")
public final class BluetoothServer extends BluetoothConnectionBase
{
  private static final String SPP_UUID = "00001101-0000-1000-8000-00805F9B34FB";
  private final Handler androidUIHandler = new Handler();
  private final AtomicReference<Object> arBluetoothServerSocket = new AtomicReference();

  public BluetoothServer(ComponentContainer paramComponentContainer)
  {
    super(paramComponentContainer, "BluetoothServer");
  }

  // ERROR //
  private void accept(final String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: invokestatic 60	com/google/appinventor/components/runtime/util/BluetoothReflection:getBluetoothAdapter	()Ljava/lang/Object;
    //   3: astore 4
    //   5: aload 4
    //   7: ifnonnull +20 -> 27
    //   10: aload_0
    //   11: getfield 64	com/google/appinventor/components/runtime/BluetoothServer:form	Lcom/google/appinventor/components/runtime/Form;
    //   14: aload_0
    //   15: aload_1
    //   16: sipush 501
    //   19: iconst_0
    //   20: anewarray 66	java/lang/Object
    //   23: invokevirtual 72	com/google/appinventor/components/runtime/Form:dispatchErrorOccurredEvent	(Lcom/google/appinventor/components/runtime/Component;Ljava/lang/String;I[Ljava/lang/Object;)V
    //   26: return
    //   27: aload 4
    //   29: invokestatic 76	com/google/appinventor/components/runtime/util/BluetoothReflection:isBluetoothEnabled	(Ljava/lang/Object;)Z
    //   32: ifne +20 -> 52
    //   35: aload_0
    //   36: getfield 64	com/google/appinventor/components/runtime/BluetoothServer:form	Lcom/google/appinventor/components/runtime/Form;
    //   39: aload_0
    //   40: aload_1
    //   41: sipush 502
    //   44: iconst_0
    //   45: anewarray 66	java/lang/Object
    //   48: invokevirtual 72	com/google/appinventor/components/runtime/Form:dispatchErrorOccurredEvent	(Lcom/google/appinventor/components/runtime/Component;Ljava/lang/String;I[Ljava/lang/Object;)V
    //   51: return
    //   52: aload_3
    //   53: invokestatic 82	java/util/UUID:fromString	(Ljava/lang/String;)Ljava/util/UUID;
    //   56: astore 6
    //   58: aload_0
    //   59: getfield 86	com/google/appinventor/components/runtime/BluetoothServer:secure	Z
    //   62: ifne +66 -> 128
    //   65: invokestatic 92	com/google/appinventor/components/runtime/util/SdkLevel:getLevel	()I
    //   68: bipush 10
    //   70: if_icmplt +58 -> 128
    //   73: aload 4
    //   75: aload_2
    //   76: aload 6
    //   78: invokestatic 96	com/google/appinventor/components/runtime/util/BluetoothReflection:listenUsingInsecureRfcommWithServiceRecord	(Ljava/lang/Object;Ljava/lang/String;Ljava/util/UUID;)Ljava/lang/Object;
    //   81: astore 9
    //   83: aload_0
    //   84: getfield 48	com/google/appinventor/components/runtime/BluetoothServer:arBluetoothServerSocket	Ljava/util/concurrent/atomic/AtomicReference;
    //   87: aload 9
    //   89: invokevirtual 100	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
    //   92: new 102	com/google/appinventor/components/runtime/BluetoothServer$1
    //   95: dup
    //   96: aload_0
    //   97: aload_1
    //   98: invokespecial 105	com/google/appinventor/components/runtime/BluetoothServer$1:<init>	(Lcom/google/appinventor/components/runtime/BluetoothServer;Ljava/lang/String;)V
    //   101: invokestatic 111	com/google/appinventor/components/runtime/util/AsynchUtil:runAsynchronously	(Ljava/lang/Runnable;)V
    //   104: return
    //   105: astore 5
    //   107: aload_0
    //   108: getfield 64	com/google/appinventor/components/runtime/BluetoothServer:form	Lcom/google/appinventor/components/runtime/Form;
    //   111: aload_0
    //   112: aload_1
    //   113: sipush 506
    //   116: iconst_1
    //   117: anewarray 66	java/lang/Object
    //   120: dup
    //   121: iconst_0
    //   122: aload_3
    //   123: aastore
    //   124: invokevirtual 72	com/google/appinventor/components/runtime/Form:dispatchErrorOccurredEvent	(Lcom/google/appinventor/components/runtime/Component;Ljava/lang/String;I[Ljava/lang/Object;)V
    //   127: return
    //   128: aload 4
    //   130: aload_2
    //   131: aload 6
    //   133: invokestatic 114	com/google/appinventor/components/runtime/util/BluetoothReflection:listenUsingRfcommWithServiceRecord	(Ljava/lang/Object;Ljava/lang/String;Ljava/util/UUID;)Ljava/lang/Object;
    //   136: astore 8
    //   138: aload 8
    //   140: astore 9
    //   142: goto -59 -> 83
    //   145: astore 7
    //   147: aload_0
    //   148: getfield 64	com/google/appinventor/components/runtime/BluetoothServer:form	Lcom/google/appinventor/components/runtime/Form;
    //   151: aload_0
    //   152: aload_1
    //   153: sipush 508
    //   156: iconst_0
    //   157: anewarray 66	java/lang/Object
    //   160: invokevirtual 72	com/google/appinventor/components/runtime/Form:dispatchErrorOccurredEvent	(Lcom/google/appinventor/components/runtime/Component;Ljava/lang/String;I[Ljava/lang/Object;)V
    //   163: return
    //
    // Exception table:
    //   from	to	target	type
    //   52	58	105	java/lang/IllegalArgumentException
    //   58	83	145	java/io/IOException
    //   83	92	145	java/io/IOException
    //   128	138	145	java/io/IOException
  }

  @SimpleFunction(description="Accept an incoming connection with the Serial Port Profile (SPP).")
  public void AcceptConnection(String paramString)
  {
    accept("AcceptConnection", paramString, "00001101-0000-1000-8000-00805F9B34FB");
  }

  @SimpleFunction(description="Accept an incoming connection with a specific UUID.")
  public void AcceptConnectionWithUUID(String paramString1, String paramString2)
  {
    accept("AcceptConnectionWithUUID", paramString1, paramString2);
  }

  @SimpleEvent(description="Indicates that a bluetooth connection has been accepted.")
  public void ConnectionAccepted()
  {
    Log.i(this.logTag, "Successfullly accepted bluetooth connection.");
    EventDispatcher.dispatchEvent(this, "ConnectionAccepted", new Object[0]);
  }

  @SimpleProperty(category=PropertyCategory.BEHAVIOR)
  public final boolean IsAccepting()
  {
    return this.arBluetoothServerSocket.get() != null;
  }

  @SimpleFunction(description="Stop accepting an incoming connection.")
  public void StopAccepting()
  {
    Object localObject = this.arBluetoothServerSocket.getAndSet(null);
    if (localObject != null);
    try
    {
      BluetoothReflection.closeBluetoothServerSocket(localObject);
      return;
    }
    catch (IOException localIOException)
    {
      Log.w(this.logTag, "Error while closing bluetooth server socket: " + localIOException.getMessage());
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.BluetoothServer
 * JD-Core Version:    0.6.2
 */