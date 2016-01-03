package algo;

import java.util.Comparator;

/**
 * 冒泡排序
 * Created by Tikitoo on 2015/12/21.
 */
public class SortBubble implements Sorter {
    private Comparator c;

    public SortBubble() {
    }

    public SortBubble(Comparator c) {
        this.c = c;
    }

    @Override
    public void sort(CharSequence s) {
    }
}
