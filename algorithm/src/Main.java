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

    static ArrayList<Integer> landSizes = new ArrayList<>();

    static final int[] dRow = {0, -1, 0, 1, -1, 1, -1, 1};
    static final int[] dCol = {-1, 0, 1, 0, 1, 1, -1, -1};

    static int W, H;
    static int[][] map;

    static int landSize = 0;

    public static void DFS(int row, int col) {

        map[row][col] = 0;

        for (int i=0; i<8; i++) {
            int nextRow = row + dRow[i];
            int nextCol = col + dCol[i];
            // 상, 좌, 하, 우, 왼쪽아래대각선, 오른쪽위대각선, 왼쪽위대각, 오른쪽아래대각

            if (nextRow < 0 || nextRow >= H || nextCol < 0 || nextCol >= W) continue;
            if (map[nextRow][nextCol] == 1) {
                landSize++;
                DFS(nextRow, nextCol);
            }
        }
    }

    public static void main(String[] args) throws Exception {

        FastScanner fs = new FastScanner(System.in);

        W = H = fs.nextInt();
        map = new int[W][H];

        for (int i=0; i<H; i++) {
            for (int j=0; j<W; j++) {
                map[i][j] = fs.nextInt();
            }
        }

        int result = 0;

        for (int i=0; i<H; i++) {
            for (int j=0; j<W; j++) {
                if (map[i][j] == 1) {
                    DFS(i, j);
                    result++;
                    landSizes.add(landSize+1);
                    landSize = 0;
                }
            }
        }

        System.out.println(result);
        Collections.sort(landSizes);
        for (int size : landSizes) {
            System.out.print(size + " ");
        }
    }
}