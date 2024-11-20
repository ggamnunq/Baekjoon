package beakjoon.range_1000.BJ_2630;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static int[] sum = {0, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursive(0,0,N);
        for (int i : sum) {
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }

    public static void recursive(int x, int y, int size) {

        if(check(x,y, size)){
            if(map[x][y] == 1){
                sum[1]++;
            }else{
                sum[0]++;
            }
            return;
        }

        int nextSize = size/2;
        for (int i = x; i <x+size; i+=nextSize) {
            for (int j = y; j < y+size; j+=nextSize) {
                recursive(i, j, nextSize);
            }
        }

    }

    public static boolean check(int x, int y, int size) {

        for (int i = x; i < x+size; i++) {
            for (int j = y; j < y+size; j++) {
                if (map[x][y] != map[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
