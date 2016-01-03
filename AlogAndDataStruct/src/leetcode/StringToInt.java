package leetcode;

/**
 * Implement atoi to convert a string to an integer.
 *
 * http://www.programcreek.com/2012/12/leetcode-string-to-integer-atoi/
 * Created by Tikitoo on 2015/12/20.
 */
public class StringToInt {
    public static void main(String[] args) {
        System.out.println("atoi: " + atoi("345"));
    }
    public static int atoi(String str) {
        if (str == null || str.length() < 1) {
            return 0;
        }

        str = str.trim();
        char flag = '+';
        int i = 0;
        if (str.charAt(0) == '-') {
            flag = '-';
            i++;
        } else if (str.charAt(0) == '+') {
            i++;
        }

        double result = 0;
        while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            result = result * 10 + (str.charAt(i) - '0');
            i++;
        }

        if (flag == '-') {
            result = -result;
        }
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) result;
    }
}
