package beakjoon.range_1000.BJ_2447;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static char[][] map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        recursive(0,0,N);
        print();

    }

    private static void print(){
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if(map[i][j] == '*'){
                    sb.append('*');
                }else{
                    sb.append(' ');
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }


    private static void recursive(int x, int y, int size) {

        if (size == 1){
            map[x][y] = '*';
            return;
        }

        int nextSize = size / 3;
        for (int i = x; i < x + size; i += nextSize) {
            for (int j = y; j < y + size; j += nextSize) {

                //중앙 안 함
                if(!(i == x+nextSize && j == y+nextSize)){
                    recursive(i, j, nextSize);
                }

            }
        }

    }

}
