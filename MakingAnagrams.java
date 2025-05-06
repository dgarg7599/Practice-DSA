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
     * Complete the 'makingAnagrams' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING s1
     *  2. STRING s2
     */

    public static int makingAnagrams(String s1, String s2) {
        // Write your code here
        Map<Character, Integer> map = new HashMap<>();

        for(int i=0;i<s1.length();i++){
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
        }
        for(int i=0;i<s2.length();i++){
            char ch = s2.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)-1);
                if(map.get(ch) == 0){
                    map.remove(ch);
                }
            }else{
                map.put(ch, map.getOrDefault(ch, 0)-1);
            }
        }

        int result = 0;
        for(char ch: map.keySet()){
            result += Math.abs(map.get(ch));
        }
        return result;

    }

}

public class MakingAnagrams {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = bufferedReader.readLine();

        String s2 = bufferedReader.readLine();

        int result = Result.makingAnagrams(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
