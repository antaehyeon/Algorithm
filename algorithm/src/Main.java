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

    String nextString() throws Exception {
        String result = br.readLine();
        return result;
    }
}

public class Main {

    static int N, M, K;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        N = fs.nextInt();
        M = fs.nextInt();
        K = fs.nextInt();

        K = K == 0 ? K : K-1;

        int[][] dp = new int[N][M];
        dp[0][0] = 1;

        // 경유지가 있는 경우
        if (K > 0) {

            int kRow = K / M;
            int kCol = K - M * kRow;

            for (int row = 0; row <= kRow; row++) {
                for (int col = 0; col <= kCol; col++) {
                    if (row == 0 && col == 0) continue;
                    dp[row][col] = (row - 1 < 0 ? 0 : dp[row - 1][col]) + (col - 1 < 0 ? 0 : dp[row][col - 1]);
                }
            }

            int temp = dp[kRow][kCol];
            dp[kRow][kCol] = 1;

            for (int row = kRow; row < N; row++) {
                for (int col = kCol; col < M; col++) {

                    if (row == kRow && col == kCol) continue;
                    dp[row][col] = (row - 1 < kRow ? 0 : dp[row - 1][col]) + (col - 1 < kCol ? 0 : dp[row][col - 1]);
                }
            }

            dp[N - 1][M - 1] *= temp;
        }
        // 경유지가 없는 경우
        else {

            for (int row = 0; row < N; row++) {
                for (int col = 0; col < M; col++) {

                    if (row == 0 && col == 0) continue;
                    dp[row][col] = (row - 1 < 0 ? 0 : dp[row - 1][col]) + (col - 1 < 0 ? 0 : dp[row][col - 1]);
                }
            }
        }

        System.out.println(dp[N - 1][M - 1]);

    }
}