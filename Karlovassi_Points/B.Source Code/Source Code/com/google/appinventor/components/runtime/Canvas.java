package com.google.appinventor.components.runtime;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.util.BoundingBox;
import com.google.appinventor.components.runtime.util.FileUtil;
import com.google.appinventor.components.runtime.util.FileUtil.FileException;
import com.google.appinventor.components.runtime.util.MediaUtil;
import com.google.appinventor.components.runtime.util.PaintUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@DesignerComponent(category=ComponentCategory.BASIC, description="<p>A two-dimensional touch-sensitive rectangular panel on which drawing can be done and sprites can be moved.</p> <p>The <code>BackgroundColor</code>, <code>PaintColor</code>, <code>BackgroundImage</code>, <code>Width</code>, and <code>Height</code> of the Canvas can be set in either the Designer or in the Blocks Editor.  The <code>Width</code> and <code>Height</code> are measured in pixels and must be positive.</p><p>Any location on the Canvas can be specified as a pair of (X, Y) values, where <ul> <li>X is the number of pixels away from the left edge of the Canvas</li><li>Y is the number of pixels away from the top edge of the Canvas</li></ul>.</p> <p>There are events to tell when and where a Canvas has been touched or a <code>Sprite</code> (<code>ImageSprite</code> or <code>Ball</code>) has been dragged.  There are also methods for drawing points, lines, and circles.</p>", version=7)
@SimpleObject
@UsesPermissions(permissionNames="android.permission.INTERNET,android.permission.WRITE_EXTERNAL_STORAGE")
public final class Canvas extends AndroidViewComponent
  implements ComponentContainer
{
  private static final int DEFAULT_BACKGROUND_COLOR = -1;
  private static final float DEFAULT_LINE_WIDTH = 2.0F;
  private static final int DEFAULT_PAINT_COLOR = -16777216;
  private static final int FLING_INTERVAL = 1000;
  private static final String LOG_TAG = "Canvas";
  private int backgroundColor;
  private String backgroundImagePath = "";
  private final Activity context;
  private boolean drawn;
  private final GestureDetector mGestureDetector;
  private final MotionEventParser motionEventParser;
  private final Paint paint;
  private int paintColor;
  private final List<Sprite> sprites;
  private int textAlignment;
  private final CanvasView view;

  public Canvas(ComponentContainer paramComponentContainer)
  {
    super(paramComponentContainer);
    this.context = paramComponentContainer.$context();
    this.view = new CanvasView(this.context);
    paramComponentContainer.$add(this);
    this.paint = new Paint();
    this.paint.setStrokeWidth(2.0F);
    PaintColor(-16777216);
    BackgroundColor(-1);
    TextAlignment(0);
    FontSize(14.0F);
    this.sprites = new LinkedList();
    this.motionEventParser = new MotionEventParser();
    this.mGestureDetector = new GestureDetector(this.context, new FlingGestureListener());
  }

  private void changePaint(Paint paramPaint, int paramInt)
  {
    if (paramInt == 0)
    {
      PaintUtil.changePaint(paramPaint, -16777216);
      return;
    }
    if (paramInt == 16777215)
    {
      PaintUtil.changePaintTransparent(paramPaint);
      return;
    }
    PaintUtil.changePaint(paramPaint, paramInt);
  }

  // ERROR //
  private String saveFile(java.io.File paramFile, Bitmap.CompressFormat paramCompressFormat, String paramString)
  {
    // Byte code:
    //   0: new 164	java/io/FileOutputStream
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 167	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   8: astore 4
    //   10: aload_0
    //   11: getfield 72	com/google/appinventor/components/runtime/Canvas:view	Lcom/google/appinventor/components/runtime/Canvas$CanvasView;
    //   14: invokestatic 171	com/google/appinventor/components/runtime/Canvas$CanvasView:access$1200	(Lcom/google/appinventor/components/runtime/Canvas$CanvasView;)Landroid/graphics/Bitmap;
    //   17: ifnonnull +43 -> 60
    //   20: aload_0
    //   21: getfield 72	com/google/appinventor/components/runtime/Canvas:view	Lcom/google/appinventor/components/runtime/Canvas$CanvasView;
    //   24: invokestatic 174	com/google/appinventor/components/runtime/Canvas$CanvasView:access$1300	(Lcom/google/appinventor/components/runtime/Canvas$CanvasView;)Landroid/graphics/Bitmap;
    //   27: astore 14
    //   29: aload 14
    //   31: astore 11
    //   33: aload 11
    //   35: aload_2
    //   36: bipush 100
    //   38: aload 4
    //   40: invokevirtual 180	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   43: istore 13
    //   45: aload 4
    //   47: invokevirtual 183	java/io/FileOutputStream:close	()V
    //   50: iload 13
    //   52: ifeq +72 -> 124
    //   55: aload_1
    //   56: invokevirtual 189	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   59: areturn
    //   60: aload_0
    //   61: getfield 72	com/google/appinventor/components/runtime/Canvas:view	Lcom/google/appinventor/components/runtime/Canvas$CanvasView;
    //   64: invokestatic 171	com/google/appinventor/components/runtime/Canvas$CanvasView:access$1200	(Lcom/google/appinventor/components/runtime/Canvas$CanvasView;)Landroid/graphics/Bitmap;
    //   67: astore 11
    //   69: goto -36 -> 33
    //   72: astore 12
    //   74: aload 4
    //   76: invokevirtual 183	java/io/FileOutputStream:close	()V
    //   79: aload 12
    //   81: athrow
    //   82: astore 8
    //   84: aload_0
    //   85: getfield 193	com/google/appinventor/components/runtime/Canvas:container	Lcom/google/appinventor/components/runtime/ComponentContainer;
    //   88: invokeinterface 197 1 0
    //   93: astore 9
    //   95: iconst_1
    //   96: anewarray 199	java/lang/Object
    //   99: astore 10
    //   101: aload 10
    //   103: iconst_0
    //   104: aload_1
    //   105: invokevirtual 189	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   108: aastore
    //   109: aload 9
    //   111: aload_0
    //   112: aload_3
    //   113: sipush 707
    //   116: aload 10
    //   118: invokevirtual 205	com/google/appinventor/components/runtime/Form:dispatchErrorOccurredEvent	(Lcom/google/appinventor/components/runtime/Component;Ljava/lang/String;I[Ljava/lang/Object;)V
    //   121: ldc 57
    //   123: areturn
    //   124: aload_0
    //   125: getfield 193	com/google/appinventor/components/runtime/Canvas:container	Lcom/google/appinventor/components/runtime/ComponentContainer;
    //   128: invokeinterface 197 1 0
    //   133: aload_0
    //   134: aload_3
    //   135: sipush 1001
    //   138: iconst_0
    //   139: anewarray 199	java/lang/Object
    //   142: invokevirtual 205	com/google/appinventor/components/runtime/Form:dispatchErrorOccurredEvent	(Lcom/google/appinventor/components/runtime/Component;Ljava/lang/String;I[Ljava/lang/Object;)V
    //   145: goto -24 -> 121
    //   148: astore 5
    //   150: aload_0
    //   151: getfield 193	com/google/appinventor/components/runtime/Canvas:container	Lcom/google/appinventor/components/runtime/ComponentContainer;
    //   154: invokeinterface 197 1 0
    //   159: astore 6
    //   161: iconst_1
    //   162: anewarray 199	java/lang/Object
    //   165: astore 7
    //   167: aload 7
    //   169: iconst_0
    //   170: aload 5
    //   172: invokevirtual 208	java/io/IOException:getMessage	()Ljava/lang/String;
    //   175: aastore
    //   176: aload 6
    //   178: aload_0
    //   179: aload_3
    //   180: sipush 708
    //   183: aload 7
    //   185: invokevirtual 205	com/google/appinventor/components/runtime/Form:dispatchErrorOccurredEvent	(Lcom/google/appinventor/components/runtime/Component;Ljava/lang/String;I[Ljava/lang/Object;)V
    //   188: goto -67 -> 121
    //
    // Exception table:
    //   from	to	target	type
    //   33	45	72	finally
    //   0	29	82	java/io/FileNotFoundException
    //   45	50	82	java/io/FileNotFoundException
    //   55	60	82	java/io/FileNotFoundException
    //   60	69	82	java/io/FileNotFoundException
    //   74	82	82	java/io/FileNotFoundException
    //   124	145	82	java/io/FileNotFoundException
    //   0	29	148	java/io/IOException
    //   45	50	148	java/io/IOException
    //   55	60	148	java/io/IOException
    //   60	69	148	java/io/IOException
    //   74	82	148	java/io/IOException
    //   124	145	148	java/io/IOException
  }

  public void $add(AndroidViewComponent paramAndroidViewComponent)
  {
    throw new UnsupportedOperationException("Canvas.$add() called");
  }

  public Activity $context()
  {
    return this.context;
  }

  public Form $form()
  {
    return this.container.$form();
  }

  @SimpleProperty(category=PropertyCategory.APPEARANCE, description="The color of the canvas background.")
  public int BackgroundColor()
  {
    return this.backgroundColor;
  }

  @DesignerProperty(defaultValue="&HFFFFFFFF", editorType="color")
  @SimpleProperty
  public void BackgroundColor(int paramInt)
  {
    this.view.setBackgroundColor(paramInt);
  }

  @SimpleProperty(category=PropertyCategory.APPEARANCE, description="The name of a file containing the background image for the canvas")
  public String BackgroundImage()
  {
    return this.backgroundImagePath;
  }

  @DesignerProperty(defaultValue="", editorType="asset")
  @SimpleProperty
  public void BackgroundImage(String paramString)
  {
    this.view.setBackgroundImage(paramString);
  }

  @SimpleFunction(description="Clears anything drawn on this Canvas but not any background color or image.")
  public void Clear()
  {
    this.view.clearDrawingLayer();
  }

  @SimpleEvent
  public void Dragged(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, boolean paramBoolean)
  {
    Object[] arrayOfObject = new Object[7];
    arrayOfObject[0] = Float.valueOf(paramFloat1);
    arrayOfObject[1] = Float.valueOf(paramFloat2);
    arrayOfObject[2] = Float.valueOf(paramFloat3);
    arrayOfObject[3] = Float.valueOf(paramFloat4);
    arrayOfObject[4] = Float.valueOf(paramFloat5);
    arrayOfObject[5] = Float.valueOf(paramFloat6);
    arrayOfObject[6] = Boolean.valueOf(paramBoolean);
    EventDispatcher.dispatchEvent(this, "Dragged", arrayOfObject);
  }

  @SimpleFunction
  public void DrawCircle(int paramInt1, int paramInt2, float paramFloat)
  {
    this.view.canvas.drawCircle(paramInt1, paramInt2, paramFloat, this.paint);
    this.view.invalidate();
  }

  @SimpleFunction
  public void DrawLine(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.view.canvas.drawLine(paramInt1, paramInt2, paramInt3, paramInt4, this.paint);
    this.view.invalidate();
  }

  @SimpleFunction
  public void DrawPoint(int paramInt1, int paramInt2)
  {
    this.view.canvas.drawPoint(paramInt1, paramInt2, this.paint);
    this.view.invalidate();
  }

  @SimpleFunction(description="Draws the specified text relative to the specified coordinates using the values of the FontSize and TextAlignment properties.")
  public void DrawText(String paramString, int paramInt1, int paramInt2)
  {
    this.view.canvas.drawText(paramString, paramInt1, paramInt2, this.paint);
    this.view.invalidate();
  }

  @SimpleFunction(description="Draws the specified text starting at the specified coordinates at the specified angle using the values of the FontSize and TextAlignment properties.")
  public void DrawTextAtAngle(String paramString, int paramInt1, int paramInt2, float paramFloat)
  {
    this.view.drawTextAtAngle(paramString, paramInt1, paramInt2, paramFloat);
  }

  @SimpleEvent
  public void Flung(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, boolean paramBoolean)
  {
    Object[] arrayOfObject = new Object[7];
    arrayOfObject[0] = Float.valueOf(paramFloat1);
    arrayOfObject[1] = Float.valueOf(paramFloat2);
    arrayOfObject[2] = Float.valueOf(paramFloat3);
    arrayOfObject[3] = Float.valueOf(paramFloat4);
    arrayOfObject[4] = Float.valueOf(paramFloat5);
    arrayOfObject[5] = Float.valueOf(paramFloat6);
    arrayOfObject[6] = Boolean.valueOf(paramBoolean);
    EventDispatcher.dispatchEvent(this, "Flung", arrayOfObject);
  }

  @SimpleProperty(category=PropertyCategory.APPEARANCE, description="The font size of text drawn on the canvas.")
  public float FontSize()
  {
    return this.paint.getTextSize();
  }

  @DesignerProperty(defaultValue="14.0", editorType="non_negative_float")
  @SimpleProperty
  public void FontSize(float paramFloat)
  {
    this.paint.setTextSize(paramFloat);
  }

  @SimpleFunction(description="Gets the color of the specified point. This includes the background and any drawn points, lines, or circles but not sprites.")
  public int GetBackgroundPixelColor(int paramInt1, int paramInt2)
  {
    return this.view.getBackgroundPixelColor(paramInt1, paramInt2);
  }

  @SimpleFunction(description="Gets the color of the specified point.")
  public int GetPixelColor(int paramInt1, int paramInt2)
  {
    return this.view.getPixelColor(paramInt1, paramInt2);
  }

  @SimpleProperty(category=PropertyCategory.APPEARANCE, description="The width of lines drawn on the canvas.")
  public float LineWidth()
  {
    return this.paint.getStrokeWidth();
  }

  @DesignerProperty(defaultValue="2.0", editorType="non_negative_float")
  @SimpleProperty
  public void LineWidth(float paramFloat)
  {
    this.paint.setStrokeWidth(paramFloat);
  }

  @SimpleProperty(category=PropertyCategory.APPEARANCE, description="The color in which lines are drawn")
  public int PaintColor()
  {
    return this.paintColor;
  }

  @DesignerProperty(defaultValue="&HFF000000", editorType="color")
  @SimpleProperty
  public void PaintColor(int paramInt)
  {
    this.paintColor = paramInt;
    changePaint(this.paint, paramInt);
  }

  @SimpleFunction
  public String Save()
  {
    try
    {
      String str = saveFile(FileUtil.getPictureFile("png"), Bitmap.CompressFormat.PNG, "Save");
      return str;
    }
    catch (IOException localIOException)
    {
      Form localForm = this.container.$form();
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = localIOException.getMessage();
      localForm.dispatchErrorOccurredEvent(this, "Save", 708, arrayOfObject);
      return "";
    }
    catch (FileUtil.FileException localFileException)
    {
      while (true)
        this.container.$form().dispatchErrorOccurredEvent(this, "Save", localFileException.getErrorMessageNumber(), new Object[0]);
    }
  }

  @SimpleFunction
  public String SaveAs(String paramString)
  {
    Bitmap.CompressFormat localCompressFormat;
    if ((paramString.endsWith(".jpg")) || (paramString.endsWith(".jpeg")))
      localCompressFormat = Bitmap.CompressFormat.JPEG;
    try
    {
      while (true)
      {
        String str = saveFile(FileUtil.getExternalFile(paramString), localCompressFormat, "SaveAs");
        return str;
        if (paramString.endsWith(".png"))
        {
          localCompressFormat = Bitmap.CompressFormat.PNG;
        }
        else
        {
          if (paramString.contains("."))
            break;
          paramString = paramString + ".png";
          localCompressFormat = Bitmap.CompressFormat.PNG;
        }
      }
      this.container.$form().dispatchErrorOccurredEvent(this, "SaveAs", 706, new Object[0]);
      return "";
    }
    catch (IOException localIOException)
    {
      Form localForm = this.container.$form();
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = localIOException.getMessage();
      localForm.dispatchErrorOccurredEvent(this, "SaveAs", 708, arrayOfObject);
      return "";
    }
    catch (FileUtil.FileException localFileException)
    {
      while (true)
        this.container.$form().dispatchErrorOccurredEvent(this, "SaveAs", localFileException.getErrorMessageNumber(), new Object[0]);
    }
  }

  @SimpleFunction(description="Sets the color of the specified point. This differs from DrawPoint by having an argument for color.")
  public void SetBackgroundPixelColor(int paramInt1, int paramInt2, int paramInt3)
  {
    Paint localPaint = new Paint();
    PaintUtil.changePaint(localPaint, paramInt3);
    this.view.canvas.drawPoint(paramInt1, paramInt2, localPaint);
    this.view.invalidate();
  }

  @SimpleProperty(category=PropertyCategory.APPEARANCE, userVisible=false)
  public int TextAlignment()
  {
    return this.textAlignment;
  }

  @DesignerProperty(defaultValue="1", editorType="textalignment")
  @SimpleProperty(userVisible=false)
  public void TextAlignment(int paramInt)
  {
    this.textAlignment = paramInt;
    switch (paramInt)
    {
    default:
      return;
    case 0:
      this.paint.setTextAlign(Paint.Align.LEFT);
      return;
    case 1:
      this.paint.setTextAlign(Paint.Align.CENTER);
      return;
    case 2:
    }
    this.paint.setTextAlign(Paint.Align.RIGHT);
  }

  @SimpleEvent
  public void TouchDown(float paramFloat1, float paramFloat2)
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Float.valueOf(paramFloat1);
    arrayOfObject[1] = Float.valueOf(paramFloat2);
    EventDispatcher.dispatchEvent(this, "TouchDown", arrayOfObject);
  }

  @SimpleEvent
  public void TouchUp(float paramFloat1, float paramFloat2)
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Float.valueOf(paramFloat1);
    arrayOfObject[1] = Float.valueOf(paramFloat2);
    EventDispatcher.dispatchEvent(this, "TouchUp", arrayOfObject);
  }

  @SimpleEvent
  public void Touched(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = Float.valueOf(paramFloat1);
    arrayOfObject[1] = Float.valueOf(paramFloat2);
    arrayOfObject[2] = Boolean.valueOf(paramBoolean);
    EventDispatcher.dispatchEvent(this, "Touched", arrayOfObject);
  }

  void addSprite(Sprite paramSprite)
  {
    for (int i = 0; i < this.sprites.size(); i++)
      if (((Sprite)this.sprites.get(i)).Z() > paramSprite.Z())
      {
        this.sprites.add(i, paramSprite);
        return;
      }
    this.sprites.add(paramSprite);
  }

  void changeSpriteLayer(Sprite paramSprite)
  {
    removeSprite(paramSprite);
    addSprite(paramSprite);
    this.view.invalidate();
  }

  protected void findSpriteCollisions(Sprite paramSprite)
  {
    Iterator localIterator = this.sprites.iterator();
    while (localIterator.hasNext())
    {
      Sprite localSprite = (Sprite)localIterator.next();
      if (localSprite != paramSprite)
        if (paramSprite.CollidingWith(localSprite))
        {
          if ((!paramSprite.Visible()) || (!paramSprite.Enabled()) || (!localSprite.Visible()) || (!localSprite.Enabled()) || (!Sprite.colliding(localSprite, paramSprite)))
          {
            paramSprite.NoLongerCollidingWith(localSprite);
            localSprite.NoLongerCollidingWith(paramSprite);
          }
        }
        else if ((paramSprite.Visible()) && (paramSprite.Enabled()) && (localSprite.Visible()) && (localSprite.Enabled()) && (Sprite.colliding(localSprite, paramSprite)))
        {
          paramSprite.CollidedWith(localSprite);
          localSprite.CollidedWith(paramSprite);
        }
    }
  }

  public View getView()
  {
    return this.view;
  }

  public boolean ready()
  {
    return this.drawn;
  }

  void registerChange(Sprite paramSprite)
  {
    this.view.invalidate();
    findSpriteCollisions(paramSprite);
  }

  void removeSprite(Sprite paramSprite)
  {
    this.sprites.remove(paramSprite);
  }

  public void setChildHeight(AndroidViewComponent paramAndroidViewComponent, int paramInt)
  {
    throw new UnsupportedOperationException("Canvas.setChildHeight() called");
  }

  public void setChildWidth(AndroidViewComponent paramAndroidViewComponent, int paramInt)
  {
    throw new UnsupportedOperationException("Canvas.setChildWidth() called");
  }

  private final class CanvasView extends View
  {
    private BitmapDrawable backgroundDrawable;
    private Bitmap bitmap = Bitmap.createBitmap(32, 48, Bitmap.Config.ARGB_8888);
    private android.graphics.Canvas canvas = new android.graphics.Canvas(this.bitmap);
    private Bitmap completeCache;
    private Bitmap scaledBackgroundBitmap;

    public CanvasView(Context arg2)
    {
      super();
    }

    private Bitmap buildCache()
    {
      setDrawingCacheEnabled(true);
      destroyDrawingCache();
      Bitmap localBitmap = getDrawingCache();
      if (localBitmap == null)
      {
        int i = getWidth();
        int j = getHeight();
        localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
        android.graphics.Canvas localCanvas = new android.graphics.Canvas(localBitmap);
        layout(0, 0, i, j);
        draw(localCanvas);
      }
      return localBitmap;
    }

    private void clearDrawingLayer()
    {
      this.canvas.drawColor(0, PorterDuff.Mode.CLEAR);
      invalidate();
    }

    private void drawTextAtAngle(String paramString, int paramInt1, int paramInt2, float paramFloat)
    {
      this.canvas.save();
      this.canvas.rotate(-paramFloat, paramInt1, paramInt2);
      this.canvas.drawText(paramString, paramInt1, paramInt2, Canvas.this.paint);
      this.canvas.restore();
      invalidate();
    }

    private int getBackgroundPixelColor(int paramInt1, int paramInt2)
    {
      if ((paramInt1 < 0) || (paramInt1 >= this.bitmap.getWidth()) || (paramInt2 < 0) || (paramInt2 >= this.bitmap.getHeight()))
        return 16777215;
      try
      {
        int i = this.bitmap.getPixel(paramInt1, paramInt2);
        if (i != 0)
          return i;
        if (this.backgroundDrawable != null)
        {
          if (this.scaledBackgroundBitmap == null)
            this.scaledBackgroundBitmap = Bitmap.createScaledBitmap(this.backgroundDrawable.getBitmap(), this.bitmap.getWidth(), this.bitmap.getHeight(), false);
          return this.scaledBackgroundBitmap.getPixel(paramInt1, paramInt2);
        }
        if (Color.alpha(Canvas.this.backgroundColor) != 0)
        {
          int j = Canvas.this.backgroundColor;
          return j;
        }
        return 16777215;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        Log.e("Canvas", String.format("Returning COLOR_NONE (exception) from getBackgroundPixelColor.", new Object[0]));
      }
      return 16777215;
    }

    private int getPixelColor(int paramInt1, int paramInt2)
    {
      if ((paramInt1 < 0) || (paramInt1 >= this.bitmap.getWidth()) || (paramInt2 < 0) || (paramInt2 >= this.bitmap.getHeight()))
        return 16777215;
      if (this.completeCache == null)
      {
        Iterator localIterator = Canvas.this.sprites.iterator();
        do
        {
          boolean bool = localIterator.hasNext();
          j = 0;
          if (!bool)
            break;
        }
        while (!((Sprite)localIterator.next()).Visible());
        int j = 1;
        if (j == 0)
          return getBackgroundPixelColor(paramInt1, paramInt2);
        this.completeCache = buildCache();
      }
      try
      {
        int i = this.completeCache.getPixel(paramInt1, paramInt2);
        return i;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        Log.e("Canvas", String.format("Returning COLOR_NONE (exception) from getPixelColor.", new Object[0]));
      }
      return 16777215;
    }

    private int getSize(int paramInt1, int paramInt2)
    {
      int i = View.MeasureSpec.getMode(paramInt1);
      int j = View.MeasureSpec.getSize(paramInt1);
      int k;
      if (i == 1073741824)
        k = j;
      do
      {
        return k;
        k = paramInt2;
      }
      while (i != -2147483648);
      return Math.min(k, j);
    }

    public void onDraw(android.graphics.Canvas paramCanvas)
    {
      this.completeCache = null;
      super.onDraw(paramCanvas);
      paramCanvas.drawBitmap(this.bitmap, 0.0F, 0.0F, null);
      Iterator localIterator = Canvas.this.sprites.iterator();
      while (localIterator.hasNext())
        ((Sprite)localIterator.next()).onDraw(paramCanvas);
      Canvas.access$102(Canvas.this, true);
    }

    protected void onMeasure(int paramInt1, int paramInt2)
    {
      Bitmap localBitmap;
      int i;
      if (this.backgroundDrawable != null)
      {
        localBitmap = this.backgroundDrawable.getBitmap();
        i = localBitmap.getWidth();
      }
      for (int j = localBitmap.getHeight(); ; j = 48)
      {
        setMeasuredDimension(getSize(paramInt1, i), getSize(paramInt2, j));
        return;
        i = 32;
      }
    }

    protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      int i = this.bitmap.getWidth();
      int j = this.bitmap.getHeight();
      Bitmap localBitmap1;
      if ((paramInt1 != i) || (paramInt2 != j))
      {
        localBitmap1 = this.bitmap;
        Bitmap localBitmap2 = Bitmap.createScaledBitmap(localBitmap1, paramInt1, paramInt2, false);
        if (!localBitmap2.isMutable())
          break label81;
        this.bitmap = localBitmap2;
        this.canvas = new android.graphics.Canvas(this.bitmap);
      }
      while (true)
      {
        this.scaledBackgroundBitmap = null;
        return;
        label81: this.bitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
        this.canvas = new android.graphics.Canvas(this.bitmap);
        Rect localRect = new Rect(0, 0, i, j);
        RectF localRectF = new RectF(0.0F, 0.0F, paramInt1, paramInt2);
        this.canvas.drawBitmap(localBitmap1, localRect, localRectF, null);
      }
    }

    public boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      Canvas.this.container.$form().dontGrabTouchEventsForComponent();
      Canvas.this.motionEventParser.parse(paramMotionEvent);
      Canvas.this.mGestureDetector.onTouchEvent(paramMotionEvent);
      return true;
    }

    public void setBackgroundColor(int paramInt)
    {
      Canvas.access$502(Canvas.this, paramInt);
      if (this.backgroundDrawable == null)
        super.setBackgroundColor(paramInt);
      clearDrawingLayer();
    }

    void setBackgroundImage(String paramString)
    {
      Canvas localCanvas = Canvas.this;
      String str;
      if (paramString == null)
        str = "";
      while (true)
      {
        Canvas.access$402(localCanvas, str);
        this.backgroundDrawable = null;
        this.scaledBackgroundBitmap = null;
        if (!TextUtils.isEmpty(Canvas.this.backgroundImagePath));
        try
        {
          this.backgroundDrawable = MediaUtil.getBitmapDrawable(Canvas.this.container.$form(), Canvas.this.backgroundImagePath);
          setBackgroundDrawable(this.backgroundDrawable);
          if (this.backgroundDrawable == null)
            super.setBackgroundColor(Canvas.this.backgroundColor);
          clearDrawingLayer();
          return;
          str = paramString;
        }
        catch (IOException localIOException)
        {
          while (true)
            Log.e("Canvas", "Unable to load " + Canvas.this.backgroundImagePath);
        }
      }
    }
  }

  class FlingGestureListener extends GestureDetector.SimpleOnGestureListener
  {
    FlingGestureListener()
    {
    }

    public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      float f1 = Math.max(0, (int)paramMotionEvent1.getX());
      float f2 = Math.max(0, (int)paramMotionEvent1.getY());
      float f3 = paramFloat1 / 1000.0F;
      float f4 = paramFloat2 / 1000.0F;
      float f5 = (float)Math.sqrt(f3 * f3 + f4 * f4);
      float f6 = (float)-Math.toDegrees(Math.atan2(f4, f3));
      int i = Canvas.this.Width();
      int j = Canvas.this.Height();
      BoundingBox localBoundingBox = new BoundingBox(Math.max(0, (int)f1 - 12), Math.max(0, (int)f2 - 12), Math.min(i - 1, 12 + (int)f1), Math.min(j - 1, 12 + (int)f2));
      boolean bool = false;
      Iterator localIterator = Canvas.this.sprites.iterator();
      while (localIterator.hasNext())
      {
        Sprite localSprite = (Sprite)localIterator.next();
        if ((localSprite.Enabled()) && (localSprite.Visible()) && (localSprite.intersectsWith(localBoundingBox)))
        {
          localSprite.Flung(f1, f2, f5, f6, f3, f4);
          bool = true;
        }
      }
      Canvas.this.Flung(f1, f2, f5, f6, f3, f4, bool);
      return true;
    }
  }

  class MotionEventParser
  {
    public static final int FINGER_HEIGHT = 24;
    public static final int FINGER_WIDTH = 24;
    private static final int HALF_FINGER_HEIGHT = 12;
    private static final int HALF_FINGER_WIDTH = 12;
    public static final int TAP_THRESHOLD = 30;
    private static final int UNSET = -1;
    private boolean drag = false;
    private final List<Sprite> draggedSprites = new ArrayList();
    private boolean isDrag = false;
    private float lastX = -1.0F;
    private float lastY = -1.0F;
    private float startX = -1.0F;
    private float startY = -1.0F;

    MotionEventParser()
    {
    }

    void parse(MotionEvent paramMotionEvent)
    {
      int i = Canvas.this.Width();
      int j = Canvas.this.Height();
      float f1 = Math.max(0, (int)paramMotionEvent.getX());
      float f2 = Math.max(0, (int)paramMotionEvent.getY());
      BoundingBox localBoundingBox = new BoundingBox(Math.max(0, (int)f1 - 12), Math.max(0, (int)f2 - 12), Math.min(i - 1, 12 + (int)f1), Math.min(j - 1, 12 + (int)f2));
      switch (paramMotionEvent.getAction())
      {
      default:
      case 0:
      case 2:
        do
        {
          return;
          this.draggedSprites.clear();
          this.startX = f1;
          this.startY = f2;
          this.lastX = f1;
          this.lastY = f2;
          this.drag = false;
          this.isDrag = false;
          Iterator localIterator5 = Canvas.this.sprites.iterator();
          while (localIterator5.hasNext())
          {
            Sprite localSprite5 = (Sprite)localIterator5.next();
            if ((localSprite5.Enabled()) && (localSprite5.Visible()) && (localSprite5.intersectsWith(localBoundingBox)))
            {
              this.draggedSprites.add(localSprite5);
              localSprite5.TouchDown(this.startX, this.startY);
            }
          }
          Canvas.this.TouchDown(this.startX, this.startY);
          return;
          if ((this.startX == -1.0F) || (this.startY == -1.0F) || (this.lastX == -1.0F) || (this.lastY == -1.0F))
            Log.w("Canvas", "In Canvas.MotionEventParser.parse(), an ACTION_MOVE was passed without a preceding ACTION_DOWN: " + paramMotionEvent);
        }
        while ((!this.isDrag) && (Math.abs(f1 - this.startX) < 30.0F) && (Math.abs(f2 - this.startY) < 30.0F));
        this.isDrag = true;
        this.drag = true;
        Iterator localIterator3 = Canvas.this.sprites.iterator();
        while (localIterator3.hasNext())
        {
          Sprite localSprite4 = (Sprite)localIterator3.next();
          if ((!this.draggedSprites.contains(localSprite4)) && (localSprite4.Enabled()) && (localSprite4.Visible()) && (localSprite4.intersectsWith(localBoundingBox)))
            this.draggedSprites.add(localSprite4);
        }
        boolean bool2 = false;
        Iterator localIterator4 = this.draggedSprites.iterator();
        while (localIterator4.hasNext())
        {
          Sprite localSprite3 = (Sprite)localIterator4.next();
          if ((localSprite3.Enabled()) && (localSprite3.Visible()))
          {
            localSprite3.Dragged(this.startX, this.startY, this.lastX, this.lastY, f1, f2);
            bool2 = true;
          }
        }
        Canvas.this.Dragged(this.startX, this.startY, this.lastX, this.lastY, f1, f2, bool2);
        this.lastX = f1;
        this.lastY = f2;
        return;
      case 1:
      }
      if (!this.drag)
      {
        boolean bool1 = false;
        Iterator localIterator2 = this.draggedSprites.iterator();
        while (localIterator2.hasNext())
        {
          Sprite localSprite2 = (Sprite)localIterator2.next();
          if ((localSprite2.Enabled()) && (localSprite2.Visible()))
          {
            localSprite2.Touched(this.startX, this.startY);
            localSprite2.TouchUp(this.startX, this.startY);
            bool1 = true;
          }
        }
        Canvas.this.Touched(this.startX, this.startY, bool1);
      }
      while (true)
      {
        Canvas.this.TouchUp(this.startX, this.startY);
        this.drag = false;
        this.startX = -1.0F;
        this.startY = -1.0F;
        this.lastX = -1.0F;
        this.lastY = -1.0F;
        return;
        Iterator localIterator1 = this.draggedSprites.iterator();
        while (localIterator1.hasNext())
        {
          Sprite localSprite1 = (Sprite)localIterator1.next();
          if ((localSprite1.Enabled()) && (localSprite1.Visible()))
          {
            localSprite1.Touched(this.startX, this.startY);
            localSprite1.TouchUp(this.startX, this.startY);
          }
        }
      }
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.Canvas
 * JD-Core Version:    0.6.2
 */