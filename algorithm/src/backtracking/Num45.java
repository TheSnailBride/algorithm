package backtracking;

public class Num45 {

    private static int answer ;
    private static boolean[] visited;
    private static int[][] Dungeons;

        //backtracking

        private static void backtracking (int k, int cnt){

            for(int i=0; i<Dungeons.length; i++){
                if(!visited[i] && k >= Dungeons[i][0]){
                    visited[i] = true;

                    backtracking(k - Dungeons[i][1], cnt+1); // 방문 후에 피로도 깍이고, 횟수 추가
                    answer = Math.max(answer, cnt+1);
                    visited[i] = false;
                }
            }
            //처음에 들어갈때 k 가 dungeons[0][0] 보다 커야함 작으면 끝 return
            //들어간 후에 k - dungeons[0][1]
            //뺀 값을 다음 순서에 넘김
            //순서를 정해야함

        }

        public int solution(int k , int[][] dungeons){
            answer =0;
            Dungeons = dungeons;

            visited = new boolean[dungeons.length];

            backtracking(k,0);

            return answer;
        }

    public static void main(String[] args) {
        Num45 sol = new Num45(); // 객체 생성

        int k = 80;
        int[][] dungeons = {
                {80, 20},
                {50, 40},
                {30, 10}
        };

        int result = sol.solution(k, dungeons);

        System.out.println("최대 탐험 가능 던전 수: " + result);
    }
}
