import java.io.*;
import java.util.*;

class Result {

    /*
     * Complete the 'alternate' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int alternate(String s) {
        Set<Character> uniqueChars = new HashSet<>();
        for (char c : s.toCharArray()) {
            uniqueChars.add(c);
        }

        List<Character> chars = new ArrayList<>(uniqueChars);
        int maxLength = 0;

        for (int i = 0; i < chars.size(); i++) {
            for (int j = i + 1; j < chars.size(); j++) {
                char ch1 = chars.get(i);
                char ch2 = chars.get(j);

                StringBuilder filtered = new StringBuilder();
                for (char c : s.toCharArray()) {
                    if (c == ch1 || c == ch2) {
                        filtered.append(c);
                    }
                }

                if (isAlternating(filtered.toString())) {
                    maxLength = Math.max(maxLength, filtered.length());
                }
            }
        }

        return maxLength;
    }

    private static boolean isAlternating(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }
}

public class TwoCharacters {
    public static void main(String[] args) throws IOException {
        // Read input
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        // Input length (not used directly, but we still read it for proper input format)
        int l = Integer.parseInt(bufferedReader.readLine().trim());

        // Input string s
        String s = bufferedReader.readLine();

        // Get the result by calling the alternate function
        int result = Result.alternate(s);

        // Write the result to output
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        // Close streams
        bufferedReader.close();
        bufferedWriter.close();
    }
}
