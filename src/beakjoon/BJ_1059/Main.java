package beakjoon.BJ_1059;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int L = Integer.parseInt(st.nextToken());
        int[] arr = new int[L];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < L; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        int a = arr[0];
        int b = arr[L-1];

        for(int i = 0 ; i < L ; i++) {
            if(arr[i] <= n && arr[i] > a)
                a = arr[i];
            if(arr[i] >= n && arr[i] < b)
                b = arr[i];{
            }
        }

        int result = 0;
        if(n < a){
            if(n == 1 || n== a-1){
                result = a - 2;
            }
            else{
                result = a - 2;
                result += (n-2) * ((n-1)*(a-(n+1)));
            }
        }
        else if(n < b){
            if(n == a+1 || n == b-1){
                result = b - a - 2;
            }
            else{
                result = b - a - 2;
                result += ((n - (a + 1)) * (b - (n + 1)));
            }
        }
        System.out.println(result);
    }

}
