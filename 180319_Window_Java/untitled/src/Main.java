import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static long [][] D;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        D = new long [N+1][10];

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

        // D[1][1...9] = 1
        for (int i=1; i<=9; i++) D[1][i] = 1;
        for (int i=2; i<=n; i++) {
            for (int j=0; j<=9; j++) {
                /*
                    D[2][0] 은 1 (D[1][1] = 1)
                    D[2][1] 은 2 (D[1][0](0) + D[1][2])
                    D[2][2] 은 2 (D[1][1] + D[1][3])
                    D[2][3] 은 2 (D[1][2] + D[1][4])
                    ...
                    D[2][8] 은 2 (D[1][7] + D[1][9])
                    D[2][9] 은 1 (D[1][8])
                */
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
    }
}
