import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
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

    static final int[] dRow = {0, -1, 0, 1, -1, 1, -1, 1};
    static final int[] dCol = {-1, 0, 1, 0, 1, 1, -1, -1};

    static int W, H;
    static int [][] map = new int[10001][10001];

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        int x1 = fs.nextInt();
        int y1 = fs.nextInt();
        int x2 = fs.nextInt();
        int y2 = fs.nextInt();
        int x3 = fs.nextInt();
        int y3 = fs.nextInt();
        int x4 = fs.nextInt();
        int y4 = fs.nextInt();
        int x5 = fs.nextInt();
        int y5 = fs.nextInt();
        int x6 = fs.nextInt();
        int y6 = fs.nextInt();

        System.out.println(solution(x1, y1, x2, y2, x3, y3, x4, y4, x5, y5, x6, y6));
    }

    public static int solution(int x1, int y1,int x2, int y2, int x3, int y3, int x4, int y4, int x5, int y5, int x6, int y6) {

        int result = 0;

        for (int i=y1; i<y2; i++) {
            for (int j=x1; j<x2; j++) {
                map[i][j] = 1;
            }
        }

        for (int i=y3; i<y4; i++) {
            for (int j=x3; j<x4; j++) {
                map[i][j] = 2;
            }
        }

        for (int i=y5; i<y6; i++) {
            for (int j=x5; j<x6; j++) {
                map[i][j] = 3;
            }
        }

        for (int i=y1; i<y2; i++) {
            for (int j=x1; j<x2; j++) {
                if (map[i][j] == 1) {
                    result += DFS(i, j);
                }
            }
        }

        return result;
    }

    public static int DFS(int row, int col) {

        int result = 1;

        map[row][col] = -1;

        for (int i = 0; i < 8; i++) {
            int nextRow = row + dRow[i];
            int nextCol = col + dCol[i];

            if (nextRow < 0 || nextRow >= H || nextCol < 0 || nextCol >= W) continue;
            if (map[nextRow][nextCol] == 1) {
                result += DFS(nextRow, nextCol);
            }
        }

        return result;
    }
}

