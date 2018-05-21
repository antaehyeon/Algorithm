import java.io.IOException;
import java.util.*;


public class Main {

    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {

        String s = "3 DUP 5 - -";

        System.out.print(solution(s));

    }

    public static int solution(String S) {
        boolean exit = false;
        String[] list = spliter(S);

        for (int i=0; i<list.length; i++) {

            if (exit) return -1;

            if (isNumeric(list[i])) {
                stack.push(Integer.parseInt(list[i]));
            } else if (list[i].equals("POP")) {
                stack.pop();
            } else if (list[i].equals("DUP")) {
                stack.push(stack.peek());
            } else if (list[i].equals("+")) {
                PLUS();
            } else if (list[i].equals("-")) {
                exit = MINUS();
            } else {
                System.out.println("ELSE _ PLEASE ERROR CHECK");
            }
        }

        if (exit) return -1;
        return stack.peek();
    }

    public static String[] spliter(String S) {
        return S.split(" ");
    }

    public static boolean isNumeric(String s)
    {
        return s.matches("-?\\d+(\\.\\d+)?");
    }

    public static void PLUS() {
        int a = stack.pop();
        int b = stack.pop();
        stack.push(a + b);
    }

    public static boolean MINUS() {

        if (stack.size() < 2) {
            return true;
        }

        int tmp = stack.pop();
        int peek = stack.peek();

        if (tmp-peek > 0) {
            stack.pop();
            stack.push(tmp-peek);
        } else {
            return true;
        }

        return false;
    }

    public static void exit() {
        System.out.println(-1);
        System.exit(-1);
    }
}

