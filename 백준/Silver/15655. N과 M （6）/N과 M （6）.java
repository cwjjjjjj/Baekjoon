
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int N;
	static int M;
	static int[] nums;
	static int[] sel;
	static StringBuilder sb = new StringBuilder();
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		nums = new int[N];
		sel = new int[M];
		visited = new boolean[N];
		
		for (int i = 0; i < N ; i++) {
			nums[i] = sc.nextInt();
		} //배열 입력
		
		Arrays.sort(nums);
		comb(0, 0, nums);
		System.out.println(sb);
	}
	
	static void comb(int idx, int sidx, int[] nums) {
		if(sidx == M) {
			for (int i : sel) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = idx; i <= N-M+sidx; i++) {
			sel[sidx] = nums[i];
			comb(i+1, sidx+1, nums);
		}
	}
}