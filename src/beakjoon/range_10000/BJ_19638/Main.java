package beakjoon.range_10000.BJ_19638;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            queue.add(Integer.parseInt(br.readLine()));
        }
        int count = 0;
        while (T-- > 0) {
            int n = queue.peek();

            if (H > n || n == 1) {
                break;
            } else {
                queue.poll();
                queue.add(n / 2);
                count++;
            }
        }

        if (H > queue.peek()) {
            System.out.println("YES");
            System.out.println(count);
        } else {
            System.out.println("NO");
            System.out.println(queue.peek());
        }
    }

}
