/**
 * 单例模式
 *
 * 懒加载：初始化然后在方法里面实例化
 * 全局初始化：初始化全局，并实例化
 * 静态代码块实例化
 * 在内部Holder 实例化
 *
 * http://wuchong.me/blog/2014/08/28/how-to-correctly-write-singleton-pattern/
 * http://www.tutorialspoint.com/java/java_using_singleton.htm
 * https://en.wikipedia.org/wiki/Singleton_pattern
 * Created by Tikitoo on 2015/12/1.
 */
public class SingleDemo {
    public static void main(String[] args) {
        Singleton.getInstance().doPlay();
        ClassSingleton.getInstance().doPlay();
    }
}

class Singleton {
    private static Singleton singleton = new Singleton();
    private Singleton() {}

    public static Singleton getInstance() {
        return singleton;
    }

    public static void doPlay() {
        System.out.println("I start play");
    }
}

class ClassSingleton {
    private static ClassSingleton instance = null;

    private ClassSingleton() {

    }

    public static ClassSingleton getInstance() {
        if (instance == null) {
            instance = new ClassSingleton();
        }
        return instance;
    }

    public static void doPlay() {
        System.out.println("I start play");
    }
}

