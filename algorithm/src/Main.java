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
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] stageClearPlayerNum = new int[N+2];
        TreeMap<Double, Integer> rank = new TreeMap<>();

        for (int playerPositionIdx : stages) {
            for (int i=1; i<=playerPositionIdx; i++)
                stageClearPlayerNum[i]++;
        }

        double dummyData = 0.0000000001;

        for (int i=1; i<=N; i++) {
            double playerOfCurrentPlayer = (double)stageClearPlayerNum[i] - stageClearPlayerNum[i+1];
            double failureRatio = playerOfCurrentPlayer / stageClearPlayerNum[i+1];
            if (rank.containsKey(failureRatio)) {
                failureRatio -= dummyData;
                dummyData += 0.0000000001;
            }
            rank.put(failureRatio, i);
        }

        for (int i=0; i<N; i++) {
            answer[i] = rank.get(rank.lastKey());
            rank.remove(rank.lastKey());
        }

        return answer;
    }
}


public class Main {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        Solution answer = new Solution();

        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};

//        int N = 4;
//        int[] stages = {4,4,4,4,4};

//        int N = 1;
//        int[] stages = {200000};

//        int N = 5;
//        int[] stages = {6, 6, 6, 6, 6, 6, 6, 6};

        int[] result = answer.solution(N, stages);

        for (int n : result) {
            System.out.print(n + " ");
        }
    }
}