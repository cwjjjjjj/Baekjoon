
import java.util.Scanner;

public class Main {
	static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int V = sc.nextInt();
		int E = sc.nextInt();
		
		int[][] adjArr = new int[V][V];
		for (int i = 0; i < E; i++) {
			int A = sc.nextInt()-1; //인덱스 0번부터 쓸 건데 컴퓨터 번호 1부터 들어오니까 1씩 빼주기!
			int B = sc.nextInt()-1;
			int W = sc.nextInt();
			
			adjArr[A][B] = W;
			adjArr[B][A] = W;
		}
		
		boolean[] visited = new boolean[V];
		
		int[] p = new int[V];
		int[] dist = new int[V];
		
		for (int i = 0; i < V; i++) {
			p[i] = -1;
			dist[i] = INF;
		}
		
		dist[0] = 0;
		int ans = 0;
		
		for (int i = 0; i < V; i++) {
			int min = INF;
			int idx = -1;
			for (int j = 0; j < V; j++) {
				if(!visited[j] && dist[j] < min) {
					min = dist[j];
					idx = j;
				}
			}
			visited[idx] = true;
			ans += dist[idx];
			
			for (int j = 0; j < V; j++) {
				if(!visited[j] && adjArr[idx][j] != 0 && dist[j] > adjArr[idx][j]) {
					dist[j] = adjArr[idx][j];
					p[j] = idx;
				}
			}
		}
		System.out.println(ans);
	}
}