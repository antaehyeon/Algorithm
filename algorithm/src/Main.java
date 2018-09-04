import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
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

        Boolean[] checkArray = new Boolean[A.length + 2];
        Arrays.fill(checkArray, false);

        for (int arrayData : A) {
            checkArray[arrayData] = true;
        }

        for (int i=1; i<=checkArray.length; i++) {
            if (!checkArray[i]) {
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

        int[] testCase = {1, 3};
        int result = answer.solution(testCase);

        System.out.print(result);
    }
}