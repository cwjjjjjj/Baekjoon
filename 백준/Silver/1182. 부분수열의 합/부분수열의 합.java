
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int N = sc.nextInt(); //주어진 정수의 개수
	static int S = sc.nextInt(); //다 더한 값이 S
	static int ans;
	static int[] arr = new int[N]; //전체 수열
	static boolean[] visited = new boolean[N]; //방문체크
	
	public static void main(String[] args) {
		ans = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		powerset(0);
		System.out.println(ans);
	}

	private static void powerset(int i) {
		//기저파트
		if(i == N) { //수열의 N개의 수를 넣을지 말지 모두 판단했으면
			int sum = 0; //합이 S면 ans++;
			boolean allFalse = true; //부분수열의 크기가 0을 초과해야 함
			for (int j = 0; j < N; j++) {
				if(visited[j]) { //방문했으면
					sum += arr[j]; //합에 포함
					allFalse = false;
				}
			}
			if(sum == S && !allFalse) {
				ans++;
			}
			return;
		}
		
		//재귀파트
		visited[i] = false; //안 넣는 경우
		powerset(i+1);
		visited[i] = true; //넣는 경우
		powerset(i+1);
	}
}