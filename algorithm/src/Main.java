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

        HashSet<Integer> intSet = new HashSet<>();

        for (int arrayData : A) {
            if (intSet.contains(arrayData)) {
                intSet.remove(arrayData);
                continue;
            }

            intSet.add(arrayData);
        }

        return intSet.toArray(new Integer[intSet.size()])[0];
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        Solution answer = new Solution();

        int[] testCase = {9, 3, 9, 3, 9, 7, 9};
        int result = answer.solution(testCase);

        System.out.print(result);
    }
}