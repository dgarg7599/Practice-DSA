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

    private static List<Integer> generatePrimes(int q) {
        List<Integer> primes = new ArrayList<>();
        int num = 2;
        while (primes.size() < q) {
            boolean isPrime = true;
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes.add(num);
            }
            num++;
        }
        return primes;
    }



    public static List<Integer> waiter(List<Integer> number, int q) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        List<Integer> primes = generatePrimes(q);

        for (int i = 0; i < q; i++) {
            int prime = primes.get(i);

            for (Integer num : number) {
                if (num % prime == 0) {
                    ans.add(num);
                } else {
                    stack.push(num);
                }
            }

            number.clear();

            while (!stack.isEmpty()) {
                number.add(stack.pop());
            }
        }

        for (int i = number.size() - 1; i >= 0; i--) {
            ans.add(number.get(i));
        }

        return ans;
    }

}

public class Waiter {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);
        int q = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> number = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.waiter(number, q);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
