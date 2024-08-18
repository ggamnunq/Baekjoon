package beakjoon.BJ_1141;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] arr = new String[N];
        int result = N;
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, (String s1, String s2) -> s1.length() - s2.length());
        List<String> list = Arrays.asList(arr);

        for (int i = 0; i < N - 1; i++) {

            String s = list.get(i);

            for (int j = i + 1; j < N; j++) {
                String compareTo = list.get(j).substring(0, s.length());
                if (s.equals(compareTo)) {
                    result--;
                    break;
                }
            }
        }
        System.out.println(result);
    }

}
