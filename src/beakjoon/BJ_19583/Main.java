package beakjoon.BJ_19583;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String S = st.nextToken();
        String E = st.nextToken();
        String Q = st.nextToken();

        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();

        String str = null;
        while ((str = br.readLine()) != null) {

            st = new StringTokenizer(str);
            String time = st.nextToken();
            String name = st.nextToken();

            if (S.compareTo(time) >= 0) {
                set1.add(name);
            } else if (E.compareTo(time) <= 0 && Q.compareTo(time) >= 0) {
                if (set1.contains(name)) {
                    set2.add(name);
                }
            }
        }
        System.out.println(set2.size());

    }


}

