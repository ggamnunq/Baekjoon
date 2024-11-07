package beakjoon.range_1000.BJ_1926.BFS;

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
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        Queue<Node> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0 ;
        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 0 || visited[i][j]) continue;
                visited[i][j] = true;
                count++;
                queue.add(new Node(i, j));
                int area = 0;
                while(!queue.isEmpty()) {

                    area++;
                    Node temp = queue.poll();
                    int x = temp.x;
                    int y = temp.y;

                    for (int z = 0; z < 4; z++) {
                        int nx = x + dx[z];
                        int ny = y + dy[z];
                        if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny] || map[nx][ny] != 1) {
                            continue;
                        }
                        visited[nx][ny] = true;
                        queue.offer(new Node(nx, ny));
                    }

                }
                max = Math.max(max, area);
            }
        }
        System.out.println(count);
        System.out.println(max);

    }
}

