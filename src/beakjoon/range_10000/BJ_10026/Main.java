package beakjoon.range_10000.BJ_10026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Node{
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int N;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char [][]map;
    static boolean [][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        sb.append(bfs(false)).append(" ");
        sb.append(bfs(true));
        System.out.println(sb);
    }

    public static int bfs(boolean isBlind) {

        visited = new boolean[N][N];
        Queue<Node> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j]) {
                    continue;
                }

                queue.add(new Node(i, j));
                visited[i][j] = true;
                count++;

                while (!queue.isEmpty()) {
                    Node tmp = queue.poll();
                    int x = tmp.x;
                    int y = tmp.y;

                    for (int k = 0; k < 4; k++) {
                        int nx = x + dx[k];
                        int ny = y + dy[k];
                        //범위 안에 있고 방문하지 않았을 경우
                        if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                            //색맹일 경우 (현재 블록과 다음 블록이 R 또는 G일 경우), (현재 블록과 다음 블록 모두 B일 경우) 이 때 bfs 계속 진행
                            if (isBlind) {
                                if (((map[x][y] == 'R' || map[x][y] == 'G') && (map[nx][ny] == 'R' || map[nx][ny] == 'G')) || (map[x][y] == map[nx][ny])) {
                                    queue.add(new Node(nx, ny));
                                    visited[nx][ny] = true;
                                }
                            }else{
                                if(map[x][y] == map[nx][ny]){
                                    queue.add(new Node(nx, ny));
                                    visited[nx][ny] = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
