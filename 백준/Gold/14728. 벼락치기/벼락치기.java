
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //단원 개수
		int T = sc.nextInt(); //공부 가능 시간
		
		int[] chapter = new int[N+1];
		int[] score = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			chapter[i] = sc.nextInt();
			score[i] = sc.nextInt();
		}
		
		int[][] dp = new int[N+1][T+1];
		for (int i = 1; i <= N; i++) {
			for (int t = 0; t <= T; t++) {
				if(chapter[i]<=t) {
					dp[i][t] = Math.max(dp[i-1][t], dp[i-1][t-chapter[i]]+score[i]);
				} else {
					dp[i][t] = dp[i-1][t];
				}
			}
		}
		System.out.println(dp[N][T]);
	}
}