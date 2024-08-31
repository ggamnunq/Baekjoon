package beakjoon.range_1000.BJ_1946;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            int result = 1;
            int[] arr = new int[N+1];
            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                arr[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
            }

            int tmp = arr[1];
            for (int i = 2; i <= N; i++) {

                if (arr[i] < tmp) {
                    tmp = arr[i];
                    result++;
                }

            }
            sb.append(result + "\n");
        }
        System.out.println(sb.toString());
    }

}
