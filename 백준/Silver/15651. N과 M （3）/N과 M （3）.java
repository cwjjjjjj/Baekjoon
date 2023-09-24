
import java.util.Iterator;
import java.util.Scanner;

public class Main {
	
	static Scanner sc = new Scanner(System.in);
	static int N = sc.nextInt();
	static int M = sc.nextInt();
	static int[] nums = new int[N];
	static int[] sel = new int[M];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		//N개의 수 중에 M개를 뽑는다. 중복 가능
		//순열에서 visited 체크만 제외하면 됨!
		for (int i = 0; i < N; i++) {
			nums[i] = i+1;
		} //배열 생성
		
	perm(0, nums);
	System.out.println(sb);
	}
	
	static void perm(int idx, int[] nums) {
		if(idx == M) {
			for (int i : sel) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 0; i < N; i++) {
			sel[idx] = nums[i]; //i번째 원소 저장
			perm(idx+1, nums);
		}
	}
}