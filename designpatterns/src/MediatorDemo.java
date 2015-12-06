/**
 * 中介模式
 *
 * 两个相关联的对象，关系处理交给Mediator 来处理。
 * http://zz563143188.iteye.com/blog/1847029
 * http://www.tutorialspoint.com/design_pattern/mediator_pattern.htm
 * Created by Tikitoo on 2015/12/6.
 */
public class MediatorDemo {
    public static void main(String[] args) {
        Mediator mediator = new MyMediator();
        mediator.createMediator();
        mediator.workAll();
    }
}

interface Mediator {
    void createMediator();
    void workAll();
}

class MyMediator implements Mediator {
    private UserSuper mUserChild1;
    private UserSuper mUserChild2;

    public UserSuper getUserChild1() {
        return mUserChild1;
    }

    public UserSuper getUserChild2() {
        return mUserChild2;
    }

    @Override
    public void createMediator() {
        mUserChild1 = new UserChild1(this);
        mUserChild2 = new UserChild2(this);
    }

    @Override
    public void workAll() {
        mUserChild1.work();
        mUserChild2.work();
    }
}

abstract class UserSuper {
    private Mediator mMediator;

    public Mediator getMediator() {
        return mMediator;
    }

    public UserSuper(Mediator mediator) {
        mMediator = mediator;
    }

    public abstract void work();
}

class UserChild1 extends UserSuper {

    public UserChild1(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void work() {
        System.out.println("user1 execute");
    }
}
class UserChild2 extends UserSuper {

    public UserChild2(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void work() {
        System.out.println("user2 execute");
    }
}
