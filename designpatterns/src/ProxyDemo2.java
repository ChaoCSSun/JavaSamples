import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 静态代理与静态代理
 *
 * http://blog.csdn.net/liangbinny/article/details/18656791
 * Created by Tikitoo on 2016/2/11.
 */
public class ProxyDemo2 {
    public static void main(String[] args) {
        Sub sub = new ProxySub();
        sub.req();
    }
}


abstract class Sub {
    public abstract void req();
}

class RealSub extends Sub {

    @Override
    public void req() {

    }
}

class ProxySub extends Sub {
    private RealSub mRealSub = null;

    @Override
    public void req() {
        preReq();
        if (mRealSub == null) {
            mRealSub = new RealSub();
        }
        mRealSub.req();
        postReq();
    }

    private void postReq() {

    }

    private void preReq() {

    }
}

interface Sub2 {
    void req();
}

class RealSub2 implements Sub2 {

    @Override
    public void req() {

    }
}


class DynamicSub2 implements InvocationHandler {
    private Object sub;

    public DynamicSub2(Object sub) {
        this.sub = sub;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        method.invoke(sub, args);
        return null;
    }
}

class ProxyTest {
    public static void main(String[] args) {
        RealSub2 rs = new RealSub2();
        InvocationHandler handler = new DynamicSub2(rs);
        Class cls = rs.getClass();
        Sub2 sub2 = (Sub2)
                Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), handler);
        sub2.req();
    }
}