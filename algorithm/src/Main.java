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

    static int N, M;
    static ArrayList<String> list = new ArrayList<String>();
    static ArrayList<String> answerPeople = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        N = fs.nextInt();
        M = fs.nextInt();

        for (int i=0; i<N; i++)
            list.add(fs.next());

        Collections.sort(list);
        String[] peoples = new String[list.size()];
        peoples = list.toArray(peoples);

        list.clear();

        for (int i=0; i<M; i++) {
            String name = fs.next();
            list.add(name);
            int idx = Arrays.binarySearch(peoples, name);
            if (idx >= 0)
                answerPeople.add(name);
        }

        Collections.sort(answerPeople);

        System.out.println(answerPeople.size());
        for (String s : answerPeople)
            System.out.println(s);

    }
}