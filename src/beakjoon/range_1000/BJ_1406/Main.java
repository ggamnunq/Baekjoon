package beakjoon.range_1000.BJ_1406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        String input = br.readLine();
        for (int i = 0; i < input.length(); i++) {
            stack1.push(input.charAt(i));
        }
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {

            String line = br.readLine();
            char c = line.charAt(0);

            if (c == 'L' && !stack1.isEmpty()) {
                stack2.push(stack1.pop());
            } else if (c == 'D' && !stack2.isEmpty()) {
                stack1.push(stack2.pop());
            } else if (c == 'B' && !stack1.isEmpty()) {
                stack1.pop();
            } else if (c == 'P') {
                stack1.push(line.charAt(2));
            }

        }
        StringBuffer sb = new StringBuffer();
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        while (!stack2.isEmpty()) {
            sb.append(stack2.pop());
        }
        System.out.println(sb);
    }
}
