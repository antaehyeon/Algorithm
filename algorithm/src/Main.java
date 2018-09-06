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
        int zeroCount = 0;
        long pairSum = 0;

        for (int i : A) {
            if (i == 0) zeroCount++;
            else pairSum += zeroCount;
        }

        if (pairSum > 1000000000) return -1;

        return (int)pairSum;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        Solution answer = new Solution();

        int[] testCase = {0,1,0,1,1};
        int result = answer.solution(testCase);

        System.out.print(result);
    }
}