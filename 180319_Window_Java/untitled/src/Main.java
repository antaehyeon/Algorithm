import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println(solution(1, 1, 2, 3));
        System.out.println(solution(2, 4, 2, 4));
        System.out.println(solution(-5000, 300, 100, 5000));
    }

    public static int solution(int A, int B, int C, int D) {
        // write your code in Java SE 8
        int[] points = {A, B, C, D};
        Arrays.sort(points);

        int firstLineLength = points[3] - points[0];
        int secondLineLength = points[2] - points[1];

        firstLineLength *= firstLineLength;
        secondLineLength *= secondLineLength;

        return firstLineLength + secondLineLength;
    }
}

