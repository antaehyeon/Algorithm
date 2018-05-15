import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static long[] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        DP = new long[N+1];

        System.out.println(topDown(N));
//        System.out.println(bottomUp(N));
    }

    public static long topDown (int n) {

        if (n == 0 || n == 1 || n == 2) {
            return 1;
        }

        if (DP[n] > 0) {
            return DP[n];
        }

        DP[n] = topDown(n-1) + topDown(n-2);

        return DP[n];
    }

    public static long bottomUp (int n) {

        /*
            1: 1
            2: 10
            3: 100, 101
            4: 1000, 1001, 1010
            5: 10000, 10001, 10100, 10101, 10010
        */

        DP[0] = 0; DP[1] = 1;

        if (n == 1) {
            return DP[1];
        }

        for (int i=2; i<=n; i++) {
            DP[i] = DP[i-1] + DP[i-2];
        }

        return DP[n];
    }
}
