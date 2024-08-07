package beakjoon.BJ_2075;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) { // 큐 사이즈 N개로 설정 및 추가
            pq.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int n = Integer.parseInt(st.nextToken());

                if (pq.peek() < n) {
                    pq.poll();
                    pq.add(n);
                }
            }
        }

        System.out.println(pq.poll());

    }

}
