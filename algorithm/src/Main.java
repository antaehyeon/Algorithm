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

        int result = 1;
        boolean[] check = new boolean[A.length + 1];

        for (int i : A) {
            if(i < check.length) {
                check[i] = true;
            }
        }

        for (int i=1; i<check.length; i++) {
            if (!check[i]) {
                result = 0;
            }
        }

        return result;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        Solution answer = new Solution();

        int[] testCase = {2};
        int result = answer.solution(testCase);

        System.out.print(result);
    }
}