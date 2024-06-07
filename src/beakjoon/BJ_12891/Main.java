package beakjoon.BJ_12891;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        String pw=st.nextToken();
        char password[]= new char[S];
        for (int i = 0; i < S; i++) {
            password[i]=pw.charAt(i);
        }
        int A,C,G,T;

        st = new StringTokenizer(br.readLine());
        A=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());
        G=Integer.parseInt(st.nextToken());
        T=Integer.parseInt(st.nextToken());
        int answer=0;
        int A_2=0, C_2=0, G_2=0, T_2=0;

        for(int j=0;j<P;j++) {
            if (password[j]=='A')
                A_2++;
            else if(password[j]=='C')
                C_2++;
            else if(password[j]=='G')
                G_2++;
            else if(password[j]=='T')
                T_2++;
        }
        if(A_2>=A && C_2>=C && G_2>=G && T_2 >= T)
            answer++;
        for (int i = 1;i<=S-P; i++) {

            if (password[i-1]=='A')
                A_2--;
            else if(password[i-1]=='C')
                C_2--;
            else if(password[i-1]=='G')
                G_2--;
            else if(password[i-1]=='T')
                T_2--;

            if (password[i+P-1]=='A')
                A_2++;
            else if(password[i+P-1]=='C')
                C_2++;
            else if(password[i+P-1]=='G')
                G_2++;
            else if(password[i+P-1]=='T')
                T_2++;

            if(A_2>=A && C_2>=C && G_2>=G && T_2 >= T)
                answer++;

//			if(i+P==S)
//				break;
        }
        System.out.println(answer);
    }
}