import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tikitoo on 2015/11/30.
 */
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World");
        for (String str : initData()) {
            System.out.println(str);
            System.out.println();
        }
    }

    private static List<String> initData() {
        List<String> lists = new ArrayList<String>();
        for (int i = 0; i < 200; i++) {
            lists.add(i + "");
        }
        return lists;
    }
}
