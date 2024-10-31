package beakjoon.range_10000.BJ_11003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Deque<A> deque = new LinkedList<>();

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {

            int n = Integer.parseInt(st.nextToken());

            while(!deque.isEmpty() && deque.getLast().value > n){
                deque.removeLast();
            }

            deque.addLast(new A(n, i));

            while (!deque.isEmpty() && deque.getFirst().index <= i - L) {
                deque.removeFirst();
            }

            sb.append(deque.getFirst().value).append(" ");
        }
        System.out.println(sb.toString());
    }
}

class A{

    int value;
    int index;

    public A(int value, int index) {
        this.value = value;
        this.index = index;
    }
}
