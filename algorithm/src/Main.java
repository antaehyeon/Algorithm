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
    public int[] solution(int N, int[] A) {

        int[] countArray = new int[N];
        int afterSetMaxValue = 0;
        boolean biggestMode = false;
        int maxValue = 0;

        for (int i : A) {

            if (i > N) {
                afterSetMaxValue = maxValue;
                biggestMode = true;
                continue;
            }

            if (biggestMode) {
                countArray[i-1] = (countArray[i-1] < afterSetMaxValue) ? afterSetMaxValue : countArray[i-1];
            }

            countArray[i-1]++;
            maxValue = (maxValue < countArray[i-1]) ? countArray[i-1] : maxValue;
        }

        for (int i=0; i<countArray.length; i++) {
            if(countArray[i] < afterSetMaxValue) {
                countArray[i] = afterSetMaxValue;
            }
        }

        return countArray;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        Solution answer = new Solution();

        int N = 5;
        int[] testCase = {3,4,4,6,1,4,4};
        int[] result = answer.solution(N, testCase);

        System.out.print(result);
    }
}