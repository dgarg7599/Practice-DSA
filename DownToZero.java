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
     * Complete the 'downToZero' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER n as parameter.
     */

//    static Map<Integer, Integer> memo = new HashMap<>();
//
//    public static int downToZero(int n) {
//        if (n == 0) return 0;
//
//        if (memo.containsKey(n)) return memo.get(n);
//
//        int ans = 1 + downToZero(n - 1);
//
//        for (int i = 2; i * i <= n; i++) {
//            if (n % i == 0) {
//                int factor = Math.max(i, n / i);
//                ans = Math.min(ans, 1 + downToZero(factor));
//                break;
//            }
//        }
//
//        memo.put(n, ans);
//        return ans;
//    }


    public static int downToZero(int n) {
        if (n == 0) return 0;

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        int[] dist = new int[n + 1];

        q.add(n);
        visited[n] = true;
        dist[n] = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();

            if (curr == 0) return dist[0];

            if (!visited[curr - 1]) {
                visited[curr - 1] = true;
                dist[curr - 1] = dist[curr] + 1;
                q.add(curr - 1);
            }

            for (int i = 2; i * i <= curr; i++) {
                if (curr % i == 0) {
                    int next = Math.max(i, curr / i);
                    if (!visited[next]) {
                        visited[next] = true;
                        dist[next] = dist[curr] + 1;
                        q.add(next);
                    }
                }
            }
        }

        return -1;
    }


}

public class DownToZero {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                int result = Result.downToZero(n);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
