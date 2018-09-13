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
        int sqrtN = (int) Math.sqrt(N);
        int numFactor =0; // number of factors

        for(int i=1; i <= sqrtN; i++){
            if (N % i ==0) {
                numFactor++;
            }
        }

        numFactor = numFactor * 2;

        if(sqrtN * sqrtN == N) {
            numFactor = numFactor - 1;
        }

        return numFactor;
    }
}


public class Main {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        Solution answer = new Solution();

        int N = 24;

        int result = answer.solution(N);

        System.out.print(result);
    }
}