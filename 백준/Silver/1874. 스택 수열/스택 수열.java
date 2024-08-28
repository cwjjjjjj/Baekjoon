
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		int num = 1; //1부터 N까지의 자연수
		boolean flag = true;
		
		outer: for(int i = 0; i < N; i++ ) {
			if(arr[i] >= num) {
				while(arr[i]  >= num) {
					stack.push(num++);
					sb.append("+\n");
				}
				stack.pop();
				sb.append("-\n");
			} else if(arr[i] < num) {
				int n = stack.pop();
				if(n > arr[i]) {
					System.out.println("NO");
					flag = false;
					break outer;
				} else {
					sb.append("-\n");
				}
			}
		}
		if(flag) {
			System.out.println(sb);
		}
	}
}
