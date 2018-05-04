import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;

public class Main {

    static int[] d;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        d = new int[n+1];

        System.out.println(bottomUp(n));
    }

    public static int topDown (int n) {
        if (n == 1) return 0;
        if (d[n] > 0) return d[n];
        d[n] = topDown(n-1) + 1;
        if (n%2 == 0) {
            int temp = topDown(n/2) + 1;
            if (d[n] > temp) d[n] = temp;
        }
        if (n%3 == 0) {
            int temp = topDown(n/3) + 1;
            if (d[n] > temp) d[n] = temp;
        }
        return d[n];
    }

    public static int bottomUp (int n) {
        d[1] = 0;
        for (int i=2; i<=n; i++) {
            d[i] = d[i-1] + 1;
            if (i%2 == 0 && d[i] > d[i/2] + 1) {
                d[i] = d[i/2] + 1;
            }
            if (i%3 == 0 && d[i] > d[i/3] + 1) {
                d[i] = d[i/3] + 1;
            }
        }
        return d[n];
    }
}
