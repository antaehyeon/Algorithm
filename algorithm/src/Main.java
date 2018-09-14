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
    public int solution(int N, int M) {
        int answer = 0;
        int originalN = N;

        while(N % M != 0) {
            N %= M;
            // swap
            int tmp = N;
            N = M;
            M = tmp;
        }
        answer = originalN / M;

        return answer;
    }
}


public class Main {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        Solution answer = new Solution();

        int N = 10;
        int M = 2;
        int result = answer.solution(N, M);

        System.out.print(result);
    }
}