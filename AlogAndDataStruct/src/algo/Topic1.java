package algo;

import edu.princeton.cs.algs4.Bag;

/**
 * Created by Tikitoo on 2015/12/10.
 */
public class Topic1 {



    // 最小公约数 欧几里得算法
    public static int qcd(int p, int q) {
        if (q == 0) return p;
        int r = p % q;
        return qcd(q, r);
    }

    // 二分查找法：在一个有序数组中，找到某个数字的下表
    public static int rank(int key, int[] a) {
        int start = 0;
        int end = a.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (key < a[mid])       end = mid - 1;
            else if (key > a[mid])  start = mid + 1;
            else                    return mid;
        }
        return -1;
    }

    public static void arrayTest(int[] array) {
        // max
        int max = array[0];
        for (int j = 0; j < array.length; j++) {
            if (array[j] > max ) max = array[j];
        }

        System.out.println("max: " + max);

        // average
        int N = array.length;
        double sum = 0;
        for (int i = 0; i < N; i++) {
            sum += array[i];
        }
        double average = sum / N;
        System.out.println("average: " + average);

        // copy array
        int[] copyArr = new int[N];
        for (int i = 0; i < N; i++) {
            copyArr[i] = array[i];
        }
        printArray(array);

        // reserve
        for (int i = 0; i < N / 2; i++) {
            int temp = array[i];
            array[i] = array[N - 1 - i];
            array[N - 1 - i] = temp;
        }
        printArray(array);
    }

    public static void printArray(int[] array) {
        System.out.print("array[");
        int len = array.length;
        for (int i = 0; i < len; i++) {
            System.out.print(array[i]);
            if (i != len - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    public static void staticSimpleTest() {

    }

    public static boolean isPrime(int N) {
        if (N < 2) return false;
        for (int i = 2; i * i < N; i++) {
            if (N % i == 0) return false;
        }
        return true;
    }

    public static void questionTest() {
        double d = Double.POSITIVE_INFINITY;
    }

    public static void sortNum(int a, int b, int c) {
        int t;
        if (a > b) { t = a; a = b; b = t; }
        if (a > c) { t = a; a = c; c = t; }
        if (b > c) { t = b; b = c; c = t; }
        System.out.println("num[" + a + " " + b + " " + c + "]");
    }


    public static void main(String[] args) {
        Bag bag = new Bag();
        sortNum(23, 56, 34);
//        System.out.println("isPrime: " + isPrime(23));
//        System.out.println("qcd: " + qcd(12, 10));
//        int[] intArr = new int[]{2, 5, 7, 8, 9, 12, 16, 45};
//        System.out.println(rank(5, intArr));
//        arrayTest(intArr);


    }
}

/**
 * 算法第四版
 * 第一章：基础
 *
 *   静态方法
 *   递归
 *   基础编程模型
 *   模块化编程
 *   单元测试
 *   外部库
 *
 * 第二章：排序
 *   插入，选择，希尔，快速，归并，队排序
 * 第三章：查找
 *   二叉查找树，平衡查找树，散列表
 * 第四章：图
 *   深度优先搜索，广度优先搜索，最小生成树，最短路径算法
 * 第五章：字符串
 *
 *
 */
