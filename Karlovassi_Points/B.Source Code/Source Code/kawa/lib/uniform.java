package kawa.lib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.lispexpr.LangObjType;
import gnu.lists.F32Vector;
import gnu.lists.F64Vector;
import gnu.lists.LList;
import gnu.lists.S16Vector;
import gnu.lists.S32Vector;
import gnu.lists.S64Vector;
import gnu.lists.S8Vector;
import gnu.lists.U16Vector;
import gnu.lists.U32Vector;
import gnu.lists.U64Vector;
import gnu.lists.U8Vector;
import gnu.mapping.CallContext;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.WrongType;
import gnu.math.IntNum;

public class uniform extends ModuleBody
{
  public static final uniform $instance;
  static final IntNum Lit0;
  static final SimpleSymbol Lit1;
  static final SimpleSymbol Lit10;
  static final SimpleSymbol Lit11;
  static final SimpleSymbol Lit12;
  static final SimpleSymbol Lit13;
  static final SimpleSymbol Lit14;
  static final SimpleSymbol Lit15;
  static final SimpleSymbol Lit16;
  static final SimpleSymbol Lit17;
  static final SimpleSymbol Lit18;
  static final SimpleSymbol Lit19;
  static final SimpleSymbol Lit2;
  static final SimpleSymbol Lit20;
  static final SimpleSymbol Lit21;
  static final SimpleSymbol Lit22;
  static final SimpleSymbol Lit23;
  static final SimpleSymbol Lit24;
  static final SimpleSymbol Lit25;
  static final SimpleSymbol Lit26;
  static final SimpleSymbol Lit27;
  static final SimpleSymbol Lit28;
  static final SimpleSymbol Lit29;
  static final SimpleSymbol Lit3;
  static final SimpleSymbol Lit30;
  static final SimpleSymbol Lit31;
  static final SimpleSymbol Lit32;
  static final SimpleSymbol Lit33;
  static final SimpleSymbol Lit34;
  static final SimpleSymbol Lit35;
  static final SimpleSymbol Lit36;
  static final SimpleSymbol Lit37;
  static final SimpleSymbol Lit38;
  static final SimpleSymbol Lit39;
  static final SimpleSymbol Lit4;
  static final SimpleSymbol Lit40;
  static final SimpleSymbol Lit41;
  static final SimpleSymbol Lit42;
  static final SimpleSymbol Lit43;
  static final SimpleSymbol Lit44;
  static final SimpleSymbol Lit45;
  static final SimpleSymbol Lit46;
  static final SimpleSymbol Lit47;
  static final SimpleSymbol Lit48;
  static final SimpleSymbol Lit49;
  static final SimpleSymbol Lit5;
  static final SimpleSymbol Lit50;
  static final SimpleSymbol Lit51;
  static final SimpleSymbol Lit52;
  static final SimpleSymbol Lit53;
  static final SimpleSymbol Lit54;
  static final SimpleSymbol Lit55;
  static final SimpleSymbol Lit56;
  static final SimpleSymbol Lit57;
  static final SimpleSymbol Lit58;
  static final SimpleSymbol Lit59;
  static final SimpleSymbol Lit6;
  static final SimpleSymbol Lit60;
  static final SimpleSymbol Lit61;
  static final SimpleSymbol Lit62;
  static final SimpleSymbol Lit63;
  static final SimpleSymbol Lit64;
  static final SimpleSymbol Lit65;
  static final SimpleSymbol Lit66;
  static final SimpleSymbol Lit67;
  static final SimpleSymbol Lit68;
  static final SimpleSymbol Lit69;
  static final SimpleSymbol Lit7;
  static final SimpleSymbol Lit70;
  static final SimpleSymbol Lit71;
  static final SimpleSymbol Lit72;
  static final SimpleSymbol Lit73;
  static final SimpleSymbol Lit74;
  static final SimpleSymbol Lit75;
  static final SimpleSymbol Lit76;
  static final SimpleSymbol Lit77;
  static final SimpleSymbol Lit78;
  static final SimpleSymbol Lit79;
  static final SimpleSymbol Lit8;
  static final SimpleSymbol Lit80 = (SimpleSymbol)new SimpleSymbol("list->f64vector").readResolve();
  static final SimpleSymbol Lit9;
  public static final ModuleMethod f32vector;
  public static final ModuleMethod f32vector$Mn$Grlist;
  public static final ModuleMethod f32vector$Mnlength;
  public static final ModuleMethod f32vector$Mnref;
  public static final ModuleMethod f32vector$Mnset$Ex;
  public static final ModuleMethod f32vector$Qu;
  public static final ModuleMethod f64vector;
  public static final ModuleMethod f64vector$Mn$Grlist;
  public static final ModuleMethod f64vector$Mnlength;
  public static final ModuleMethod f64vector$Mnref;
  public static final ModuleMethod f64vector$Mnset$Ex;
  public static final ModuleMethod f64vector$Qu;
  public static final ModuleMethod list$Mn$Grf32vector;
  public static final ModuleMethod list$Mn$Grf64vector;
  public static final ModuleMethod list$Mn$Grs16vector;
  public static final ModuleMethod list$Mn$Grs32vector;
  public static final ModuleMethod list$Mn$Grs64vector;
  public static final ModuleMethod list$Mn$Grs8vector;
  public static final ModuleMethod list$Mn$Gru16vector;
  public static final ModuleMethod list$Mn$Gru32vector;
  public static final ModuleMethod list$Mn$Gru64vector;
  public static final ModuleMethod list$Mn$Gru8vector;
  public static final ModuleMethod make$Mnf32vector;
  public static final ModuleMethod make$Mnf64vector;
  public static final ModuleMethod make$Mns16vector;
  public static final ModuleMethod make$Mns32vector;
  public static final ModuleMethod make$Mns64vector;
  public static final ModuleMethod make$Mns8vector;
  public static final ModuleMethod make$Mnu16vector;
  public static final ModuleMethod make$Mnu32vector;
  public static final ModuleMethod make$Mnu64vector;
  public static final ModuleMethod make$Mnu8vector;
  public static final ModuleMethod s16vector;
  public static final ModuleMethod s16vector$Mn$Grlist;
  public static final ModuleMethod s16vector$Mnlength;
  public static final ModuleMethod s16vector$Mnref;
  public static final ModuleMethod s16vector$Mnset$Ex;
  public static final ModuleMethod s16vector$Qu;
  public static final ModuleMethod s32vector;
  public static final ModuleMethod s32vector$Mn$Grlist;
  public static final ModuleMethod s32vector$Mnlength;
  public static final ModuleMethod s32vector$Mnref;
  public static final ModuleMethod s32vector$Mnset$Ex;
  public static final ModuleMethod s32vector$Qu;
  public static final ModuleMethod s64vector;
  public static final ModuleMethod s64vector$Mn$Grlist;
  public static final ModuleMethod s64vector$Mnlength;
  public static final ModuleMethod s64vector$Mnref;
  public static final ModuleMethod s64vector$Mnset$Ex;
  public static final ModuleMethod s64vector$Qu;
  public static final ModuleMethod s8vector;
  public static final ModuleMethod s8vector$Mn$Grlist;
  public static final ModuleMethod s8vector$Mnlength;
  public static final ModuleMethod s8vector$Mnref;
  public static final ModuleMethod s8vector$Mnset$Ex;
  public static final ModuleMethod s8vector$Qu;
  public static final ModuleMethod u16vector;
  public static final ModuleMethod u16vector$Mn$Grlist;
  public static final ModuleMethod u16vector$Mnlength;
  public static final ModuleMethod u16vector$Mnref;
  public static final ModuleMethod u16vector$Mnset$Ex;
  public static final ModuleMethod u16vector$Qu;
  public static final ModuleMethod u32vector;
  public static final ModuleMethod u32vector$Mn$Grlist;
  public static final ModuleMethod u32vector$Mnlength;
  public static final ModuleMethod u32vector$Mnref;
  public static final ModuleMethod u32vector$Mnset$Ex;
  public static final ModuleMethod u32vector$Qu;
  public static final ModuleMethod u64vector;
  public static final ModuleMethod u64vector$Mn$Grlist;
  public static final ModuleMethod u64vector$Mnlength;
  public static final ModuleMethod u64vector$Mnref;
  public static final ModuleMethod u64vector$Mnset$Ex;
  public static final ModuleMethod u64vector$Qu;
  public static final ModuleMethod u8vector;
  public static final ModuleMethod u8vector$Mn$Grlist;
  public static final ModuleMethod u8vector$Mnlength;
  public static final ModuleMethod u8vector$Mnref;
  public static final ModuleMethod u8vector$Mnset$Ex;
  public static final ModuleMethod u8vector$Qu;

