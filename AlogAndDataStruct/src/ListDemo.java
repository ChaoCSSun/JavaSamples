import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tikitoo on 2015/11/30.
 */
public class ListDemo {
    private static List<String> mList;
    public static void main(String[] args) {
        initData();
        for(String str : initData()) {
            System.out.println(str);
        }
    }

    private static List<String> initData() {

        mList = new ArrayList<String>();

        for (int i = 0; i < 30; i++) {
            mList.add("x= i " + i);
        }
        return mList/* != null ? mList : new ArrayList<String>()*/;
    }
}
