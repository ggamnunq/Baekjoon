package beakjoon.range_10000.BJ_10866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());
        int n;
        while(N-- > 0){
            st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            switch (input){
                case "push_front":
                    n = Integer.parseInt(st.nextToken());
                    deque.addFirst(n);
                    break;
                case "push_back":
                    n = Integer.parseInt(st.nextToken());
                    deque.addLast(n);
                    break;
                case "pop_front":
                    if(!deque.isEmpty()){
                        sb.append(deque.removeFirst() + "\n");
                    }
                    else{
                        sb.append("-1\n");
                    }
                    break;
                case "pop_back":
                    if(!deque.isEmpty()){
                        sb.append(deque.removeLast() + "\n");
                    }
                    else{
                        sb.append("-1\n");
                    }
                    break;
                case "size":
                    sb.append(deque.size() + "\n");
                    break;
                case "empty":
                    if(deque.isEmpty()){
                        sb.append("1\n");
                    }else{
                        sb.append("0\n");
                    }
                    break;
                case "front":
                    if(deque.isEmpty()){
                        sb.append("-1\n");
                    }
                    else{
                        sb.append(deque.getFirst() + "\n");
                    }
                    break;
                case "back":
                    if(deque.isEmpty()){
                        sb.append("-1\n");
                    }else{
                        sb.append(deque.getLast() + "\n");
                    }
                    break;
            }
        }
        System.out.print(sb.toString());
    }
}