  static
  {
    Lit79 = (SimpleSymbol)new SimpleSymbol("f64vector->list").readResolve();
    Lit78 = (SimpleSymbol)new SimpleSymbol("f64vector-set!").readResolve();
    Lit77 = (SimpleSymbol)new SimpleSymbol("f64vector-ref").readResolve();
    Lit76 = (SimpleSymbol)new SimpleSymbol("f64vector-length").readResolve();
    Lit75 = (SimpleSymbol)new SimpleSymbol("f64vector").readResolve();
    Lit74 = (SimpleSymbol)new SimpleSymbol("make-f64vector").readResolve();
    Lit73 = (SimpleSymbol)new SimpleSymbol("f64vector?").readResolve();
    Lit72 = (SimpleSymbol)new SimpleSymbol("list->f32vector").readResolve();
    Lit71 = (SimpleSymbol)new SimpleSymbol("f32vector->list").readResolve();
    Lit70 = (SimpleSymbol)new SimpleSymbol("f32vector-set!").readResolve();
    Lit69 = (SimpleSymbol)new SimpleSymbol("f32vector-ref").readResolve();
    Lit68 = (SimpleSymbol)new SimpleSymbol("f32vector-length").readResolve();
    Lit67 = (SimpleSymbol)new SimpleSymbol("f32vector").readResolve();
    Lit66 = (SimpleSymbol)new SimpleSymbol("make-f32vector").readResolve();
    Lit65 = (SimpleSymbol)new SimpleSymbol("f32vector?").readResolve();
    Lit64 = (SimpleSymbol)new SimpleSymbol("list->u64vector").readResolve();
    Lit63 = (SimpleSymbol)new SimpleSymbol("u64vector->list").readResolve();
    Lit62 = (SimpleSymbol)new SimpleSymbol("u64vector-set!").readResolve();
    Lit61 = (SimpleSymbol)new SimpleSymbol("u64vector-ref").readResolve();
    Lit60 = (SimpleSymbol)new SimpleSymbol("u64vector-length").readResolve();
    Lit59 = (SimpleSymbol)new SimpleSymbol("u64vector").readResolve();
    Lit58 = (SimpleSymbol)new SimpleSymbol("make-u64vector").readResolve();
    Lit57 = (SimpleSymbol)new SimpleSymbol("u64vector?").readResolve();
    Lit56 = (SimpleSymbol)new SimpleSymbol("list->s64vector").readResolve();
    Lit55 = (SimpleSymbol)new SimpleSymbol("s64vector->list").readResolve();
    Lit54 = (SimpleSymbol)new SimpleSymbol("s64vector-set!").readResolve();
    Lit53 = (SimpleSymbol)new SimpleSymbol("s64vector-ref").readResolve();
    Lit52 = (SimpleSymbol)new SimpleSymbol("s64vector-length").readResolve();
    Lit51 = (SimpleSymbol)new SimpleSymbol("s64vector").readResolve();
    Lit50 = (SimpleSymbol)new SimpleSymbol("make-s64vector").readResolve();
    Lit49 = (SimpleSymbol)new SimpleSymbol("s64vector?").readResolve();
    Lit48 = (SimpleSymbol)new SimpleSymbol("list->u32vector").readResolve();
    Lit47 = (SimpleSymbol)new SimpleSymbol("u32vector->list").readResolve();
    Lit46 = (SimpleSymbol)new SimpleSymbol("u32vector-set!").readResolve();
    Lit45 = (SimpleSymbol)new SimpleSymbol("u32vector-ref").readResolve();
    Lit44 = (SimpleSymbol)new SimpleSymbol("u32vector-length").readResolve();
    Lit43 = (SimpleSymbol)new SimpleSymbol("u32vector").readResolve();
    Lit42 = (SimpleSymbol)new SimpleSymbol("make-u32vector").readResolve();
    Lit41 = (SimpleSymbol)new SimpleSymbol("u32vector?").readResolve();
    Lit40 = (SimpleSymbol)new SimpleSymbol("list->s32vector").readResolve();
    Lit39 = (SimpleSymbol)new SimpleSymbol("s32vector->list").readResolve();
    Lit38 = (SimpleSymbol)new SimpleSymbol("s32vector-set!").readResolve();
    Lit37 = (SimpleSymbol)new SimpleSymbol("s32vector-ref").readResolve();
    Lit36 = (SimpleSymbol)new SimpleSymbol("s32vector-length").readResolve();
    Lit35 = (SimpleSymbol)new SimpleSymbol("s32vector").readResolve();
    Lit34 = (SimpleSymbol)new SimpleSymbol("make-s32vector").readResolve();
    Lit33 = (SimpleSymbol)new SimpleSymbol("s32vector?").readResolve();
    Lit32 = (SimpleSymbol)new SimpleSymbol("list->u16vector").readResolve();
    Lit31 = (SimpleSymbol)new SimpleSymbol("u16vector->list").readResolve();
    Lit30 = (SimpleSymbol)new SimpleSymbol("u16vector-set!").readResolve();
    Lit29 = (SimpleSymbol)new SimpleSymbol("u16vector-ref").readResolve();
    Lit28 = (SimpleSymbol)new SimpleSymbol("u16vector-length").readResolve();
    Lit27 = (SimpleSymbol)new SimpleSymbol("u16vector").readResolve();
    Lit26 = (SimpleSymbol)new SimpleSymbol("make-u16vector").readResolve();
    Lit25 = (SimpleSymbol)new SimpleSymbol("u16vector?").readResolve();
    Lit24 = (SimpleSymbol)new SimpleSymbol("list->s16vector").readResolve();
    Lit23 = (SimpleSymbol)new SimpleSymbol("s16vector->list").readResolve();
    Lit22 = (SimpleSymbol)new SimpleSymbol("s16vector-set!").readResolve();
    Lit21 = (SimpleSymbol)new SimpleSymbol("s16vector-ref").readResolve();
    Lit20 = (SimpleSymbol)new SimpleSymbol("s16vector-length").readResolve();
    Lit19 = (SimpleSymbol)new SimpleSymbol("s16vector").readResolve();
    Lit18 = (SimpleSymbol)new SimpleSymbol("make-s16vector").readResolve();
    Lit17 = (SimpleSymbol)new SimpleSymbol("s16vector?").readResolve();
    Lit16 = (SimpleSymbol)new SimpleSymbol("list->u8vector").readResolve();
    Lit15 = (SimpleSymbol)new SimpleSymbol("u8vector->list").readResolve();
    Lit14 = (SimpleSymbol)new SimpleSymbol("u8vector-set!").readResolve();
    Lit13 = (SimpleSymbol)new SimpleSymbol("u8vector-ref").readResolve();
    Lit12 = (SimpleSymbol)new SimpleSymbol("u8vector-length").readResolve();
    Lit11 = (SimpleSymbol)new SimpleSymbol("u8vector").readResolve();
    Lit10 = (SimpleSymbol)new SimpleSymbol("make-u8vector").readResolve();
    Lit9 = (SimpleSymbol)new SimpleSymbol("u8vector?").readResolve();
    Lit8 = (SimpleSymbol)new SimpleSymbol("list->s8vector").readResolve();
    Lit7 = (SimpleSymbol)new SimpleSymbol("s8vector->list").readResolve();
    Lit6 = (SimpleSymbol)new SimpleSymbol("s8vector-set!").readResolve();
    Lit5 = (SimpleSymbol)new SimpleSymbol("s8vector-ref").readResolve();
    Lit4 = (SimpleSymbol)new SimpleSymbol("s8vector-length").readResolve();
    Lit3 = (SimpleSymbol)new SimpleSymbol("s8vector").readResolve();
    Lit2 = (SimpleSymbol)new SimpleSymbol("make-s8vector").readResolve();
    Lit1 = (SimpleSymbol)new SimpleSymbol("s8vector?").readResolve();
    Lit0 = IntNum.make(0);
    $instance = new uniform();
    uniform localuniform = $instance;
    s8vector$Qu = new ModuleMethod(localuniform, 1, Lit1, 4097);
    make$Mns8vector = new ModuleMethod(localuniform, 2, Lit2, 8193);
    s8vector = new ModuleMethod(localuniform, 4, Lit3, -4096);
    s8vector$Mnlength = new ModuleMethod(localuniform, 5, Lit4, 4097);
    s8vector$Mnref = new ModuleMethod(localuniform, 6, Lit5, 8194);
    s8vector$Mnset$Ex = new ModuleMethod(localuniform, 7, Lit6, 12291);
    s8vector$Mn$Grlist = new ModuleMethod(localuniform, 8, Lit7, 4097);
    list$Mn$Grs8vector = new ModuleMethod(localuniform, 9, Lit8, 4097);
    u8vector$Qu = new ModuleMethod(localuniform, 10, Lit9, 4097);
    make$Mnu8vector = new ModuleMethod(localuniform, 11, Lit10, 8193);
    u8vector = new ModuleMethod(localuniform, 13, Lit11, -4096);
    u8vector$Mnlength = new ModuleMethod(localuniform, 14, Lit12, 4097);
    u8vector$Mnref = new ModuleMethod(localuniform, 15, Lit13, 8194);
    u8vector$Mnset$Ex = new ModuleMethod(localuniform, 16, Lit14, 12291);
    u8vector$Mn$Grlist = new ModuleMethod(localuniform, 17, Lit15, 4097);
    list$Mn$Gru8vector = new ModuleMethod(localuniform, 18, Lit16, 4097);
    s16vector$Qu = new ModuleMethod(localuniform, 19, Lit17, 4097);
    make$Mns16vector = new ModuleMethod(localuniform, 20, Lit18, 8193);
    s16vector = new ModuleMethod(localuniform, 22, Lit19, -4096);
    s16vector$Mnlength = new ModuleMethod(localuniform, 23, Lit20, 4097);
    s16vector$Mnref = new ModuleMethod(localuniform, 24, Lit21, 8194);
    s16vector$Mnset$Ex = new ModuleMethod(localuniform, 25, Lit22, 12291);
    s16vector$Mn$Grlist = new ModuleMethod(localuniform, 26, Lit23, 4097);
    list$Mn$Grs16vector = new ModuleMethod(localuniform, 27, Lit24, 4097);
    u16vector$Qu = new ModuleMethod(localuniform, 28, Lit25, 4097);
    make$Mnu16vector = new ModuleMethod(localuniform, 29, Lit26, 8193);
    u16vector = new ModuleMethod(localuniform, 31, Lit27, -4096);
    u16vector$Mnlength = new ModuleMethod(localuniform, 32, Lit28, 4097);
    u16vector$Mnref = new ModuleMethod(localuniform, 33, Lit29, 8194);
    u16vector$Mnset$Ex = new ModuleMethod(localuniform, 34, Lit30, 12291);
    u16vector$Mn$Grlist = new ModuleMethod(localuniform, 35, Lit31, 4097);
    list$Mn$Gru16vector = new ModuleMethod(localuniform, 36, Lit32, 4097);
    s32vector$Qu = new ModuleMethod(localuniform, 37, Lit33, 4097);
    make$Mns32vector = new ModuleMethod(localuniform, 38, Lit34, 8193);
    s32vector = new ModuleMethod(localuniform, 40, Lit35, -4096);
    s32vector$Mnlength = new ModuleMethod(localuniform, 41, Lit36, 4097);
    s32vector$Mnref = new ModuleMethod(localuniform, 42, Lit37, 8194);
    s32vector$Mnset$Ex = new ModuleMethod(localuniform, 43, Lit38, 12291);
    s32vector$Mn$Grlist = new ModuleMethod(localuniform, 44, Lit39, 4097);
    list$Mn$Grs32vector = new ModuleMethod(localuniform, 45, Lit40, 4097);
    u32vector$Qu = new ModuleMethod(localuniform, 46, Lit41, 4097);
    make$Mnu32vector = new ModuleMethod(localuniform, 47, Lit42, 8193);
    u32vector = new ModuleMethod(localuniform, 49, Lit43, -4096);
    u32vector$Mnlength = new ModuleMethod(localuniform, 50, Lit44, 4097);
    u32vector$Mnref = new ModuleMethod(localuniform, 51, Lit45, 8194);
    u32vector$Mnset$Ex = new ModuleMethod(localuniform, 52, Lit46, 12291);
    u32vector$Mn$Grlist = new ModuleMethod(localuniform, 53, Lit47, 4097);
    list$Mn$Gru32vector = new ModuleMethod(localuniform, 54, Lit48, 4097);
    s64vector$Qu = new ModuleMethod(localuniform, 55, Lit49, 4097);
    make$Mns64vector = new ModuleMethod(localuniform, 56, Lit50, 8193);
    s64vector = new ModuleMethod(localuniform, 58, Lit51, -4096);
    s64vector$Mnlength = new ModuleMethod(localuniform, 59, Lit52, 4097);
    s64vector$Mnref = new ModuleMethod(localuniform, 60, Lit53, 8194);
    s64vector$Mnset$Ex = new ModuleMethod(localuniform, 61, Lit54, 12291);
    s64vector$Mn$Grlist = new ModuleMethod(localuniform, 62, Lit55, 4097);
    list$Mn$Grs64vector = new ModuleMethod(localuniform, 63, Lit56, 4097);
    u64vector$Qu = new ModuleMethod(localuniform, 64, Lit57, 4097);
    make$Mnu64vector = new ModuleMethod(localuniform, 65, Lit58, 8193);
    u64vector = new ModuleMethod(localuniform, 67, Lit59, -4096);
    u64vector$Mnlength = new ModuleMethod(localuniform, 68, Lit60, 4097);
    u64vector$Mnref = new ModuleMethod(localuniform, 69, Lit61, 8194);
    u64vector$Mnset$Ex = new ModuleMethod(localuniform, 70, Lit62, 12291);
    u64vector$Mn$Grlist = new ModuleMethod(localuniform, 71, Lit63, 4097);
    list$Mn$Gru64vector = new ModuleMethod(localuniform, 72, Lit64, 4097);
    f32vector$Qu = new ModuleMethod(localuniform, 73, Lit65, 4097);
    make$Mnf32vector = new ModuleMethod(localuniform, 74, Lit66, 8193);
    f32vector = new ModuleMethod(localuniform, 76, Lit67, -4096);
    f32vector$Mnlength = new ModuleMethod(localuniform, 77, Lit68, 4097);
    f32vector$Mnref = new ModuleMethod(localuniform, 78, Lit69, 8194);
    f32vector$Mnset$Ex = new ModuleMethod(localuniform, 79, Lit70, 12291);
    f32vector$Mn$Grlist = new ModuleMethod(localuniform, 80, Lit71, 4097);
    list$Mn$Grf32vector = new ModuleMethod(localuniform, 81, Lit72, 4097);
    f64vector$Qu = new ModuleMethod(localuniform, 82, Lit73, 4097);
    make$Mnf64vector = new ModuleMethod(localuniform, 83, Lit74, 8193);
    f64vector = new ModuleMethod(localuniform, 85, Lit75, -4096);
    f64vector$Mnlength = new ModuleMethod(localuniform, 86, Lit76, 4097);
    f64vector$Mnref = new ModuleMethod(localuniform, 87, Lit77, 8194);
    f64vector$Mnset$Ex = new ModuleMethod(localuniform, 88, Lit78, 12291);
    f64vector$Mn$Grlist = new ModuleMethod(localuniform, 89, Lit79, 4097);
    list$Mn$Grf64vector = new ModuleMethod(localuniform, 90, Lit80, 4097);
    $instance.run();
  }

  public uniform()
  {
    ModuleInfo.register(this);
  }

  public static LList f32vector$To$List(F32Vector paramF32Vector)
  {
    return LList.makeList(paramF32Vector);
  }

  public static F32Vector f32vector$V(Object[] paramArrayOfObject)
  {
    return list$To$F32vector(LList.makeList(paramArrayOfObject, 0));
  }

  public static int f32vectorLength(F32Vector paramF32Vector)
  {
    return paramF32Vector.size();
  }

  public static float f32vectorRef(F32Vector paramF32Vector, int paramInt)
  {
    return paramF32Vector.floatAt(paramInt);
  }

  public static void f32vectorSet$Ex(F32Vector paramF32Vector, int paramInt, float paramFloat)
  {
    paramF32Vector.setFloatAt(paramInt, paramFloat);
  }

  public static LList f64vector$To$List(F64Vector paramF64Vector)
  {
    return LList.makeList(paramF64Vector);
  }

  public static F64Vector f64vector$V(Object[] paramArrayOfObject)
  {
    return list$To$F64vector(LList.makeList(paramArrayOfObject, 0));
  }

  public static int f64vectorLength(F64Vector paramF64Vector)
  {
    return paramF64Vector.size();
  }

  public static double f64vectorRef(F64Vector paramF64Vector, int paramInt)
  {
    return paramF64Vector.doubleAt(paramInt);
  }

  public static void f64vectorSet$Ex(F64Vector paramF64Vector, int paramInt, double paramDouble)
  {
    paramF64Vector.setDoubleAt(paramInt, paramDouble);
  }

  public static boolean isF32vector(Object paramObject)
  {
    return paramObject instanceof F32Vector;
  }

  public static boolean isF64vector(Object paramObject)
  {
    return paramObject instanceof F64Vector;
  }

  public static boolean isS16vector(Object paramObject)
  {
    return paramObject instanceof S16Vector;
  }

  public static boolean isS32vector(Object paramObject)
  {
    return paramObject instanceof S32Vector;
  }

  public static boolean isS64vector(Object paramObject)
  {
    return paramObject instanceof S64Vector;
  }

  public static boolean isS8vector(Object paramObject)
  {
    return paramObject instanceof S8Vector;
  }

  public static boolean isU16vector(Object paramObject)
  {
    return paramObject instanceof U16Vector;
  }

  public static boolean isU32vector(Object paramObject)
  {
    return paramObject instanceof U32Vector;
  }

  public static boolean isU64vector(Object paramObject)
  {
    return paramObject instanceof U64Vector;
  }

  public static boolean isU8vector(Object paramObject)
  {
    return paramObject instanceof U8Vector;
  }

  public static F32Vector list$To$F32vector(LList paramLList)
  {
    return new F32Vector(paramLList);
  }

  public static F64Vector list$To$F64vector(LList paramLList)
  {
    return new F64Vector(paramLList);
  }

  public static S16Vector list$To$S16vector(LList paramLList)
  {
    return new S16Vector(paramLList);
  }

  public static S32Vector list$To$S32vector(LList paramLList)
  {
    return new S32Vector(paramLList);
  }

  public static S64Vector list$To$S64vector(LList paramLList)
  {
    return new S64Vector(paramLList);
  }

  public static S8Vector list$To$S8vector(LList paramLList)
  {
    return new S8Vector(paramLList);
  }

  public static U16Vector list$To$U16vector(LList paramLList)
  {
    return new U16Vector(paramLList);
  }

  public static U32Vector list$To$U32vector(LList paramLList)
  {
    return new U32Vector(paramLList);
  }

  public static U64Vector list$To$U64vector(LList paramLList)
  {
    return new U64Vector(paramLList);
  }

  public static U8Vector list$To$U8vector(LList paramLList)
  {
    return new U8Vector(paramLList);
  }

  public static F32Vector makeF32vector(int paramInt)
  {
    return makeF32vector(paramInt, 0.0F);
  }

  public static F32Vector makeF32vector(int paramInt, float paramFloat)
  {
    return new F32Vector(paramInt, paramFloat);
  }

