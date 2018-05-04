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
    }

    public static int bottomUp (int n) {
        d[0] = 1;
        if (n > 0) d[1] = 1;
        for (int i=2; i<=n; i++) {
            d[i] = d[i-2] + d[i-1];
            d[i] %= 10007;
        }
        System.out.println(d[n]);
        return d[n];
    }
}
