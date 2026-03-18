package graph;

import java.util.ArrayList;
import java.util.Arrays;

public class num34 {
    private static ArrayList<Integer>[] adjList;

    private static boolean[] visted;
    private static ArrayList<Integer> answer;

    public static int[] solution(int[][] graph, int start, int n){
        adjList = new ArrayList[n+1];

        for (int i=0; i<adjList.length; i++){
            adjList[i] = new ArrayList<>(); //ArrayList<Integer>[] adjList = new ArrayList<>();
        }

        for(int [] edge : graph){
            adjList[edge[0]].add(edge[1]);

        }

        visted = new boolean[n+1];
        answer = new ArrayList<>();
        dfs(start);

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    private static void dfs(int now){
        visted[now] = true; //방문처리
        answer.add(now); // 결과 리스트 추가

        for(int next: adjList[now]){ //인접노드 방문
            if(!visted[next]){
                dfs(next); //
            }
        }

    }

    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        int start = 1;
        int n = 5;

        int[] output = solution(graph, start, n);
        System.out.println(Arrays.toString(output));
        // 결과: [1, 2, 3, 4, 5]
    }

}
