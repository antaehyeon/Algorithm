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

        final long mod = 10007;

        for (int i=0; i<=9; i++) D[1][i] = 1;
        for (int i=2; i<=n; i++) {
            for (int j=0; j<=9; j++) {
                // k = 0~J 까지의 범위를 뜻함
                // 인접한 수가 같아도 오름차순으로 치기 때문에
                // 해당 J까지의 반복문이 필요
                for (int k=0; k<=j; k++) {
                    D[i][j] += D[i-1][k];
                    D[i][j] %= mod;
                }
            }
        }
        long ans = 0;
        for (int i=0; i<=9; i++) ans += D[n][i];
        ans %= mod;

        return ans;
    }
}
