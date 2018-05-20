import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println(Integer.toBinaryString(6));
        System.out.println(Integer.toBinaryString(20));
        System.out.println(Integer.toBinaryString(1041));
        System.out.println(Integer.toBinaryString(51712));

        System.out.println(solution(6));
        System.out.println(solution(20));
        System.out.println(solution(1041));
        System.out.println(solution(51712));

    }

    public static int solution(int N) {
        // write your code in Java SE 8
        String line = Integer.toBinaryString(N);

        int t = line.length();
        int zeroCount = 0;
        int result = 0;
        boolean oneMode = false;
        String[] ss = line.split("");

        while (t-- > 0) {

            if (ss[t].equals("1")) {
                oneMode = true;
                result = (result < zeroCount) ? zeroCount : result;
                zeroCount = 0;
            } else if (oneMode && ss[t].equals("0")) {
                zeroCount++;
            }

        }

        return result;
    }
}
