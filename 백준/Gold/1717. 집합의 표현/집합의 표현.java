
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	//초기에 n+1개의 집합(0~n) 존재 - 합집합 연산 / 두 원소가 같은 집합인지 
	//m개의 연산 주어짐 - 0: 합집합 / 1: 같은 집합인지 확인
	//같은 집합이면 YES, 아니면 NO
	static int n, m;
	static int[] p;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		
		p = new int[n+1];
		//집합 생성
		for (int i = 0; i <= n; i++) {
			makeSet(i);
		}
		
		//명령어 m개 주어짐
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int order = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(order == 0) {
				union(a, b);
			} else {
				if (findSet(a) == findSet(b)) {
					sb.append("YES").append("\n");
				} else {
					sb.append("NO").append("\n");					
				}
			}
		}
		System.out.println(sb);
	}

	private static void makeSet(int i) {
		p[i] = i;
	}

	private static int findSet(int a) {
		if(a != p[a]) {
			p[a] = findSet(p[a]);
		}
		return p[a];
	}

	private static void union(int a, int b) {
		p[findSet(a)] = findSet(b);
	}
}