
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken()); //0부터 n까지, n+1개의 집합이 있음
		m = Integer.parseInt(st.nextToken()); //연산의 개수
		
		//집합 생성
		int[] p = new int[n+1];
		for (int i = 1; i < n+1; i++) {
			makeset(i, p);
		}
		
		//0 a b 합집합
		//1 a b 같은 집합인지 확인해서 YES / NO
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int order = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(order==0) {
				union(a, b, p);
			} else if(order==1) {
				if(findset(a, p) != findset(b, p)) {
					sb.append("NO"+"\n");
				} else {
					sb.append("YES"+"\n");
				}
			}
		}
		System.out.println(sb);
	}

	private static void union(int a, int b, int[] p) {
		p[findset(a, p)] = findset(b, p);
		
	}

	private static int findset(int a, int[] p) {
		if(a != p[a]) { //a의 대표가 a가 아니면
			p[a] = findset(p[a], p);
		}
		return p[a];
	}

	private static void makeset(int i, int[] p) {
		p[i] = i; //i의 대표는 i
	}
}