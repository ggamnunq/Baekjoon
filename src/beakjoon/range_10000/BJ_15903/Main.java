package beakjoon.range_10000.BJ_15903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        PriorityQueue<Long> queue = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        long result = 0;
        for (int i = 0; i < n; i++) {
            long input = Long.parseLong(st.nextToken());
            queue.offer(input);
        }

        for (int i = 0; i < m; i++) {

            long sum = queue.poll() + queue.poll();
            queue.offer(sum);
            queue.offer(sum);
        }

        for (int i = 0; i < n; i++) {
            result += queue.poll();
        }
        System.out.println(result);
    }


}

