package week4;

import java.util.Scanner;

public class b8958 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); //테케의 개수
		for(int tc = 1; tc <= T; tc++) {
			String quiz = sc.next();
			int sum = 0;
			int cnt = 0;
			for(int i = 0; i < quiz.length(); i++) {
				if(quiz.charAt(i) == 'O') {
					cnt++;
					sum+= cnt;
				} else {
					cnt = 0;
				}
			}
			System.out.println(sum);
		}
	}
}