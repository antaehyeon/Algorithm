import java.io.BufferedReader;
import java.io.IOException;
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

    static final int[] dRow = {0, -1, 0, 1, -1, 1, -1, 1};
    static final int[] dCol = {-1, 0, 1, 0, 1, 1, -1, -1};

    static int W, H;
    static int[][] map = new int[51][51];

    public static void DFS(int row, int col) {

        map[row][col] = 0;

        for (int i=0; i<8; i++) {
            int nextRow = row + dRow[i];
            int nextCol = col + dCol[i];
            // 상, 좌, 하, 우, 왼쪽아래대각선, 오른쪽위대각선, 왼쪽위대각, 오른쪽아래대각

            if (nextRow < 0 || nextRow >= H || nextCol < 0 || nextCol >= W) continue;
            if (map[nextRow][nextCol] == 1) {
                DFS(nextRow, nextCol);
            }


        }
    }

    public static void main(String[] args) throws Exception {

        FastScanner fs = new FastScanner(System.in);

        while (true) {
            W = fs.nextInt();
            H = fs.nextInt();

            if (W == 0 && H == 0) break;

            for (int i=0; i<H; i++) {
                String line = fs.nextString();
                String[] lines = line.split(" ");
                for (int j=0; j<W; j++) {
                    map[i][j] = Integer.parseInt(lines[j]);
                }
            }

            int result = 0;

            for (int i=0; i<H; i++) {
                for (int j=0; j<W; j++) {
                    if (map[i][j] == 1) {
                        DFS(i, j);
                        result++;
                    }
                }
            }

            System.out.println(result);
        }
    }
}