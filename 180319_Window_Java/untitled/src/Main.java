import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static long [][] D;
    static int[] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        D = new long [N+1][10];
        DP = new int[N+1];

//        System.out.println(topDown(N));
        System.out.println(bottomUp(N));
    }

    public static long topDown (int n) {
        return 0;
    }

    public static long bottomUp (int n) {

        final long mod = 1000000000;

        /*
            갯수를 구하는 문제
            1 : D[1][1...9] = 9
            2 : D[2][?] = D[N-1][?-1] + D[N-1][?+1]
            10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98
        */

        for (int i=1; i<=9; i++) D[1][i] = 1;
        for (int i=2; i<=n; i++) {
            for (int j=0; j<=9; j++) {
                D[i][j] = 0;
                if (j-1 >= 0) D[i][j] += D[i-1][j-1];
                if (j+1 <= 9) D[i][j] += D[i-1][j+1];
                D[i][j] %= mod;
            }
        }

        long ans = 0;
        for (int i=0; i<=9; i++) ans += D[n][i];
        ans %= mod;

        return ans;



//        if (n == 1) {
//            DP[1] = 9;
//            return 9;
//        }
//
//
//        for (int i=1; i<=n; i++) {
//            DP[i] = 0;
//            for (int j=0; j<=9; j++) {
//                D[i][j] = 1;
//            }
//            D[i][10] = 0;
//        }
//
//        DP[1] = 9;
//
//        for (int i=2; i<=n; i++) {
//            for (int j=1; j<=9; j++) {
//                DP[i] += (D[i-1][j-1] + D[i-1][j+1]);
//            }
//        }
//
//        return DP[n];
    }
}
