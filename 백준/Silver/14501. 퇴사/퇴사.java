
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] T = new int[N+1];
		int[] P = new int[N+1]; //0번 인덱스 사용하지 않음
		int[] dp = new int[N+2]; //왜 N+2???
		
		for (int i = 1; i < N+1; i++) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		//뒤에서부터 탐색!
		for(int i = N; i > 0; i--) { //N일부터 1일까지 줄어든다
			if(i+T[i] > N+1) { //일을 할 수 없으면
				dp[i] = dp[i+1]; //이전값이 최대값
			} else { //할 수 있으면 최대값 갱신
				dp[i] = Math.max(dp[i+1], dp[i+T[i]] + P[i]);
			}
		}
		System.out.println(dp[1]); //1일부터 N일까지의 최대값이므로 1을 넣어주기!!
	}
}