
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(n<=100 && n >=90) {
			System.out.println("A");
		}
		if(n<=89 && n >=80) {
			System.out.println("B");
		}
		if(n<=79 && n >=70) {
			System.out.println("C");
		}
		if(n<=69 && n >=60) {
			System.out.println("D");
		}
		if(n<60) {
			System.out.println("F");
		}
	}
}