package beakjoon.BJ_1138;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        List<Integer> arr = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<>();
        while(st.asIterator().hasNext()){
            stack.push(Integer.parseInt(st.nextToken()));
        }

        arr.add(N);
        stack.pop();

        for(int i=N-1 ; i>=1 ;i--) {
            int idx=0;
            int n = stack.pop();

            while( true ){

                if(n > 0){
                    n--;
                    idx++;

                } else if(n==0){ //n==0
                    arr.add(idx, i);
                    break;

                }
            }
        }
        for (int n : arr) {
            System.out.print(n + " ");
        }
    }

}
