/**
 * 原型模式
 * clone
 * http://www.importnew.com/6907.html
 * Created by Tikitoo on 2015/12/3.
 */
public class PtototypeDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        Hello hello = new Hello(2);
        Prototype prototype = hello.clone();

        prototype.printSize();
        for (int i = 1; i < 9; i++) {
            Prototype temp = hello.clone();
            temp.setSize(i);
            temp.printSize();
        }
    }
}

interface Prototype {
    void setSize(int x);
    void printSize();
}

class Hello implements Prototype, Cloneable {
    private int size;

    public Hello(int size) {
        this.size = size;
    }

    @Override
    public void setSize(int x) {
        this.size = x;
    }

    @Override
    public void printSize() {
        System.out.println("size: " + size);
    }

    @Override
    protected Hello clone() throws CloneNotSupportedException {
        return (Hello)super.clone();
    }
}