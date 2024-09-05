package beakjoon.range_10000.BJ_12904;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String T = br.readLine();

        for (int i = T.length()-1; i >= S.length(); i--) {

            char c = T.charAt(i);
            T = T.substring(0, i);
            if (c == 'B') {
                StringBuilder sb = new StringBuilder(T);
                T = sb.reverse().toString();
            }
        }

        if (T.equals(S)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

    }
}
