package leetcode;

/**
 * Created by Tikitoo on 2015/12/20.
 */
public class PalindromeNum {
    public static void main(String[] args) {
        System.out.println("isPalindrome: " + isPalindrome(12321));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        return  x == reverse(x);
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
