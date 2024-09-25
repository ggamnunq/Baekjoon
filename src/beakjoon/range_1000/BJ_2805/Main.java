package beakjoon.range_1000.BJ_2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Integer[] trees = new Integer[N];
        int max = 0;
        int min = 0;
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, trees[i]);
        }

        while (min < max) {

            int mid = (max + min) / 2;
            long sum = 0;

            for (Integer tree : trees) {

                if (tree > mid) {
                    sum += tree - mid;
                }
            }

            if (sum < M) {
                max = mid;
            } else {
                min = mid + 1;
            }

        }

        System.out.println(min-1);
    }
}
