package beakjoon.range_1000.BJ_4949;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {

            String str = br.readLine();
            if(str.equals(".")) break;

            Stack<Character> stack = new Stack<>();
            boolean flag = true; // YES or NO 추가할지 판단

            for(int i=0; i<str.length(); i++) {

                char ch = str.charAt(i);

                if(ch=='(' || ch=='['){
                    stack.push(ch);
                } else if(ch==')') {

                    if(stack.isEmpty() || stack.peek()!='(') {
                        flag  = false;
                        break;
                    }
                    else if(stack.peek()=='('){
                        stack.pop();
                    }

                } else if(ch==']') {

                    if(stack.isEmpty() || stack.peek()!='[') {
                        flag = false;
                        break;
                    }
                    else if(stack.peek()=='['){
                        stack.pop();
                    }

                }
            }

            if(stack.isEmpty() && flag)
                sb.append("yes").append("\n");
            else
                sb.append("no").append("\n");
        }

        System.out.println(sb.toString());
    }

}
