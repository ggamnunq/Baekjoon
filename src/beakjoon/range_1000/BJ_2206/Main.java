package beakjoon.range_1000.BJ_2206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    int x;
    int y;
    boolean canBreak;
    int count;

    public Node(int x, int y, boolean canBreak, int count) {
        this.x = x;
        this.y = y;
        this.canBreak = canBreak;
        this.count = count;
    }
}

public class Main {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1][2]; // 이전에 벽을 부수고 지점을 방문했을 때와 부수지 않고 방문헀을 때를 구분

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(1, 1, true, 1));
        visited[1][1][1] = true; // 시작점 방문 체크

        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            for (int j = 1; j <= M; j++) {
                map[i][j] = line.charAt(j - 1) - '0';
            }
        }

        int result = -1;
        while (!queue.isEmpty()) {

            Node tmp = queue.poll();
            int x = tmp.x;
            int y = tmp.y;
            boolean canBreak = tmp.canBreak;
            int count = tmp.count;

            if (x == N && y == M) {
                result = count;
                break;
            }

            for (int i = 0; i < 4; i++) {

                int nx = x + dx[i];
                int ny = y + dy[i];
                int canBreakInt = canBreak ? 1 : 0;

                if (nx >= 1 && ny >= 1 && nx <= N && ny <= M) {

                    if (canBreak && map[nx][ny] == 1 && !visited[nx][ny][0]) {
                        queue.add(new Node(nx, ny, false, count + 1));
                        visited[nx][ny][0] = true;
                    } else if (map[nx][ny] == 0 && !visited[nx][ny][canBreakInt]) {
                        queue.add(new Node(nx, ny, canBreak, count + 1));
                        visited[nx][ny][canBreakInt] = true;
                    }
                }
            }
        }

        System.out.println(result);
    }
}
