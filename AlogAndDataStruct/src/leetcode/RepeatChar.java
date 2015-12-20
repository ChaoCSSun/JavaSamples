package leetcode;

import java.util.HashSet;

/**
 * Longest Substring Without Repeating Characters
 * 去除重复字符串
 * for:
 *  "abcabcbb" --> "abc" 3
 *  "bbbbb" --> "b" 1
 *
 *  http://www.jiuzhang.com/solutions/longest-substring-without-repeating-characters/
 * Created by Tikitoo on 2015/12/19.
 */
public class RepeatChar {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        HashSet<Character> set = new HashSet<Character>();
        int leftBound = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                while (leftBound < i && s.charAt(leftBound) != s.charAt(i)) {
                    set.remove(s.charAt(leftBound));
                    leftBound++;
                }
            } else {
                set.add(s.charAt(i));
                max = Math.max(max, i - leftBound + 1);
            }
        }
        return max;
    }


        // me
    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        int N = chars.length;
        for (int i = 0; i < N; i++) {
            if (!sb.toString().contains(String.valueOf(chars[i]))) {
                sb.append(chars[i]);
            }
        }
//        System.out.println("without: " + sb.toString());
        return sb.length();
    }
}
