
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		//재료의 개수
		int M = sc.nextInt();
		//두 재료의 합이 M이면 완성
		
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int ans = 0;
		
		for(int i = 0; i < N; i++) {
			int sum = arr[i];
			//M이 넘는 수에 도달하면 시도해볼 필요 없음
			if(i > M) break;
			
			for(int j = i+1; j < N; j++) {
				sum += arr[j];
				if(sum == M) {
					ans++;
				}
				//다음 턴 돌기 전에 sum 초기화. 안 그러면 계속 커짐
				sum = arr[i];
			}
		}
		System.out.println(ans);
	}
}