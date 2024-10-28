package beakjoon.range_1000.BJ_9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {

            Stack<Character> stack = new Stack<>();
            char[] charArray = br.readLine().toCharArray();
            for (char c : charArray) {

                if(c == '('){
                    stack.push(c);
                }else{
                    if(!stack.isEmpty() && stack.peek() == '('){
                        stack.pop();
                    }else{
                        stack.push(c);
                    }
                }

            }

            if(stack.isEmpty()){
                sb.append("YES\n");
            }else{
                sb.append("NO\n");
            }
        }
        System.out.print(sb.toString());
    }
}