  public static F64Vector makeF64vector(int paramInt)
  {
    return makeF64vector(paramInt, 0.0D);
  }

  public static F64Vector makeF64vector(int paramInt, double paramDouble)
  {
    return new F64Vector(paramInt, paramDouble);
  }

  public static S16Vector makeS16vector(int paramInt)
  {
    return makeS16vector(paramInt, 0);
  }

  public static S16Vector makeS16vector(int paramInt1, int paramInt2)
  {
    return new S16Vector(paramInt1, (short)paramInt2);
  }

  public static S32Vector makeS32vector(int paramInt)
  {
    return makeS32vector(paramInt, 0);
  }

  public static S32Vector makeS32vector(int paramInt1, int paramInt2)
  {
    return new S32Vector(paramInt1, paramInt2);
  }

  public static S64Vector makeS64vector(int paramInt)
  {
    return makeS64vector(paramInt, 0L);
  }

  public static S64Vector makeS64vector(int paramInt, long paramLong)
  {
    return new S64Vector(paramInt, paramLong);
  }

  public static S8Vector makeS8vector(int paramInt)
  {
    return makeS8vector(paramInt, 0);
  }

  public static S8Vector makeS8vector(int paramInt1, int paramInt2)
  {
    return new S8Vector(paramInt1, (byte)paramInt2);
  }

  public static U16Vector makeU16vector(int paramInt)
  {
    return makeU16vector(paramInt, 0);
  }

  public static U16Vector makeU16vector(int paramInt1, int paramInt2)
  {
    return new U16Vector(paramInt1, (short)paramInt2);
  }

  public static U32Vector makeU32vector(int paramInt)
  {
    return makeU32vector(paramInt, 0L);
  }

  public static U32Vector makeU32vector(int paramInt, long paramLong)
  {
    return new U32Vector(paramInt, (int)paramLong);
  }

  public static U64Vector makeU64vector(int paramInt)
  {
    return makeU64vector(paramInt, Lit0);
  }

