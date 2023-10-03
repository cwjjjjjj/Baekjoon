
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int num = A * B * C;

		String str = String.valueOf(num);
		int[] arr = new int[str.length()];

		for (int i = 0; i < str.length(); i++) {
			arr[i] = str.charAt(i)-48;
		}

		int[] times = new int[10]; //횟수
		for (int i = 0; i < str.length(); i++) {
			times[arr[i]]++;
		}
		for (int c : times) {
			System.out.println(c);
		}
	}
}