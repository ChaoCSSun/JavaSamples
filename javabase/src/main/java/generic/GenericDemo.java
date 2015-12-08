package generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 泛型
 *
 * Created by Tikitoo on 2015/12/8.
 */
public class GenericDemo {
    public static void main(String[] args) {
        listString();
    }

    private void initTest() {
        List list = new ArrayList();
        list.add("hello");
        list.add(2);
        list.add(true);
    }

    private static void listString() {
        List<String> list = new ArrayList();
        list.add("hello");
        for(String st : list) {
            System.out.println(st);
        }
    }
}

class Gen<T> {
    T obj;

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public static void main(String[] args) {
        Gen<String> gen = new Gen<String>();
        gen.setObj("abc");
//        gen.setObj(12);

        String str = gen.getObj();

        Gen gen2 = new Gen();
        gen2.setObj("abc");
        gen2.setObj(23);
        Integer num = (Integer) gen2.getObj();
        System.out.println("gen2 num: " + num);
    }
}


class GenMethod {
    public static <T> void  fromArrayToCollection(T[] a, Collection<T> c) {
        for(T t : a) {
          c.add(t);
        }
    }

    public static void main(String[] args) {
        Object[] oc = new Object[100];
        Collection<Object> collect = new ArrayList<Object>();
      GenMethod.fromArrayToCollection(oc, collect);
    }
}