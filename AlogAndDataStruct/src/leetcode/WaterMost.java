package leetcode;

/**
 * Created by Tikitoo on 2015/12/21.
 */
public class WaterMost {
    public static void main(String[] args) {
        int x = maxArea(new int[]{3, 6, 8, 4, 9, 23});
        System.out.println("max: " + x);
    }

    public static int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }

        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            max = Math.max(max, (right - left) * Math.min(left, right));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
