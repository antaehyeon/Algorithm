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
}

public class Main {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int n = fs.nextInt();
        int[] data = new int[n];

        data = new int[n];

        for (int i=0; i<n; i++)
            data[i] = fs.nextInt();

        if (nextPermutation(data)) {
            for (int i=0; i<n; i++) {
                System.out.print(data[i] + " ");
            }
            System.out.println();
        } else {
            System.out.println("-1");
        }

    }

    public static boolean nextPermutation(int[] data) {

        final int arraySize = data.length-1;

        int i = arraySize; // Array Length

        // 순열의 위치를 잡는다
        while (i>0 && data[i-1] >= data[i]) {
            i--;
        }

        // 다음 순열이 없다면 리턴
        if (i<=0) {
            return false;
        }

        int j = arraySize;
        while (data[j] <= data[i-1]) {
            j--;
        }

        int temp = data[i-1];
        data[i-1] = data[j];
        data[j] = temp;

        j = arraySize;
        while (i<j) {
            temp = data[i];
            data[i] = data[j];
            data[j] = temp;
            i++;
            j--;
        }
        return true;
    }
}