package beakjoon.range_1000.BJ_4889;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = 0;
        while (true) {

            String str = br.readLine();
            if (str.contains("-")) {
                break;
                }
            n++;
            Stack<Character> stack = new Stack<>();
            int cnt = 0;
            for (int i = 0; i < str.length(); i++) {

                char c = str.charAt(i);

                if (c == '{') {
                    stack.add(c);
                } else {
                    if (stack.empty()) {
                        stack.add('{');
                        cnt++;
                    } else {
                        stack.pop();
                    }
                }

            }
            if (!stack.isEmpty()) {
                cnt += stack.size() / 2;
            }
            System.out.println(n + ". " + cnt);
        }
    }
}
