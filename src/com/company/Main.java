package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<n; i++) {
            String line = bf.readLine();
            String[] s = line.split(" ");
            String cmd = s[0];
            switch(cmd) {
                case "push":
                    stack.push(Integer.parseInt(s[1]));
                    break;
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
                    if (stack.empty()) System.out.println("-1");
                    else               System.out.println(stack.peek());
                    break;
                default:
                    break;
            } // switch
        } // for i-n
    } // Main
}
