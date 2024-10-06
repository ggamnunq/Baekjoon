package beakjoon.range_1000.BJ_2193;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long a = 1, b = 0;
        long c = a + b;

        for (int i = 0; i < N; i++) {
            c = a+b;
            a = b;
            b = c;
        }
        System.out.println(c);

    }
}
