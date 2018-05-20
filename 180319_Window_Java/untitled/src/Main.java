import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Main {
    public static void main(String[] args) throws IOException {

        int[] A = {3, 8, 9, 7, 6};

        System.out.print(solution(A, 3));

    }

    public static int[] solution(int[] A, int K) {
        // write your code in Java SE 8
        int al = A.length;

        if (al == 0) return A;

        K %= al;

        while (K-- > 0) {
            int temp = 0;
            int temp2 = 0;

            temp = temp2 = A[1];
            A[1] = A[0];

            for (int i=1; i<al-1; i++) {
                temp2 = A[i+1];
                A[i+1] = temp;
                temp = temp2;
            }

            A[0] = temp;
        }

        return A;
    }
}
