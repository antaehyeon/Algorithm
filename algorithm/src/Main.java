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
        int result = 0;
        int arrLen = A.length;
        int[] dps = new int[arrLen];
        int[] dpe = new int[arrLen];

        for (int i=0; i<arrLen; i++) {
            int t = A.length-1;
            int s = (i > A[i]) ? i-A[i] : 0;
            int e = (t-i > A[i]) ? i+A[i] : t;
            dps[s]++;
            dpe[e]++;
        }

        int t=0;
        for (int i=0; i<arrLen; i++) {
//            System.out.println(i + " 번째 t : " + t);
            if (dps[i] > 0) {
//                System.out.println(i + " 번째 : " + t * dps[i]);
                result += t * dps[i];
//                System.out.println(i + " 번째 : " + dps[i] * (dps[i] - 1) / 2);
                result += dps[i] * (dps[i] - 1) / 2;
                if (10000000 < result) return -1;
                t += dps[i];
            }
            t -= dpe[i];
        }

        return result;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        Solution answer = new Solution();

        int[] A = {1, 5, 2, 1, 4, 0};

        int result = answer.solution(A);

        System.out.print(result);
    }
}