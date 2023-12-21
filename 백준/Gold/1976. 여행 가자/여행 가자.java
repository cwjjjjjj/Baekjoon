
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int[] p;
	static int N, M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //도시의 개수
		M = sc.nextInt(); //여행할 도시
		p = new int[N];
		
		for (int i = 0; i < N; i++) {
			makeSet(i);
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int order = sc.nextInt();
				if(order == 1) {
					union(i, j);
				}
			}
		}
		int[] dest = new int[M];
		for (int i = 0; i < M; i++) {
			dest[i] = sc.nextInt()-1;
		}
		
		boolean check = true;
		int tmp = findSet(dest[0]);
		for (int i = 1; i < M; i++) {
			if(findSet(dest[i]) != tmp) {
				check = false;
			}
		}
		
		if(check) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
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