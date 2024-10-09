package beakjoon.range_10000.BJ_10773;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        int sum = 0;
        while (K-- > 0) {

            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                sum -= stack.pop();

            } else {
                sum += stack.push(n);
            }
        }
        System.out.println(sum);

    }
}
