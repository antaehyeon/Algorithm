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
    public int solution(int[] A) {

        int[] maxLeft = new int[A.length];
        int[] maxRight = new int[A.length];

        for (int i=1; i<A.length; i++) {
            maxLeft[i] = Math.max(0, maxLeft[i-1] + A[i]);
        }

        for (int i=A.length-2; i>=0; i--) {
            maxRight[i] = Math.max(0, maxRight[i+1] + A[i]);
        }

        int maxOfSum = Integer.MIN_VALUE;

        for (int i=1; i<A.length-1; i++) {
            maxOfSum = Math.max(maxOfSum, maxLeft[i-1] + maxRight[i+1]);
        }

        return maxOfSum;
    }
}


public class Main {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        Solution answer = new Solution();

        int[] A = {3, 2, 6, -1, 4, 5, -1, 2};

        int result = answer.solution(A);

        System.out.print(result);
    }
}