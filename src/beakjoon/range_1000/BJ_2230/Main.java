package beakjoon.range_1000.BJ_2230;

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
        int min = Integer.MAX_VALUE;

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int a=0, b=0;
        while (b < N) {

            int numA = arr[a];
            int numB = arr[b];

            if (numB - numA > M) {
                min = Math.min(min, numB - numA);
                a++;
            } else if (numB - numA < M) {
                b++;
            } else {
                min = M;
                break;
            }

        }

        System.out.println(min);
    }
}
