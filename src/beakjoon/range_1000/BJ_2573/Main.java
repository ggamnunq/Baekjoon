package beakjoon.range_1000.BJ_2573;

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

    static int N, M;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static int[][] nextMap;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        while (true) {

            nextMap = new int[N][M];
            result++;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {

                    if(map[i][j] > 0){
                        int count = 0;
                        for (int k = 0; k < 4; k++) {
                            int nx = i + dx[k];
                            int ny = j + dy[k];
                            if(map[nx][ny] == 0){
                                count++;
                            }
                        }
                        //빙산 높이 감소 ( 0보다 작아지는걸 방지 )
                        nextMap[i][j] = Math.max(0, map[i][j] - count);
                    }
                }
            }
            map = nextMap;

            visited = new boolean[N][M];
            int count = 0;
            //빙산 개수 구함
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(map[i][j] > 0 && !visited[i][j]){
                        bfs(i,j);
                        count++;
                    }
                }
            }

            if (count == 0) {
                System.out.println(0);
                break;
            }else if(count > 1){
                System.out.println(result);
                break;
            }

        }
    }

    private static void bfs(int x, int y){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y));
        visited[x][y] = true;

        while(!queue.isEmpty()){

            Node tmp = queue.poll();
            int cx = tmp.x;
            int cy = tmp.y;
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] > 0 && !visited[nx][ny]){
                    queue.add(new Node(nx, ny));
                    visited[nx][ny] = true;
                }
            }

        }
    }

}
