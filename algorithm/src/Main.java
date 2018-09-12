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
        if (A.length == 0 || A.length == 1) return 0;

        int nMaxOfDifference = Integer.MIN_VALUE;
        int nMin = Integer.MAX_VALUE;

        for (int n : A) {
            nMin = Math.min(nMin, n);
            nMaxOfDifference = Math.max(nMaxOfDifference, n - nMin);
        }

        return nMaxOfDifference;
    }
}


public class Main {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        Solution answer = new Solution();

        int[] A = {23171, 21011, 21123, 21366, 21013, 21367};
//        int[] A = {};

        int result = answer.solution(A);

        System.out.print(result);
    }
}