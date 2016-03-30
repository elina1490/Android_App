package com.google.appinventor.components.runtime.errors;

import com.google.appinventor.components.annotations.SimpleObject;

@SimpleObject
public abstract class RuntimeError extends RuntimeException
{
  protected RuntimeError()
  {
  }

  protected RuntimeError(String paramString)
  {
    super(paramString);
  }

  public static RuntimeError convertToRuntimeError(Throwable paramThrowable)
  {
    if ((paramThrowable instanceof RuntimeError))
      return (RuntimeError)paramThrowable;
    if ((paramThrowable instanceof ArrayIndexOutOfBoundsException))
      return new ArrayIndexOutOfBoundsError();
    if ((paramThrowable instanceof IllegalArgumentException))
      return new IllegalArgumentError();
    if ((paramThrowable instanceof NullPointerException))
      return new UninitializedInstanceError();
    throw new UnsupportedOperationException(paramThrowable);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.errors.RuntimeError
 * JD-Core Version:    0.6.2
 */