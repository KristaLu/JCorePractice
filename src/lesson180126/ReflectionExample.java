package lesson180126;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionExample {
    public static void main(String[] classNames) {
        if (classNames.length>0){

            for (String className : classNames) {
                try {
                    Class<?> cls = Class.forName(className);
                    Method[] methods = cls.getDeclaredMethods();
                    Field f = cls.getDeclaredField("str");

                    if (f!=null)
                        System.out.println("yes!");

                    for (Method m : methods){
                        processMethod(cls, m, f);
                    }

                } catch (ClassNotFoundException e) {
                    System.err.printf("Can't find a class %s in class path%n", className);
                    e.printStackTrace();
                } catch (ReflectiveOperationException  e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public static void processMethod(Class<?> cls, Method m, Field f) throws InstantiationException, IllegalAccessException, InvocationTargetException {
        MyTest myT = m.getAnnotation(MyTest.class);
        if (myT != null){
            Object instance = cls.newInstance();

            if (f != null) {
                f.setAccessible(true);
                f.set(instance,"Hello for " + m);
            }

            System.out.println("Invoking " + m.getName());
            m.invoke(instance);
        }

    }
}
