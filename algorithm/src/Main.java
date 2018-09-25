import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;
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
}

public class Main {
    static int N;
    static int max = Integer.MIN_VALUE;
    static int cnt = 0;
    static int repeatNum = 1;
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        N = fs.nextInt();
        int[] array = new int[N];

        for (int i=0; i<N; i++)
            array[i] = fs.nextInt();

        permutation(array, 0);

        System.out.println(max);
    }

    public static void permutation(int[] arr, int d) {
        if (d == N) {
            cnt++;
            return;
        }

        for (int i=d; i<N; i++) {
            swap(arr, d, i);
            permutation(arr, d+1);
            maxDifferece(arr);
            swap(arr, d, i);
        }
    }

    public static void swap (int[] arr, int d, int i) {
        int temp = arr[i];
        arr[i] = arr[d];
        arr[d] = temp;
    }

    public static void maxDifferece(int[] array) {
        int sum = 0;
        for (int i=0; i<array.length-1; i++) {
            sum += Math.abs(array[i]-array[i+1]);
        }
        max = Math.max(max, sum);
    }
}