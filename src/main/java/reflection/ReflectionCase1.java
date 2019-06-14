package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionCase1 {

  public ReflectionCase1() {
  }

  public void scenario1() {
    Class myClass = MyClass.class;
    System.out.println(myClass.getName());
    System.out.println(myClass.getSimpleName());
    System.out.println(myClass.getCanonicalName());


  }
  public void scenario2Constructors() {
    Class myClass = MyClass.class;
    Constructor [] constr = myClass.getConstructors();
    for(Constructor c: constr) {
      System.out.println(c.getName());
    }
    try {
      MyClass instance = (MyClass)myClass.getConstructor(Integer.class, Integer.class).newInstance(2, 3);
      System.out.println(instance.sum());
    } catch (InstantiationException e) {

      e.printStackTrace();
    } catch (IllegalAccessException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IllegalArgumentException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (NoSuchMethodException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (SecurityException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
    public void scenario3Fields() {
      Class myClass = MyClass.class;
      Field[] fields = myClass.getFields();
      for(Field field: fields) {
        System.out.println(field.getName());
      }
    }

    public void scenario4Methods() {
      Class myClass = MyClass.class;
      try {
        Method m = myClass.getMethod("sum", Integer.class, Integer.class);
        MyClass instance = (MyClass) myClass.getConstructor(null).newInstance(null);
        int sum = (Integer) m.invoke(instance, 3,4);
        System.out.println(sum);
      } catch (NoSuchMethodException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (SecurityException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (IllegalAccessException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (IllegalArgumentException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (InvocationTargetException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (InstantiationException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

    }
public void scenario5GetterSetterMethods() {
  Class myClass = MyClass.class;
  Method[] methods = myClass.getMethods();

  for(Method m: methods) {
    if(isGetter(m)) System.out.println("Getter: "+m.getName());
    if(isSetter(m)) System.out.println("Setter: "+m.getName());
  }
}

  private boolean isGetter(Method m) {
    if(!m.getName().startsWith("get"))
      return false;
    if(! void.class.equals(m.getReturnType()))
      return false;
    return true;
}

  private boolean isSetter(Method m) {
    if(!m.getName().startsWith("set"))
      return false;
    if( void.class.equals(m.getReturnType()))
      return true;
    return true;
}
  public static void main (String[] args) {
    ReflectionCase1 instance = new ReflectionCase1();
  // instance.scenario1();
  // instance.scenario2Constructors();
   // instance.scenario3Fields();
    //instance.scenario4Methods();
      instance.scenario5GetterSetterMethods();

  }

}
