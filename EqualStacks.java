import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'equalStacks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h1
     *  2. INTEGER_ARRAY h2
     *  3. INTEGER_ARRAY h3
     */

    private static Stack<Integer> buildHeightStack(List<Integer> heights) {
        Stack<Integer> stack = new Stack<>();
        int total = 0;
        for (int i = heights.size() - 1; i >= 0; i--) {
            total += heights.get(i);
            stack.push(total);
        }
        return stack;
    }

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        // Write your code here

        Stack<Integer> s1 = buildHeightStack(h1);
        Stack<Integer> s2 = buildHeightStack(h2);
        Stack<Integer> s3 = buildHeightStack(h3);

        while (!s1.isEmpty() && !s2.isEmpty() && !s3.isEmpty()) {
            int top1 = s1.peek();
            int top2 = s2.peek();
            int top3 = s3.peek();

            if (top1 == top2 && top2 == top3) {
                return top1;
            }

            if (top1 >= top2 && top1 >= top3) {
                s1.pop();
            } else if (top2 >= top1 && top2 >= top3) {
                s2.pop();
            } else {
                s3.pop();
            }
        }

        return 0;

    }

}

public class EqualStacks {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n1 = Integer.parseInt(firstMultipleInput[0]);

        int n2 = Integer.parseInt(firstMultipleInput[1]);

        int n3 = Integer.parseInt(firstMultipleInput[2]);

        List<Integer> h1 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> h2 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> h3 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.equalStacks(h1, h2, h3);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
