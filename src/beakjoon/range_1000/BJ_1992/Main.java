package beakjoon.range_1000.BJ_1992;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int [][] map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
        recursive(0, 0, N);
        System.out.println(sb);
    }

    public static void recursive(int x, int y, int size) {
        if(check(x,y,size)) {
            if(map[x][y]==0) {
                sb.append(0);
            }else{
                sb.append(1);
            }
            return;
        }

        int nextSize = size/2;
        sb.append("(");
        for (int i = x; i < x + size; i+=nextSize) {
            for (int j = y; j < y + size; j+=nextSize) {
                recursive(i, j, nextSize);
            }
        }
        sb.append(")");
    }

    public static boolean check(int x, int y, int size){
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if(map[x][y] != map[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}
