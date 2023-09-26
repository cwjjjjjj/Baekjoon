

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.zip.InflaterInputStream;
public class Main {

	static boolean[] visited;
	static int N; // 정점 번호는 1부터 N
	static int[][] adj;
	static StringBuilder sb = new StringBuilder();
	static Queue<Integer> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 정점의 개수
		int M = Integer.parseInt(st.nextToken()); // 간선의 개수
		int V = Integer.parseInt(st.nextToken()); // 탐색을 시작할 정점 번호
		visited = new boolean[N+1]; //어느 정점 방문했는지 처리
		adj = new int[N + 1][N + 1]; // 정점 1부터 시작하므로 0번 인덱스 사용하지 않음

		for (int i = 0; i < M; i++) { // M개의 줄에 간선 정보 주어짐
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			adj[start][end] = adj[end][start] = 1; // 무향그래프
		}
		DFS(V);
		visited = new boolean[N+1]; //한 번 썼으니까 초기화해주기!
		sb.append("\n");
		BFS(V);
		System.out.println(sb);
	}

	private static void DFS(int v) {
		// v에 대해 방문처리
		visited[v] = true;
		sb.append(v).append(" ");

		// 방문하지 않았으면서 간선이 존재한다면 재귀호출
		for (int i = 1; i < N+1; i++) {
			if (!visited[i] && adj[v][i] == 1) {
				DFS(i);
			}
		}
	}
	
	private static void BFS(int v) {
		queue.add(v); //시작정점을 큐에 넣음
		visited[v] = true; //방문처리
		
		while(!queue.isEmpty()) {
			int t = queue.poll(); //현재 내 정점
			sb.append(t).append(" ");
			
			for (int i = 1; i < N+1; i++) {
				if(!visited[i] && adj[t][i] == 1) {
					queue.add(i); //큐에 넣고 방문처리
					visited[i] = true;
				}
			}
		}
	}
}