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
    public int solution(int A, int B) {
        Vector<Integer> vPrize2017 = new Vector<>();
        Vector<Integer> vPrize2018 = new Vector<>();

        int[] prize2017 = {500, 300, 200, 50, 30, 10};
        int[] prize2018 = {512, 256, 128, 64, 32};

        int people2018 = 1;
        int prizeSum = 0;

        for (int i=0; i<6; i++) {
            for (int j=0; j<i+1; j++) {
                vPrize2017.add(prize2017[i]);
            }
        }

        for (int i=0; i<5; i++) {
            for (int j=0; j<people2018; j++) {
                vPrize2018.add(prize2018[i]);
            }
            people2018 *= 2;
        }

        if (1 <= A && A <= 21) prizeSum += vPrize2017.get(A-1);
        if (1 <= B && B <= 31) prizeSum += vPrize2018.get(B-1);

        return prizeSum * 10000;
    }
}


public class Main {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        Solution answer = new Solution();

        int nRepeat = fs.nextInt();

        for (int i=0; i<nRepeat; i++) {
            int rank2017 = fs.nextInt();
            int rank2018 = fs.nextInt();
            int prizeMoney = answer.solution(rank2017, rank2018);
            System.out.println(prizeMoney);
        }

    }
}