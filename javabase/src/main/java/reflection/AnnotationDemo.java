package reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by Tikitoo on 2015/12/7.
 */



public class AnnotationDemo {
    public static void main(String[] args) throws NoSuchMethodException {

        Class aClass = TheClass.class;
        Annotation[] annotations = aClass.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof MyAnnotation) {
                MyAnnotation myAnno = (MyAnnotation) annotation;
                System.out.println("name: " + myAnno.name());
                System.out.println("value: " + myAnno.value());
            }
        }

        Method method = aClass.getMethod("name", String.class);
        Annotation[] annotations1 = method.getDeclaredAnnotations();
        method.getAnnotation(MyAnnotation.class);


        method.getParameterAnnotations();

    }


    @Override
    @MethodInfo(author = "Tikitoo", comments = "Main method", date = "12-07", revision = 1)
    public String toString() {
        return "Overide toString Method";
    }

    @Deprecated
    @MethodInfo(date = "10-9", comments = "Deprecated method")
    public static void oldMethod() {
        System.out.println("old method");
    }


}



@MyAnnotation(name = "somename", value = "value")
class TheClass {

    @MyAnnotation(name = "dafd", value = "dafda")
    public String field = null;

    @MyAnnotation(name="methodName", value = "methodValue")
    public void doPlay() {}
}