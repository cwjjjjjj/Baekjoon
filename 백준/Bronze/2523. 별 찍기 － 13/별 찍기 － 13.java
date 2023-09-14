import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= i; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		
		for(int i = N; i >= 1; i--) {
			for(int k = i-1; k >= 1; k--) {
				sb.append("*");
			}
		sb.append("\n");
		}
		System.out.println(sb);
	}
}