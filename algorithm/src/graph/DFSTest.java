package graph;

import java.util.*;

public class DFSTest {
    // 방문 여부를 체크할 배열
    static boolean[] visited;
    // 그래프를 표현할 인접 리스트
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) {
        int n = 5; // 노드 개수
        adj = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        // 그래프 간선 연결 (예시)
        adj[1].add(2); adj[1].add(3);
        adj[2].add(4); adj[2].add(5);

        System.out.print("DFS 탐색 순서: ");
        dfs(1);
    }

    static void dfs(int now) {
        // 1. 현재 노드 방문 처리
        visited[now] = true;
        System.out.print(now + " ");

        // 2. 연결된 인접 노드 확인
        for (int next : adj[now]) {
            // 3. 아직 방문하지 않은 노드라면 재귀 호출
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}