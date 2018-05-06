import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] DP;
    static int[] P;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        P = new int[N+1];
        DP = new int[N+1];

        String[] p = bf.readLine().split(" ");

        for (int i=1; i<=N; i++) {
            P[i] = Integer.parseInt(p[i-1]);
        }

        System.out.println(bottomUp(N));
    }

    public static int topDown (int n) {
        return 0;
    }

    public static int bottomUp (int n) {
        DP[0] = 0;
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=i; j++) {
                DP[i] = Math.max(DP[i], DP[i-j] + P[j]);
            }
        }
        return DP[n];
    }
}
