package beakjoon.range_1000.BJ_1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int [][]map;
    static boolean [][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {

            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            map = new int[M][N];
            visited = new boolean[M][N];
            Queue<Node> queue = new LinkedList<>();
            int count = 0;

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    // 배추가 있고, 방문되지 않았다면 count 1 증가 후 BFS
                    if (map[i][j] == 1 && !visited[i][j]) {
                        count++;
                        // BFS
                        queue.add(new Node(i, j));
                        visited[i][j] = true;

                        while (!queue.isEmpty()) {
                            Node tmp = queue.poll();
                            int x = tmp.x;
                            int y = tmp.y;

                            for (int k = 0; k < 4; k++) {
                                int nx = x + dx[k];
                                int ny = y + dy[k];
                                if(nx >= 0 && nx < M && ny >= 0 && ny < N && !visited[nx][ny] && map[nx][ny] == 1) {
                                    queue.add(new Node(nx, ny));
                                    visited[nx][ny] = true;
                                }
                            }
                        }

                    }

                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb.toString());

    }
}
