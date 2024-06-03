package beakjoon.BJ_1059;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer( br.readLine() );

        int L = Integer.parseInt(st.nextToken());    // Lucky Set에 포함된 숫자의 개수
        int[] arr = new int[L];				      // Lucky Set에 포함된 숫자만큼 배열 할당
        st = new StringTokenizer( br.readLine() );
        for(int i = 0 ; i < L ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());  // Lucky Set 데이터 입력
        }
        st = new StringTokenizer( br.readLine() );
        int N = Integer.parseInt(st.nextToken());     // 포함되어야하는 숫자 입력
        Arrays.sort(arr);							   // Lucky Set 데이터 정렬
        int a = arr[0], b = arr[L-1], count = 0;      // Lucky Set 데이터 최솟값, 최댓값 저장

        for(int i = 0 ; i < L ; i++) {				   // 포함되어야하는 숫자와 인접한 최솟값 최댓값 찾아 저장
            if(arr[i] <= N && arr[i] > a)
                a = arr[i];
            if(arr[i] >= N && arr[i] < b)
                b = arr[i];
        }
        if(N<a) {									   // 2가지 경우의 수 존재 N이 Lucky Set 데이터 최솟값 보다 앞에 있는 경우
            if(N == 1 || N == a-1) {
                count = a - 2;
            }
            else {
                count = a - 2;
                count = count + ((N-1)*(a-(N+1)));
            }
        }
        else if (N<b) {							   // N이 Lucky Set 데이터들 사이에 있는 경우
            if(N == a+1 || N == b-1) {
                count = b - a - 2;
            }
            else {
                count = b - a - 2;
                count = count + ((N-(a+1))*(b-(N+1)));
            }
        }
        System.out.println(count);
    }
}