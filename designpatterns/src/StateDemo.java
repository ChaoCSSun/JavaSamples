/**
 * 状态模式
 *
 * 多种状态，可以相互切换。
 * 例子：开关，遥控器。
 * http://ifeve.com/state-design-pattern-in-java-example-tutorial/
 * http://www.tutorialspoint.com/design_pattern/state_pattern.htm
 * Created by Tikitoo on 2015/12/7.
 */
public class StateDemo {
    public static void main(String[] args) {
        Context2 context2 = new Context2();

        StartState startState = new StartState();
        startState.doAction(context2);
        System.out.println(context2.getState().toString());

        StopState stopState = new StopState();
        stopState.doAction(context2);
        System.out.println(context2.getState().toString());
    }
}

interface State {
    void doAction(Context2 context2);
}

class StartState implements State {
    @Override
    public void doAction(Context2 context2) {
        System.out.println("Player is start state");
        context2.setState(this);
    }

    @Override
    public String toString() {
        return "start state";
    }
}

class StopState implements State {
    @Override
    public void doAction(Context2 context2) {
        System.out.println("Player is stop state");
        context2.setState(this);
    }

    @Override
    public String toString() {
        return "stop state";
    }
}

class Context2 {
    private State mState;

    public Context2() {
        mState = null;
    }

    public State getState() {
        return mState;
    }

    public void setState(State state) {
        mState = state;
    }
}
