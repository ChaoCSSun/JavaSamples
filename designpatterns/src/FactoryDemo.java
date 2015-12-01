/**
 * 工厂模式
 *
 * http://ygsilence.iteye.com/blog/1409291
 * http://www.tutorialspoint.com/design_pattern/factory_pattern.htm
 * Created by Tikitoo on 2015/12/1.
 */
public class FactoryDemo {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape rectangleShape = shapeFactory.getShape(ShapeType.Rectangle);
        Shape circleShape = shapeFactory.getShape(ShapeType.Circle);
        Shape squareShape = shapeFactory.getShape(ShapeType.Square);
        rectangleShape.draw();
        circleShape.draw();
        squareShape.draw();
    }
}

interface Shape {
    void draw();
}

enum ShapeType {
    Rectangle, Circle, Square
}

class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Rectangle draw() method");
    }
}

class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Circle draw() method");
    }
}

class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Square draw() method");
    }
}

class ShapeFactory {
    public Shape getShape(ShapeType shapeType) {
        if (shapeType == null) {
            return null;
        }
        switch (shapeType) {
            case Rectangle:
                return new Rectangle();
            case Circle:
                return new Circle();
            case Square:
                return new Square();
            default:
                return null;
        }
    }
}

