package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class num35 {
    private static ArrayList<Integer>[] adjList;

    private static boolean[] visited;

    private static ArrayList<Integer> answer;

    private static int[] solution(int[][] graph, int start, int n){
        adjList = new ArrayList[n+1];

        for(int i=0; i<adjList.length; i++){
            adjList[i] = new ArrayList<>();
        }

        for(int edge[]: graph){
            adjList[edge[0]].add(edge[1]);
        }
        visited = new boolean[n+1];
        answer = new ArrayList<>();

        bfs(start);

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private static void bfs(int start){
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int now = queue.poll();
            answer.add(now);

            for(int next : adjList[now]){
                if(!visited[next]){
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 6}};
        int start = 1;
        int n = 6;



        int[] result = solution(graph, start, n);
        System.out.println(java.util.Arrays.toString(result));
        // 예상 결과: [1, 2, 3, 4, 5, 6]
    }
}
