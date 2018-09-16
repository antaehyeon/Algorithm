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
    public int solution(int[] food_times, long k) {
        int answer = 0;
        int arraySize = food_times.length;
        int quotient;
        int rest;

        if (arraySize >= k) {
            int startIdx = (arraySize == k) ? 0 : (int)k;
            for (int i=startIdx; i<arraySize; i++) {
                if (food_times[i] > 0)
                    return i;
            }
        }

        quotient = (int)k / arraySize;
        rest = (int)k % arraySize;

        for (int i=0; i<arraySize; i++) {
            food_times[i] -= quotient;
        }

        for (int i=0; i<arraySize-1; i++) {
            if (food_times[i] < 0) {
                food_times[i+1] += food_times[i];
            }
        }

        food_times[0] += food_times[arraySize-1];

        int startIdx = rest;

        while (answer != 0) {
            if (food_times[startIdx] > 0)
                answer = startIdx;
        }

        return answer+1;
    }
}


public class Main {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        Solution answer = new Solution();

        int[] food_times = {3, 1, 2};
        int K = 5;

        int result = answer.solution(food_times, K);

        System.out.print(result);
    }
}