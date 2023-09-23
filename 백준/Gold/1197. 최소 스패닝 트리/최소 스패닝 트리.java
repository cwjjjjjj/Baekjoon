
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	
	static final int INF = Integer.MAX_VALUE;
	
	//내가 만든 클래스 이용해서 우선순위큐 활용하려면 정렬기준이 필요함
	static class Edge implements Comparable<Edge> {
		int st, ed, w;

		public Edge(int st, int ed, int w) {
			super();
			this.st = st;
			this.ed = ed;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int V = sc.nextInt(); //정점의 개수
		int E = sc.nextInt(); //간선의 개수
		
		//인접리스트
		List<Edge>[] adjList = new ArrayList[V];
		
		//리스트 생성
		for (int i = 0; i < V; i++) {
			adjList[i] = new ArrayList<>();
		}
	
		for(int i = 0; i < E; i++) {
			int A = sc.nextInt()-1; //시작 정점. 정점 번호는 1부터 들어오는데 인덱스 0부터 만들고 싶으니까 1 빼주기
			int B = sc.nextInt()-1; //끝 정점
			int W = sc.nextInt(); //가중치
			
			adjList[A].add(new Edge(A, B, W));
			adjList[B].add(new Edge(B, A, W));
		}
		
		//방문처리
		boolean[] visited = new boolean[V];
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		//시작 정점 하나 뽑아 넣어놓고 시작
		visited[0] = true;
		
		//정점 하나 뽑아서 해당 정점의 모든 간선 큐에 넣기
		for (Edge e : adjList[0]) {
			pq.add(e);
		}
		
		int pick = 1;
		int ans = 0;
		
		while(pick != V) {
			Edge e = pq.poll();
			
			if(visited[e.ed]) continue;
			ans += e.w;
			pq.addAll(adjList[e.ed]);
			visited[e.ed] = true;
			pick++;
		}
		System.out.println(ans);
	}
}