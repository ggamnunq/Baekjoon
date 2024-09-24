package beakjoon.range_1000.BJ_1092;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<Integer> crane = new ArrayList<>();

        //crane 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            crane.add(Integer.parseInt(st.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());
        List<Integer> box = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            box.add(Integer.parseInt(st.nextToken()));
        }

        //내림차순 정렬
        Collections.sort(crane, Collections.reverseOrder());
        Collections.sort(box, Collections.reverseOrder());

        if (crane.get(0) < box.get(0)) {
            System.out.println(-1);
            return;
        }

        int ans = 0;

        int boxIdx = 0;
        while (boxIdx < M) {
            
            int craneIdx = 0;
            while (craneIdx < N) {

                if (boxIdx == box.size()) {
                    break;
                } else if (crane.get(craneIdx) >= box.get(boxIdx)) { //통과
                    boxIdx++;
                    craneIdx++;
                } else {
                    break;
                }
            }
            ans++;
        }

        System.out.println(ans);
    }

}
