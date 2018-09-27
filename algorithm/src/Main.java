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

    static StringBuilder sb = new StringBuilder("");
    static int L;
    static int C;
    static char[] alphabets;
    static boolean[] visit;


    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        L = fs.nextInt();
        C = fs.nextInt();

        alphabets = new char[C];
        visit = new boolean[26]; // 알파벳 갯수만큼 초기화

        for (int i=0; i<C; i++)
            alphabets[i] = fs.next().charAt(0);

        Arrays.sort(alphabets);

        for (int i=0; i<=C-1; i++)
            DFS(i, 1, "" + alphabets[i]);

        System.out.println(sb);
    }

    public static void DFS(int v, int cnt, String s) {
        int idx = alphabets[v] - 'a';
        visit[idx] = true;

        if (L == cnt) {
            if (isSatisfy())
                sb.append(s + "\n");
        } else {
            for (int i=v+1; i<C; i++) {
                if (!visit[alphabets[i] - 'a'])
                    DFS(i, cnt+1, s+alphabets[i]);
            }
        }

        // backtracking
        visit[idx] = false;
    }

    public static boolean isSatisfy() {
        int vowel = 0; // 모음
        int consonant = 0; // 자음

        for (int i=0; i<26; i++) {
            // 모음갯수 판별
            if (i==0 || i==4 || i==8 || i==14 || i==20) {
                if (visit[i])
                    vowel++;
            // 나머지 자음
            } else if (visit[i])
                consonant++;
        }

        if (vowel > 0 && consonant > 1)
            return true;

        return false;
    }

}