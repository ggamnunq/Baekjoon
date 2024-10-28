package beakjoon.range_1000.BJ_3986;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int count = 0;

        while (N-- > 0) {

            String str = br.readLine();
            Stack<Character> stack = new Stack<>();

            char[] charArray = str.toCharArray();
            for (char c : charArray) {

                if (stack.isEmpty() || stack.peek() != c) {
                    stack.push(c);
                }else{
                    stack.pop();
                }

            }

            if(str.length() % 2 == 0 && stack.isEmpty())
                count++;


        }
        System.out.println(count);
    }
}
