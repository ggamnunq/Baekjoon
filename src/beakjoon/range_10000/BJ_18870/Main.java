package beakjoon.range_10000.BJ_18870;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] arr2 = new int[N];
        Map<Integer, Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            arr2[i] = arr[i];
        }

        Arrays.sort(arr2);

        int idx=0;
        for (int i : arr2) {
            if (!map.containsKey(i))
                map.put(i, idx++);
        }

        for (int i : arr) {
            sb.append(map.get(i)).append(" ");
        }
        System.out.println(sb);
    }

}
