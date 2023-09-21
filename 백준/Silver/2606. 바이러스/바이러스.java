
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
	
	static int[] p; //대표 저장할 배열
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt(); //정점(컴퓨터)의 개수
		int E = sc.nextInt(); //간선의 개수
		
		//간선 배열
		int[][] edges = new int[E][2];
		
		for (int i = 0; i < E; i++) {
			edges[i][0] = sc.nextInt(); //시작 정점
			edges[i][1] = sc.nextInt(); //끝 정점
		}
		
		p = new int[V+1];
		//make-set
		for (int i = 1; i <= V; i++) {
			p[i] = i;
		}
//		System.out.println(Arrays.toString(p));
		
		//간선을 모두 union
		for (int i = 0; i < E; i++) {
//			if(edges[][]) {
//				union(edges[i][1], edges[i][0]);
//			} else {
				union(edges[i][0], edges[i][1]);
//			}
//			System.out.println(Arrays.toString(p));
		}
		
		int cnt = 0;
		//find-set으로 동일 집합인지 검사
		for (int i = 1; i < V+1; i++) {
			if(findset(i) == findset(1)) {
				cnt++;
			}
		}
		if(cnt==1) {
			System.out.println(0);
		} else {
		System.out.println(cnt-1); //1번은 제외하고 뽑아야 함
		}
	}
	
	static void union(int x, int y) {
//		p[y] = x;
		if(x > y) { //더 작은 값이 부모가 된다
			p[findset(y)] = findset(x);
		} else {
			p[findset(x)] = findset(y);
		}
	}
	
	static int findset(int x) { 
//		if(x != p[x]) {
//			p[x] = findset(p[x]);
//		}
//		return p[x];
		if(x==p[x]) return x;
		return findset(p[x]);
	}
	
}