import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static int run(String data) {
        String[] lines = data.split("");
        Stack<String> s = new Stack<>();
        int result = 0;
        boolean c = false;

        for (String a : lines) {
            if (a.equals("(")) {
                s.push("(");
                c = true;
            } else {
                if (c) {
                    s.pop();
                    c = false;
                    result += s.size();
                } else {
                    s.pop();
                    result += 1;
                }
            }
        }

        return result;
    }

    public static void print(String data) {
        System.out.println(data);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line = bf.readLine();

        System.out.println(run(line));
    }
}
