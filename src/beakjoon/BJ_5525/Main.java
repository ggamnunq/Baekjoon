package beakjoon.BJ_5525;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();

        int cnt = 0;

        for(int i=0; i <= M-(2*N+1); i++){

            if (S.charAt(i) == 'I') {
                int cntOI = 0;
                while (i + 2 < M && S.charAt(i + 1) == 'O' && S.charAt(i + 2) == 'I') {
                    cntOI++;
                    i+=2;
                }

                if (cntOI >= N) {
                    cnt += 1 + (cntOI - N);
                }

            }

        }

//        String str = "I";
//        for(int i=0; i < N ;i++){
//            str += "OI";
//        }
//
//        for(int i=0; i < M-str.length(); i++){
//
//            if (S.substring(i, i + str.length()).equals(str)) {
//                System.out.println("[" + i + "," + (i+str.length()) + ")");
//                cnt++;
//            }
//        }

        System.out.println(cnt);

    }
}
