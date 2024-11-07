package beakjoon.range_1000.BJ_1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] map = new int[100001];
        boolean[] visited = new boolean[100001];
        int[] dx = {-1, 1, 2};

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        visited[N] = true;

        while (!queue.isEmpty()) {

            int tempPoint = queue.poll();

            for (int i = 0; i < 3; i++) {
                int nx;
                if (i < 2) {
                    nx = tempPoint + dx[i];
                }else{
                    nx = tempPoint * dx[i];
                }
                if(nx < 0 || nx > 100000 || visited[nx]) {
                    continue;
                }
                visited[nx] = true;
                queue.offer(nx);
                map[nx] = map[tempPoint] + 1;
            }
        }

        System.out.println(map[K]);
    }
}
