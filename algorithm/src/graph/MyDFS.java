package graph;

import java.util.*;



public class MyDFS {
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) {
        // 1. 테스트 데이터 준비
        int[][] graph = {{1, 2}, {1, 3}, {2, 4}, {2, 5}};
        int n = 5;
        int start = 1;

        // 2. 초기화 (이 부분을 직접 짜봐!)

        adj = new ArrayList[n+1];
        // adj 배열 생성 및 n+1개의 ArrayList 객체 생성

        for(int i=0; i< adj.length; i++){
            adj[i] = new ArrayList<>();
        }
        // 3. 간선 추가 (graph 배열의 데이터를 adj에 넣기)

        for(int[] edge : graph){
            adj[edge[0]].add(edge[1]);
        }
        visited = new boolean[n+1];

        // 4. DFS 실행 및 결과 출력
        dfs(start);
        System.out.println("결과: " + result);
    }

    static void dfs(int now) {
        visited[now] = true; //방문 체크
        result.add(now); // 방문 값
        for(int next : adj[now]){ // 노드의 간선
            if(!visited[next]){ //중복 체크
                dfs(next);
            }

        }


        //간선 방문

        // 5. 방문 처리 및 재귀 로직 구현
    }
}