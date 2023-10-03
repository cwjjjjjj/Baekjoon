
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 설탕 무게

		int[] dp = new int[N + 1]; // 0번 인덱스부터 사용

		for (int i = 1; i <= N; i++) {
			// 3키로그램짜리 시도
			if (i % 5 == 0) {
				dp[i] = dp[i - 5] + 1;
			} else if (i % 3 == 0) {
				dp[i] = dp[i - 3] + 1;
			} else if (i-3>=0 && dp[i-3] != 0 && dp[i - 3] == dp[i - 5])
				dp[i] = dp[i - 3] + 1;
		}

		if (dp[N] == 0) {
			System.out.println("-1");
		} else {
			System.out.println(dp[N]);
		}
	}
}