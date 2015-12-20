package leetcode;

/**
 * ZigZag Conversion
 * PAYPALISHIRING --> PAHNAPLSIIGYIR
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * Created by Tikitoo on 2015/12/19.
 */
public class ZigZagConversion {
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) { return s; }
        StringBuilder sb = new StringBuilder();
        int step = 2 * numRows - 2;
        for (int i = 0; i < numRows; i++) {
            if (i == 0 || i == numRows -1) {
                for (int j = i; j < s.length(); j =  j + step) {
                    sb.append(s.charAt(j));
                }
            } else {
                int j = i;
                boolean flag = true;
                int step1 = 2 * (numRows - 1 - i);
                int step2 = step - step1;
                while (j < s.length()) {
                    sb.append(s.charAt(j));
                    if (flag) {
                        j = j + step1;
                    } else {
                        j = j + step2;

                    }
                    flag = !flag;
                }
            }
        }
        return sb.toString();

    }
}
