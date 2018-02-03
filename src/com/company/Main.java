package com.company;

import com.oracle.tools.packager.Log;

import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        // init
        int a;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<Integer>();

        // input
        a = Integer.parseInt(bf.readLine());

        // algorithm - OUTPUT
        for (int i = 0; i < a; i++) {
            String line = bf.readLine();
            StringTokenizer st = new StringTokenizer(line, " ");

            // PUSH
            if (st.countTokens() == 2) {
                st.nextToken();
                stack.push(Integer.parseInt(st.nextToken()));
                continue;
            } // if

            switch (st.nextToken()) {
                case "pop":
                    if (stack.empty())
                        System.out.println("-1");
                    else
                        System.out.println(stack.pop());
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                    if (stack.empty()) System.out.println("1");
                    else               System.out.println("0");
                    break;
                case "top":
                    if (stack.empty())
                        System.out.println("-1");
                    int temp = stack.pop();
                    System.out.println(temp);
                    stack.push(temp);
                    break;
            } // switch-case
        } // for i-a
    } // Main
}
