
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int N = sc.nextInt(); //1부터 N까지의 자연수 중
	static int M = sc.nextInt(); //길이가 M인 수열 모두 출력
	static int[] sel = new int[M];

	public static void main(String[] args) {
		//1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열 => 조합
		
		int[] nums = new int[N];
		for (int i = 0; i < N ; i++) {
			nums[i] = i+1; //인덱스 0부터 숫자 1 넣기
		} //배열 생성
		
		comb(0, 0, nums);
	}
	
	static void comb (int idx, int sidx, int[] nums) {
		if(sidx == M) { //기저파트
			for (int i : sel) {
				System.out.print(i+" ");
			}
			System.out.println();
			return; //return을 if 밖으로 꺼내주기
		}
		for (int i = idx; i <= N-M+sidx; i++) { //재귀파트
			sel[sidx] = nums[i];
			comb(i+1, sidx+1, nums);
		}
	}
}