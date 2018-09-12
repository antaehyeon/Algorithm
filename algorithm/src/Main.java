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

class Solution {
    public int solution(int[] A) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int dominator = 0;
        int count = 0;

        for (int i : A) {
            if (hashMap.containsKey(i)) {
                int tmpCount = hashMap.get(i);
                tmpCount++;
                hashMap.put(i, tmpCount);
                if (tmpCount > count) {
                    count = tmpCount;
                    dominator = i;
                }
            } else hashMap.put(i, 1);
        }

        if (A.length == 1) return 0;
        if (count < (A.length/2)) return -1;

        for (int i=0; i<A.length; i++) {
            if (A[i] == dominator) return i;
        }
        return -1;
    }
}


public class Main {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        Solution answer = new Solution();

//        int[] H = {3, 4, 3, 2, 3, -1, 3, 3};
//        int[] H = {1, 2, 3, 4, 4, 5};
//        int[] H = {3, 4, 3, 2, 3, 4, 3, 3, 4};
        int[] H = {2147483647};

        int result = answer.solution(H);

        System.out.print(result);
    }
}