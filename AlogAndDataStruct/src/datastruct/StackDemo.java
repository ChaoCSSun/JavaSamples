package datastruct;

import java.util.Stack;

/**
 * Stack 后进先出
 * push(), add()
 * peek() 获取栈顶，不删除
 * pop() 获取栈顶，删除
 *
 *
 * Created by Tikitoo on 2015/12/15.
 */
public class StackDemo {
    public static void main(String[] args) {
        stackTest();

    }

    public static void showPush(Stack stack, int a) {
        stack.push(new Integer(a));
        System.out.println("push: " + a);
        System.out.println("stack: " + stack);
    }

    public static void showAdd(Stack stack, int i) {
        stack.add(new Integer(i));
        System.out.println("add: " + i);
        System.out.println("stack: " + stack);
    }

    public static void showPop(Stack stack) {
        System.out.print("pop -> ");
        Integer integer = (Integer) stack.pop();
        System.out.println(integer);
        System.out.println("stack: " + stack);
    }

    public static void stackTest() {
        Stack stack = new Stack();
        System.out.println("stack: " + stack);
        showAdd(stack, 4);
        showAdd(stack, 344);
        showAdd(stack, 56);
        showAdd(stack, 13);
        showAdd(stack, 6748);

        showPop(stack);
        showPop(stack);
        showPop(stack);
        showPop(stack);
        showPop(stack);
    }
}


