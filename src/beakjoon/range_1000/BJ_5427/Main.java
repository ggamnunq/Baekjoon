package beakjoon.range_1000.BJ_5427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
    int x;
    int y;
    int time;

    public Node(int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }
}

public class Main {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char [][]map;
    static int [][] fireMap;
    static int h;
    static int w;
    static Queue<Node> personQueue;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            map = new char[w][h];
            fireMap = new int[w][h];
            Queue<Node> fireQueue = new LinkedList<>();
            personQueue = new LinkedList<>();

            //입력
            for (int i = 0; i < w; i++) {
                String line = br.readLine();
                for (int j = 0; j < h; j++) {
                    map[i][j] = line.charAt(j);
                    fireMap[i][j] = -1;
                    if(map[i][j] == '@') {
                        personQueue.add(new Node(i, j, 0));
                    }else if(map[i][j] == '*') {
                        fireQueue.add(new Node(i, j, 0));
                        fireMap[i][j] = 0;
                    }

                }
            }

            //fire BFS
            while(!fireQueue.isEmpty()) {

                Node tmp = fireQueue.poll();
                int x = tmp.x;
                int y = tmp.y;
                for (int i = 0; i < 4; i++) {

                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx >= 0 && ny >= 0 && nx < w && ny < h && map[nx][ny] == '.' && fireMap[nx][ny] == -1) {
                        fireMap[nx][ny] = tmp.time + 1;
                        fireQueue.add(new Node(nx, ny, tmp.time + 1));
                    }
                }

            }

            //person BFS
            int escape = escapeBFS();
            if (escape == -1) {
                sb.append("IMPOSSIBLE\n");
            } else {
                sb.append(escape).append("\n");
            }

        }
        System.out.print(sb);
    }

    public static int escapeBFS(){

        while(!personQueue.isEmpty()) {

            Node tmp = personQueue.poll();
            int x = tmp.x;
            int y = tmp.y;
            for (int i = 0; i < 4; i++) {

                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny <0 || nx >= w || ny >= h) {
                    return tmp.time+1;
                }else if(map[nx][ny] == '.' && (fireMap[nx][ny] == -1 || fireMap[nx][ny] > tmp.time + 1)) {
                    map[nx][ny] = '@'; // 방문 처리
                    personQueue.add(new Node(nx, ny, tmp.time + 1));
                }

            }

        }
        return -1;
    }

}
