
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int N  = sc.nextInt();; //N개의 숫자 중
	static int M = sc.nextInt(); //M개 고르기
	static int[] arr = new int[N];
	static int[] sel = new int[M];
//	static boolean[] visited = new boolean[N];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr); //사전순으로 출력하기 위해 정렬
		perm(0, arr);
		System.out.println(sb);
	}

	private static void perm(int idx, int[] arr) {
		if(idx==M) { //M개 다 뽑았으면 return
			for (int i : sel) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		} else {
			for (int i = 0; i < N; i++) {
				sel[idx] = arr[i];
				perm(idx+1, arr);
			}
		}
	}
}