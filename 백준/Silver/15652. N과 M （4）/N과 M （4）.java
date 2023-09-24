
import java.util.Scanner;

public class Main {
	
	static Scanner sc = new Scanner(System.in);
	static int N = sc.nextInt();
	static int M = sc.nextInt();
	static int[] nums = new int[N];
	static int[] sel = new int[M];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		//나머지 조건은 중복순열과 같음
		//앞자리 수보다 뒷자리 수가 커지면 제외
		for (int i = 0; i < N; i++) {
			nums[i] = i+1;
		}
		perm(0, nums);
		System.out.println(sb);
	}
	
	static void perm (int sidx, int[] nums) {
		if(sidx == M) {
			for (int i : sel) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 0; i < N; i++) {
			if(sidx-1>=0 && sel[sidx-1] > nums[i]) { //1번 인덱스부터 검사
				//sel의 이전 인덱스 인자가 다음에 들어올 인자보다 작으면 하지마
				continue;
			}
			sel[sidx] = nums[i];
			perm(sidx+1, nums);
		}
	}
}