import java.util.HashMap;

/**
 * 享元模式
 *
 * http://www.tutorialspoint.com/design_pattern/flyweight_pattern.htm
 * Created by Tikitoo on 2015/12/6.
 */
public class FlyweightDemo {
    public static final String color[]
            = {"Red", "Green", "Orange", "Blue", "White"};
    public static void main(String[] args) {
        for (int i = 0; i < 20; ++i) {
            Circle3 circle3 = (Circle3) ShapeFactory3.getCircle(getRandomColor());
            circle3.setX(getRandX());
            circle3.setX(getRandY());
            circle3.setRadius(100);
            circle3.draw();

        }
    }

    private static String getRandomColor() {
        return color[((int) (Math.random() * color.length))];
    }

    private static int getRandX() {
        return (int) (Math.random() * 100);
    }

    private static int getRandY() {
        return (int) (Math.random() * 100);
    }
}

interface Shape3 {
    void draw();
}

class Circle3 implements Shape3 {
    private String color;
    private int x;
    private int y;
    private int radius;

    public Circle3(String color) {
        this.color = color;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Circle3: Draw() ["
                + ": color: " + color
                + "; x: " + x
                + "; y: " + y
                + "; radius: " + radius
                + "]");
    }
}

class ShapeFactory3 {
    public static final HashMap<String, Shape3> MAP = new HashMap();

    public static Shape3 getCircle(String color) {
        Circle3 circle3 = (Circle3) MAP.get(color);
        if (circle3 == null) {
            circle3 = new Circle3(color);
            MAP.put(color, circle3);
            System.out.println("create circle of color : " + color);
        }

        return circle3;
    }
}
