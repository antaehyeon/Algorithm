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
    public boolean checkTriplet (long A, long B, long C) {

        if (!((A+B) > C)) return false;
        if (!((B+C) > A)) return false;
        if (!((A+C) > B)) return false;

        return true;
    }

    public int solution(int[] A) {
        int arrLen = A.length;

        if (arrLen < 3) return 0;

        int result = 0;

        Arrays.sort(A);

        for (int i=2; i<arrLen; i++) {
            boolean tripletResult = checkTriplet(A[i-2] , A[i-1], A[i]);
            if (tripletResult) {
                result = 1;
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

        int[] A = {2147483647, 2147483647, 2147483647};

        int result = answer.solution(A);

        System.out.print(result);
    }
}