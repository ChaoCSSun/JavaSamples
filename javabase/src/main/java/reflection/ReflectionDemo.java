package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 反射：运行期做一些事情
 * <p/>
 * Created by Tikitoo on 2015/12/7.
 */
public class ReflectionDemo {

    public static void main(String[] args) {
        // get Class all method
        Method[] methods = MyObject.class.getMethods();
        for (Method method : methods) {
            System.out.println("method: " + method.getName());
        }

        // Class Object
        Class aClass = MyObject.class;
        String className = "reflection.MyObject";
        try {
            Class eClass = Class.forName(className);
            boolean flag = aClass.equals(eClass);
            System.out.println(flag);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Class Name
        String className2 = aClass.getName();
        String simpleClassName = aClass.getSimpleName();
        System.out.println("className: " + className2
                + "\nsimpleClassName: " + simpleClassName);

        // Modifier
        int modifiers = aClass.getModifiers();
        boolean modifFlag = Modifier.isInterface(modifiers);
        System.out.println("modifFlag: " + modifFlag);

        // Package
        aClass.getPackage();

        // super class
        aClass.getSuperclass();

        aClass.getInterfaces();

        aClass.getConstructors();

        aClass.getMethods();

        aClass.getFields();

        aClass.getAnnotations();

        // Todo Constructor
        Constructor constructor;
        try {
            constructor = aClass.getConstructor(new Class[]{String.class});
            Class[] parameterType = constructor.getParameterTypes();
            for (Class cl : parameterType) {
                System.out.println("method filed: " + cl.getName());
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        try {
            Constructor constructor1 = MyObject.class.getConstructor(String.class);
            MyObject myObject = (MyObject) constructor1.newInstance("constructor-arg11");
            System.out.println("name: " + myObject.getName());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        // Todo Field
        Field[] fields = aClass.getFields();

        try {
            Field field = aClass.getField("name");
            System.out.println("fields: " + field.getName());
            Object objType = field.getType();
            if (objType instanceof String) {

                System.out.println("true");
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        // Todo Method
        Method[] methods1 = aClass.getMethods();
        try {
            Method method = aClass.getMethod("setName", new Class[]{String.class});
            Class[] parameterTypes = method.getParameterTypes();
            Class returnType = method.getReturnType();

            Method method1 = MyObject.class.getMethod("setName", String.class);
            Object returnValue = method1.invoke(null, "paramter-value1");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

class MyObject implements Runnable {
    public String name;

    public MyObject(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void run() {

    }
}