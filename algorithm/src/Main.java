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

        int[] testData = {1, 4, -1, 3, 2};

        int result = solution(testData);
        System.out.println(result);

    }

    public static int solution(int[] A) {
        int cnt = 1;
        int idx = A[0];

        if (idx == -1) {
            return 1;
        }

        for (int i=0; i<A.length; i++) {
            cnt++;
            if (A[idx] == -1) {
                return cnt;
            }

            idx = A[idx];
        }

        return 1;
    }
}