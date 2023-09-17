
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[7];
		for(int i = 0; i < 7; i++) {
			int N = sc.nextInt();
			
			if(N%2!=0) {
				arr[i] = N;
			}
		}
		
		int min = 100;
		for(int i = 0; i < 7; i++) {
			if(arr[i] != 0 && arr[i] < min) {
				min = arr[i];
			}
		}
		
		int sum = 0;
		for(int i = 0; i < 7; i++) {
			sum+=arr[i];
		}
		if(sum==0) {
			System.out.println(-1);
		} else {
			System.out.println(sum);
			System.out.println(min);
		}
		
	}
}