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
        double minAvg = Double.MAX_VALUE;
        int minIndex = 0;

        for(int i=1; i<A.length; i++) {
            double tempAvg = (A[i-1] + A[i]) / 2.0;
            minIndex = (minAvg > tempAvg) ? i-1 : minIndex;
            minAvg = (minAvg > tempAvg) ? tempAvg : minAvg;
        }

        for (int i=2; i<A.length; i++) {
            double tempAvg = (A[i-2] + A[i-1] + A[i]) / 3.0;
            if (tempAvg >= minAvg) continue;
            minAvg = tempAvg;
            minIndex = i-2;
        }

        return minIndex;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        Solution answer = new Solution();

        int[] A = {4, 2, 2, 5, 1, 5, 8};

        int result = answer.solution(A);

        System.out.print(result);
    }
}