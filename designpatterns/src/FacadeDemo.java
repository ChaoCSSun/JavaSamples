/**
 * 外观模式
 *
 * 将通用的东西抽离出来。复用
 * JDBC 连接数据库
 * http://www.tutorialspoint.com/design_pattern/facade_pattern.htm
 * http://www.dotspace.idv.tw/Patterns/Jdon_Facade.htm
 * Created by Tikitoo on 2015/12/4.
 */
public class FacadeDemo {
    public static void main(String[] args) {
        ShapeMaker shapeMaker = new ShapeMaker();
        shapeMaker.drawCircle();
        shapeMaker.drawSquare();
        shapeMaker.drawRetangle();
    }
}

interface Shape2 {
    void draw();
}

class Square2 implements Shape2 {
    @Override
    public void draw() {
        System.out.println("Square2: draw");
    }
}

class Rectangle2 implements Shape2 {
    @Override
    public void draw() {
        System.out.println("Rectangle2: draw");
    }
}

class Circle2 implements Shape2 {
    @Override
    public void draw() {
        System.out.println("Circle2: draw");
    }
}

class ShapeMaker {
    private Shape2 circle;
    private Shape2 square;
    private Shape2 rectangle;

    ShapeMaker() {
        circle = new Circle2();
        square = new Square2();
        rectangle = new Rectangle2();
    }

    public void drawCircle() {
        circle.draw();
    }


    public void drawSquare() {
        square.draw();
    }

    public void drawRetangle() {
        rectangle.draw();
    }


}

