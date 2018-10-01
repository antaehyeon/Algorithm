import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

class FastScanner {

    BufferedReader br;
    StringTokenizer st;


    FastScanner(InputStream i) throws Exception {
        br = new BufferedReader(new InputStreamReader(i));
    }

    String next() throws Exception {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    int nextInt() throws Exception {
        return Integer.parseInt(next());
    }

    String nextString() throws Exception {
        String result = br.readLine();
        return result;
    }
}

public class Main {


    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        String testData = "Forget  CVS..Save time . x x";

        System.out.println(solution(testData));

    }

    public static int solution(String S) {
        int maxWordNum = Integer.MIN_VALUE;

        String[] sentences = S.split("\\.|\\?|\\!");

        for (String sentence : sentences) {
            sentence = sentence.trim();
            if (sentence.equals("")) continue;
            String[] words = sentence.split("\\s+");
            maxWordNum = Math.max(maxWordNum, words.length);
        }

        return maxWordNum;
    }
}