
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static LinkedList<Integer>[] adj;
    static int N, M;
    static int[] visited; //방문 안했으면 0, 했으면 순서

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sto = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(sto.nextToken()); //정점의 수
        M = Integer.parseInt(sto.nextToken()); //간선의 수
        int R = Integer.parseInt(sto.nextToken())-1; //시작 정점
        //R도 1 빼주는 거 잊지 말기!!!

        adj = new LinkedList[N];
        visited = new int[N];

        for (int i = 0; i < N; i++) {
            adj[i] = new LinkedList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            sto = new StringTokenizer(br.readLine(), " ");
            int st = Integer.parseInt(sto.nextToken())-1;
            int ed = Integer.parseInt(sto.nextToken())-1;
            adj[st].add(ed);
            adj[ed].add(st);
        }

        //오름차순으로 방문한다!!!
        for (int i = 0; i < N; i++) {
            Collections.sort(adj[i]);
        }

        DFS(R);
        for (int i : visited) {
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }

    static int cnt = 1;

    private static void DFS(int r) {
        visited[r] = cnt++;

        for (Integer i: adj[r]) {
            if(visited[i] == 0) {
                DFS(i);
            }
        }
    }
}