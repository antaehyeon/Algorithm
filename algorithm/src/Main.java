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

    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static int N;
    static int[] numbers;
    static int[] operator;
    static boolean[] visit;


    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int idx = 0;
        N = fs.nextInt();

        numbers = new int[N];
        operator = new int[N-1];
        visit = new boolean[N];

        for (int i=0; i<N; i++)
            numbers[i] = fs.nextInt();

//        for (int i=0; i<4; i++)
//            operator[i] = fs.nextInt();

        for (int i=0; i<4; i++) {
            int cnt = fs.nextInt();
            for (int j=0; j<cnt; j++)
                operator[idx++] = i+1;
        }

        DFS(0, 1, numbers[0], 0);
        System.out.println(max);
        System.out.println(min);
    }

    public static void DFS(int v, int idx, int n, int len) {
        int result = 0;

        if (len == N-1) {
            max = Math.max(max, n);
            min = Math.min(min, n);
        } else {
            for (int i=0; i<N-1; i++) {
                if (!visit[i]) {
                    switch (operator[i]) {
                        case 1:
                            result = n + numbers[idx];
                            break;
                        case 2:
                            result = n - numbers[idx];
                            break;
                        case 3:
                            result = n * numbers[idx];
                            break;
                        case 4:
                            result = n / numbers[idx];
                            break;
                    }
                    visit[i] = true;
                    DFS(i, idx+1, result, len+1);
                }
            }
        }
        // backtracking
        visit[v] = false;
    }

}