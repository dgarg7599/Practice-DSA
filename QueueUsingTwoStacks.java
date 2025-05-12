import java.io.*;
import java.util.*;

public class QueueUsingTwoStacks {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while (q-- > 0) {
            int type = sc.nextInt();

            if (type == 1) {
                // Enqueue
                int value = sc.nextInt();
                stack1.push(value);

            } else if (type == 2) {
                // Dequeue
                if (stack2.isEmpty()) {
                    while (!stack1.isEmpty()) {
                        stack2.push(stack1.pop());
                    }
                }
                if (!stack2.isEmpty()) {
                    stack2.pop();
                }

            } else if (type == 3) {
                // Peek
                if (stack2.isEmpty()) {
                    while (!stack1.isEmpty()) {
                        stack2.push(stack1.pop());
                    }
                }
                if (!stack2.isEmpty()) {
                    System.out.println(stack2.peek());
                }
            }
        }
        sc.close();

    }
}