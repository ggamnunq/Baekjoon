package beakjoon.range_1000.BJ_1780;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] sum = {0,0,0};
    static int[][] map = new int[N][N];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursive(0,0, N);
        for (int i : sum) {
            sb.append(i).append("\n");
        }
        System.out.print(sb);
    }

    public static void recursive(int r, int c, int size){

        if (check(r, c, size)) {
            if (map[r][c] == -1) {
                sum[0]++;
            }else if(map[r][c] == 0){
                sum[1]++;
            }else{
                sum[2]++;
            }
            return;
        }

        int nextSize = size / 3;
        for (int i = r; i < r+size; i+=nextSize){
            for (int j = c; j < c+size; j+=nextSize) {
                recursive(i, j, nextSize);
            }
        }

    }

    public static boolean check(int r, int c, int size){
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if(map[r][c] != map[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}
