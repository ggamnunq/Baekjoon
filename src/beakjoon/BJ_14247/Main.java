package beakjoon.BJ_14247;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Long count = 0L;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            count += Integer.parseInt(st.nextToken());
        }

        int[] speed = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            speed[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(speed);
        for (int i = 0; i < n; i++) {
            count += speed[i] * i;
        }
        System.out.println(count);

    }

}
