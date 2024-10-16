package beakjoon.range_10000.BJ_17298;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());
        int[] ans = new int[N];


        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ans[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {

            int num = ans[i];
            while (!stack.isEmpty() && num > ans[stack.peek()]) {
                ans[stack.pop()] = num;
            }
            stack.push(i);

        }

        while(!stack.isEmpty()) {
            ans[stack.pop()] = -1;
        }

        for (int i = 0; i < N; i++) {
            sb.append(ans[i] + " ");
        }

        System.out.println(sb.toString());
    }
}
