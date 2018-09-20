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
    public String solution(int N) {
        boolean[] isPrimeNumber = new boolean[N+1];
        ArrayList<Integer> primeNumList = new ArrayList<>();

        int nSqrt = (int)Math.sqrt(N);
        int nMax = 0;
        String answer = "";

        // 에라토스테네스의 체 코드
        for (int i=2; i<=nSqrt; i++) {
            if (isPrimeNumber[i]) continue;
            for (int j=i+i; j<=N; j+=i) {
                isPrimeNumber[j] = true;
            }
        }

        // ArrayList 에 따로 소수만 담는 과정
        for (int i=2; i<=N; i++) {
            if (!isPrimeNumber[i]) primeNumList.add(i);
        }

        // 골드바흐의 추측 알고리즘 (6588)
        for (int i=0; i<primeNumList.size(); i++) {
            int nPrime = primeNumList.get(i);
            int result = N - nPrime;
            int nTemp = 0;

            if (primeNumList.contains(result))
                nTemp = result - nPrime;

            if (nTemp > nMax) {
                nMax = nTemp;
                answer = N + " = " + nPrime + " + " + result;
            }
        }

        if (nMax == 0) return "Goldbach's conjecture is wrong.";

        return answer;
    }
}


public class Main {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        Solution answer = new Solution();

        while (true) {
            int n = fs.nextInt();

            if (n == 0) break;

            String result = answer.solution(n);
            System.out.println(result);
        }
    }
}