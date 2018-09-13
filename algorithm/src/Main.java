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
}

class Solution {
    public int solution(int N) {
        int minPeriphery = Integer.MAX_VALUE;
        int nSqrt = (int)Math.sqrt(N);

        for (int i=1; i<=nSqrt; i++) {
            if (N % i == 0) {
                int quotient = N / i;
                int periphery = (i + quotient) * 2;
                minPeriphery = Math.min(minPeriphery, periphery);
            }
        }
        return minPeriphery;
    }
}


public class Main {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        Solution answer = new Solution();

        int N = 30;
        int result = answer.solution(N);

        System.out.print(result);
    }
}