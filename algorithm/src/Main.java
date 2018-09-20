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
    public String solution(boolean[] isPrimeNum, int N) {

        String answer = "";
        boolean flag = false;

        for (int i=2; i<=N/2; i++) {
            int A, B;

            if (isPrimeNum[i] && isPrimeNum[N-i]) {
                A = i;
                B = N-i;
                flag = true;

                answer = N + " = " + A + " + " + B;
                break;
            }
        }

        if (!flag) return "Goldbach's conjecture is wrong.";

        return answer;
    }
}


public class Main {
    public static final int MAX = 1000000;
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        Solution answer = new Solution();

        boolean[] isPrimeNum = new boolean[MAX+1];
        int nSqrt = (int)Math.sqrt(MAX);

        // 배열 초기화 (false >> true)
        for (int i=2; i<=MAX; i++)
            isPrimeNum[i] = true;

        // 에라토스테네스의 체 코드
        for (int i=2; i<=nSqrt; i++) {
            if (!isPrimeNum[i]) continue;
            for (int j=i+i; j<=MAX; j+=i) {
                isPrimeNum[j] = false;
            }
        }

        while (true) {
            int n = fs.nextInt();

            if (n == 0) break;

            String result = answer.solution(isPrimeNum, n);
            System.out.println(result);
        }
    }
}