package com.google.appinventor.components.runtime;

import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.errors.YailRuntimeError;
import com.google.appinventor.components.runtime.util.Dates;
import com.google.appinventor.components.runtime.util.TimerInternal;
import java.util.Calendar;

@DesignerComponent(category=ComponentCategory.BASIC, description="Non-visible component that provides the phone's clock, a timer, and time calculations.", iconName="images/clock.png", nonVisible=true, version=1)
@SimpleObject
public final class Clock extends AndroidNonvisibleComponent
  implements Component, AlarmHandler, OnStopListener, OnResumeListener, OnDestroyListener, Deleteable
{
  private static final boolean DEFAULT_ENABLED = true;
  private static final int DEFAULT_INTERVAL = 1000;
  private boolean onScreen = false;
  private boolean timerAlwaysFires = true;
  private TimerInternal timerInternal;

  public Clock()
  {
    super(null);
  }

  public Clock(ComponentContainer paramComponentContainer)
  {
    super(paramComponentContainer.$form());
    this.timerInternal = new TimerInternal(this, true, 1000);
    this.form.registerForOnResume(this);
    this.form.registerForOnStop(this);
    this.form.registerForOnDestroy(this);
    if ((this.form instanceof ReplForm))
      this.onScreen = true;
  }

  @SimpleFunction(description="An instant in time some days after the argument")
  public static Calendar AddDays(Calendar paramCalendar, int paramInt)
  {
    Calendar localCalendar = (Calendar)paramCalendar.clone();
    Dates.DateAdd(localCalendar, 5, paramInt);
    return localCalendar;
  }

  @SimpleFunction(description="An instant in time some hours after the argument")
  public static Calendar AddHours(Calendar paramCalendar, int paramInt)
  {
    Calendar localCalendar = (Calendar)paramCalendar.clone();
    Dates.DateAdd(localCalendar, 11, paramInt);
    return localCalendar;
  }

  @SimpleFunction(description="An instant in time some minutes after the argument")
  public static Calendar AddMinutes(Calendar paramCalendar, int paramInt)
  {
    Calendar localCalendar = (Calendar)paramCalendar.clone();
    Dates.DateAdd(localCalendar, 12, paramInt);
    return localCalendar;
  }

  @SimpleFunction(description="An instant in time some months after the argument")
  public static Calendar AddMonths(Calendar paramCalendar, int paramInt)
  {
    Calendar localCalendar = (Calendar)paramCalendar.clone();
    Dates.DateAdd(localCalendar, 2, paramInt);
    return localCalendar;
  }

  @SimpleFunction(description="An instant in time some seconds after the argument")
  public static Calendar AddSeconds(Calendar paramCalendar, int paramInt)
  {
    Calendar localCalendar = (Calendar)paramCalendar.clone();
    Dates.DateAdd(localCalendar, 13, paramInt);
    return localCalendar;
  }

  @SimpleFunction(description="An instant in time some weeks after the argument")
  public static Calendar AddWeeks(Calendar paramCalendar, int paramInt)
  {
    Calendar localCalendar = (Calendar)paramCalendar.clone();
    Dates.DateAdd(localCalendar, 3, paramInt);
    return localCalendar;
  }

  @SimpleFunction(description="An instant in time some years after the argument")
  public static Calendar AddYears(Calendar paramCalendar, int paramInt)
  {
    Calendar localCalendar = (Calendar)paramCalendar.clone();
    Dates.DateAdd(localCalendar, 1, paramInt);
    return localCalendar;
  }

  @SimpleFunction(description="The day of the month")
  public static int DayOfMonth(Calendar paramCalendar)
  {
    return Dates.Day(paramCalendar);
  }

  @SimpleFunction(description="Milliseconds between instants")
  public static long Duration(Calendar paramCalendar1, Calendar paramCalendar2)
  {
    return paramCalendar2.getTimeInMillis() - paramCalendar1.getTimeInMillis();
  }

  @SimpleFunction(description="Text describing the date of an instant")
  public static String FormatDate(Calendar paramCalendar)
  {
    return Dates.FormatDate(paramCalendar);
  }

  @SimpleFunction(description="Text describing the date and time of an instant")
  public static String FormatDateTime(Calendar paramCalendar)
  {
    return Dates.FormatDateTime(paramCalendar);
  }

  @SimpleFunction(description="Text describing time time of an instant")
  public static String FormatTime(Calendar paramCalendar)
  {
    return Dates.FormatTime(paramCalendar);
  }

  @SimpleFunction(description="The instant in time measured as milliseconds since 1970.")
  public static long GetMillis(Calendar paramCalendar)
  {
    return paramCalendar.getTimeInMillis();
  }

  @SimpleFunction(description="The hour of the day")
  public static int Hour(Calendar paramCalendar)
  {
    return Dates.Hour(paramCalendar);
  }

  @SimpleFunction(description="An instant specified by MM/DD/YYYY hh:mm:ss or MM/DD/YYYY or hh:mm")
  public static Calendar MakeInstant(String paramString)
  {
    try
    {
      Calendar localCalendar = Dates.DateValue(paramString);
      return localCalendar;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
    }
    throw new YailRuntimeError("Argument to MakeInstant should have form MM/DD/YYYY, hh:mm:ss, or MM/DD/YYYY or hh:mm", "Sorry to be so picky.");
  }

  @SimpleFunction(description="An instant in time specified by the milliseconds since 1970.")
  public static Calendar MakeInstantFromMillis(long paramLong)
  {
    Calendar localCalendar = Dates.Now();
    localCalendar.setTimeInMillis(paramLong);
    return localCalendar;
  }

  @SimpleFunction(description="The minute of the hour")
  public static int Minute(Calendar paramCalendar)
  {
    return Dates.Minute(paramCalendar);
  }

  @SimpleFunction(description="The month of the year, a number from 1 to 12)")
  public static int Month(Calendar paramCalendar)
  {
    return 1 + Dates.Month(paramCalendar);
  }

  @SimpleFunction(description="The name of the month")
  public static String MonthName(Calendar paramCalendar)
  {
    return Dates.MonthName(paramCalendar);
  }

  @SimpleFunction(description="The instant in time read from phone's clock")
  public static Calendar Now()
  {
    return Dates.Now();
  }

  @SimpleFunction(description="The second of the minute")
  public static int Second(Calendar paramCalendar)
  {
    return Dates.Second(paramCalendar);
  }

  @SimpleFunction(description="The phone's internal time")
  public static long SystemTime()
  {
    return Dates.Timer();
  }

  @SimpleFunction(description="The day of the week. a number from 1 (Sunday) to 7 (Saturday)")
  public static int Weekday(Calendar paramCalendar)
  {
    return Dates.Weekday(paramCalendar);
  }

  @SimpleFunction(description="The name of the day of the week")
  public static String WeekdayName(Calendar paramCalendar)
  {
    return Dates.WeekdayName(paramCalendar);
  }

  @SimpleFunction(description="The year")
  public static int Year(Calendar paramCalendar)
  {
    return Dates.Year(paramCalendar);
  }

  @SimpleEvent(description="Timer has gone off.")
  public void Timer()
  {
    if ((this.timerAlwaysFires) || (this.onScreen))
      EventDispatcher.dispatchEvent(this, "Timer", new Object[0]);
  }

  @DesignerProperty(defaultValue="True", editorType="boolean")
  @SimpleProperty
  public void TimerAlwaysFires(boolean paramBoolean)
  {
    this.timerAlwaysFires = paramBoolean;
  }

  @SimpleProperty(category=PropertyCategory.BEHAVIOR)
  public boolean TimerAlwaysFires()
  {
    return this.timerAlwaysFires;
  }

  @DesignerProperty(defaultValue="True", editorType="boolean")
  @SimpleProperty
  public void TimerEnabled(boolean paramBoolean)
  {
    this.timerInternal.Enabled(paramBoolean);
  }

  @SimpleProperty(category=PropertyCategory.BEHAVIOR)
  public boolean TimerEnabled()
  {
    return this.timerInternal.Enabled();
  }

  @SimpleProperty(category=PropertyCategory.BEHAVIOR)
  public int TimerInterval()
  {
    return this.timerInternal.Interval();
  }

  @DesignerProperty(defaultValue="1000", editorType="non_negative_integer")
  @SimpleProperty
  public void TimerInterval(int paramInt)
  {
    this.timerInternal.Interval(paramInt);
  }

  public void alarm()
  {
    Timer();
  }

  public void onDelete()
  {
    this.timerInternal.Enabled(false);
  }

  public void onDestroy()
  {
    this.timerInternal.Enabled(false);
  }

  public void onResume()
  {
    this.onScreen = true;
  }

  public void onStop()
  {
    this.onScreen = false;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.Clock
 * JD-Core Version:    0.6.2
 */