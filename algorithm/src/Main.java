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
    public int checkPrimeNum(int N) {

//        double nSqrt = Math.sqrt(N);

        if (N == 1) return 0;

        for (int i=2; i<N; i++) {
            if (N % i == 0) return 0;
        }

        return 1;
    }
}


public class Main {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        Solution answer = new Solution();

        int nRepeat = fs.nextInt();
        int nPrimeCount = 0;

        for (int i=0; i<nRepeat; i++) {
            int n = fs.nextInt();
            nPrimeCount += answer.checkPrimeNum(n);
        }

        System.out.println(nPrimeCount);
    }
}