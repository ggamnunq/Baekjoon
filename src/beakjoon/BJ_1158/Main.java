package beakjoon.BJ_1158;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0 ; i < N; i++){
            list.add(i+1);
        }

        int idx = K-1;

        sb.append("<");
        while (true) {
            sb.append(list.get(idx) + ", ");
            list.remove(idx);
            if(list.size() == 0 ) break;
            idx = (idx + K-1)%list.size();
        }

        sb.replace(sb.length() - 2, sb.length() - 1, ">");
        System.out.println(sb.toString());


    }
}
