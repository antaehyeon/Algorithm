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

    String nextString() throws Exception {
        String result = br.readLine();
        return result;
    }
}

public class Main {

    public static void main(String[] args) throws Exception {

        FastScanner fs = new FastScanner(System.in);

        int n = fs.nextInt();
        String line = fs.nextString();
        String[] nums = line.split(" ");

        ArrayList<Integer> list = new ArrayList<>();

        for (int i=0; i<n; i++) {
            list.add(Integer.parseInt(nums[i]));
        }

        Collections.sort(list);

        System.out.println(list.get(0));
        System.out.println(list.get(n-1));
    }
}

