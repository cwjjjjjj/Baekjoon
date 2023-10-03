
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //물품 수
		int K = sc.nextInt(); //최대 가방 무게
		
		int[] weight = new int[N+1];
		int[] value = new int[N+1];

		for (int i = 1; i <= N; i++) {
			weight[i] = sc.nextInt();
			value[i] = sc.nextInt();
		}
		
		int[][] dp = new int[N+1][K+1];
		for (int i = 1; i <= N; i++) {
			//i번째 물건까지 고려한 경우 저장
			//임시 배낭의 크기
			
			for (int w = 0; w <= K; w++) {
				if(weight[i]<=w) {
					dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w-weight[i]]+value[i]);
				} else {
					dp[i][w] = dp[i-1][w];
				}
			}
		}
		System.out.println(dp[N][K]);
	}
}