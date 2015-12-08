package generic;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import sun.corba.Bridge;

/**
 * 泛型
 *
 * http://tutorials.jenkov.com/java-generics/implementing-iterable.html
 * http://www.cnblogs.com/sharewind/archive/2012/11/26/2788698.html
 * http://peiquan.blog.51cto.com/7518552/1302898
 * http://www.journaldev.com/1663/java-generics-tutorial-example-class-interface-methods-wildcards-and-much-more
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

// Class
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

// Method
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

// Class
class GenFactory<T> {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        GenFactory<String> factory = new GenFactory<String>(String.class);
        String str = factory.createInstance();

        GenFactory<Number> numFactory = new GenFactory<Number>(Number.class);
        Number number = numFactory.createInstance();


    }
    Class mClass = null;

    public GenFactory(Class aClass) {
        mClass = aClass;
    }

    public T createInstance() throws IllegalAccessException, InstantiationException {
        return (T) this.mClass.newInstance();
    }
}

// runtime, instance
class GenRun {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        String str = getInstance(String.class);
        Number number = getInstance(Number.class);

        Driver driver = read(Driver.class, "select * from user where id= 1");
        Bridge bridge = read(Bridge.class, "select * from bride where id= 1");
    }

    public static  <T> T getInstance(Class<T> tClass) throws IllegalAccessException, InstantiationException {
        return tClass.newInstance();
    }

    public static <T> T read(Class<T> tClass,   String sql) throws IllegalAccessException, InstantiationException {
        T o = tClass.newInstance();
        return o;
    }
}

// loop, iterator
class GenLoop {
    public static void main(String[] args) {
//        initList();
//        initSet();
        initMap();
    }

    public static void initList() {
        List<String> list = new ArrayList();
        list.add("dfa");
        list.add("dfad");
        for(String aString : list) {
            System.out.println(aString);
        }
    }

    public static void initSet() {
        Set<String> set = new HashSet<String>();
        set.add("dfad");
//        set.add("dfad");
        set.add("fdfasdf");
        for(String str : set) {
            System.out.println("set: " + str);
        }
    }

    public static void initMap() {
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "123");
        map.put(2, "123d");
        map.put(3, "123dfa");
        for(Integer aKey : map.keySet()) {
            String aValue = map.get(aKey);
            System.out.println(aKey + " : " + aValue);
        }
    }
}

// impl interface
class MyCollection<E> implements Iterable<E> {
    public static void main(String[] args) {
        MyCollection<String> strings = new MyCollection<String>();
        for(String aString : strings) {
            System.out.println(aString);
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator<E>();
    }
}

class MyIterator<T> implements Iterator<T> {

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public T next() {
        return null;
    }

    @Override
    public void remove() {

    }
}

// Wildcards 通配符
class Parent {}
class SubA  extends Parent {}
class SubB  extends Parent {}

/**
 * super: 参数类型，大于此。
 * extends: 返回类型限定，小于此。
 */
class GenWild {
    public static void main(String[] args) {
        List<Parent> listParent = new ArrayList<Parent>();
        List<SubA> listSubA = new ArrayList<SubA>();
//        listParent = listSubA; error
//        listSubA = listParent; error

        List<?>                 listUkown         = new ArrayList<Parent>();
        List<? extends Parent>  extendParentLisst = new ArrayList<Parent>();
        List<? super Parent>         superParentList   = new ArrayList<Parent>();
    }
}