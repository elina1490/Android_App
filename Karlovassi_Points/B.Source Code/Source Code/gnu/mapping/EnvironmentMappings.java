package gnu.mapping;

import java.util.AbstractSet;
import java.util.Iterator;

class EnvironmentMappings extends AbstractSet
{
  SimpleEnvironment env;

  public EnvironmentMappings(SimpleEnvironment paramSimpleEnvironment)
  {
    this.env = paramSimpleEnvironment;
  }

  public Iterator iterator()
  {
    return new LocationEnumeration(this.env);
  }

  public int size()
  {
    return this.env.size();
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.mapping.EnvironmentMappings
 * JD-Core Version:    0.6.2
 */