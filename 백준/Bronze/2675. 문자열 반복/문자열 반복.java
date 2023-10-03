
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int R = sc.nextInt();
			String S = sc.next();
			char[] c = new char[S.length()];
			
			for (int i = 0; i < S.length(); i++) {
				c[i] = S.charAt(i);
			}
			for (int i = 0; i < S.length(); i++) {
				for (int j = 0; j < R; j++) { //R번 출력
					System.out.print(c[i]);
				}
			}
			System.out.println();
		}
	}
}