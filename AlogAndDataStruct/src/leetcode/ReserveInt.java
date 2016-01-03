package leetcode;

/**
 * Reverse digits of an integer.
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 *
 * http://www.programcreek.com/2012/12/leetcode-reverse-integer/
 * Created by Tikitoo on 2015/12/20.
 */
public class ReserveInt {
    public static void main(String[] args) {
        System.out.println(reverse(123));
    }

    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            rev = rev * 10 + x % 10;
            x  = x / 10;
        }
        return rev;
    }
}
