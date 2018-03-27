import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        int N;
        String cmd;

        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Editor editor = new Editor(br.readLine().toCharArray());

        N = Integer.parseInt(br.readLine());

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            cmd = st.nextToken();

            switch (cmd) {
                case "L":
                    editor.L();
                    break;
                case "D":
                    editor.D();
                    break;
                case "B":
                    editor.B();
                    break;
                case "P":
                    char c = st.nextToken().charAt(0);
                    editor.P(c);
                    break;
                default:
                    break;
            }
        }
        editor.printStr();
    }
}

class Editor {

    List<Character> str;
    ListIterator<Character> it;

    int index = 0;

    Editor(char[] arr) {
        str = new LinkedList<Character>();
        it = str.listIterator(str.size());
        pushInitStr(arr);
    }

    // 커서를 왼쪽으로 한칸 옮김
    // 맨 앞이면 무시됨
    public void L() {
        if (it.hasPrevious()) {
            it.previous();
        }
    }

    // 커서를 오른쪽으로 한칸 옮김
    // 커서가 문장의 맨 뒤이면 무시됨
    public void D() {
        if (it.hasNext()) {
            it.next();
        }
    }

    // 커서 왼쪽에 있는 문자를 삭제함
    // 커서의 위치는 옮겨지지만
    // 실제로 커서의 오른쪽에 있던 문자는 그대로임
    public void B() {
        if (it.hasPrevious()) {
            it.previous();
            it.remove();
        }
    }

    // 문자를 커서 왼쪽에 추가함
    public void P(char c) {
        it.add(c);
    }

    // System.out.print 를 최대한 줄이자!
    public void printStr() {
        StringBuilder sb = new StringBuilder();
        for (char c : str) {
            sb.append(c);
        }
        System.out.print(sb);
    }

    private void pushInitStr(char[] arr) {
        for (int i=0; i<arr.length; i++) {
            P(arr[i]);
        }
    }
}