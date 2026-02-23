package Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class num13 {
    public static void main(String[] args) {
        int[][] array = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}
        };

        List<Stack<Integer>> multiStack = new ArrayList<>();


        Stack<Integer> result = new Stack<>();

        int M = array[0].length;
        int N = array.length ;
        for(int i=0; i<M; i++){ //M 의 길이
            multiStack.add(new Stack<Integer>()); //stack 생성
        }
        int result_num =0;

        for(int i = 0; i<N; i++){
            for(int j = 0; j<M ; j++){
                int num = array[i][j];
                if(num > 0 ){
                    if(result.isEmpty()) {
                        result.add(num);
                        System.out.println(num);
                    }else if(result.peek() == num){
                        result.pop();
                        result_num+=2;
                    }else{
                        result.add(num);
                    }
                }
                array[i][j] =0;
            }
        }

        System.out.println(result_num);



    }
}
