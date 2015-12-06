/**
 * 访问者模式
 *
 * 数据结构与算法分离，为一个访问者添加新的操作，不需要额外添加其他。
 * http://www.tutorialspoint.com/design_pattern/visitor_pattern.htm
 * http://blog.csdn.net/zhangerqing/article/details/8245537
 * Created by Tikitoo on 2015/12/6.
 */
public class VisitorDemo {
    public static void main(String[] args) {
        Visitor visitor = new MyVisitor();
        Subject2 subject2 = new MySubject2();
        subject2.accept(visitor);
    }
}


interface Visitor {
    void visit(Subject2 subject2);
}

class MyVisitor implements Visitor {

    @Override
    public void visit(Subject2 subject2) {
        System.out.println("Visitor the subject: " + subject2.getSubject());
    }
}

interface Subject2 {
    void accept(Visitor visitor);
    String getSubject();
}

class MySubject2 implements Subject2 {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String getSubject() {
        return "love";
    }
}