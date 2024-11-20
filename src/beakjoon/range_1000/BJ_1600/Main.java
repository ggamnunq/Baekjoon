package beakjoon.range_1000.BJ_1600;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    int x, y;
    int horseCount;//말 점프 횟수
    int count;//움직인 횟수

    Node(int x, int y, int horseCount, int count){
        this.x = x;
        this.y = y;
        this.horseCount = horseCount;
        this.count = count;
    }
}

public class Main {

    static int W, H, K;

    static int[][] map;
    static boolean[][][] visited;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[] hx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] hy = {-2, -1, 1, 2, 2, 1, -1, -2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        visited = new boolean[H][W][K + 1];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = bfs(0, 0, K);

        System.out.println(ans);
    }

    static int bfs(int x, int y, int k) {
        Queue<Node> que = new LinkedList<>();

        que.add(new Node(x, y, 0, 0));
        visited[x][y][0] = true;

        while (!que.isEmpty()) {
            Node p = que.poll();

            int curX = p.x;
            int curY = p.y;

            // 목적지에 도착
            if (curX == H - 1 && curY == W - 1) {
                return p.count;
            }
            // 원숭이 이동
            for (int t = 0; t < 4; t++) {

                int nx = curX + dx[t];
                int ny = curY + dy[t];

                if (nx < 0 || ny < 0 || nx >= H || ny >= W) continue;
                if (visited[nx][ny][p.horseCount]) continue;

                if (map[nx][ny] == 0) {
                    visited[nx][ny][p.horseCount] = true;
                    que.add(new Node(nx, ny, p.horseCount, p.count + 1));
                }
            }
            // 말 이동
            if (p.horseCount < k) {
                for (int t = 0; t < 8; t++) {

                    int nx = curX + hx[t];
                    int ny = curY + hy[t];

                    if (nx < 0 || ny < 0 || nx >= H || ny >= W) continue;
                    if (visited[nx][ny][p.horseCount + 1]) continue;

                    if (map[nx][ny] == 0) {
                        visited[nx][ny][p.horseCount + 1] = true;
                        que.add(new Node(nx, ny, p.horseCount + 1, p.count + 1));
                    }
                }
            }


        }

        return -1;
    }

}