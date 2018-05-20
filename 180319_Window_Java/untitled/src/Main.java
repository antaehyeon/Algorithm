import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;


public class Main {
    public static void main(String[] args) throws IOException {

        int[] A = {9, 3, 9, 3, 9, 7, 9};

        System.out.print(solution(A));

    }

    public static int solution(int[] A) {
        // write your code in Java SE 8

        Set<Integer> s = new HashSet<Integer>();
        int i = A.length;

        while(i-- > 0) {
            if (s.contains(A[i])) {
                s.remove(A[i]);
            } else {
                s.add(A[i]);
            }
        }

        return s.iterator().next();
    }
}

