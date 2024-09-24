package beakjoon.range_1000.BJ_14501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 1];

        for(int i= 0 ; i < N ; i++) {

            int duration = arr[i][0];
            int pay = arr[i][1];

            if (i + duration <= N) {
                dp[i + duration] = Math.max(dp[i + duration], dp[i] + pay);
            }
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);

        }
        System.out.println(dp[N]);

    }
}
