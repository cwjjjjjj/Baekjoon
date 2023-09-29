
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int[] memo; //메모이제이션
	static int n;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); //n번째 피보나치 수 구하기
		memo = new int[n+1];
		
		Arrays.fill(memo, -1); //-1로 다 채우기
		memo[0] = 0;
		memo[1] = 1;
		
		System.out.println(Fibo(n));
	}
	
	private static int Fibo(int n) {
		if(memo[n] == -1) {
			memo[n] = Fibo(n-1) + Fibo(n-2);
		}
		return memo[n];
	}
}