package com.google.appinventor.components.runtime;

import android.util.Log;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.util.BluetoothReflection;
import com.google.appinventor.components.runtime.util.SdkLevel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@DesignerComponent(category=ComponentCategory.MISC, description="Bluetooth client component", iconName="images/bluetooth.png", nonVisible=true, version=5)
@SimpleObject
@UsesPermissions(permissionNames="android.permission.BLUETOOTH")
public final class BluetoothClient extends BluetoothConnectionBase
{
  private static final String SPP_UUID = "00001101-0000-1000-8000-00805F9B34FB";
  private Set<Integer> acceptableDeviceClasses;
  private final List<Component> attachedComponents = new ArrayList();

  public BluetoothClient(ComponentContainer paramComponentContainer)
  {
    super(paramComponentContainer, "BluetoothClient");
  }

  private void connect(Object paramObject, UUID paramUUID)
    throws IOException
  {
    if ((!this.secure) && (SdkLevel.getLevel() >= 10));
    for (Object localObject = BluetoothReflection.createInsecureRfcommSocketToServiceRecord(paramObject, paramUUID); ; localObject = BluetoothReflection.createRfcommSocketToServiceRecord(paramObject, paramUUID))
    {
      BluetoothReflection.connectToBluetoothSocket(localObject);
      setConnection(localObject);
      Log.i(this.logTag, "Connected to Bluetooth device " + BluetoothReflection.getBluetoothDeviceAddress(paramObject) + " " + BluetoothReflection.getBluetoothDeviceName(paramObject) + ".");
      return;
    }
  }

