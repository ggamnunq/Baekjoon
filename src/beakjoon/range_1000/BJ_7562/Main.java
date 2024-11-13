package beakjoon.range_1000.BJ_7562;

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

    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {1, -1, 2, -2, 2, -2, 1, -1};
    static int [][]map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {

            int I = Integer.parseInt(br.readLine());
            map = new int[I][I];
            Queue<Node> queue = new LinkedList<>();

            //시작점
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            //목적지
            st = new StringTokenizer(br.readLine());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            queue.add(new Node(startX, startY));

            //bfs
            while(!queue.isEmpty()) {

                Node tmp = queue.poll();
                int x = tmp.x;
                int y = tmp.y;

                if(x == endX && y == endY) {
                    break;
                }

                for (int i = 0; i < 8; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if(nx >= 0 && nx < I && ny >= 0 && ny < I && map[nx][ny] == 0) {
                        queue.add(new Node(nx, ny));
                        map[nx][ny] = map[x][y] + 1;
                    }
                }

            }
            sb.append(map[endX][endY]).append("\n");
        }
        System.out.print(sb);
    }

}
