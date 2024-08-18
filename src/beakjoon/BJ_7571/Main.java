package beakjoon.BJ_7571;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] row = new int[M];
        int[] col = new int[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            row[i] = Integer.parseInt(st.nextToken());
            col[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(row);
        Arrays.sort(col);

        int rowMid = row[M / 2];
        int colMid = col[M / 2];

        int result = 0;
        for (int i = 0; i < M; i++) {
            result += Math.abs(rowMid - row[i]) + Math.abs(colMid - col[i]);
        }
        System.out.println(result);
    }

}
