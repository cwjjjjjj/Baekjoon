
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		//참가자의 수
		int[] nums = new int[6];
		
		for(int i = 0; i < 6 ; i++) {
			nums[i] = sc.nextInt();
		}
		
		int ans = 0;
		int T = sc.nextInt();
		for(int i = 0; i < 6 ; i++) {
			if(nums[i] <= T && nums[i] > 0) {
				ans++;
			} else if(nums[i] % T == 0) {
				ans += nums[i]/T;
			} else if(nums[i] > T) {
				ans += nums[i]/T + 1;
			}
		}
		System.out.println(ans);
		
		int P = sc.nextInt();
		System.out.printf(N/P+" "+N%P);
	}
}