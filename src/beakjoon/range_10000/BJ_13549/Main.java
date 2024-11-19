package beakjoon.range_10000.BJ_13549;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
    int x, time;

    Node(int x, int time){
        this.x = x;
        this.time = time;
    }
}

public class Main {

    static int K;
    static boolean[] visited;
    static int MAX = 100000;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[MAX+1];

        bfs(N);

        System.out.println(min);
    }

    static void bfs(int x){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, 0));
        visited[x] = true;

        while(!q.isEmpty()){

            Node now = q.poll();

            if(now.x == K)
                min = Math.min(min, now.time);

            if(now.x*2<=MAX && !visited[now.x*2]){
                q.offer(new Node(now.x*2, now.time));
                visited[now.x*2] = true;
            }

            if(now.x-1>=0 && !visited[now.x-1]){
                q.offer(new Node(now.x-1, now.time + 1));
                visited[now.x-1] = true;
            }

            if(now.x+1<=MAX && !visited[now.x+1]){
                q.offer(new Node(now.x+1, now.time + 1));
                visited[now.x+1] = true;
            }
        }
    }
}


