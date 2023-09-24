
import java.util.Scanner;

public class Main {
	
	static Scanner sc = new Scanner(System.in);
	static int N = sc.nextInt();
	static int[] nums = new int[N]; //N 개 중 M 개 뽑기
	static int M = sc.nextInt();
	static int[] sel = new int[M];
	static boolean[] visited = new boolean[N]; //해당 원소 사용 유무
	
	public static void main(String[] args) {
		//1~N까지 순서를 고려해서 뽑기 -> 순열
		for (int i = 0; i < N; i++) {
			nums[i] = i+1;
		} //배열 생성
		perm(0, nums);
	}
	
	static void perm(int idx, int[] nums) {
		if(idx == M) { //필요한 개수만큼 뽑았으면 출력하고 멈춰
			for (int i : sel) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}
		for(int i = 0; i < N; i++) { //필요한 개수가 될 때까지 재귀해 //사용 가능한 모든 숫자(N) 체크!!
			if(visited[i]) { //이미 사용한 원소라면 쳐내
				continue;
			}
			sel[idx] = nums[i]; //해당 i번째 원소 저장
			visited[i] = true; //i번째 원소 사용했다고 표시
			
			perm(idx+1, nums); //재귀 호출
			visited[i] = false; //i번째 방문체크 원상복구
		}
	}
}