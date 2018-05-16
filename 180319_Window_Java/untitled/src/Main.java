import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static long [][] D;
    static long [][] A;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());

        for (int i=0; i<T; i++) {
            int n = Integer.parseInt(bf.readLine());
            A = new long[2][n+1];
            String[] datas = bf.readLine().split(" ");
            String[] datas2 = bf.readLine().split(" ");
            for (int k=0; k<n; k++) {
                A[0][k] = Long.parseLong(datas[k]);
                A[1][k] = Long.parseLong(datas2[k]);
            }
            System.out.println(bottomUp(n));
        }
    }

    public static long topDown (int n) {
        return 0;
    }

    public static long bottomUp(int n) {

        /*
            초기값이 무엇일까?
            D[0][0]

            D[0][1]
            D[0][2]
         */

        long[][] d = new long[3][n+1];
        for (int i=1; i<=n; i++) {
            d[0][i] = Math.max(d[0][i-1], Math.max(d[1][i-1], d[2][i-1]));
            d[1][i] = Math.max(d[0][i-1], d[2][i-1]) + A[0][i-1];
            d[2][i] = Math.max(d[0][i-1], d[1][i-1]) + A[1][i-1];
        }

        long ans = 0;
        ans = Math.max(d[0][n], Math.max(d[1][n], d[2][n]));

        return ans;
    }
}
