import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());

        DP = new int[11];

        for (int i=0; i<T; i++) {
            int n = Integer.parseInt(bf.readLine());
            System.out.println(bottomUp(n));
        }
    }

    public static int topDown (int n) {

        return 0;
    }

    public static int bottomUp (int n) {
        DP[0] = 1; DP[1] = 1; DP[2] = 2;
        for (int i=3; i<=n; i++) {
            DP[i] = DP[i - 1] + DP[i - 2] + DP[i - 3];
        }
        return DP[n];
    }
}
