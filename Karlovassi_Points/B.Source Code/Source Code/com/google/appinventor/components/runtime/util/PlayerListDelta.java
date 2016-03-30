package com.google.appinventor.components.runtime.util;

import java.util.ArrayList;
import java.util.List;

public class PlayerListDelta
{
  public static PlayerListDelta NO_CHANGE = new PlayerListDelta(new ArrayList(), new ArrayList());
  private List<String> playersAdded;
  private List<String> playersRemoved;

  public PlayerListDelta(List<String> paramList1, List<String> paramList2)
  {
    this.playersRemoved = paramList1;
    this.playersAdded = paramList2;
  }

  public List<String> getPlayersAdded()
  {
    return this.playersAdded;
  }

  public List<String> getPlayersRemoved()
  {
    return this.playersRemoved;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.util.PlayerListDelta
 * JD-Core Version:    0.6.2
 */