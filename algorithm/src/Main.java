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

    static int[] a = new int[9];
    static int n = 9;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        int sum = 0;


        for (int i=0; i<n; i++) {
            a[i] = fs.nextInt();
            sum += a[i];
        }

        Arrays.sort(a);

        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                if (sum-a[i] - a[j] == 100) {
                    for (int k=0; k<n; k++) {
                        if (i==k || j==k) continue;
                        System.out.println(a[k]);
                    }
                    return;
                }
            }
        }
        return;
    }
}