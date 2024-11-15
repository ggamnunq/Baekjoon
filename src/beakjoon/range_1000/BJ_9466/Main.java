package beakjoon.range_1000.BJ_9466;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


class Main {

    static int n;
    static int[] arr;
    static int count = 0;
    static boolean[] visited;
    static boolean[] checked;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {

            n = Integer.parseInt(br.readLine());
            arr = new int[n+1];
            visited = new boolean[n+1];
            checked = new boolean[n+1];
            count = 0;

            st = new StringTokenizer(br.readLine());
            for(int i=1; i<n+1; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            for (int i = 1; i < n + 1; i++) {
                dfs(i);
            }

            sb.append(n - count).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int now) {

        if(visited[now])
            return;

        visited[now] = true;
        int next = arr[now];

        //방문된 애들은 어차피 구하지 못하거나 이미 팀을 구한 애들임
        if(!visited[next])
            dfs(next);
        else {
            if(!checked[next]) {
                count++;
                for(int i=next; i != now; i = arr[i])
                    count++;
            }
        }

        checked[now] = true;
    }
}
