package beakjoon.range_1000.BJ_2170;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (map.containsKey(x)) {
                map.replace(x, Math.max(map.get(x), y));
            } else {
                map.put(x, y);
            }
        }

        List<Integer> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);

        int start = keySet.get(0);
        int now = map.get(start);
        long sum = now - start;
        for (int i=1; i < keySet.size(); i++) {

            start = keySet.get(i);
            if (map.get(start) <= now) {
                continue;
            }
            if (start <= now) {
                start = now;
            }

            now = map.get(keySet.get(i));
            sum += now - start;
        }
        System.out.println(sum);
    }
}
