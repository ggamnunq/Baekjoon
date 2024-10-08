package beakjoon.range_1000.BJ_1158.sol2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            queue.add(i+1);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int n = 1;
        while (!queue.isEmpty()) {
            if (n == K) {
                sb.append(queue.poll()).append(", ");
                n = 0;
            }
            else{
                queue.add(queue.poll());
            }
            n++;
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append(">");
        System.out.println(sb.toString());
    }

}
