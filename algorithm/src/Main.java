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

    static int N;
    static int M;
    static int max;

    static int[][] tetrominoMap;
    static boolean[][] visited;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        N = fs.nextInt();
        M = fs.nextInt();

        tetrominoMap = new int[N][M];
        visited = new boolean[N][M];

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                tetrominoMap[i][j] = fs.nextInt();
            }
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                DFS(i, j, 0, 0);
                Exception(i, j);
            }
        }

        System.out.println(max);
    }

    public static void DFS (int x, int y, int depth, int sum) {
        if (depth == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int i=0; i<4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M)
                continue;

            if (visited[nextX][nextY])
                continue;

            visited[nextX][nextY] = true;
            DFS(nextX, nextY, depth+1, sum+tetrominoMap[nextX][nextY]);
            visited[nextX][nextY] = false;
        }
    }

    public static void Exception(int x, int y) {
        int wing = 4;
        int min = Integer.MAX_VALUE;
        int sum = tetrominoMap[x][y];

        for (int i=0; i<4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (wing <= 2) return;

            if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
                wing--;
                continue;
            }

            min = Math.min(min, tetrominoMap[nextX][nextY]);
            sum = sum + tetrominoMap[nextX][nextY];
        }

        if (wing == 4)
            sum -= min;

        max = Math.max(max, sum);
    }
}