  public static U64Vector makeU64vector(int paramInt, IntNum paramIntNum)
  {
    try
    {
      long l = paramIntNum.longValue();
      return new U64Vector(paramInt, l);
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "gnu.lists.U64Vector.<init>(int,long)", 2, paramIntNum);
    }
  }

  public static U8Vector makeU8vector(int paramInt)
  {
    return makeU8vector(paramInt, 0);
  }

  public static U8Vector makeU8vector(int paramInt1, int paramInt2)
  {
    return new U8Vector(paramInt1, (byte)paramInt2);
  }

  public static LList s16vector$To$List(S16Vector paramS16Vector)
  {
    return LList.makeList(paramS16Vector);
  }

  public static S16Vector s16vector$V(Object[] paramArrayOfObject)
  {
    return list$To$S16vector(LList.makeList(paramArrayOfObject, 0));
  }

  public static int s16vectorLength(S16Vector paramS16Vector)
  {
    return paramS16Vector.size();
  }

  public static int s16vectorRef(S16Vector paramS16Vector, int paramInt)
  {
    return paramS16Vector.intAt(paramInt);
  }

  public static void s16vectorSet$Ex(S16Vector paramS16Vector, int paramInt1, int paramInt2)
  {
    paramS16Vector.setShortAt(paramInt1, (short)paramInt2);
  }

  public static LList s32vector$To$List(S32Vector paramS32Vector)
  {
    return LList.makeList(paramS32Vector);
  }

  public static S32Vector s32vector$V(Object[] paramArrayOfObject)
  {
    return list$To$S32vector(LList.makeList(paramArrayOfObject, 0));
  }

  public static int s32vectorLength(S32Vector paramS32Vector)
  {
    return paramS32Vector.size();
  }

  public static int s32vectorRef(S32Vector paramS32Vector, int paramInt)
  {
    return paramS32Vector.intAt(paramInt);
  }

  public static void s32vectorSet$Ex(S32Vector paramS32Vector, int paramInt1, int paramInt2)
  {
    paramS32Vector.setIntAt(paramInt1, paramInt2);
  }

  public static LList s64vector$To$List(S64Vector paramS64Vector)
  {
    return LList.makeList(paramS64Vector);
  }

  public static S64Vector s64vector$V(Object[] paramArrayOfObject)
  {
    return list$To$S64vector(LList.makeList(paramArrayOfObject, 0));
  }

  public static int s64vectorLength(S64Vector paramS64Vector)
  {
    return paramS64Vector.size();
  }

  public static long s64vectorRef(S64Vector paramS64Vector, int paramInt)
  {
    return paramS64Vector.longAt(paramInt);
  }

  public static void s64vectorSet$Ex(S64Vector paramS64Vector, int paramInt, long paramLong)
  {
    paramS64Vector.setLongAt(paramInt, paramLong);
  }

  public static LList s8vector$To$List(S8Vector paramS8Vector)
  {
    return LList.makeList(paramS8Vector);
  }

  public static S8Vector s8vector$V(Object[] paramArrayOfObject)
  {
    return list$To$S8vector(LList.makeList(paramArrayOfObject, 0));
  }

  public static int s8vectorLength(S8Vector paramS8Vector)
  {
    return paramS8Vector.size();
  }

  public static int s8vectorRef(S8Vector paramS8Vector, int paramInt)
  {
    return paramS8Vector.intAt(paramInt);
  }

  public static void s8vectorSet$Ex(S8Vector paramS8Vector, int paramInt1, int paramInt2)
  {
    paramS8Vector.setByteAt(paramInt1, (byte)paramInt2);
  }

  public static LList u16vector$To$List(U16Vector paramU16Vector)
  {
    return LList.makeList(paramU16Vector);
  }

  public static U16Vector u16vector$V(Object[] paramArrayOfObject)
  {
    return list$To$U16vector(LList.makeList(paramArrayOfObject, 0));
  }

  public static int u16vectorLength(U16Vector paramU16Vector)
  {
    return paramU16Vector.size();
  }

  public static int u16vectorRef(U16Vector paramU16Vector, int paramInt)
  {
    return paramU16Vector.intAt(paramInt);
  }

  public static void u16vectorSet$Ex(U16Vector paramU16Vector, int paramInt1, int paramInt2)
  {
    paramU16Vector.setShortAt(paramInt1, (short)paramInt2);
  }

  public static LList u32vector$To$List(U32Vector paramU32Vector)
  {
    return LList.makeList(paramU32Vector);
  }

  public static U32Vector u32vector$V(Object[] paramArrayOfObject)
  {
    return list$To$U32vector(LList.makeList(paramArrayOfObject, 0));
  }

  public static int u32vectorLength(U32Vector paramU32Vector)
  {
    return paramU32Vector.size();
  }

  public static long u32vectorRef(U32Vector paramU32Vector, int paramInt)
  {
    return ((Number)paramU32Vector.get(paramInt)).longValue();
  }

  public static void u32vectorSet$Ex(U32Vector paramU32Vector, int paramInt, long paramLong)
  {
    paramU32Vector.setIntAt(paramInt, (int)paramLong);
  }

  public static LList u64vector$To$List(U64Vector paramU64Vector)
  {
    return LList.makeList(paramU64Vector);
  }

  public static U64Vector u64vector$V(Object[] paramArrayOfObject)
  {
    return list$To$U64vector(LList.makeList(paramArrayOfObject, 0));
  }

  public static int u64vectorLength(U64Vector paramU64Vector)
  {
    return paramU64Vector.size();
  }

  public static IntNum u64vectorRef(U64Vector paramU64Vector, int paramInt)
  {
    return LangObjType.coerceIntNum(paramU64Vector.get(paramInt));
  }

  public static void u64vectorSet$Ex(U64Vector paramU64Vector, int paramInt, IntNum paramIntNum)
  {
    try
    {
      long l = paramIntNum.longValue();
      paramU64Vector.setLongAt(paramInt, l);
      return;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "gnu.lists.U64Vector.setLongAt(int,long)", 3, paramIntNum);
    }
  }

  public static LList u8vector$To$List(U8Vector paramU8Vector)
  {
    return LList.makeList(paramU8Vector);
  }

  public static U8Vector u8vector$V(Object[] paramArrayOfObject)
  {
    return list$To$U8vector(LList.makeList(paramArrayOfObject, 0));
  }

  public static int u8vectorLength(U8Vector paramU8Vector)
  {
    return paramU8Vector.size();
  }

  public static int u8vectorRef(U8Vector paramU8Vector, int paramInt)
  {
    return paramU8Vector.intAt(paramInt);
  }

  public static void u8vectorSet$Ex(U8Vector paramU8Vector, int paramInt1, int paramInt2)
  {
    paramU8Vector.setByteAt(paramInt1, (byte)paramInt2);
  }

  // ERROR //
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 1032	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+376 -> 380, 1:+383->387, 2:+398->402, 3:+376->380, 4:+376->380, 5:+413->417, 6:+376->380, 7:+376->380, 8:+428->432, 9:+440->444, 10:+452->456, 11:+467->471, 12:+376->380, 13:+376->380, 14:+482->486, 15:+376->380, 16:+376->380, 17:+497->501, 18:+509->513, 19:+521->525, 20:+536->540, 21:+376->380, 22:+376->380, 23:+551->555, 24:+376->380, 25:+376->380, 26:+566->570, 27:+578->582, 28:+590->594, 29:+605->609, 30:+376->380, 31:+376->380, 32:+620->624, 33:+376->380, 34:+376->380, 35:+635->639, 36:+647->651, 37:+659->663, 38:+674->678, 39:+376->380, 40:+376->380, 41:+689->693, 42:+376->380, 43:+376->380, 44:+704->708, 45:+716->720, 46:+728->732, 47:+743->747, 48:+376->380, 49:+376->380, 50:+758->762, 51:+376->380, 52:+376->380, 53:+773->777, 54:+785->789, 55:+797->801, 56:+812->816, 57:+376->380, 58:+376->380, 59:+827->831, 60:+376->380, 61:+376->380, 62:+842->846, 63:+854->858, 64:+866->870, 65:+881->885, 66:+376->380, 67:+376->380, 68:+896->900, 69:+376->380, 70:+376->380, 71:+911->915, 72:+923->927, 73:+935->939, 74:+950->954, 75:+376->380, 76:+376->380, 77:+965->969, 78:+376->380, 79:+376->380, 80:+980->984, 81:+992->996, 82:+1004->1008, 83:+1019->1023, 84:+376->380, 85:+376->380, 86:+1034->1038, 87:+376->380, 88:+376->380, 89:+1049->1053, 90:+1061->1065
    //   381: aload_1
    //   382: aload_2
    //   383: invokespecial 1034	gnu/expr/ModuleBody:apply1	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;)Ljava/lang/Object;
    //   386: areturn
    //   387: aload_2
    //   388: invokestatic 1036	kawa/lib/uniform:isS8vector	(Ljava/lang/Object;)Z
    //   391: ifeq +7 -> 398
    //   394: getstatic 1042	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   397: areturn
    //   398: getstatic 1045	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   401: areturn
    //   402: aload_2
    //   403: checkcast 863	java/lang/Number
    //   406: invokevirtual 1048	java/lang/Number:intValue	()I
    //   409: istore 82
    //   411: iload 82
    //   413: invokestatic 1050	kawa/lib/uniform:makeS8vector	(I)Lgnu/lists/S8Vector;
    //   416: areturn
    //   417: aload_2
    //   418: checkcast 756	gnu/lists/S8Vector
    //   421: astore 80
    //   423: aload 80
    //   425: invokestatic 1052	kawa/lib/uniform:s8vectorLength	(Lgnu/lists/S8Vector;)I
    //   428: invokestatic 1058	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   431: areturn
    //   432: aload_2
    //   433: checkcast 756	gnu/lists/S8Vector
    //   436: astore 78
    //   438: aload 78
    //   440: invokestatic 1060	kawa/lib/uniform:s8vector$To$List	(Lgnu/lists/S8Vector;)Lgnu/lists/LList;
    //   443: areturn
    //   444: aload_2
    //   445: checkcast 683	gnu/lists/LList
    //   448: astore 76
    //   450: aload 76
    //   452: invokestatic 944	kawa/lib/uniform:list$To$S8vector	(Lgnu/lists/LList;)Lgnu/lists/S8Vector;
    //   455: areturn
    //   456: aload_2
    //   457: invokestatic 1062	kawa/lib/uniform:isU8vector	(Ljava/lang/Object;)Z
    //   460: ifeq +7 -> 467
    //   463: getstatic 1042	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   466: areturn
    //   467: getstatic 1045	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   470: areturn
    //   471: aload_2
    //   472: checkcast 863	java/lang/Number
    //   475: invokevirtual 1048	java/lang/Number:intValue	()I
    //   478: istore 74
    //   480: iload 74
    //   482: invokestatic 1064	kawa/lib/uniform:makeU8vector	(I)Lgnu/lists/U8Vector;
    //   485: areturn
    //   486: aload_2
    //   487: checkcast 768	gnu/lists/U8Vector
    //   490: astore 72
    //   492: aload 72
    //   494: invokestatic 1066	kawa/lib/uniform:u8vectorLength	(Lgnu/lists/U8Vector;)I
    //   497: invokestatic 1058	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   500: areturn
    //   501: aload_2
    //   502: checkcast 768	gnu/lists/U8Vector
    //   505: astore 70
    //   507: aload 70
    //   509: invokestatic 1068	kawa/lib/uniform:u8vector$To$List	(Lgnu/lists/U8Vector;)Lgnu/lists/LList;
    //   512: areturn
    //   513: aload_2
    //   514: checkcast 683	gnu/lists/LList
    //   517: astore 68
    //   519: aload 68
    //   521: invokestatic 1017	kawa/lib/uniform:list$To$U8vector	(Lgnu/lists/LList;)Lgnu/lists/U8Vector;
    //   524: areturn
    //   525: aload_2
    //   526: invokestatic 1070	kawa/lib/uniform:isS16vector	(Ljava/lang/Object;)Z
    //   529: ifeq +7 -> 536
    //   532: getstatic 1042	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   535: areturn
    //   536: getstatic 1045	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   539: areturn
    //   540: aload_2
    //   541: checkcast 863	java/lang/Number
    //   544: invokevirtual 1048	java/lang/Number:intValue	()I
    //   547: istore 66
    //   549: iload 66
    //   551: invokestatic 1072	kawa/lib/uniform:makeS16vector	(I)Lgnu/lists/S16Vector;
    //   554: areturn
    //   555: aload_2
    //   556: checkcast 747	gnu/lists/S16Vector
    //   559: astore 64
    //   561: aload 64
    //   563: invokestatic 1074	kawa/lib/uniform:s16vectorLength	(Lgnu/lists/S16Vector;)I
    //   566: invokestatic 1058	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   569: areturn
    //   570: aload_2
    //   571: checkcast 747	gnu/lists/S16Vector
    //   574: astore 62
    //   576: aload 62
    //   578: invokestatic 1076	kawa/lib/uniform:s16vector$To$List	(Lgnu/lists/S16Vector;)Lgnu/lists/LList;
    //   581: areturn
    //   582: aload_2
    //   583: checkcast 683	gnu/lists/LList
    //   586: astore 60
    //   588: aload 60
    //   590: invokestatic 887	kawa/lib/uniform:list$To$S16vector	(Lgnu/lists/LList;)Lgnu/lists/S16Vector;
    //   593: areturn
    //   594: aload_2
    //   595: invokestatic 1078	kawa/lib/uniform:isU16vector	(Ljava/lang/Object;)Z
    //   598: ifeq +7 -> 605
    //   601: getstatic 1042	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   604: areturn
    //   605: getstatic 1045	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   608: areturn
    //   609: aload_2
    //   610: checkcast 863	java/lang/Number
    //   613: invokevirtual 1048	java/lang/Number:intValue	()I
    //   616: istore 58
    //   618: iload 58
    //   620: invokestatic 1080	kawa/lib/uniform:makeU16vector	(I)Lgnu/lists/U16Vector;
    //   623: areturn
    //   624: aload_2
    //   625: checkcast 759	gnu/lists/U16Vector
    //   628: astore 56
    //   630: aload 56
    //   632: invokestatic 1082	kawa/lib/uniform:u16vectorLength	(Lgnu/lists/U16Vector;)I
    //   635: invokestatic 1058	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   638: areturn
    //   639: aload_2
    //   640: checkcast 759	gnu/lists/U16Vector
    //   643: astore 54
    //   645: aload 54
    //   647: invokestatic 1084	kawa/lib/uniform:u16vector$To$List	(Lgnu/lists/U16Vector;)Lgnu/lists/LList;
    //   650: areturn
    //   651: aload_2
    //   652: checkcast 683	gnu/lists/LList
    //   655: astore 52
    //   657: aload 52
    //   659: invokestatic 961	kawa/lib/uniform:list$To$U16vector	(Lgnu/lists/LList;)Lgnu/lists/U16Vector;
    //   662: areturn
    //   663: aload_2
    //   664: invokestatic 1086	kawa/lib/uniform:isS32vector	(Ljava/lang/Object;)Z
    //   667: ifeq +7 -> 674
    //   670: getstatic 1042	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   673: areturn
    //   674: getstatic 1045	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   677: areturn
    //   678: aload_2
    //   679: checkcast 863	java/lang/Number
    //   682: invokevirtual 1048	java/lang/Number:intValue	()I
    //   685: istore 50
    //   687: iload 50
    //   689: invokestatic 1088	kawa/lib/uniform:makeS32vector	(I)Lgnu/lists/S32Vector;
    //   692: areturn
    //   693: aload_2
    //   694: checkcast 750	gnu/lists/S32Vector
    //   697: astore 48
    //   699: aload 48
    //   701: invokestatic 1090	kawa/lib/uniform:s32vectorLength	(Lgnu/lists/S32Vector;)I
    //   704: invokestatic 1058	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   707: areturn
    //   708: aload_2
    //   709: checkcast 750	gnu/lists/S32Vector
    //   712: astore 46
    //   714: aload 46
    //   716: invokestatic 1092	kawa/lib/uniform:s32vector$To$List	(Lgnu/lists/S32Vector;)Lgnu/lists/LList;
    //   719: areturn
    //   720: aload_2
    //   721: checkcast 683	gnu/lists/LList
    //   724: astore 44
    //   726: aload 44
    //   728: invokestatic 907	kawa/lib/uniform:list$To$S32vector	(Lgnu/lists/LList;)Lgnu/lists/S32Vector;
    //   731: areturn
    //   732: aload_2
    //   733: invokestatic 1094	kawa/lib/uniform:isU32vector	(Ljava/lang/Object;)Z
    //   736: ifeq +7 -> 743
    //   739: getstatic 1042	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   742: areturn
    //   743: getstatic 1045	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   746: areturn
    //   747: aload_2
    //   748: checkcast 863	java/lang/Number
    //   751: invokevirtual 1048	java/lang/Number:intValue	()I
    //   754: istore 42
    //   756: iload 42
    //   758: invokestatic 1096	kawa/lib/uniform:makeU32vector	(I)Lgnu/lists/U32Vector;
    //   761: areturn
    //   762: aload_2
    //   763: checkcast 762	gnu/lists/U32Vector
    //   766: astore 40
    //   768: aload 40
    //   770: invokestatic 1098	kawa/lib/uniform:u32vectorLength	(Lgnu/lists/U32Vector;)I
    //   773: invokestatic 1058	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   776: areturn
    //   777: aload_2
    //   778: checkcast 762	gnu/lists/U32Vector
    //   781: astore 38
    //   783: aload 38
    //   785: invokestatic 1100	kawa/lib/uniform:u32vector$To$List	(Lgnu/lists/U32Vector;)Lgnu/lists/LList;
    //   788: areturn
    //   789: aload_2
    //   790: checkcast 683	gnu/lists/LList
    //   793: astore 36
    //   795: aload 36
    //   797: invokestatic 976	kawa/lib/uniform:list$To$U32vector	(Lgnu/lists/LList;)Lgnu/lists/U32Vector;
    //   800: areturn
    //   801: aload_2
    //   802: invokestatic 1102	kawa/lib/uniform:isS64vector	(Ljava/lang/Object;)Z
    //   805: ifeq +7 -> 812
    //   808: getstatic 1042	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   811: areturn
    //   812: getstatic 1045	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   815: areturn
    //   816: aload_2
    //   817: checkcast 863	java/lang/Number
    //   820: invokevirtual 1048	java/lang/Number:intValue	()I
    //   823: istore 34
    //   825: iload 34
    //   827: invokestatic 1104	kawa/lib/uniform:makeS64vector	(I)Lgnu/lists/S64Vector;
    //   830: areturn
    //   831: aload_2
    //   832: checkcast 753	gnu/lists/S64Vector
    //   835: astore 32
    //   837: aload 32
    //   839: invokestatic 1106	kawa/lib/uniform:s64vectorLength	(Lgnu/lists/S64Vector;)I
    //   842: invokestatic 1058	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   845: areturn
    //   846: aload_2
    //   847: checkcast 753	gnu/lists/S64Vector
    //   850: astore 30
    //   852: aload 30
    //   854: invokestatic 1108	kawa/lib/uniform:s64vector$To$List	(Lgnu/lists/S64Vector;)Lgnu/lists/LList;
    //   857: areturn
    //   858: aload_2
    //   859: checkcast 683	gnu/lists/LList
    //   862: astore 28
    //   864: aload 28
    //   866: invokestatic 924	kawa/lib/uniform:list$To$S64vector	(Lgnu/lists/LList;)Lgnu/lists/S64Vector;
    //   869: areturn
    //   870: aload_2
    //   871: invokestatic 1110	kawa/lib/uniform:isU64vector	(Ljava/lang/Object;)Z
    //   874: ifeq +7 -> 881
    //   877: getstatic 1042	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   880: areturn
    //   881: getstatic 1045	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   884: areturn
    //   885: aload_2
    //   886: checkcast 863	java/lang/Number
    //   889: invokevirtual 1048	java/lang/Number:intValue	()I
    //   892: istore 26
    //   894: iload 26
    //   896: invokestatic 1112	kawa/lib/uniform:makeU64vector	(I)Lgnu/lists/U64Vector;
    //   899: areturn
    //   900: aload_2
    //   901: checkcast 765	gnu/lists/U64Vector
    //   904: astore 24
    //   906: aload 24
    //   908: invokestatic 1114	kawa/lib/uniform:u64vectorLength	(Lgnu/lists/U64Vector;)I
    //   911: invokestatic 1058	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   914: areturn
    //   915: aload_2
    //   916: checkcast 765	gnu/lists/U64Vector
    //   919: astore 22
    //   921: aload 22
    //   923: invokestatic 1116	kawa/lib/uniform:u64vector$To$List	(Lgnu/lists/U64Vector;)Lgnu/lists/LList;
    //   926: areturn
    //   927: aload_2
    //   928: checkcast 683	gnu/lists/LList
    //   931: astore 20
    //   933: aload 20
    //   935: invokestatic 994	kawa/lib/uniform:list$To$U64vector	(Lgnu/lists/LList;)Lgnu/lists/U64Vector;
    //   938: areturn
    //   939: aload_2
    //   940: invokestatic 1118	kawa/lib/uniform:isF32vector	(Ljava/lang/Object;)Z
    //   943: ifeq +7 -> 950
    //   946: getstatic 1042	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   949: areturn
    //   950: getstatic 1045	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   953: areturn
    //   954: aload_2
    //   955: checkcast 863	java/lang/Number
    //   958: invokevirtual 1048	java/lang/Number:intValue	()I
    //   961: istore 18
    //   963: iload 18
    //   965: invokestatic 1120	kawa/lib/uniform:makeF32vector	(I)Lgnu/lists/F32Vector;
    //   968: areturn
    //   969: aload_2
    //   970: checkcast 700	gnu/lists/F32Vector
    //   973: astore 16
    //   975: aload 16
    //   977: invokestatic 1122	kawa/lib/uniform:f32vectorLength	(Lgnu/lists/F32Vector;)I
    //   980: invokestatic 1058	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   983: areturn
    //   984: aload_2
    //   985: checkcast 700	gnu/lists/F32Vector
    //   988: astore 14
    //   990: aload 14
    //   992: invokestatic 1124	kawa/lib/uniform:f32vector$To$List	(Lgnu/lists/F32Vector;)Lgnu/lists/LList;
    //   995: areturn
    //   996: aload_2
    //   997: checkcast 683	gnu/lists/LList
    //   1000: astore 12
    //   1002: aload 12
    //   1004: invokestatic 696	kawa/lib/uniform:list$To$F32vector	(Lgnu/lists/LList;)Lgnu/lists/F32Vector;
    //   1007: areturn
    //   1008: aload_2
    //   1009: invokestatic 1126	kawa/lib/uniform:isF64vector	(Ljava/lang/Object;)Z
    //   1012: ifeq +7 -> 1019
    //   1015: getstatic 1042	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   1018: areturn
    //   1019: getstatic 1045	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   1022: areturn
    //   1023: aload_2
    //   1024: checkcast 863	java/lang/Number
    //   1027: invokevirtual 1048	java/lang/Number:intValue	()I
    //   1030: istore 10
    //   1032: iload 10
    //   1034: invokestatic 1128	kawa/lib/uniform:makeF64vector	(I)Lgnu/lists/F64Vector;
    //   1037: areturn
    //   1038: aload_2
    //   1039: checkcast 728	gnu/lists/F64Vector
    //   1042: astore 8
    //   1044: aload 8
    //   1046: invokestatic 1130	kawa/lib/uniform:f64vectorLength	(Lgnu/lists/F64Vector;)I
    //   1049: invokestatic 1058	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1052: areturn
    //   1053: aload_2
    //   1054: checkcast 728	gnu/lists/F64Vector
    //   1057: astore 6
    //   1059: aload 6
    //   1061: invokestatic 1132	kawa/lib/uniform:f64vector$To$List	(Lgnu/lists/F64Vector;)Lgnu/lists/LList;
    //   1064: areturn
    //   1065: aload_2
    //   1066: checkcast 683	gnu/lists/LList
    //   1069: astore 4
    //   1071: aload 4
    //   1073: invokestatic 724	kawa/lib/uniform:list$To$F64vector	(Lgnu/lists/LList;)Lgnu/lists/F64Vector;
    //   1076: areturn
    //   1077: astore 81
    //   1079: new 870	gnu/mapping/WrongType
    //   1082: dup
    //   1083: aload 81
    //   1085: ldc_w 486
    //   1088: iconst_1
    //   1089: aload_2
    //   1090: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1093: athrow
    //   1094: astore 79
    //   1096: new 870	gnu/mapping/WrongType
    //   1099: dup
    //   1100: aload 79
    //   1102: ldc_w 479
    //   1105: iconst_1
    //   1106: aload_2
    //   1107: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1110: athrow
    //   1111: astore 77
    //   1113: new 870	gnu/mapping/WrongType
    //   1116: dup
    //   1117: aload 77
    //   1119: ldc_w 467
    //   1122: iconst_1
    //   1123: aload_2
    //   1124: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1127: athrow
    //   1128: astore 75
    //   1130: new 870	gnu/mapping/WrongType
    //   1133: dup
    //   1134: aload 75
    //   1136: ldc_w 463
    //   1139: iconst_1
    //   1140: aload_2
    //   1141: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1144: athrow
    //   1145: astore 73
    //   1147: new 870	gnu/mapping/WrongType
    //   1150: dup
    //   1151: aload 73
    //   1153: ldc_w 455
    //   1156: iconst_1
    //   1157: aload_2
    //   1158: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1161: athrow
    //   1162: astore 71
    //   1164: new 870	gnu/mapping/WrongType
    //   1167: dup
    //   1168: aload 71
    //   1170: ldc_w 448
    //   1173: iconst_1
    //   1174: aload_2
    //   1175: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1178: athrow
    //   1179: astore 69
    //   1181: new 870	gnu/mapping/WrongType
    //   1184: dup
    //   1185: aload 69
    //   1187: ldc_w 436
    //   1190: iconst_1
    //   1191: aload_2
    //   1192: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1195: athrow
    //   1196: astore 67
    //   1198: new 870	gnu/mapping/WrongType
    //   1201: dup
    //   1202: aload 67
    //   1204: ldc_w 432
    //   1207: iconst_1
    //   1208: aload_2
    //   1209: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1212: athrow
    //   1213: astore 65
    //   1215: new 870	gnu/mapping/WrongType
    //   1218: dup
    //   1219: aload 65
    //   1221: ldc_w 424
    //   1224: iconst_1
    //   1225: aload_2
    //   1226: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1229: athrow
    //   1230: astore 63
    //   1232: new 870	gnu/mapping/WrongType
    //   1235: dup
    //   1236: aload 63
    //   1238: ldc_w 417
    //   1241: iconst_1
    //   1242: aload_2
    //   1243: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1246: athrow
    //   1247: astore 61
    //   1249: new 870	gnu/mapping/WrongType
    //   1252: dup
    //   1253: aload 61
    //   1255: ldc_w 405
    //   1258: iconst_1
    //   1259: aload_2
    //   1260: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1263: athrow
    //   1264: astore 59
    //   1266: new 870	gnu/mapping/WrongType
    //   1269: dup
    //   1270: aload 59
    //   1272: ldc_w 401
    //   1275: iconst_1
    //   1276: aload_2
    //   1277: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1280: athrow
    //   1281: astore 57
    //   1283: new 870	gnu/mapping/WrongType
    //   1286: dup
    //   1287: aload 57
    //   1289: ldc_w 393
    //   1292: iconst_1
    //   1293: aload_2
    //   1294: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1297: athrow
    //   1298: astore 55
    //   1300: new 870	gnu/mapping/WrongType
    //   1303: dup
    //   1304: aload 55
    //   1306: ldc_w 386
    //   1309: iconst_1
    //   1310: aload_2
    //   1311: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1314: athrow
    //   1315: astore 53
    //   1317: new 870	gnu/mapping/WrongType
    //   1320: dup
    //   1321: aload 53
    //   1323: ldc_w 374
    //   1326: iconst_1
    //   1327: aload_2
    //   1328: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1331: athrow
    //   1332: astore 51
    //   1334: new 870	gnu/mapping/WrongType
    //   1337: dup
    //   1338: aload 51
    //   1340: ldc_w 370
    //   1343: iconst_1
    //   1344: aload_2
    //   1345: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1348: athrow
    //   1349: astore 49
    //   1351: new 870	gnu/mapping/WrongType
    //   1354: dup
    //   1355: aload 49
    //   1357: ldc_w 362
    //   1360: iconst_1
    //   1361: aload_2
    //   1362: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1365: athrow
    //   1366: astore 47
    //   1368: new 870	gnu/mapping/WrongType
    //   1371: dup
    //   1372: aload 47
    //   1374: ldc_w 355
    //   1377: iconst_1
    //   1378: aload_2
    //   1379: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1382: athrow
    //   1383: astore 45
    //   1385: new 870	gnu/mapping/WrongType
    //   1388: dup
    //   1389: aload 45
    //   1391: ldc_w 343
    //   1394: iconst_1
    //   1395: aload_2
    //   1396: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1399: athrow
    //   1400: astore 43
    //   1402: new 870	gnu/mapping/WrongType
    //   1405: dup
    //   1406: aload 43
    //   1408: ldc_w 339
    //   1411: iconst_1
    //   1412: aload_2
    //   1413: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1416: athrow
    //   1417: astore 41
    //   1419: new 870	gnu/mapping/WrongType
    //   1422: dup
    //   1423: aload 41
    //   1425: ldc_w 331
    //   1428: iconst_1
    //   1429: aload_2
    //   1430: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1433: athrow
    //   1434: astore 39
    //   1436: new 870	gnu/mapping/WrongType
    //   1439: dup
    //   1440: aload 39
    //   1442: ldc_w 324
    //   1445: iconst_1
    //   1446: aload_2
    //   1447: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1450: athrow
    //   1451: astore 37
    //   1453: new 870	gnu/mapping/WrongType
    //   1456: dup
    //   1457: aload 37
    //   1459: ldc_w 312
    //   1462: iconst_1
    //   1463: aload_2
    //   1464: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1467: athrow
    //   1468: astore 35
    //   1470: new 870	gnu/mapping/WrongType
    //   1473: dup
    //   1474: aload 35
    //   1476: ldc_w 308
    //   1479: iconst_1
    //   1480: aload_2
    //   1481: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1484: athrow
    //   1485: astore 33
    //   1487: new 870	gnu/mapping/WrongType
    //   1490: dup
    //   1491: aload 33
    //   1493: ldc_w 300
    //   1496: iconst_1
    //   1497: aload_2
    //   1498: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1501: athrow
    //   1502: astore 31
    //   1504: new 870	gnu/mapping/WrongType
    //   1507: dup
    //   1508: aload 31
    //   1510: ldc_w 293
    //   1513: iconst_1
    //   1514: aload_2
    //   1515: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1518: athrow
    //   1519: astore 29
    //   1521: new 870	gnu/mapping/WrongType
    //   1524: dup
    //   1525: aload 29
    //   1527: ldc_w 281
    //   1530: iconst_1
    //   1531: aload_2
    //   1532: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1535: athrow
    //   1536: astore 27
    //   1538: new 870	gnu/mapping/WrongType
    //   1541: dup
    //   1542: aload 27
    //   1544: ldc_w 277
    //   1547: iconst_1
    //   1548: aload_2
    //   1549: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1552: athrow
    //   1553: astore 25
    //   1555: new 870	gnu/mapping/WrongType
    //   1558: dup
    //   1559: aload 25
    //   1561: ldc_w 269
    //   1564: iconst_1
    //   1565: aload_2
    //   1566: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1569: athrow
    //   1570: astore 23
    //   1572: new 870	gnu/mapping/WrongType
    //   1575: dup
    //   1576: aload 23
    //   1578: ldc_w 262
    //   1581: iconst_1
    //   1582: aload_2
    //   1583: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1586: athrow
    //   1587: astore 21
    //   1589: new 870	gnu/mapping/WrongType
    //   1592: dup
    //   1593: aload 21
    //   1595: ldc 250
    //   1597: iconst_1
    //   1598: aload_2
    //   1599: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1602: athrow
    //   1603: astore 19
    //   1605: new 870	gnu/mapping/WrongType
    //   1608: dup
    //   1609: aload 19
    //   1611: ldc 246
    //   1613: iconst_1
    //   1614: aload_2
    //   1615: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1618: athrow
    //   1619: astore 17
    //   1621: new 870	gnu/mapping/WrongType
    //   1624: dup
    //   1625: aload 17
    //   1627: ldc 238
    //   1629: iconst_1
    //   1630: aload_2
    //   1631: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1634: athrow
    //   1635: astore 15
    //   1637: new 870	gnu/mapping/WrongType
    //   1640: dup
    //   1641: aload 15
    //   1643: ldc 231
    //   1645: iconst_1
    //   1646: aload_2
    //   1647: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1650: athrow
    //   1651: astore 13
    //   1653: new 870	gnu/mapping/WrongType
    //   1656: dup
    //   1657: aload 13
    //   1659: ldc 219
    //   1661: iconst_1
    //   1662: aload_2
    //   1663: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1666: athrow
    //   1667: astore 11
    //   1669: new 870	gnu/mapping/WrongType
    //   1672: dup
    //   1673: aload 11
    //   1675: ldc 215
    //   1677: iconst_1
    //   1678: aload_2
    //   1679: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1682: athrow
    //   1683: astore 9
    //   1685: new 870	gnu/mapping/WrongType
    //   1688: dup
    //   1689: aload 9
    //   1691: ldc 207
    //   1693: iconst_1
    //   1694: aload_2
    //   1695: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1698: athrow
    //   1699: astore 7
    //   1701: new 870	gnu/mapping/WrongType
    //   1704: dup
    //   1705: aload 7
    //   1707: ldc 200
    //   1709: iconst_1
    //   1710: aload_2
    //   1711: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1714: athrow
    //   1715: astore 5
    //   1717: new 870	gnu/mapping/WrongType
    //   1720: dup
    //   1721: aload 5
    //   1723: ldc 188
    //   1725: iconst_1
    //   1726: aload_2
    //   1727: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1730: athrow
    //   1731: astore_3
    //   1732: new 870	gnu/mapping/WrongType
    //   1735: dup
    //   1736: aload_3
    //   1737: ldc 176
    //   1739: iconst_1
    //   1740: aload_2
    //   1741: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1744: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   402	411	1077	java/lang/ClassCastException
    //   417	423	1094	java/lang/ClassCastException
    //   432	438	1111	java/lang/ClassCastException
    //   444	450	1128	java/lang/ClassCastException
    //   471	480	1145	java/lang/ClassCastException
    //   486	492	1162	java/lang/ClassCastException
    //   501	507	1179	java/lang/ClassCastException
    //   513	519	1196	java/lang/ClassCastException
    //   540	549	1213	java/lang/ClassCastException
    //   555	561	1230	java/lang/ClassCastException
    //   570	576	1247	java/lang/ClassCastException
    //   582	588	1264	java/lang/ClassCastException
    //   609	618	1281	java/lang/ClassCastException
    //   624	630	1298	java/lang/ClassCastException
    //   639	645	1315	java/lang/ClassCastException
    //   651	657	1332	java/lang/ClassCastException
    //   678	687	1349	java/lang/ClassCastException
    //   693	699	1366	java/lang/ClassCastException
    //   708	714	1383	java/lang/ClassCastException
    //   720	726	1400	java/lang/ClassCastException
    //   747	756	1417	java/lang/ClassCastException
    //   762	768	1434	java/lang/ClassCastException
    //   777	783	1451	java/lang/ClassCastException
    //   789	795	1468	java/lang/ClassCastException
    //   816	825	1485	java/lang/ClassCastException
    //   831	837	1502	java/lang/ClassCastException
    //   846	852	1519	java/lang/ClassCastException
    //   858	864	1536	java/lang/ClassCastException
    //   885	894	1553	java/lang/ClassCastException
    //   900	906	1570	java/lang/ClassCastException
    //   915	921	1587	java/lang/ClassCastException
    //   927	933	1603	java/lang/ClassCastException
    //   954	963	1619	java/lang/ClassCastException
    //   969	975	1635	java/lang/ClassCastException
    //   984	990	1651	java/lang/ClassCastException
    //   996	1002	1667	java/lang/ClassCastException
    //   1023	1032	1683	java/lang/ClassCastException
    //   1038	1044	1699	java/lang/ClassCastException
    //   1053	1059	1715	java/lang/ClassCastException
    //   1065	1071	1731	java/lang/ClassCastException
  }

  // ERROR //
  public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 1032	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+172->176, 2:+180->184, 6:+206->210, 11:+232->236, 15:+258->262, 20:+284->288, 24:+310->314, 29:+336->340, 33:+362->366, 38:+388->392, 42:+414->418, 47:+440->444, 51:+466->470, 56:+492->496, 60:+518->522, 65:+544->548, 69:+567->571, 74:+590->594, 78:+616->620, 83:+642->646, 87:+668->672
    //   177: aload_1
    //   178: aload_2
    //   179: aload_3
    //   180: invokespecial 1136	gnu/expr/ModuleBody:apply2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   183: areturn
    //   184: aload_2
    //   185: checkcast 863	java/lang/Number
    //   188: invokevirtual 1048	java/lang/Number:intValue	()I
    //   191: istore 84
    //   193: aload_3
    //   194: checkcast 863	java/lang/Number
    //   197: invokevirtual 1048	java/lang/Number:intValue	()I
    //   200: istore 86
    //   202: iload 84
    //   204: iload 86
    //   206: invokestatic 839	kawa/lib/uniform:makeS8vector	(II)Lgnu/lists/S8Vector;
    //   209: areturn
    //   210: aload_2
    //   211: checkcast 756	gnu/lists/S8Vector
    //   214: astore 80
    //   216: aload_3
    //   217: checkcast 863	java/lang/Number
    //   220: invokevirtual 1048	java/lang/Number:intValue	()I
    //   223: istore 82
    //   225: aload 80
    //   227: iload 82
    //   229: invokestatic 1138	kawa/lib/uniform:s8vectorRef	(Lgnu/lists/S8Vector;I)I
    //   232: invokestatic 1058	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   235: areturn
    //   236: aload_2
    //   237: checkcast 863	java/lang/Number
    //   240: invokevirtual 1048	java/lang/Number:intValue	()I
    //   243: istore 76
    //   245: aload_3
    //   246: checkcast 863	java/lang/Number
    //   249: invokevirtual 1048	java/lang/Number:intValue	()I
    //   252: istore 78
    //   254: iload 76
    //   256: iload 78
    //   258: invokestatic 880	kawa/lib/uniform:makeU8vector	(II)Lgnu/lists/U8Vector;
    //   261: areturn
    //   262: aload_2
    //   263: checkcast 768	gnu/lists/U8Vector
    //   266: astore 72
    //   268: aload_3
    //   269: checkcast 863	java/lang/Number
    //   272: invokevirtual 1048	java/lang/Number:intValue	()I
    //   275: istore 74
    //   277: aload 72
    //   279: iload 74
    //   281: invokestatic 1140	kawa/lib/uniform:u8vectorRef	(Lgnu/lists/U8Vector;I)I
    //   284: invokestatic 1058	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   287: areturn
    //   288: aload_2
    //   289: checkcast 863	java/lang/Number
    //   292: invokevirtual 1048	java/lang/Number:intValue	()I
    //   295: istore 68
    //   297: aload_3
    //   298: checkcast 863	java/lang/Number
    //   301: invokevirtual 1048	java/lang/Number:intValue	()I
    //   304: istore 70
    //   306: iload 68
    //   308: iload 70
    //   310: invokestatic 815	kawa/lib/uniform:makeS16vector	(II)Lgnu/lists/S16Vector;
    //   313: areturn
    //   314: aload_2
    //   315: checkcast 747	gnu/lists/S16Vector
    //   318: astore 64
    //   320: aload_3
    //   321: checkcast 863	java/lang/Number
    //   324: invokevirtual 1048	java/lang/Number:intValue	()I
    //   327: istore 66
    //   329: aload 64
    //   331: iload 66
    //   333: invokestatic 1142	kawa/lib/uniform:s16vectorRef	(Lgnu/lists/S16Vector;I)I
    //   336: invokestatic 1058	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   339: areturn
    //   340: aload_2
    //   341: checkcast 863	java/lang/Number
    //   344: invokevirtual 1048	java/lang/Number:intValue	()I
    //   347: istore 60
    //   349: aload_3
    //   350: checkcast 863	java/lang/Number
    //   353: invokevirtual 1048	java/lang/Number:intValue	()I
    //   356: istore 62
    //   358: iload 60
    //   360: iload 62
    //   362: invokestatic 847	kawa/lib/uniform:makeU16vector	(II)Lgnu/lists/U16Vector;
    //   365: areturn
    //   366: aload_2
    //   367: checkcast 759	gnu/lists/U16Vector
    //   370: astore 56
    //   372: aload_3
    //   373: checkcast 863	java/lang/Number
    //   376: invokevirtual 1048	java/lang/Number:intValue	()I
    //   379: istore 58
    //   381: aload 56
    //   383: iload 58
    //   385: invokestatic 1144	kawa/lib/uniform:u16vectorRef	(Lgnu/lists/U16Vector;I)I
    //   388: invokestatic 1058	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   391: areturn
    //   392: aload_2
    //   393: checkcast 863	java/lang/Number
    //   396: invokevirtual 1048	java/lang/Number:intValue	()I
    //   399: istore 52
    //   401: aload_3
    //   402: checkcast 863	java/lang/Number
    //   405: invokevirtual 1048	java/lang/Number:intValue	()I
    //   408: istore 54
    //   410: iload 52
    //   412: iload 54
    //   414: invokestatic 823	kawa/lib/uniform:makeS32vector	(II)Lgnu/lists/S32Vector;
    //   417: areturn
    //   418: aload_2
    //   419: checkcast 750	gnu/lists/S32Vector
    //   422: astore 48
    //   424: aload_3
    //   425: checkcast 863	java/lang/Number
    //   428: invokevirtual 1048	java/lang/Number:intValue	()I
    //   431: istore 50
    //   433: aload 48
    //   435: iload 50
    //   437: invokestatic 1146	kawa/lib/uniform:s32vectorRef	(Lgnu/lists/S32Vector;I)I
    //   440: invokestatic 1058	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   443: areturn
    //   444: aload_2
    //   445: checkcast 863	java/lang/Number
    //   448: invokevirtual 1048	java/lang/Number:intValue	()I
    //   451: istore 43
    //   453: aload_3
    //   454: checkcast 863	java/lang/Number
    //   457: invokevirtual 867	java/lang/Number:longValue	()J
    //   460: lstore 45
    //   462: iload 43
    //   464: lload 45
    //   466: invokestatic 853	kawa/lib/uniform:makeU32vector	(IJ)Lgnu/lists/U32Vector;
    //   469: areturn
    //   470: aload_2
    //   471: checkcast 762	gnu/lists/U32Vector
    //   474: astore 39
    //   476: aload_3
    //   477: checkcast 863	java/lang/Number
    //   480: invokevirtual 1048	java/lang/Number:intValue	()I
    //   483: istore 41
    //   485: aload 39
    //   487: iload 41
    //   489: invokestatic 1148	kawa/lib/uniform:u32vectorRef	(Lgnu/lists/U32Vector;I)J
    //   492: invokestatic 1153	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   495: areturn
    //   496: aload_2
    //   497: checkcast 863	java/lang/Number
    //   500: invokevirtual 1048	java/lang/Number:intValue	()I
    //   503: istore 34
    //   505: aload_3
    //   506: checkcast 863	java/lang/Number
    //   509: invokevirtual 867	java/lang/Number:longValue	()J
    //   512: lstore 36
    //   514: iload 34
    //   516: lload 36
    //   518: invokestatic 831	kawa/lib/uniform:makeS64vector	(IJ)Lgnu/lists/S64Vector;
    //   521: areturn
    //   522: aload_2
    //   523: checkcast 753	gnu/lists/S64Vector
    //   526: astore 30
    //   528: aload_3
    //   529: checkcast 863	java/lang/Number
    //   532: invokevirtual 1048	java/lang/Number:intValue	()I
    //   535: istore 32
    //   537: aload 30
    //   539: iload 32
    //   541: invokestatic 1155	kawa/lib/uniform:s64vectorRef	(Lgnu/lists/S64Vector;I)J
    //   544: invokestatic 1153	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   547: areturn
    //   548: aload_2
    //   549: checkcast 863	java/lang/Number
    //   552: invokevirtual 1048	java/lang/Number:intValue	()I
    //   555: istore 26
    //   557: aload_3
    //   558: invokestatic 1006	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   561: astore 28
    //   563: iload 26
    //   565: aload 28
    //   567: invokestatic 859	kawa/lib/uniform:makeU64vector	(ILgnu/math/IntNum;)Lgnu/lists/U64Vector;
    //   570: areturn
    //   571: aload_2
    //   572: checkcast 765	gnu/lists/U64Vector
    //   575: astore 22
    //   577: aload_3
    //   578: checkcast 863	java/lang/Number
    //   581: invokevirtual 1048	java/lang/Number:intValue	()I
    //   584: istore 24
    //   586: aload 22
    //   588: iload 24
    //   590: invokestatic 1157	kawa/lib/uniform:u64vectorRef	(Lgnu/lists/U64Vector;I)Lgnu/math/IntNum;
    //   593: areturn
    //   594: aload_2
    //   595: checkcast 863	java/lang/Number
    //   598: invokevirtual 1048	java/lang/Number:intValue	()I
    //   601: istore 18
    //   603: aload_3
    //   604: checkcast 863	java/lang/Number
    //   607: invokevirtual 1161	java/lang/Number:floatValue	()F
    //   610: fstore 20
    //   612: iload 18
    //   614: fload 20
    //   616: invokestatic 801	kawa/lib/uniform:makeF32vector	(IF)Lgnu/lists/F32Vector;
    //   619: areturn
    //   620: aload_2
    //   621: checkcast 700	gnu/lists/F32Vector
    //   624: astore 14
    //   626: aload_3
    //   627: checkcast 863	java/lang/Number
    //   630: invokevirtual 1048	java/lang/Number:intValue	()I
    //   633: istore 16
    //   635: aload 14
    //   637: iload 16
    //   639: invokestatic 1163	kawa/lib/uniform:f32vectorRef	(Lgnu/lists/F32Vector;I)F
    //   642: invokestatic 1168	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   645: areturn
    //   646: aload_2
    //   647: checkcast 863	java/lang/Number
    //   650: invokevirtual 1048	java/lang/Number:intValue	()I
    //   653: istore 9
    //   655: aload_3
    //   656: checkcast 863	java/lang/Number
    //   659: invokevirtual 1172	java/lang/Number:doubleValue	()D
    //   662: dstore 11
    //   664: iload 9
    //   666: dload 11
    //   668: invokestatic 808	kawa/lib/uniform:makeF64vector	(ID)Lgnu/lists/F64Vector;
    //   671: areturn
    //   672: aload_2
    //   673: checkcast 728	gnu/lists/F64Vector
    //   676: astore 5
    //   678: aload_3
    //   679: checkcast 863	java/lang/Number
    //   682: invokevirtual 1048	java/lang/Number:intValue	()I
    //   685: istore 7
    //   687: aload 5
    //   689: iload 7
    //   691: invokestatic 1174	kawa/lib/uniform:f64vectorRef	(Lgnu/lists/F64Vector;I)D
    //   694: invokestatic 1179	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   697: areturn
    //   698: astore 83
    //   700: new 870	gnu/mapping/WrongType
    //   703: dup
    //   704: aload 83
    //   706: ldc_w 486
    //   709: iconst_1
    //   710: aload_2
    //   711: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   714: athrow
    //   715: astore 85
    //   717: new 870	gnu/mapping/WrongType
    //   720: dup
    //   721: aload 85
    //   723: ldc_w 486
    //   726: iconst_2
    //   727: aload_3
    //   728: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   731: athrow
    //   732: astore 79
    //   734: new 870	gnu/mapping/WrongType
    //   737: dup
    //   738: aload 79
    //   740: ldc_w 475
    //   743: iconst_1
    //   744: aload_2
    //   745: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   748: athrow
    //   749: astore 81
    //   751: new 870	gnu/mapping/WrongType
    //   754: dup
    //   755: aload 81
    //   757: ldc_w 475
    //   760: iconst_2
    //   761: aload_3
    //   762: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   765: athrow
    //   766: astore 75
    //   768: new 870	gnu/mapping/WrongType
    //   771: dup
    //   772: aload 75
    //   774: ldc_w 455
    //   777: iconst_1
    //   778: aload_2
    //   779: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   782: athrow
    //   783: astore 77
    //   785: new 870	gnu/mapping/WrongType
    //   788: dup
    //   789: aload 77
    //   791: ldc_w 455
    //   794: iconst_2
    //   795: aload_3
    //   796: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   799: athrow
    //   800: astore 71
    //   802: new 870	gnu/mapping/WrongType
    //   805: dup
    //   806: aload 71
    //   808: ldc_w 444
    //   811: iconst_1
    //   812: aload_2
    //   813: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   816: athrow
    //   817: astore 73
    //   819: new 870	gnu/mapping/WrongType
    //   822: dup
    //   823: aload 73
    //   825: ldc_w 444
    //   828: iconst_2
    //   829: aload_3
    //   830: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   833: athrow
    //   834: astore 67
    //   836: new 870	gnu/mapping/WrongType
    //   839: dup
    //   840: aload 67
    //   842: ldc_w 424
    //   845: iconst_1
    //   846: aload_2
    //   847: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   850: athrow
    //   851: astore 69
    //   853: new 870	gnu/mapping/WrongType
    //   856: dup
    //   857: aload 69
    //   859: ldc_w 424
    //   862: iconst_2
    //   863: aload_3
    //   864: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   867: athrow
    //   868: astore 63
    //   870: new 870	gnu/mapping/WrongType
    //   873: dup
    //   874: aload 63
    //   876: ldc_w 413
    //   879: iconst_1
    //   880: aload_2
    //   881: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   884: athrow
    //   885: astore 65
    //   887: new 870	gnu/mapping/WrongType
    //   890: dup
    //   891: aload 65
    //   893: ldc_w 413
    //   896: iconst_2
    //   897: aload_3
    //   898: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   901: athrow
    //   902: astore 59
    //   904: new 870	gnu/mapping/WrongType
    //   907: dup
    //   908: aload 59
    //   910: ldc_w 393
    //   913: iconst_1
    //   914: aload_2
    //   915: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   918: athrow
    //   919: astore 61
    //   921: new 870	gnu/mapping/WrongType
    //   924: dup
    //   925: aload 61
    //   927: ldc_w 393
    //   930: iconst_2
    //   931: aload_3
    //   932: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   935: athrow
    //   936: astore 55
    //   938: new 870	gnu/mapping/WrongType
    //   941: dup
    //   942: aload 55
    //   944: ldc_w 382
    //   947: iconst_1
    //   948: aload_2
    //   949: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   952: athrow
    //   953: astore 57
    //   955: new 870	gnu/mapping/WrongType
    //   958: dup
    //   959: aload 57
    //   961: ldc_w 382
    //   964: iconst_2
    //   965: aload_3
    //   966: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   969: athrow
    //   970: astore 51
    //   972: new 870	gnu/mapping/WrongType
    //   975: dup
    //   976: aload 51
    //   978: ldc_w 362
    //   981: iconst_1
    //   982: aload_2
    //   983: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   986: athrow
    //   987: astore 53
    //   989: new 870	gnu/mapping/WrongType
    //   992: dup
    //   993: aload 53
    //   995: ldc_w 362
    //   998: iconst_2
    //   999: aload_3
    //   1000: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1003: athrow
    //   1004: astore 47
    //   1006: new 870	gnu/mapping/WrongType
    //   1009: dup
    //   1010: aload 47
    //   1012: ldc_w 351
    //   1015: iconst_1
    //   1016: aload_2
    //   1017: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1020: athrow
    //   1021: astore 49
    //   1023: new 870	gnu/mapping/WrongType
    //   1026: dup
    //   1027: aload 49
    //   1029: ldc_w 351
    //   1032: iconst_2
    //   1033: aload_3
    //   1034: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1037: athrow
    //   1038: astore 42
    //   1040: new 870	gnu/mapping/WrongType
    //   1043: dup
    //   1044: aload 42
    //   1046: ldc_w 331
    //   1049: iconst_1
    //   1050: aload_2
    //   1051: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1054: athrow
    //   1055: astore 44
    //   1057: new 870	gnu/mapping/WrongType
    //   1060: dup
    //   1061: aload 44
    //   1063: ldc_w 331
    //   1066: iconst_2
    //   1067: aload_3
    //   1068: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1071: athrow
    //   1072: astore 38
    //   1074: new 870	gnu/mapping/WrongType
    //   1077: dup
    //   1078: aload 38
    //   1080: ldc_w 320
    //   1083: iconst_1
    //   1084: aload_2
    //   1085: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1088: athrow
    //   1089: astore 40
    //   1091: new 870	gnu/mapping/WrongType
    //   1094: dup
    //   1095: aload 40
    //   1097: ldc_w 320
    //   1100: iconst_2
    //   1101: aload_3
    //   1102: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1105: athrow
    //   1106: astore 33
    //   1108: new 870	gnu/mapping/WrongType
    //   1111: dup
    //   1112: aload 33
    //   1114: ldc_w 300
    //   1117: iconst_1
    //   1118: aload_2
    //   1119: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1122: athrow
    //   1123: astore 35
    //   1125: new 870	gnu/mapping/WrongType
    //   1128: dup
    //   1129: aload 35
    //   1131: ldc_w 300
    //   1134: iconst_2
    //   1135: aload_3
    //   1136: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1139: athrow
    //   1140: astore 29
    //   1142: new 870	gnu/mapping/WrongType
    //   1145: dup
    //   1146: aload 29
    //   1148: ldc_w 289
    //   1151: iconst_1
    //   1152: aload_2
    //   1153: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1156: athrow
    //   1157: astore 31
    //   1159: new 870	gnu/mapping/WrongType
    //   1162: dup
    //   1163: aload 31
    //   1165: ldc_w 289
    //   1168: iconst_2
    //   1169: aload_3
    //   1170: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1173: athrow
    //   1174: astore 25
    //   1176: new 870	gnu/mapping/WrongType
    //   1179: dup
    //   1180: aload 25
    //   1182: ldc_w 269
    //   1185: iconst_1
    //   1186: aload_2
    //   1187: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1190: athrow
    //   1191: astore 27
    //   1193: new 870	gnu/mapping/WrongType
    //   1196: dup
    //   1197: aload 27
    //   1199: ldc_w 269
    //   1202: iconst_2
    //   1203: aload_3
    //   1204: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1207: athrow
    //   1208: astore 21
    //   1210: new 870	gnu/mapping/WrongType
    //   1213: dup
    //   1214: aload 21
    //   1216: ldc_w 258
    //   1219: iconst_1
    //   1220: aload_2
    //   1221: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1224: athrow
    //   1225: astore 23
    //   1227: new 870	gnu/mapping/WrongType
    //   1230: dup
    //   1231: aload 23
    //   1233: ldc_w 258
    //   1236: iconst_2
    //   1237: aload_3
    //   1238: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1241: athrow
    //   1242: astore 17
    //   1244: new 870	gnu/mapping/WrongType
    //   1247: dup
    //   1248: aload 17
    //   1250: ldc 238
    //   1252: iconst_1
    //   1253: aload_2
    //   1254: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1257: athrow
    //   1258: astore 19
    //   1260: new 870	gnu/mapping/WrongType
    //   1263: dup
    //   1264: aload 19
    //   1266: ldc 238
    //   1268: iconst_2
    //   1269: aload_3
    //   1270: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1273: athrow
    //   1274: astore 13
    //   1276: new 870	gnu/mapping/WrongType
    //   1279: dup
    //   1280: aload 13
    //   1282: ldc 227
    //   1284: iconst_1
    //   1285: aload_2
    //   1286: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1289: athrow
    //   1290: astore 15
    //   1292: new 870	gnu/mapping/WrongType
    //   1295: dup
    //   1296: aload 15
    //   1298: ldc 227
    //   1300: iconst_2
    //   1301: aload_3
    //   1302: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1305: athrow
    //   1306: astore 8
    //   1308: new 870	gnu/mapping/WrongType
    //   1311: dup
    //   1312: aload 8
    //   1314: ldc 207
    //   1316: iconst_1
    //   1317: aload_2
    //   1318: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1321: athrow
    //   1322: astore 10
    //   1324: new 870	gnu/mapping/WrongType
    //   1327: dup
    //   1328: aload 10
    //   1330: ldc 207
    //   1332: iconst_2
    //   1333: aload_3
    //   1334: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1337: athrow
    //   1338: astore 4
    //   1340: new 870	gnu/mapping/WrongType
    //   1343: dup
    //   1344: aload 4
    //   1346: ldc 196
    //   1348: iconst_1
    //   1349: aload_2
    //   1350: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1353: athrow
    //   1354: astore 6
    //   1356: new 870	gnu/mapping/WrongType
    //   1359: dup
    //   1360: aload 6
    //   1362: ldc 196
    //   1364: iconst_2
    //   1365: aload_3
    //   1366: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1369: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   184	193	698	java/lang/ClassCastException
    //   193	202	715	java/lang/ClassCastException
    //   210	216	732	java/lang/ClassCastException
    //   216	225	749	java/lang/ClassCastException
    //   236	245	766	java/lang/ClassCastException
    //   245	254	783	java/lang/ClassCastException
    //   262	268	800	java/lang/ClassCastException
    //   268	277	817	java/lang/ClassCastException
    //   288	297	834	java/lang/ClassCastException
    //   297	306	851	java/lang/ClassCastException
    //   314	320	868	java/lang/ClassCastException
    //   320	329	885	java/lang/ClassCastException
    //   340	349	902	java/lang/ClassCastException
    //   349	358	919	java/lang/ClassCastException
    //   366	372	936	java/lang/ClassCastException
    //   372	381	953	java/lang/ClassCastException
    //   392	401	970	java/lang/ClassCastException
    //   401	410	987	java/lang/ClassCastException
    //   418	424	1004	java/lang/ClassCastException
    //   424	433	1021	java/lang/ClassCastException
    //   444	453	1038	java/lang/ClassCastException
    //   453	462	1055	java/lang/ClassCastException
    //   470	476	1072	java/lang/ClassCastException
    //   476	485	1089	java/lang/ClassCastException
    //   496	505	1106	java/lang/ClassCastException
    //   505	514	1123	java/lang/ClassCastException
    //   522	528	1140	java/lang/ClassCastException
    //   528	537	1157	java/lang/ClassCastException
    //   548	557	1174	java/lang/ClassCastException
    //   557	563	1191	java/lang/ClassCastException
    //   571	577	1208	java/lang/ClassCastException
    //   577	586	1225	java/lang/ClassCastException
    //   594	603	1242	java/lang/ClassCastException
    //   603	612	1258	java/lang/ClassCastException
    //   620	626	1274	java/lang/ClassCastException
    //   626	635	1290	java/lang/ClassCastException
    //   646	655	1306	java/lang/ClassCastException
    //   655	664	1322	java/lang/ClassCastException
    //   672	678	1338	java/lang/ClassCastException
    //   678	687	1354	java/lang/ClassCastException
  }

  // ERROR //
  public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 1032	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+92->96, 7:+102->106, 16:+140->144, 25:+178->182, 34:+216->220, 43:+254->258, 52:+292->296, 61:+330->334, 70:+368->372, 79:+403->407, 88:+441->445
    //   97: aload_1
    //   98: aload_2
    //   99: aload_3
    //   100: aload 4
    //   102: invokespecial 1183	gnu/expr/ModuleBody:apply3	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   105: areturn
    //   106: aload_2
    //   107: checkcast 756	gnu/lists/S8Vector
    //   110: astore 63
    //   112: aload_3
    //   113: checkcast 863	java/lang/Number
    //   116: invokevirtual 1048	java/lang/Number:intValue	()I
    //   119: istore 65
    //   121: aload 4
    //   123: checkcast 863	java/lang/Number
    //   126: invokevirtual 1048	java/lang/Number:intValue	()I
    //   129: istore 67
    //   131: aload 63
    //   133: iload 65
    //   135: iload 67
    //   137: invokestatic 1185	kawa/lib/uniform:s8vectorSet$Ex	(Lgnu/lists/S8Vector;II)V
    //   140: getstatic 1191	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   143: areturn
    //   144: aload_2
    //   145: checkcast 768	gnu/lists/U8Vector
    //   148: astore 57
    //   150: aload_3
    //   151: checkcast 863	java/lang/Number
    //   154: invokevirtual 1048	java/lang/Number:intValue	()I
    //   157: istore 59
    //   159: aload 4
    //   161: checkcast 863	java/lang/Number
    //   164: invokevirtual 1048	java/lang/Number:intValue	()I
    //   167: istore 61
    //   169: aload 57
    //   171: iload 59
    //   173: iload 61
    //   175: invokestatic 1193	kawa/lib/uniform:u8vectorSet$Ex	(Lgnu/lists/U8Vector;II)V
    //   178: getstatic 1191	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   181: areturn
    //   182: aload_2
    //   183: checkcast 747	gnu/lists/S16Vector
    //   186: astore 51
    //   188: aload_3
    //   189: checkcast 863	java/lang/Number
    //   192: invokevirtual 1048	java/lang/Number:intValue	()I
    //   195: istore 53
    //   197: aload 4
    //   199: checkcast 863	java/lang/Number
    //   202: invokevirtual 1048	java/lang/Number:intValue	()I
    //   205: istore 55
    //   207: aload 51
    //   209: iload 53
    //   211: iload 55
    //   213: invokestatic 1195	kawa/lib/uniform:s16vectorSet$Ex	(Lgnu/lists/S16Vector;II)V
    //   216: getstatic 1191	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   219: areturn
    //   220: aload_2
    //   221: checkcast 759	gnu/lists/U16Vector
    //   224: astore 45
    //   226: aload_3
    //   227: checkcast 863	java/lang/Number
    //   230: invokevirtual 1048	java/lang/Number:intValue	()I
    //   233: istore 47
    //   235: aload 4
    //   237: checkcast 863	java/lang/Number
    //   240: invokevirtual 1048	java/lang/Number:intValue	()I
    //   243: istore 49
    //   245: aload 45
    //   247: iload 47
    //   249: iload 49
    //   251: invokestatic 1197	kawa/lib/uniform:u16vectorSet$Ex	(Lgnu/lists/U16Vector;II)V
    //   254: getstatic 1191	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   257: areturn
    //   258: aload_2
    //   259: checkcast 750	gnu/lists/S32Vector
    //   262: astore 39
    //   264: aload_3
    //   265: checkcast 863	java/lang/Number
    //   268: invokevirtual 1048	java/lang/Number:intValue	()I
    //   271: istore 41
    //   273: aload 4
    //   275: checkcast 863	java/lang/Number
    //   278: invokevirtual 1048	java/lang/Number:intValue	()I
    //   281: istore 43
    //   283: aload 39
    //   285: iload 41
    //   287: iload 43
    //   289: invokestatic 1199	kawa/lib/uniform:s32vectorSet$Ex	(Lgnu/lists/S32Vector;II)V
    //   292: getstatic 1191	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   295: areturn
    //   296: aload_2
    //   297: checkcast 762	gnu/lists/U32Vector
    //   300: astore 32
    //   302: aload_3
    //   303: checkcast 863	java/lang/Number
    //   306: invokevirtual 1048	java/lang/Number:intValue	()I
    //   309: istore 34
    //   311: aload 4
    //   313: checkcast 863	java/lang/Number
    //   316: invokevirtual 867	java/lang/Number:longValue	()J
    //   319: lstore 36
    //   321: aload 32
    //   323: iload 34
    //   325: lload 36
    //   327: invokestatic 1201	kawa/lib/uniform:u32vectorSet$Ex	(Lgnu/lists/U32Vector;IJ)V
    //   330: getstatic 1191	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   333: areturn
    //   334: aload_2
    //   335: checkcast 753	gnu/lists/S64Vector
    //   338: astore 25
    //   340: aload_3
    //   341: checkcast 863	java/lang/Number
    //   344: invokevirtual 1048	java/lang/Number:intValue	()I
    //   347: istore 27
    //   349: aload 4
    //   351: checkcast 863	java/lang/Number
    //   354: invokevirtual 867	java/lang/Number:longValue	()J
    //   357: lstore 29
    //   359: aload 25
    //   361: iload 27
    //   363: lload 29
    //   365: invokestatic 1203	kawa/lib/uniform:s64vectorSet$Ex	(Lgnu/lists/S64Vector;IJ)V
    //   368: getstatic 1191	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   371: areturn
    //   372: aload_2
    //   373: checkcast 765	gnu/lists/U64Vector
    //   376: astore 19
    //   378: aload_3
    //   379: checkcast 863	java/lang/Number
    //   382: invokevirtual 1048	java/lang/Number:intValue	()I
    //   385: istore 21
    //   387: aload 4
    //   389: invokestatic 1006	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   392: astore 23
    //   394: aload 19
    //   396: iload 21
    //   398: aload 23
    //   400: invokestatic 1205	kawa/lib/uniform:u64vectorSet$Ex	(Lgnu/lists/U64Vector;ILgnu/math/IntNum;)V
    //   403: getstatic 1191	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   406: areturn
    //   407: aload_2
    //   408: checkcast 700	gnu/lists/F32Vector
    //   411: astore 13
    //   413: aload_3
    //   414: checkcast 863	java/lang/Number
    //   417: invokevirtual 1048	java/lang/Number:intValue	()I
    //   420: istore 15
    //   422: aload 4
    //   424: checkcast 863	java/lang/Number
    //   427: invokevirtual 1161	java/lang/Number:floatValue	()F
    //   430: fstore 17
    //   432: aload 13
    //   434: iload 15
    //   436: fload 17
    //   438: invokestatic 1207	kawa/lib/uniform:f32vectorSet$Ex	(Lgnu/lists/F32Vector;IF)V
    //   441: getstatic 1191	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   444: areturn
    //   445: aload_2
    //   446: checkcast 728	gnu/lists/F64Vector
    //   449: astore 6
    //   451: aload_3
    //   452: checkcast 863	java/lang/Number
    //   455: invokevirtual 1048	java/lang/Number:intValue	()I
    //   458: istore 8
    //   460: aload 4
    //   462: checkcast 863	java/lang/Number
    //   465: invokevirtual 1172	java/lang/Number:doubleValue	()D
    //   468: dstore 10
    //   470: aload 6
    //   472: iload 8
    //   474: dload 10
    //   476: invokestatic 1209	kawa/lib/uniform:f64vectorSet$Ex	(Lgnu/lists/F64Vector;ID)V
    //   479: getstatic 1191	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   482: areturn
    //   483: astore 62
    //   485: new 870	gnu/mapping/WrongType
    //   488: dup
    //   489: aload 62
    //   491: ldc_w 471
    //   494: iconst_1
    //   495: aload_2
    //   496: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   499: athrow
    //   500: astore 64
    //   502: new 870	gnu/mapping/WrongType
    //   505: dup
    //   506: aload 64
    //   508: ldc_w 471
    //   511: iconst_2
    //   512: aload_3
    //   513: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   516: athrow
    //   517: astore 66
    //   519: new 870	gnu/mapping/WrongType
    //   522: dup
    //   523: aload 66
    //   525: ldc_w 471
    //   528: iconst_3
    //   529: aload 4
    //   531: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   534: athrow
    //   535: astore 56
    //   537: new 870	gnu/mapping/WrongType
    //   540: dup
    //   541: aload 56
    //   543: ldc_w 440
    //   546: iconst_1
    //   547: aload_2
    //   548: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   551: athrow
    //   552: astore 58
    //   554: new 870	gnu/mapping/WrongType
    //   557: dup
    //   558: aload 58
    //   560: ldc_w 440
    //   563: iconst_2
    //   564: aload_3
    //   565: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   568: athrow
    //   569: astore 60
    //   571: new 870	gnu/mapping/WrongType
    //   574: dup
    //   575: aload 60
    //   577: ldc_w 440
    //   580: iconst_3
    //   581: aload 4
    //   583: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   586: athrow
    //   587: astore 50
    //   589: new 870	gnu/mapping/WrongType
    //   592: dup
    //   593: aload 50
    //   595: ldc_w 409
    //   598: iconst_1
    //   599: aload_2
    //   600: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   603: athrow
    //   604: astore 52
    //   606: new 870	gnu/mapping/WrongType
    //   609: dup
    //   610: aload 52
    //   612: ldc_w 409
    //   615: iconst_2
    //   616: aload_3
    //   617: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   620: athrow
    //   621: astore 54
    //   623: new 870	gnu/mapping/WrongType
    //   626: dup
    //   627: aload 54
    //   629: ldc_w 409
    //   632: iconst_3
    //   633: aload 4
    //   635: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   638: athrow
    //   639: astore 44
    //   641: new 870	gnu/mapping/WrongType
    //   644: dup
    //   645: aload 44
    //   647: ldc_w 378
    //   650: iconst_1
    //   651: aload_2
    //   652: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   655: athrow
    //   656: astore 46
    //   658: new 870	gnu/mapping/WrongType
    //   661: dup
    //   662: aload 46
    //   664: ldc_w 378
    //   667: iconst_2
    //   668: aload_3
    //   669: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   672: athrow
    //   673: astore 48
    //   675: new 870	gnu/mapping/WrongType
    //   678: dup
    //   679: aload 48
    //   681: ldc_w 378
    //   684: iconst_3
    //   685: aload 4
    //   687: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   690: athrow
    //   691: astore 38
    //   693: new 870	gnu/mapping/WrongType
    //   696: dup
    //   697: aload 38
    //   699: ldc_w 347
    //   702: iconst_1
    //   703: aload_2
    //   704: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   707: athrow
    //   708: astore 40
    //   710: new 870	gnu/mapping/WrongType
    //   713: dup
    //   714: aload 40
    //   716: ldc_w 347
    //   719: iconst_2
    //   720: aload_3
    //   721: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   724: athrow
    //   725: astore 42
    //   727: new 870	gnu/mapping/WrongType
    //   730: dup
    //   731: aload 42
    //   733: ldc_w 347
    //   736: iconst_3
    //   737: aload 4
    //   739: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   742: athrow
    //   743: astore 31
    //   745: new 870	gnu/mapping/WrongType
    //   748: dup
    //   749: aload 31
    //   751: ldc_w 316
    //   754: iconst_1
    //   755: aload_2
    //   756: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   759: athrow
    //   760: astore 33
    //   762: new 870	gnu/mapping/WrongType
    //   765: dup
    //   766: aload 33
    //   768: ldc_w 316
    //   771: iconst_2
    //   772: aload_3
    //   773: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   776: athrow
    //   777: astore 35
    //   779: new 870	gnu/mapping/WrongType
    //   782: dup
    //   783: aload 35
    //   785: ldc_w 316
    //   788: iconst_3
    //   789: aload 4
    //   791: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   794: athrow
    //   795: astore 24
    //   797: new 870	gnu/mapping/WrongType
    //   800: dup
    //   801: aload 24
    //   803: ldc_w 285
    //   806: iconst_1
    //   807: aload_2
    //   808: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   811: athrow
    //   812: astore 26
    //   814: new 870	gnu/mapping/WrongType
    //   817: dup
    //   818: aload 26
    //   820: ldc_w 285
    //   823: iconst_2
    //   824: aload_3
    //   825: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   828: athrow
    //   829: astore 28
    //   831: new 870	gnu/mapping/WrongType
    //   834: dup
    //   835: aload 28
    //   837: ldc_w 285
    //   840: iconst_3
    //   841: aload 4
    //   843: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   846: athrow
    //   847: astore 18
    //   849: new 870	gnu/mapping/WrongType
    //   852: dup
    //   853: aload 18
    //   855: ldc 254
    //   857: iconst_1
    //   858: aload_2
    //   859: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   862: athrow
    //   863: astore 20
    //   865: new 870	gnu/mapping/WrongType
    //   868: dup
    //   869: aload 20
    //   871: ldc 254
    //   873: iconst_2
    //   874: aload_3
    //   875: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   878: athrow
    //   879: astore 22
    //   881: new 870	gnu/mapping/WrongType
    //   884: dup
    //   885: aload 22
    //   887: ldc 254
    //   889: iconst_3
    //   890: aload 4
    //   892: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   895: athrow
    //   896: astore 12
    //   898: new 870	gnu/mapping/WrongType
    //   901: dup
    //   902: aload 12
    //   904: ldc 223
    //   906: iconst_1
    //   907: aload_2
    //   908: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   911: athrow
    //   912: astore 14
    //   914: new 870	gnu/mapping/WrongType
    //   917: dup
    //   918: aload 14
    //   920: ldc 223
    //   922: iconst_2
    //   923: aload_3
    //   924: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   927: athrow
    //   928: astore 16
    //   930: new 870	gnu/mapping/WrongType
    //   933: dup
    //   934: aload 16
    //   936: ldc 223
    //   938: iconst_3
    //   939: aload 4
    //   941: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   944: athrow
    //   945: astore 5
    //   947: new 870	gnu/mapping/WrongType
    //   950: dup
    //   951: aload 5
    //   953: ldc 192
    //   955: iconst_1
    //   956: aload_2
    //   957: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   960: athrow
    //   961: astore 7
    //   963: new 870	gnu/mapping/WrongType
    //   966: dup
    //   967: aload 7
    //   969: ldc 192
    //   971: iconst_2
    //   972: aload_3
    //   973: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   976: athrow
    //   977: astore 9
    //   979: new 870	gnu/mapping/WrongType
    //   982: dup
    //   983: aload 9
    //   985: ldc 192
    //   987: iconst_3
    //   988: aload 4
    //   990: invokespecial 875	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   993: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   106	112	483	java/lang/ClassCastException
    //   112	121	500	java/lang/ClassCastException
    //   121	131	517	java/lang/ClassCastException
    //   144	150	535	java/lang/ClassCastException
    //   150	159	552	java/lang/ClassCastException
    //   159	169	569	java/lang/ClassCastException
    //   182	188	587	java/lang/ClassCastException
    //   188	197	604	java/lang/ClassCastException
    //   197	207	621	java/lang/ClassCastException
    //   220	226	639	java/lang/ClassCastException
    //   226	235	656	java/lang/ClassCastException
    //   235	245	673	java/lang/ClassCastException
    //   258	264	691	java/lang/ClassCastException
    //   264	273	708	java/lang/ClassCastException
    //   273	283	725	java/lang/ClassCastException
    //   296	302	743	java/lang/ClassCastException
    //   302	311	760	java/lang/ClassCastException
    //   311	321	777	java/lang/ClassCastException
    //   334	340	795	java/lang/ClassCastException
    //   340	349	812	java/lang/ClassCastException
    //   349	359	829	java/lang/ClassCastException
    //   372	378	847	java/lang/ClassCastException
    //   378	387	863	java/lang/ClassCastException
    //   387	394	879	java/lang/ClassCastException
    //   407	413	896	java/lang/ClassCastException
    //   413	422	912	java/lang/ClassCastException
    //   422	432	928	java/lang/ClassCastException
    //   445	451	945	java/lang/ClassCastException
    //   451	460	961	java/lang/ClassCastException
    //   460	470	977	java/lang/ClassCastException
  }

  public Object applyN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject)
  {
    switch (paramModuleMethod.selector)
    {
    default:
      return super.applyN(paramModuleMethod, paramArrayOfObject);
    case 4:
      return s8vector$V(paramArrayOfObject);
    case 13:
      return u8vector$V(paramArrayOfObject);
    case 22:
      return s16vector$V(paramArrayOfObject);
    case 31:
      return u16vector$V(paramArrayOfObject);
    case 40:
      return s32vector$V(paramArrayOfObject);
    case 49:
      return u32vector$V(paramArrayOfObject);
    case 58:
      return s64vector$V(paramArrayOfObject);
    case 67:
      return u64vector$V(paramArrayOfObject);
    case 76:
      return f32vector$V(paramArrayOfObject);
    case 85:
    }
    return f64vector$V(paramArrayOfObject);
  }

  public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    case 3:
    case 4:
    case 6:
    case 7:
    case 12:
    case 13:
    case 15:
    case 16:
    case 21:
    case 22:
    case 24:
    case 25:
    case 30:
    case 31:
    case 33:
    case 34:
    case 39:
    case 40:
    case 42:
    case 43:
    case 48:
    case 49:
    case 51:
    case 52:
    case 57:
    case 58:
    case 60:
    case 61:
    case 66:
    case 67:
    case 69:
    case 70:
    case 75:
    case 76:
    case 78:
    case 79:
    case 84:
    case 85:
    case 87:
    case 88:
    default:
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    case 90:
      if ((paramObject instanceof LList))
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 89:
      if (!(paramObject instanceof F64Vector))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 86:
      if (!(paramObject instanceof F64Vector))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 83:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 82:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 81:
      if ((paramObject instanceof LList))
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 80:
      if (!(paramObject instanceof F32Vector))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 77:
      if (!(paramObject instanceof F32Vector))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 74:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 73:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 72:
      if ((paramObject instanceof LList))
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 71:
      if (!(paramObject instanceof U64Vector))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 68:
      if (!(paramObject instanceof U64Vector))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 65:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 64:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 63:
      if ((paramObject instanceof LList))
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 62:
      if (!(paramObject instanceof S64Vector))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 59:
      if (!(paramObject instanceof S64Vector))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 56:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 55:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 54:
      if ((paramObject instanceof LList))
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 53:
      if (!(paramObject instanceof U32Vector))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 50:
      if (!(paramObject instanceof U32Vector))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 47:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 46:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 45:
      if ((paramObject instanceof LList))
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 44:
      if (!(paramObject instanceof S32Vector))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 41:
      if (!(paramObject instanceof S32Vector))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 38:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 37:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 36:
      if ((paramObject instanceof LList))
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 35:
      if (!(paramObject instanceof U16Vector))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 32:
      if (!(paramObject instanceof U16Vector))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 29:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 28:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 27:
      if ((paramObject instanceof LList))
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 26:
      if (!(paramObject instanceof S16Vector))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 23:
      if (!(paramObject instanceof S16Vector))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 20:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 19:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 18:
      if ((paramObject instanceof LList))
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 17:
      if (!(paramObject instanceof U8Vector))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 14:
      if (!(paramObject instanceof U8Vector))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 11:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 10:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 9:
      if ((paramObject instanceof LList))
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 8:
      if (!(paramObject instanceof S8Vector))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 5:
      if (!(paramObject instanceof S8Vector))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 2:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 1:
    }
    paramCallContext.value1 = paramObject;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 1;
    return 0;
  }

  public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default:
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    case 87:
      if (!(paramObject1 instanceof F64Vector))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 83:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 78:
      if (!(paramObject1 instanceof F32Vector))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 74:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 69:
      if (!(paramObject1 instanceof U64Vector))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 65:
      paramCallContext.value1 = paramObject1;
      if (IntNum.asIntNumOrNull(paramObject2) != null)
      {
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return -786430;
    case 60:
      if (!(paramObject1 instanceof S64Vector))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 56:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 51:
      if (!(paramObject1 instanceof U32Vector))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 47:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 42:
      if (!(paramObject1 instanceof S32Vector))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 38:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 33:
      if (!(paramObject1 instanceof U16Vector))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 29:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 24:
      if (!(paramObject1 instanceof S16Vector))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 20:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 15:
      if (!(paramObject1 instanceof U8Vector))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 11:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 6:
      if (!(paramObject1 instanceof S8Vector))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 2:
    }
    paramCallContext.value1 = paramObject1;
    paramCallContext.value2 = paramObject2;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 2;
    return 0;
  }

  public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default:
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    case 88:
      if (!(paramObject1 instanceof F64Vector))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 79:
      if (!(paramObject1 instanceof F32Vector))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 70:
      if (!(paramObject1 instanceof U64Vector))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      if (IntNum.asIntNumOrNull(paramObject3) != null)
      {
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return -786429;
    case 61:
      if (!(paramObject1 instanceof S64Vector))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 52:
      if (!(paramObject1 instanceof U32Vector))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 43:
      if (!(paramObject1 instanceof S32Vector))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 34:
      if (!(paramObject1 instanceof U16Vector))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 25:
      if (!(paramObject1 instanceof S16Vector))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 16:
      if (!(paramObject1 instanceof U8Vector))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 7:
    }
    if (!(paramObject1 instanceof S8Vector))
      return -786431;
    paramCallContext.value1 = paramObject1;
    paramCallContext.value2 = paramObject2;
    paramCallContext.value3 = paramObject3;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 3;
    return 0;
  }

  public int matchN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default:
      return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext);
    case 85:
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 76:
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 67:
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 58:
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 49:
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 40:
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 31:
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 22:
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 13:
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 4:
    }
    paramCallContext.values = paramArrayOfObject;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 5;
    return 0;
  }

  public final void run(CallContext paramCallContext)
  {
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.lib.uniform
 * JD-Core Version:    0.6.2
 */