/**
 * 备忘录模式（备份模式）
 *
 * 将一个对象的状态备份，修改后，并且可以恢复。
 * Memento 是一个缓存，最后将数据存储在Storage 中。
 * http://blog.csdn.net/zhangerqing/article/details/8245537
 * Created by Tikitoo on 2015/12/6.
 */
public class MementoDemo {
    public static void main(String[] args) {
        Original original = new Original("egg");

        Storage storage = new Storage(original.createMemento());

        System.out.println("init status : " + original.getValue());
        original.setValue("egg modify");
        System.out.println("modify status: " + original.getValue());

        original.restoreMemento(storage.getMemento());
        System.out.println("restore status: " + original.getValue());
    }
}

class Original {
    private String value;

    public Original(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Memento createMemento() {
        return new Memento(value);
    }

    public void restoreMemento(Memento memento) {
        this.value = memento.getValue();
    }

}

class Memento {
    private String value;

    public Memento(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

class Storage {
    private Memento mMemento;

    public Storage(Memento memento) {
        mMemento = memento;
    }

    public Memento getMemento() {
        return mMemento;
    }

    public void setMemento(Memento memento) {
        mMemento = memento;
    }
}
