
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static int N = sc.nextInt();
	static int[] arr = new int[N];
	static int[] sel = new int[N];
	static boolean[] visited = new boolean[N];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		for (int i = 0; i < N; i++) {
			arr[i] = i+1;
		}
		perm(0, arr);
		System.out.println(sb);
	}

	private static void perm(int idx, int[] arr) {
		if(idx==N) {
			for (int i : sel) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		} else {
			for (int i = 0; i < N; i++) {
				if(!visited[i]) {
				sel[idx] = arr[i];
				visited[i] = true;
				perm(idx+1, arr);
				visited[i] = false;
				}
			}
		}
		
	}

}