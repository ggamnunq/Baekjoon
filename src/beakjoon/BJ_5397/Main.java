package beakjoon.BJ_5397;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        while(T-->0){

            StringBuilder sb= new StringBuilder();

            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            int L = str.length();

            LinkedList<Character> linkedList = new LinkedList<>();
            int curs = 0;
            for (int i = 0; i < L; i++) {

                char c = str.charAt(i);

                if (('0' <= c && c <= '9') || ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z')) {
                    linkedList.add(curs, c);
                    curs++;
                }
                else if (c == '<' && curs > 0) {
                    curs--;

                } else if (c == '>' && curs < linkedList.size()) {
                    curs++;

                } else if (c == '-' && curs > 0) {
                    linkedList.remove(curs-1);
                    curs--;

                }

            }
            for(Character ch : linkedList){
                sb.append(ch);
            }
            System.out.println(sb.toString());
        }
    }
}
