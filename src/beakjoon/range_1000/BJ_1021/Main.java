package beakjoon.range_1000.BJ_1021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        LinkedList<Integer> deque = new LinkedList<>();
        int[] arr = new int[M];

        for (int i = 0; i < N; i++) {
            deque.addLast(i+1);
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;

        for(int j = 0 ; j < M ; j++){

            int idx = deque.indexOf(arr[j]);

            int middleIdx;
            if (deque.size() % 2 == 0) {
                middleIdx = deque.size() / 2-1;
            }
            else{
                middleIdx = deque.size() / 2;
            }

            if (idx <= middleIdx) {
                for (int i = 0; i < idx; i++) {
                    int tmp = deque.pollFirst();
                    deque.addLast(tmp);
                    count++;
                }
            }else{
                for (int i = 0; i <deque.size() - idx; i++) {
                    int tmp = deque.pollLast();
                    deque.addFirst(tmp);
                    count++;
                }
            }
            deque.pollFirst();
        }
        System.out.println(count);
    }
}
