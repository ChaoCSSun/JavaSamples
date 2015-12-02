/**
 * 适配器模式
 * 让原有的对象，具有目标对象的属性
 * https://www.ibm.com/developerworks/cn/java/j-lo-adapter-pattern/
 * http://www.programcreek.com/2011/09/java-design-pattern-adapter/
 * http://www.cnblogs.com/java-my-life/archive/2012/04/13/2442795.html
 * Created by Tikitoo on 2015/12/2.
 */
public class AdapterDemo {
    public static void main(String[] args) {
        Apple apple = new Apple();
        Apple apple2 = new Apple();

        apple.getColor("Green");

        Orange orange = new Orange();
        AppleAdapter adapter = new AppleAdapter(orange);
        adapter.getColor("red");

    }
}

abstract class Fruit {
    abstract void getColor(String color);
}

class Apple extends Fruit {
    @Override
    void getColor(String color) {
        System.out.println("apple color is: " + color);
    }
}

class Orange extends Fruit {
    @Override
    void getColor(String color) {
        System.out.println("apple color is: " + color);
    }
}

class AppleAdapter extends Apple {
    private Orange mOrange;

    public AppleAdapter(Orange orange) {
        mOrange = orange;
    }

    @Override
    void getColor(String color) {
        mOrange.getColor(color);
    }
}


interface Targeet {
    void request();
}

class Adaptee {
    void specialRequest() {
        System.out.println("do specialRequest thing");
    }
}

class Adapter implements Targeet {
    private Adaptee mAdaptee;

    public Adapter(Adaptee adaptee) {
        mAdaptee = adaptee;
    }

    @Override
    public void request() {
        mAdaptee.specialRequest();
    }
}

class Client {
    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();
        Targeet targeet = new Adapter(adaptee);
        targeet.request();
    }
}

