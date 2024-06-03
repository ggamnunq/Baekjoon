package beakjoon.BJ_1874;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+1];
        for(int i=0 ; i < n ; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int idx = 0;
        for(int i=0; i < n ; i++){

            stack.push(i + 1);
            sb.append("+" + "\n");

            while( !stack.isEmpty() && stack.peek() == arr[idx] ){
                stack.pop();
                sb.append("-" + "\n");
                idx++;
            }

            if(stack.contains(arr[idx]) && stack.peek()!=arr[idx]){
                System.out.println("NO");
                return;
            }
        }
        System.out.print(sb.toString());
    }
}
