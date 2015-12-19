package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  For example, given array S = {-1 0 1 2 -1 -4},
 *  A solution set is:
 *  (-1, 0, 1)
 *  (-1, -1, 2)
 *
 * Created by Tikitoo on 2015/12/17.
 */
public class SumThree {
    public static void main(String[] args) {
        int[] nums = new int[] {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum2(nums);
        for(List<Integer> intList : lists) {
            printList(intList);
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        List<Integer> intList = new ArrayList<Integer>();

        int N = nums.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (i != j && i != k && j != k) {
                        int twoSum = nums[i] + nums[j] + nums[k];
                        if (twoSum == 0) {
                            intList.add(nums[i]);
                            intList.add(nums[j]);
                            intList.add(nums[k]);
                            lists.add(intList);
                        }
                    }
                }
            }
        }
        return lists;
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        List<Integer> intList = new ArrayList<Integer>();

        Arrays.sort(nums);
        int N = nums.length;
        for (int i = 0; i < N; i++) {
            if (nums[i] > 0) break;
            for (int j = i + 1; j < N; j++) {
                if (nums[i] + nums[j] > 0 && nums[j] > 0) break;

                for (int k = j + 1; k < N; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        intList.add(nums[i]);
                        intList.add(nums[j]);
                        intList.add(nums[k]);
                        lists.add(intList);
                        intList.clear();
                    }
                }
            }
        }
        return lists;
    }



    public static void printList(List<Integer> list) {
        System.out.print("(");
        int N = list.size();
        for (int i = 0; i < N; i++) {
            System.out.print(list.get(i) + "");
            if (i != N -1) {
                System.out.print(", ");
            }
        }
        System.out.println(")");
    }
}
