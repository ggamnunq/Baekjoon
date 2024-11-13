package beakjoon.range_1000.BJ_7569;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    int x;
    int y;
    int z;

    Node(int z, int y, int x){
        this.z = z;
        this.y = y;
        this.x = x;
    }
}

public class Main {
    static int M; // 가로
    static int N; // 세로
    static int H; // 높이

    static int[] dx = { -1, 0, 1, 0, 0, 0 };
    static int[] dy = { 0, 1, 0, -1, 0, 0 };
    static int[] dz = { 0, 0, 0, 0, 1, -1 };

    static int[][][] map;
    static Queue<Node> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][M][N];
        queue = new LinkedList<>();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    if(map[i][j][k] == 1) {
                        queue.add(new Node(i, j, k));
                    }
                }
            }
        }
        System.out.println(bfs());
    }
    public static int bfs() {
        while(!queue.isEmpty()) {
            Node tmp = queue.poll();

            int z = tmp.z;
            int y = tmp.y;
            int x = tmp.x;

            for (int i = 0; i < 6; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];

                //옆,위아래 조회
                if (nx >= 0 && ny >= 0 && nz >= 0 && nx < N && ny < M && nz < H) {
                    if (Main.map[nz][ny][nx] == 0) {
                        queue.add(new Node(nz, ny, nx));
                        Main.map[nz][ny][nx] = Main.map[z][y][x] + 1;
                    }
                }
            }
        }

        int result = Integer.MIN_VALUE;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    if (map[i][j][k] == 0) return -1;
                    result = Math.max(result, map[i][j][k]);
                }
            }
        }

        return result - 1;
    }
}
