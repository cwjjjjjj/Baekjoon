
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = 0;
		String str = sc.nextLine();
		String[] arr = str.split(" ");
	
		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			if(!arr[i].equals("") && !arr[i].equals(" ")) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}