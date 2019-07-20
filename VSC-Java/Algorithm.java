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

public class Algorithm
{
    public static int[] a = new int[9];
    public static int n = 9;

	public static void main(String[] args) {
        FastScanner fs = new FastScanner(System.in);
        int sum = 0;
        for (int i=0; i<n; i++) {
            a[i] = fs.nextInt();
            sum += a[i];
        }

        System.out.println(a);


        // for (int i=0; i<n; i++) {
        //     for (int j=i+1; j<n; j++) {
        //         if (sum )
        //     }
        // }

	}
}