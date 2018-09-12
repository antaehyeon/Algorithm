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
        int leader=-1;
        int countOfLeader=0;

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for(int i=0;i<A.length;i++){
            if(hashMap.containsKey(A[i])){
                int count=hashMap.get(A[i]);
                count++;
                hashMap.put(A[i],count);
                if(countOfLeader<count){
                    countOfLeader=count;
                    leader=A[i];
                }
            }else{
                hashMap.put(A[i], 1);
            }
        }
        if(countOfLeader<A.length/2){
            return 0;
        }

        int countEquil=0;
        int counterOfrLeaderInRight=0;
        int counterOfrLeaderInLeft=countOfLeader;
        for(int i=A.length-1;i>=0;i--){
            if(A[i]==leader){
                counterOfrLeaderInRight++;
                counterOfrLeaderInLeft--;
            }

            if(counterOfrLeaderInLeft>i/2 && counterOfrLeaderInRight>((A.length-i)/2)){
                countEquil++;
            }
        }
        return countEquil;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        Solution answer = new Solution();

        int[] H = {4, 3, 4, 4, 4, 2};
//        int[] H = {1, 2, 3, 4, 4, 5};

        int result = answer.solution(H);

        System.out.print(result);
    }
}