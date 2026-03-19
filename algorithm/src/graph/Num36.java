package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Num36 {

    public static class Node{
        int dest, cost;

        public Node(int dest, int cost){
            this.dest = dest;
            this.cost = cost;
        }
    }

    public static int[] solution(int[][] graph, int start, int n){
        ArrayList<Node>[] adjList = new ArrayList[n]; // n??

        for(int i =0; i<n; i++){
            adjList[i] = new ArrayList<>();
        }

        for(int[] edge : graph){
            adjList[edge[0]].add(new Node(edge[1], edge[2]));
        }

        int[] dist = new int[n];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[start] =0;

        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) -> Integer.compare(o1.cost,o2.cost));

        pq.add(new Node(start, 0));  // 시작 출발점 대입

        while(!pq.isEmpty()){
            Node now = pq.poll();

            if(dist[now.dest] < now.cost) // max < 0
                continue;

            for(Node next : adjList[now.dest]){ // adjList[0] next.dest = 1 next.cost = 9

                if(dist[next.dest] > now.cost + next.cost){ // dist[1](max) >0+9 더 작은 값을 갱신해줘야함
                    dist[next.dest] = now.cost + next.cost; // dist[1] = 0+9
                    pq.add(new Node(next.dest, dist[next.dest])); // 1,9 를 노드에 추가
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        // 0: 출발 노드, 1: 도착 노드, 2: 가중치(비용)
        int[][] graph = {
                {0, 1, 9},
                {0, 2, 3},
                {1, 0, 5},
                {2, 1, 1}
        };
        int start = 0; // 시작 노드
        int n = 4;     // 노드 총 개수 (0, 1, 2, 3)

        int[] result = solution(graph, start, n);

        System.out.println("시작 노드 " + start + "로부터의 최단 거리:");
        for (int i = 0; i < result.length; i++) {
            System.out.println("노드 " + i + "까지의 거리: " + (result[i] == Integer.MAX_VALUE ? "INF" : result[i]));
        }
    }
}
