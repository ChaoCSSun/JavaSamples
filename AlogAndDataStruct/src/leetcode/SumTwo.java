package leetcode;

import java.util.HashMap;

/**
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 * Created by Tikitoo on 2015/12/17.
 */
public class SumTwo{
    public static void main(String[] args) {
        int[] nums = new int[]{3, 5, 6, 7, 78, 8};
        long startTime = System.currentTimeMillis();
        int[] indexs = twoSum(nums, 13);
//        int[] indexs = twoSum2(nums, 13);
        long endtTime = System.currentTimeMillis();
        long time = endtTime - startTime;
        System.out.println("time: " + time);
        System.out.println("indexs: " + indexs[0] + ", " + indexs[1]);
    }

    // me
    public static int[] twoSum(int[] nums, int target) {
        int[] indexs = new int[2];
        int N = nums.length;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (nums[i] + nums[j] == target) {
                    indexs[0] = i + 1;
                    indexs[1] = j + 1;
                }
            }
        }
        if (indexs.length == 0) {
            throw new RuntimeException("not two sum equals target number");
        }
        return indexs;
    }

    // http://www.jiuzhang.com/solutions/two-sum/
    public static int[] twoSum2(int[] nums, int target) {
        if (nums == null || nums.length < 2) return null;
        int[] indexs = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int N = nums.length;
        for (int i = 0; i < N; i++) {
            map.put(nums[i], i + 1);
        }
        for (int i = 0; i < N; i++) {
            if (map.containsKey(target - nums[i])) {
                int index1 = i + 1;
                int index2 = map.get(target - nums[i]);
                if (index1 == index2) {
                    continue;
                }
                indexs[0] = index1;
                indexs[1] = index2;
                return indexs;
            }
        }
        return indexs;
    }
}