  // ERROR //
  private boolean connect(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: invokestatic 114	com/google/appinventor/components/runtime/util/BluetoothReflection:getBluetoothAdapter	()Ljava/lang/Object;
    //   3: astore 4
    //   5: aload 4
    //   7: ifnonnull +21 -> 28
    //   10: aload_0
    //   11: getfield 118	com/google/appinventor/components/runtime/BluetoothClient:form	Lcom/google/appinventor/components/runtime/Form;
    //   14: aload_0
    //   15: aload_1
    //   16: sipush 501
    //   19: iconst_0
    //   20: anewarray 120	java/lang/Object
    //   23: invokevirtual 126	com/google/appinventor/components/runtime/Form:dispatchErrorOccurredEvent	(Lcom/google/appinventor/components/runtime/Component;Ljava/lang/String;I[Ljava/lang/Object;)V
    //   26: iconst_0
    //   27: ireturn
    //   28: aload 4
    //   30: invokestatic 130	com/google/appinventor/components/runtime/util/BluetoothReflection:isBluetoothEnabled	(Ljava/lang/Object;)Z
    //   33: ifne +21 -> 54
    //   36: aload_0
    //   37: getfield 118	com/google/appinventor/components/runtime/BluetoothClient:form	Lcom/google/appinventor/components/runtime/Form;
    //   40: aload_0
    //   41: aload_1
    //   42: sipush 502
    //   45: iconst_0
    //   46: anewarray 120	java/lang/Object
    //   49: invokevirtual 126	com/google/appinventor/components/runtime/Form:dispatchErrorOccurredEvent	(Lcom/google/appinventor/components/runtime/Component;Ljava/lang/String;I[Ljava/lang/Object;)V
    //   52: iconst_0
    //   53: ireturn
    //   54: aload_2
    //   55: ldc 89
    //   57: invokevirtual 136	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   60: istore 5
    //   62: iload 5
    //   64: iconst_m1
    //   65: if_icmpeq +11 -> 76
    //   68: aload_2
    //   69: iconst_0
    //   70: iload 5
    //   72: invokevirtual 140	java/lang/String:substring	(II)Ljava/lang/String;
    //   75: astore_2
    //   76: aload 4
    //   78: aload_2
    //   79: invokestatic 144	com/google/appinventor/components/runtime/util/BluetoothReflection:checkBluetoothAddress	(Ljava/lang/Object;Ljava/lang/String;)Z
    //   82: ifne +21 -> 103
    //   85: aload_0
    //   86: getfield 118	com/google/appinventor/components/runtime/BluetoothClient:form	Lcom/google/appinventor/components/runtime/Form;
    //   89: aload_0
    //   90: aload_1
    //   91: sipush 503
    //   94: iconst_0
    //   95: anewarray 120	java/lang/Object
    //   98: invokevirtual 126	com/google/appinventor/components/runtime/Form:dispatchErrorOccurredEvent	(Lcom/google/appinventor/components/runtime/Component;Ljava/lang/String;I[Ljava/lang/Object;)V
    //   101: iconst_0
    //   102: ireturn
    //   103: aload 4
    //   105: aload_2
    //   106: invokestatic 148	com/google/appinventor/components/runtime/util/BluetoothReflection:getRemoteDevice	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   109: astore 6
    //   111: aload 6
    //   113: invokestatic 151	com/google/appinventor/components/runtime/util/BluetoothReflection:isBonded	(Ljava/lang/Object;)Z
    //   116: ifne +21 -> 137
    //   119: aload_0
    //   120: getfield 118	com/google/appinventor/components/runtime/BluetoothClient:form	Lcom/google/appinventor/components/runtime/Form;
    //   123: aload_0
    //   124: aload_1
    //   125: sipush 504
    //   128: iconst_0
    //   129: anewarray 120	java/lang/Object
    //   132: invokevirtual 126	com/google/appinventor/components/runtime/Form:dispatchErrorOccurredEvent	(Lcom/google/appinventor/components/runtime/Component;Ljava/lang/String;I[Ljava/lang/Object;)V
    //   135: iconst_0
    //   136: ireturn
    //   137: aload_0
    //   138: aload 6
    //   140: invokespecial 154	com/google/appinventor/components/runtime/BluetoothClient:isDeviceClassAcceptable	(Ljava/lang/Object;)Z
    //   143: ifne +21 -> 164
    //   146: aload_0
    //   147: getfield 118	com/google/appinventor/components/runtime/BluetoothClient:form	Lcom/google/appinventor/components/runtime/Form;
    //   150: aload_0
    //   151: aload_1
    //   152: sipush 505
    //   155: iconst_0
    //   156: anewarray 120	java/lang/Object
    //   159: invokevirtual 126	com/google/appinventor/components/runtime/Form:dispatchErrorOccurredEvent	(Lcom/google/appinventor/components/runtime/Component;Ljava/lang/String;I[Ljava/lang/Object;)V
    //   162: iconst_0
    //   163: ireturn
    //   164: aload_3
    //   165: invokestatic 160	java/util/UUID:fromString	(Ljava/lang/String;)Ljava/util/UUID;
    //   168: astore 8
    //   170: aload_0
    //   171: invokevirtual 163	com/google/appinventor/components/runtime/BluetoothClient:Disconnect	()V
    //   174: aload_0
    //   175: aload 6
    //   177: aload 8
    //   179: invokespecial 165	com/google/appinventor/components/runtime/BluetoothClient:connect	(Ljava/lang/Object;Ljava/util/UUID;)V
    //   182: iconst_1
    //   183: ireturn
    //   184: astore 7
    //   186: aload_0
    //   187: getfield 118	com/google/appinventor/components/runtime/BluetoothClient:form	Lcom/google/appinventor/components/runtime/Form;
    //   190: aload_0
    //   191: aload_1
    //   192: sipush 506
    //   195: iconst_1
    //   196: anewarray 120	java/lang/Object
    //   199: dup
    //   200: iconst_0
    //   201: aload_3
    //   202: aastore
    //   203: invokevirtual 126	com/google/appinventor/components/runtime/Form:dispatchErrorOccurredEvent	(Lcom/google/appinventor/components/runtime/Component;Ljava/lang/String;I[Ljava/lang/Object;)V
    //   206: iconst_0
    //   207: ireturn
    //   208: astore 9
    //   210: aload_0
    //   211: invokevirtual 163	com/google/appinventor/components/runtime/BluetoothClient:Disconnect	()V
    //   214: aload_0
    //   215: getfield 118	com/google/appinventor/components/runtime/BluetoothClient:form	Lcom/google/appinventor/components/runtime/Form;
    //   218: aload_0
    //   219: aload_1
    //   220: sipush 507
    //   223: iconst_0
    //   224: anewarray 120	java/lang/Object
    //   227: invokevirtual 126	com/google/appinventor/components/runtime/Form:dispatchErrorOccurredEvent	(Lcom/google/appinventor/components/runtime/Component;Ljava/lang/String;I[Ljava/lang/Object;)V
    //   230: iconst_0
    //   231: ireturn
    //
    // Exception table:
    //   from	to	target	type
    //   164	170	184	java/lang/IllegalArgumentException
    //   174	182	208	java/io/IOException
  }

