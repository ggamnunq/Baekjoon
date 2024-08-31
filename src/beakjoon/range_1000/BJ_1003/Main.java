package beakjoon.range_1000.BJ_1003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        int[] zero= new int[41];
        int[] one = new int[41];

        zero[0] = 1; zero[1] = 0;
        one[0] = 0; one[1] = 1;

        for(int i = 0; i < T; i++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            for (int j = 2; j <= N; j++) {
                zero[j] = zero[j - 2] + zero[j - 1];
                one[j] = one[j-2] + one[j-1];
            }

            System.out.println(zero[N] + " " + one[N]);

        }

    }


}
