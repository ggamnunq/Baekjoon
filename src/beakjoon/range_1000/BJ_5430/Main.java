package beakjoon.range_1000.BJ_5430;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {

            String func = br.readLine();
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), "[],");

            Deque<String> deque = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                deque.add(st.nextToken());
            }

            boolean reverse = false;
            boolean error = false;
            for (int i = 0 ;i < func.length(); i++) {

                char c = func.charAt(i);

                if (c == 'R') {
                    reverse = !reverse;
                } else if (c == 'D') {

                    if (deque.isEmpty()) {
                        error = true;
                        break;
                    } else if (reverse) {
                        deque.pollLast();
                    } else {
                        deque.pollFirst();
                    }
                } else {
                    error = true;
                    break;
                }
            }


            if (error) {
                sb.append("error\n");
            } else {

                sb.append("[");
                int size = deque.size();
                if (size == 0) {
                    sb.append("]\n");
                    continue;
                }
                else if (reverse) {
                    for (int i = 0; i < size-1; i++) {
                        sb.append(deque.pollLast()).append(",");
                    }
                } else {
                    for (int i = 0; i < size-1; i++) {
                        sb.append(deque.pollFirst()).append(",");
                    }
                }
                sb.append(deque.poll() + "]\n");
            }
        }
        System.out.print(sb);
    }



}
