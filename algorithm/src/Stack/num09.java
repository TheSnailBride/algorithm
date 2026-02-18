package Stack;

import java.util.Stack;

public class num09 {
    public static String Solution(int n){


        String result =""; // 초기화 할때
        Stack<Integer> stack = new Stack<>();

        while(n>0){
            stack.push(n%2); // 나머지 넣기
            n = n/2; // n 초기화

        }
        while(!stack.isEmpty()){
            result += stack.pop();
        }


        return result;
    }
    public static void main(String[] args) {
        System.out.println(Solution(10));
        System.out.println(Solution(27));
        System.out.println(Solution(12345));

    }

}
