package beakjoon.range_1000.BJ_5430.sol2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){

            Deque<Integer> deque = new LinkedList<>();
            String func = br.readLine();
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), "[],");

            while(st.hasMoreTokens()){
                deque.addLast(Integer.parseInt(st.nextToken()));
            }

            boolean isReversed = false;
            boolean isError = false;
            for (char c : func.toCharArray()) {

                if(c == 'R'){
                    isReversed = !isReversed;
                } else if (c == 'D') {
                    if(deque.isEmpty()){ // error 출력하는 경우
                        isError = true;
                        break;
                    }

                    if(!isReversed){
                        deque.removeFirst();
                    }else{
                        deque.removeLast();
                    }
                }else{
                    isReversed = true;
                }
            }

            if(isError) {
                sb.append("error\n");
            }else{
                sb.append("[");
                int size = deque.size();
                if (size == 0) {
                    sb.append("]\n");
                    continue;
                }
                else if (isReversed) {
                    for (int i = 0; i < size-1; i++) {
                        sb.append(deque.pollLast()).append(",");
                    }
                } else {
                    for (int i = 0; i < size-1; i++) {
                        sb.append(deque.pollFirst()).append(",");
                    }
                }
                sb.append(deque.poll()).append("]\n");
            }

        }
        System.out.print(sb.toString());
    }

}
