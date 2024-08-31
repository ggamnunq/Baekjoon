package beakjoon.range_1000.BJ_1449;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int cnt = 0;
        if (L == 1) {
            System.out.println(N);
        } else {

            int next = arr[0] + L;
            cnt++;

            for (int i = 1; i < N; i++) {
                if (arr[i] >= next) {
                    next = arr[i] + L;
                    cnt++;
                }
            }
            System.out.println(cnt);
        }

    }
}
