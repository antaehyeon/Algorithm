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

        int[] testData = {1, 0, 0, 1, 0, 0};

        System.out.print(solution(testData));

    }

    public static int solution(int[] A) {
        final int heads = 0;

        int headCount = 0;
        int tailCount = 0;
        int result;


        for (int coinStatus : A) {
            if (coinStatus == heads) {
                headCount++;
            } else {
                tailCount++;
            }
        }

        result = Math.min(headCount, tailCount);
        return result;
    }
}