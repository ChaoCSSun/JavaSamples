/**
 * 解释器模式
 *
 * http://zz563143188.iteye.com/blog/1847029
 * Created by Tikitoo on 2015/12/7.
 */
public class ExpressionDemo {
    public static void main(String[] args) {
        // 9 + 2 - 8
        int result = new Minus().interpret(new Context3(
                new Plus().interpret(new Context3(9, 2)), 8));
        System.out.println("result: " + result);
    }
}

interface Expression {
    int interpret(Context3 context3);
}

class Minus implements Expression {

    @Override
    public int interpret(Context3 context3) {
        return context3.getNum1() - context3.getNum2();
    }
}

class Plus implements Expression {

    @Override
    public int interpret(Context3 context3) {
        return context3.getNum1() + context3.getNum2();
    }
}

class Context3 {
    private int num1;
    private int num2;

    public Context3(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }
}
