
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next(); //문자열
		String[] arr = str.split("");

		System.out.println(arr[sc.nextInt()-1]);
	}
}