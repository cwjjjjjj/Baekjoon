
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M; //정점의 개수 N, 간선의 개수 M
    static int[][] adj;
    static boolean[] visited;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); //이거 받을 때 절대 int N 으로 하지말기... 그냥 N으로!!
        M = Integer.parseInt(st.nextToken());
        adj = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int sta = Integer.parseInt(st.nextToken())-1; //0번 인덱스부터 쓰고 싶으니까 1 빼주기
            int end = Integer.parseInt(st.nextToken())-1;
            adj[sta][end] = adj[end][sta] = 1;
        }
        
        int cnt = 1;
        BFS(0); //일단 첫 인덱스에서 한 번 돌고

        for(int i = 1; i < N; i++) { //방문 안 된(=첫 인덱스와 다른 집합인) 곳 발견하면 BFS 호출 반복
            if(!visited[i]) {
                BFS(i);
                cnt++; //호출하는 횟수를 카운팅하는 것과 같음
            }
        }
        System.out.println(cnt);
    } //main

    private static void BFS(int i) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        visited[i] = true;

        while(!q.isEmpty()) {
            int curr = q.poll(); //제일 앞에 거 하나 빼서 현재 위치로 삼기
            for(int j = 0; j < N; j++) {
                if(!visited[j] && adj[curr][j]==1) { //방문한 적 없고 길도 있으면
                    q.add(j);
                    visited[j] = true;
                }
            }
        }
    }
} //class
