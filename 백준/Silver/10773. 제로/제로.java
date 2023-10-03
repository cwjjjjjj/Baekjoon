
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		Scanner sc = new Scanner(System.in);
		
		int K = sc.nextInt();
		for (int i = 0; i < K; i++) {
			int n = sc.nextInt();
			if(n == 0) {
				stack.pop();
			} else {
				stack.push(n);
			}
		}
		int ans = 0;
		while(!stack.isEmpty()) {
			ans+=stack.pop();
		}
		System.out.println(ans);
	}
}