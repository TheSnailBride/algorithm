package Stack;

import java.util.*;

public class truck {
    public int truck(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();

        // 1. 다리 길이만큼 0으로 채워서 초기화 (다리가 비어있음을 의미)
        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }

        int time = 0;
        int currentWeight = 0; // 현재 다리 위 트럭들의 총 무게
        int truckIdx = 0;      // 대기 중인 트럭의 인덱스

        // 2. 모든 트럭이 다리에 올라갈 때까지 반복
        while (truckIdx < truck_weights.length) {
            time++;

            // [빼기] 다리 맨 앞의 트럭(또는 0)을 무조건 제거
            currentWeight -= bridge.poll();

            // [넣기] 새 트럭이 들어올 수 있는지 체크
            if (currentWeight + truck_weights[truckIdx] <= weight) {
                // 들어올 수 있으면 트럭 무게 삽입
                bridge.offer(truck_weights[truckIdx]);
                currentWeight += truck_weights[truckIdx];
                truckIdx++;
            } else {
                // 못 들어오면 빈 공간(0) 삽입하여 다리 길이 유지
                bridge.offer(0);
            }
        }

        // 3. 마지막 트럭이 올라간 시점에서 반복문이 끝나므로, 다리 길이를 더해줌
        return time + bridge_length;
    }
}