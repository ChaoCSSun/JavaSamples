/**
 * 装饰着模式
 * 一个女孩，可以是美国的，中国的，欧洲的。
 * 她也可以是一个高才生，琴棋书画，
 * 这样就可以使用装饰者模式，动态来添加她的一些特性。
 *
 * http://www.programcreek.com/2012/05/java-design-pattern-decorator-decorate-your-girlfriend/
 * Created by Tikitoo on 2015/11/30.
 */
public class DecoratorDemo {
    public static void main(String[] args) {
        Girl girl = new AmericanGirl();
        System.out.println(girl.getDescription());
        Science girl2 = new Science(girl);
        System.out.println(girl2.getDescription());

        Art art = new Art(girl);
        System.out.println(art.getDescription());
    }
}

abstract class Girl {
    protected String description = "default";

    public String getDescription() {
        return description;
    }
}

class AmericanGirl extends Girl {
    public AmericanGirl() {
        description = "+American";
    }
}

class EuropeanGirl extends Girl {
    public EuropeanGirl() {
        description = "+European";
    }
}

abstract class GirlDecorator extends Girl{
    public abstract String getDescription();
}

class Science extends GirlDecorator {
    private Girl mGirl;

    public Science(Girl girl) {
        mGirl = girl;
    }

    @Override
    public String getDescription() {
        return mGirl.getDescription() + "Like Science";
    }
    public void caltulateStuff() {
        System.out.println("caltulate Stuff");
    }
}

class Art extends GirlDecorator {
    private Girl mGirl;

    public Art(Girl girl) {
        mGirl = girl;
    }

    @Override
    public String getDescription() {
        return mGirl.getDescription() + "Like Art";
    }

    public void draw() {
        System.out.println("draw pic");
    }
}
