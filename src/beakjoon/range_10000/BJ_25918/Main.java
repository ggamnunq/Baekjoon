package beakjoon.range_10000.BJ_25918;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Stack<Character> stack = new Stack<>();
        String str = br.readLine();

        int result = -1;

        if (str.length() % 2 == 0) {

            for (char c : str.toCharArray()) {
                if (stack.isEmpty() || stack.peek().equals(c)) {
                    stack.add(c);
                } else {
                    stack.pop();
                }
                result = Math.max(result, stack.size());
            }
            if (!stack.isEmpty()) {
                result = -1;
            }
        }
        System.out.println(result);

    }

}
