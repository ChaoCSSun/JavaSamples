/**
 * 模板模式
 *
 * 抽象基类，为所有子类提供算法框架
 * 建造房子，特定的顺序，特工一个模板
 *
 * http://ifeve.com/template-method-design-pattern/
 *
 * Created by Tikitoo on 2015/12/1.
 */
public class TemplateDemo {
    public static void main(String[] args) {
        HourseTemplate hourseTemplate = new WoodenHouse();
        hourseTemplate.buildHourse();
        System.out.println("***********");
        hourseTemplate = new GlassHourse();
        hourseTemplate.buildHourse();;
    }
}

abstract class HourseTemplate {
    public final void buildHourse() {
        buildFoundation();
        buildPillars();
        buildWalls();
        buildWindows();
        System.out.println("Hourse is built");
    }

    private void buildFoundation() {
        System.out.println("Building Foundation with");
    }

    public abstract void buildPillars();

    public abstract void buildWalls();

    private void buildWindows() {
        System.out.println("build windows");
    }
}

class WoodenHouse extends HourseTemplate {

    @Override
    public void buildPillars() {
        System.out.println("Build wooden pillars");
    }

    @Override
    public void buildWalls() {
        System.out.println("Build wooden walls");

    }
}

class GlassHourse extends HourseTemplate {

    @Override
    public void buildPillars() {
        System.out.println("Build glass pillars");
    }

    @Override
    public void buildWalls() {
        System.out.println("Build glass wall");
    }
}


