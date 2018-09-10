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
        int arrLen = A.length;
        int result = 0;

        Arrays.sort(A);

        result = A[arrLen-3] * A[arrLen-2] * A[arrLen-1];

        int tmpMultiple = A[0] * A[1] * A[arrLen-1];

        result = (result < tmpMultiple) ? tmpMultiple : result;

        return result;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        Solution answer = new Solution();

        int[] A = {-3, 1, 2, -2, 5, 6};

        int result = answer.solution(A);

        System.out.print(result);
    }
}