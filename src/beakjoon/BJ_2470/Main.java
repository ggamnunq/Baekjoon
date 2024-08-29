package beakjoon.BJ_2470;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>( );

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {

                int a = Math.abs(o1);
                int b = Math.abs(o2);
                return a - b;
            }
        });

        int min = 2000000000;
        int n1=0, n2=0;
        for (int i = 0; i < N - 1; i++) {

            int a = list.get(i);
            int b = list.get(i + 1);
            int num = Math.abs(a + b);
            if (num < min) {
                min = num;
                n1 = a;
                n2 = b;
            }
        }

        System.out.println(Math.min(n1, n2) + " " + Math.max(n1, n2));

    }

}
