import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {


        Solution sol = new Solution();

        // 2. 테스트 데이터 준비 (배열 선언)
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {
                "chicken", "apple", "apple", "banana", "rice",
                "apple", "pork", "banana", "pork", "rice",
                "pot", "banana", "apple", "banana"
        };

        // 3. 메서드 호출 및 결과 출력
        int result = sol.solution(want, number, discount);
        System.out.println("결과: " + result);    }

    static class Solution {
        public int solution(String[] want, int[] number, String[] discount) {
            int answer = 0;
            HashMap<String, Integer> hashmap1 = new HashMap<>();

            for(int i=0; i<want.length; i++){
                hashmap1.put(want[i], number[i]); //map에는 과일과 개수
            }
            int start =0;

            while(start <= discount.length-10){
                HashMap<String, Integer> hashmap2 = new HashMap<>();
                for(int i=start; i<start+10; i++){

                    if(hashmap2.containsKey(discount[i])){
                        int num = hashmap2.get(discount[i]) +1;
                        hashmap2.put(discount[i], num);
                    }else{
                        hashmap2.put(discount[i], 1);
                    }
                }
                start++;
                if(hashmap1.equals(hashmap2)) answer ++;
            }
            return answer;
        }

    }
}
