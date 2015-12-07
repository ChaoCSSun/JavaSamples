/**
 * 策略模式
 *
 * 一种状态，两种实现目的，相互可以替换，
 *
 * 例子：好警察和坏警察。两个数的加减乘除。
 *
 * http://ifeve.com/java-example-of-strategy-pattern/
 * http://www.tutorialspoint.com/design_pattern/strategy_pattern.htm
 * Created by Tikitoo on 2015/12/7.
 */
public class StrategyDemo {
    public static void main(String[] args) {
        HardPolice hp = new HardPolice();
        NicePolice np = new NicePolice();

        Situation s1 = new Situation(hp);
        Situation s2 = new Situation(np);
        s1.handleByPolice(10);
        s2.handleByPolice(10);

        System.out.println("----------------------------------");

        Context context = new Context(new OperationAdd());
        System.out.println("10 + 5 = " + context.execureStrategy(5, 10));

        context = new Context(new OperationSubstract());
        System.out.println("10 - 5 = " + context.execureStrategy(10, 5));

        context = new Context(new OperationMultiply());
        System.out.println("10 * 5 = " + context.execureStrategy(5, 10));
    }
}

interface Strategy {
    void processSpeeding(int speed);

}

class NicePolice implements Strategy {

    @Override
    public void processSpeeding(int speed) {
        System.out.println("This is first, don't again");
    }
}

class HardPolice implements Strategy {

    @Override
    public void processSpeeding(int speed) {
        System.out.println("You speed is " + speed + "should get ticket");
    }
}

class Situation {
    private Strategy mStrategy;

    public Situation(Strategy strategy) {
        mStrategy = strategy;
    }

    public void handleByPolice(int speed) {
        this.mStrategy.processSpeeding(speed);
    }
}

interface Strategy2 {
    int doOperation(int num1, int num2);
}

class OperationAdd implements Strategy2 {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}

class OperationSubstract implements Strategy2 {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}

class OperationMultiply implements Strategy2 {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}

class Context {
    private Strategy2 mStrategy2;

    public Context(Strategy2 strategy2) {
        mStrategy2 = strategy2;
    }

    public int execureStrategy(int num1, int num2) {
        return mStrategy2.doOperation(num1, num2);
    }
}


