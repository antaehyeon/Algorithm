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
    public int solution(int X, int[] A) {
        HashSet<Integer> set = new HashSet<>();
        int result = -1;

        for (int i=0; i<A.length; i++) {
            set.add(A[i]);
            if (set.size() == X && set.contains(X)) {
                result = i;
                break;
            }
        }

        return result;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        Solution answer = new Solution();

        int X = 5;
        int[] testCase = {1,3,1,4,2,3,5,4};
        int result = answer.solution(X, testCase);

        System.out.print(result);
    }
}