import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;


public class Main {
    public static void main(String[] args) throws IOException {

        System.out.print(solution(10, 85, 30));

    }

    public static int solution(int X, int Y, int D) {
        // write your code in Java SE 8
        return ((Y-X) % D > 0) ? ((Y-X) / D + 1) : (Y-X) / D;
    }
}