  private boolean isDeviceClassAcceptable(Object paramObject)
  {
    if (this.acceptableDeviceClasses == null)
      return true;
    Object localObject = BluetoothReflection.getBluetoothClass(paramObject);
    if (localObject == null)
      return false;
    int i = BluetoothReflection.getDeviceClass(localObject);
    return this.acceptableDeviceClasses.contains(Integer.valueOf(i));
  }

  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="The addresses and names of paired Bluetooth devices")
  public List<String> AddressesAndNames()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = BluetoothReflection.getBluetoothAdapter();
    if ((localObject1 != null) && (BluetoothReflection.isBluetoothEnabled(localObject1)))
    {
      Iterator localIterator = BluetoothReflection.getBondedDevices(localObject1).iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = localIterator.next();
        if (isDeviceClassAcceptable(localObject2))
        {
          String str1 = BluetoothReflection.getBluetoothDeviceName(localObject2);
          String str2 = BluetoothReflection.getBluetoothDeviceAddress(localObject2);
          localArrayList.add(str2 + " " + str1);
        }
      }
    }
    return localArrayList;
  }

  @SimpleFunction(description="Connect to the Bluetooth device with the specified address and the Serial Port Profile (SPP). Returns true if the connection was successful.")
  public boolean Connect(String paramString)
  {
    return connect("Connect", paramString, "00001101-0000-1000-8000-00805F9B34FB");
  }

  @SimpleFunction(description="Connect to the Bluetooth device with the specified address and UUID. Returns true if the connection was successful.")
  public boolean ConnectWithUUID(String paramString1, String paramString2)
  {
    return connect("ConnectWithUUID", paramString1, paramString2);
  }

  @SimpleFunction(description="Checks whether the Bluetooth device with the specified address is paired.")
  public boolean IsDevicePaired(String paramString)
  {
    Object localObject = BluetoothReflection.getBluetoothAdapter();
    if (localObject == null)
    {
      this.form.dispatchErrorOccurredEvent(this, "IsDevicePaired", 501, new Object[0]);
      return false;
    }
    if (!BluetoothReflection.isBluetoothEnabled(localObject))
    {
      this.form.dispatchErrorOccurredEvent(this, "IsDevicePaired", 502, new Object[0]);
      return false;
    }
    int i = paramString.indexOf(" ");
    if (i != -1)
      paramString = paramString.substring(0, i);
    if (!BluetoothReflection.checkBluetoothAddress(localObject, paramString))
    {
      this.form.dispatchErrorOccurredEvent(this, "IsDevicePaired", 503, new Object[0]);
      return false;
    }
    return BluetoothReflection.isBonded(BluetoothReflection.getRemoteDevice(localObject, paramString));
  }

  boolean attachComponent(Component paramComponent, Set<Integer> paramSet)
  {
    HashSet localHashSet;
    if (this.attachedComponents.isEmpty())
      if (paramSet == null)
      {
        localHashSet = null;
        this.acceptableDeviceClasses = localHashSet;
      }
    label64: 
    do
    {
      do
      {
        this.attachedComponents.add(paramComponent);
        return true;
        localHashSet = new HashSet(paramSet);
        break;
        if (this.acceptableDeviceClasses != null)
          break label64;
      }
      while (paramSet == null);
      return false;
      if (paramSet == null)
        return false;
      if (!this.acceptableDeviceClasses.containsAll(paramSet))
        return false;
    }
    while (paramSet.containsAll(this.acceptableDeviceClasses));
    return false;
  }

  void detachComponent(Component paramComponent)
  {
    this.attachedComponents.remove(paramComponent);
    if (this.attachedComponents.isEmpty())
      this.acceptableDeviceClasses = null;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.BluetoothClient
 * JD-Core Version:    0.6.2
 */