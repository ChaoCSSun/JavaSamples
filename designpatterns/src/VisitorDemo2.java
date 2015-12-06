/**
 * 访问者模式
 *
 * Created by Tikitoo on 2015/12/6.
 */
public class VisitorDemo2 {
    public static void main(String[] args) {
        ComputerPart computerPart = new Computer2();
        computerPart.accept(new ComputerPartDisplayVistor());
    }
}

interface ComputerPart {
    void accept(ComputerPartVisitor visitor);
}

class Keyboard implements ComputerPart {
    @Override
    public void accept(ComputerPartVisitor visitor) {
        visitor.visit(this);
    }
}

class Monitor implements ComputerPart {
    @Override
    public void accept(ComputerPartVisitor visitor) {
        visitor.visit(this);
    }
}

class Mouse implements ComputerPart {

    @Override
    public void accept(ComputerPartVisitor visitor) {
        visitor.visit(this);
    }
}

class Computer2 implements ComputerPart {
    ComputerPart[] mParts;

    public Computer2() {
        mParts = new ComputerPart[]{new Mouse(), new Monitor(), new Keyboard()};
    }

    @Override
    public void accept(ComputerPartVisitor visitor) {
        for (int i = 0; i < mParts.length; i++) {
            mParts[i].accept(visitor);
        }
        visitor.visit(this);
    }
}

interface ComputerPartVisitor {
    void visit(Computer2 computer2);
    void visit(Keyboard keyboard);
    void visit(Monitor monitor);
    void visit(Mouse mouse);
}

class ComputerPartDisplayVistor implements ComputerPartVisitor {

    @Override
    public void visit(Computer2 computer2) {
        System.out.println("Displaying Computer.");
    }

    @Override
    public void visit(Keyboard keyboard) {
        System.out.println("Displaying keyboard.");
    }

    @Override
    public void visit(Monitor monitor) {
        System.out.println("Displaying monitor.");
    }

    @Override
    public void visit(Mouse mouse) {
        System.out.println("Displaying mouse.");
    }
}


