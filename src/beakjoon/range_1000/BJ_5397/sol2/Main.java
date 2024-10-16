package beakjoon.range_1000.BJ_5397;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {

            Stack<Character> stack1 = new Stack<>();
            Stack<Character> stack2 = new Stack<>();

            String input = br.readLine();
            for (char c : input.toCharArray()) {

                switch (c) {
                    case '<':
                        if (!stack1.isEmpty()) {
                            stack2.push(stack1.pop());
                        }
                        break;
                    case '>':
                        if (!stack2.isEmpty()) {
                            stack1.push(stack2.pop());
                        }
                        break;
                    case '-':
                        if (!stack1.isEmpty()) {
                            stack1.pop();
                        }
                        break;
                    default:
                        stack1.push(c);
                }

            }

            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            while (!stack2.isEmpty()) {
                sb.append(stack2.pop());
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());

    }
}
