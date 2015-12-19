package leetcode;

/**
 * You are given two linked lists representing two non-negative numbers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 *
 * Created by Tikitoo on 2015/12/19.
 */
public class AddTwoNumbers {

    private static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) {
        ListNode l1 = new ListNode(4);
        ListNode point= l1;
        point.next = new ListNode(7);
        point = point.next;
        point.next = new ListNode(9);
//        point = point.next;

        ListNode l2 = new ListNode(5);
        point = l2;
        point.next = new ListNode(6);
        point = point.next;
        point.next = new ListNode(4);

        ListNode node = addTwoNums(l1, l2);
        System.out.println(iterNode(node));
    }


    public static String iterNode(ListNode listNode) {
        sb.append(listNode.val);
        if (listNode.next != null) {
            sb.append("-->");
            iterNode(listNode.next);
        }

        return sb.toString();
    }

    public static ListNode addTwoNums(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;

        ListNode head = new ListNode(0);
        ListNode point = head;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int sum = carry + l1.val + l2.val;
            point.next = new ListNode(sum % 10);
            carry = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
            point = point.next;
        }

        while (l1 != null) {
            int sum = carry + l1.val;
            point.next = new ListNode(sum % 10);
            carry = sum / 10;
            l1 = l1.next;
            point = point.next;
        }

        while (l2 != null) {
            int sum = carry + l2.val;
            point.next = new ListNode(sum % 10);
            carry = sum / 10;
            l2 = l2.next;
            point = point.next;
        }

        if (carry != 0) {
            point.next = new ListNode(carry);
        }

        return head.next;


    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }



}
