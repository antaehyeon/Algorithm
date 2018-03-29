import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static boolean[] visited;
    static boolean[] finished;
    static int n;
    static StringTokenizer st;
    static int result;

    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < n + 1; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            result = 0;
            visited = new boolean[n + 1];
            finished = new boolean[n + 1];
            for (int i = 1; i < n + 1; i++) {
                if(!visited[i]){
                    dfs(i);
                }
            }
            System.out.println(n-result);
        }
    }

    public static void dfs(int curr) {
        visited[curr] = true;
        int next = arr[curr];
        if (visited[next]) {
            if (!finished[next]) {
                for (int temp = next; temp != curr; temp = arr[temp])
                    result++;
                result++; // 자기 자신
            }
        } else
            dfs(next);
        finished[curr] = true;
    }
}
