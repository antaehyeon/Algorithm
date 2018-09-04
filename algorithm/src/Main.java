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

        int front = 0; int back = 0;
        int result = Integer.MAX_VALUE;

        for (int N : A) {
            back += N;
        }

        int count = 0;

        for (int N : A) {
            count++;
            if (count == A.length) break;

            front += N;
            back -= N;

            int temp = Math.abs(front-back);

            result = (result > temp) ? temp : result;
        }

        return result;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        Solution answer = new Solution();

        int[] testCase = {3, -1};
        int result = answer.solution(testCase);

        System.out.print(result);
    }
}