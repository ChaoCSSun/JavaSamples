package datastruct;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

/**
 * List: 链表，有序
 * ArrayList: 数组队列
 * LinkedList: 双向链表
 * Vector: 矢量队列
 * Stack: 栈，后进先出
 *
 *
 * Created by Tikitoo on 2015/12/16.
 */
public class ListDemo {
    private static final int COUNT = 100000;
    private static LinkedList linkedList = new LinkedList();
    private static ArrayList arrayList = new ArrayList();
    private static Vector vector = new Vector();
    private static Stack stack = new Stack();


    public static void main(String[] args) {
        System.out.println();
        insertByPosition(stack);
        insertByPosition(vector);
        insertByPosition(linkedList);
        insertByPosition(arrayList);

        System.out.println();
        readByPosition(stack);
        readByPosition(vector);
        readByPosition(linkedList);
        readByPosition(arrayList);

        System.out.println();
        deleteByPosition(stack);
        deleteByPosition(vector);
        deleteByPosition(linkedList);
        deleteByPosition(arrayList);

        System.out.println();

    }

    private static void insertByPosition(List list) {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < COUNT; i++) {
            list.add(0, i);
        }
        long endTime = System.currentTimeMillis();
        long interval = endTime - startTime;
        System.out.println(getListName(list) + " : insert " + COUNT
                +"user time: " + interval + "ms");
    }

    private static void deleteByPosition(List list) {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < COUNT; i++) {
            list.remove(0);
        }
        long endTime = System.currentTimeMillis();
        long interval = endTime - startTime;
        System.out.println(getListName(list) + " : delete " + COUNT
                +"user time: " + interval + "ms");
    }

    private static void readByPosition(List list) {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < COUNT; i++) {
            list.get(i);
        }
        long endTime = System.currentTimeMillis();
        long interval = endTime - startTime;
        System.out.println(getListName(list) + " : read " + COUNT
                +"user time: " + interval + "ms");
    }

    private static String getListName(List list) {
        if (list instanceof  LinkedList) {
            return "LinkedList";
        } else if (list instanceof ArrayList) {
            return "ArrayList";
        } else if (list instanceof Stack) {
            return "Stack";
        } else if (list instanceof Vector) {
            return "Vector";
        } else {
            return "List";
        }
    }
}

/**
 * 快速删除，插入：LinkedList
 * 随机访问（读取）：ArrayList, Vector
 * ArrayList 和Vector
 * 相同
 *  继承实现
 *  RandomAccess,Cloneable
 *  数组实现
 *  默认都是10
 *  支持Iterator, ListIterator
 * 不同
 *  线程
 *  序列化
 *  动态指定增加系数
 *  容量增加方式不同
 *  Enum 遍历
 *
 result

 Stack : insert 100000user time: 1173ms
 Vector : insert 100000user time: 814ms
 LinkedList : insert 100000user time: 8ms
 ArrayList : insert 100000user time: 829ms

 Stack : read 100000user time: 7ms
 Vector : read 100000user time: 5ms
 LinkedList : read 100000user time: 5118ms
 ArrayList : read 100000user time: 2ms

 Stack : delete 100000user time: 1077ms
 Vector : delete 100000user time: 830ms
 LinkedList : delete 100000user time: 6ms
 ArrayList : delete 100000user time: 1144ms

 */
