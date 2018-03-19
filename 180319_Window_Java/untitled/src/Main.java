import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        boolean chk = false;

        Stack<String> a = new Stack<>();

        for (int i=0; i<n; i++) {
            String line = bf.readLine();
            String[] lines = line.split("");

            for (int j=0; j<line.length(); j++) {
                if (lines[j].equals("(")) {
                    a.push("(");
                } else {
                    if (a.size() == 0) {
                        System.out.println("NO");
                        chk = true;
                        break;
                    }
                    if (!a.pop().equals("(")) {
                        System.out.println("NO");
                        a.clear();
                        chk = true;
                        break;
                    }
                }
            }

            if (chk) {
                chk = false;
                continue;
            }

            if (a.size() > 0) {
                a.clear();
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
}
