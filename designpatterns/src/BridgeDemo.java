/**
 * 桥接模式
 *
 * http://zz563143188.iteye.com/blog/1847029
 * http://www.dotspace.idv.tw/Patterns/Jdon_Bridge.htm
 * Created by Tikitoo on 2015/12/4.
 */
public class BridgeDemo {
    public static void main(String[] args) {
        Bridge bridge = new MyBridge();

        Sourceable sourceSubOne = new SourceSubOne();
        bridge.setSourceable(sourceSubOne);
        sourceSubOne.method();

        Sourceable sourceSubTwo = new SourceSubTwo();
        bridge.setSourceable(sourceSubTwo);
        sourceSubTwo.method();


    }
}

interface Sourceable {
    void method();
}

class SourceSubOne implements Sourceable {
    @Override
    public void method() {
        System.out.println("one sub method");
    }
}

class SourceSubTwo implements Sourceable {
    @Override
    public void method() {
        System.out.println("two sub method");
    }
}

abstract class Bridge {
    private Sourceable mSourceable;
    private void method() {
        mSourceable.method();
    }

    public Sourceable getSourceable() {
        return mSourceable;
    }

    public void setSourceable(Sourceable sourceable) {
        mSourceable = sourceable;
    }
}

class MyBridge extends Bridge {
    void method() {
        getSourceable().method();
    }
}
