package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class Num15 {
    public static void main(String[] args) {
        Deque<Integer> queue = new ArrayDeque<>();

        int K =2 ; // k=2 1+1;
        int N =5 ;

        for(int i=1; i<=N; i++){
            queue.add(i);
        }

        while(queue.size() >1 ){
            int search = K-1;

            for(int i=0; i<search; i++){
                queue.add(queue.poll());

            }
            queue.poll();
        }
        System.out.println(queue.poll());

    }
}
