package beakjoon.range_10000.BJ_10799;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();

        //레이저 발사 시기의 쇠막대의 수 = 스택에 남아있는
        // '('를 입력했을 때 조각 하나 추가 ( sum+=1 )...근데 괄호 닫으면 sum 하나 줄임
        // -> 왜냐. 닫는괄호랑 만나는 열린괄호는 쇠막대기의 시작이 아닌 레이저 가리키기 때문
        // 레이저 발사 시 stickCount만큼 sum 증가
        // 그리고 스택에 요소 push

        int sum = 0; // 조각 개수
        int stickCount = 0; //현재 스틱 개수
        String input = br.readLine();
        for (char c : input.toCharArray()) {

            if (c == '(') {
                sum++;
                stickCount++;
            }
            else{
                stickCount--;
                if(stack.peek() == '('){//레이저 발사
                    sum += stickCount; //스틱 개수만큼 증
                    sum--; // 짝 맞는 (는 스틱이 아니라 레이저임
                }
            }
            stack.push(c);
        }
        System.out.println(sum);
    }
}
