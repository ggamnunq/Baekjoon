package beakjoon.range_1000.BJ_4179;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
    int x;
    int y;
    char style;

    public Node(int x, int y, char style) {
        this.x = x;
        this.y = y;
        this.style = style;
    }
}

public class Main {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char [][]map;
    static boolean [][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        Queue<Node> queue = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'J') {
                    queue.offer(new Node(i, j, 'J'));
                    visited[i][j] = true;
                } else if (map[i][j] == 'F') {
                    queue.offer(new Node(i, j, 'F'));
                }
            }
        }

        int result = 0;

        //J에서 시작
        //다음꺼가 점(.)일 경우에만 이동 가능
        //만약 다음꺼가 범위 바깥이면 탈출
        while(!queue.isEmpty()) {

            Node temp = queue.poll();
            int x = temp.x;
            int y = temp.y;

            boolean canGo = false;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                //다음꺼가 벽이거나 불일 경우, 이미 방문한 경우 continue
                if(map[nx][ny]=='#'|| map[nx][ny] == 'F') {
                    continue;
                }
                //다음께 공백일 때, 유저면 탈출, 불이면 continue
                if(nx < 0 || ny < 0 || nx >= C || ny >= R) {
                    if(map[nx][ny]=='F') continue;
                    else if(map[nx][ny]=='J') {
                        System.out.println("정답");
                        return;
                    }
                }
                if (temp.style == 'J') {
                    canGo = true;
                }
                visited[nx][ny] = true;
                queue.offer(new Node(nx, ny, temp.style));
            }

            if (!canGo) {
                System.out.println("IMPOSSIBLE");
                return;
            }

            if (temp.style == 'J') {
                result++;
            }

        }
        System.out.println(result);
    }
}
