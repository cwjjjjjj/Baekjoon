
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		//자연수 N의 분해합 == N + N의 각 자리수의 합
		//M의 분해합이 N이라면
		//M은 N의 생성자 M(생성자) N(분해합)
		//생성자가 없을 수도, 여러 개일 수도 있음

		//245(생성자) 256(분해합)
		//N의 최소 생성자, 없으면 0 출력
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		boolean flag = false;
		int M = 0; //구해야 하는 생성자
		//가장 작은 자연수인 1부터 모두 탐색
		for(int i = 1; i < N; i++) {
			if(i+digit(i) == N) {
				flag = true;
				System.out.println(i);
				break;
			}
		}
		if(!flag) System.out.println('0');
		
	}

	private static int digit(int i) {
		int res = 0;
		while(i > 0) {
			res += i%10;
			i /= 10;
		}
		return res;
	}
}