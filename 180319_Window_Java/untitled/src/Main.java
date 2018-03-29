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

    public static void LOG (String data) {
        System.out.println(data);
    }

    public static void LOG (int data) {
        System.out.println(data);
    }

    public static void LOG (double data) {
        System.out.println(data);
    }

    public static int[] splitNumber (int n) {

        int size = String.valueOf(n).length();

        int[] result = new int[size];

        String temp = String.valueOf(n);
        String[] datas = temp.split("");

        for (int i=0; i<size; i++) {
            result[i] = Integer.parseInt(datas[i]);
        }

        return result;

    }

    public static int func (Vector<Integer> v, int A, int P) {

        while (true) {
            int[] datas = splitNumber(A);
            double n = 0;

            for (int i=0; i<datas.length; i++) {
                n += Math.pow(datas[i], P);
            }

            int nn = (int) n;

            if (v.contains(nn)) {
                return v.indexOf(nn);
            } else {
                v.add(nn);
                A = nn;
            }
        }
    }

    public static void main(String[] args) throws Exception {

        FastScanner fs = new FastScanner(System.in);

        Vector<Integer> v = new Vector<>();

        int A = fs.nextInt();
        int P = fs.nextInt();

        v.add(A);

        int result = func(v, A, P);
        System.out.println(result);
    }
}