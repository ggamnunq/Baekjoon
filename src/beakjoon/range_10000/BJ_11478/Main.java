package beakjoon.range_10000.BJ_11478;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Set<String> set = new HashSet<>();
        String str;

        for(int i=1; i <= s.length(); i++){  //글자 수 종류 가지

            for(int j=0 ; j<=s.length()-i; j++){
                str = s.substring(j, j+i);
                set.add(str);
            }

        }
        System.out.println(set.size());

    }
}


