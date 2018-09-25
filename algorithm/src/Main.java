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
    static int[][] moveCost;
    static int[] visit;
    static int n;
    static int min = Integer.MAX_VALUE;
    static int cnt = 0;
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        n = fs.nextInt();

        moveCost = new int[n][n];
        visit = new int[n];

        Arrays.fill(visit, 0);

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                moveCost[i][j] = fs.nextInt();
            }
        }

        for (int i=0; i<n; i++)
            DFS(i, i, 0);

        System.out.print(min);
    }

    public static void DFS(int first, int a, int sum) {
        if (cnt == n && first == a) {
            min = Math.min(min, sum);
            return;
        }

        for (int i=0; i<n; i++) {
            if (visit[i] == 0 && moveCost[a][i] != 0) {
                visit[i] = 1;
                sum += moveCost[a][i];
                cnt++;
                DFS(first, i, sum);
                visit[i] = 0;
                sum -= moveCost[a][i];
                cnt--;
            }
        }
    }

}