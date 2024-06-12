package beakjoon.BJ_4948;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {

            int n = Integer.parseInt(br.readLine());
            if(n == 0) break;

            boolean[] isNotPrime = new boolean[2*123456+1];
            isNotPrime[0]=true;
            isNotPrime[1]=true;
            int cnt = 0;

            for (int i = 2; i <= Math.sqrt(2 * n + 1); i++) {

                for (int j = i*i; j <= 2*n; j += i) {
                    isNotPrime[j]=true;
                }

            }
            for (int i = n+1; i <= n*2; i++) {
                if(!isNotPrime[i]) cnt++;
            }

            System.out.println(cnt);
        }
    }
}
