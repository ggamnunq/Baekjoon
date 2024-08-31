package beakjoon.range_1000.BJ_2607;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;

        String s = br.readLine();
        int str1Size = s.length();

        List<Character> str1 = new ArrayList<>();
        for (char c : s.toCharArray()) {
            str1.add(c);
        }

        while(N-- > 1){

            s = br.readLine();
            int str2Size = s.length();
            List<Character> str2 = new ArrayList<>();
            for (char c : s.toCharArray()) {
                str2.add(c);
            }

            for (Character c : str1) {
                str2.remove(c);
            }

            if (str2.isEmpty() && str1Size==str2Size) { // 구성이 같을 때
                cnt++;
            } else if (str2.size() == 1 && ((str1Size+1 == str2Size) || (str1Size == str2Size))) { //문자 하나 추가했을 때, 한 문자 바꿨을 때
                cnt++;
            } else if(str1Size-1 == str2Size && str2.isEmpty()){ //한 문자 없앴을 때
                cnt++;
            }

        }
        System.out.println(cnt);


    }

}
