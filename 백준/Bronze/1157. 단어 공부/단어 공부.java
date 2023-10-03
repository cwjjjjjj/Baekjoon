
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next(); //단어 통째로 받음
		int[] c = new int[200];
		for (int i = 0; i < str.length(); i++) {
			int tmp = Character.toUpperCase(str.charAt(i));
			c[tmp]++;
		} //아스키코드로 변환한 배열 완성
		
		int max = 0;
		int key = 0;
		for (int i = 0; i < c.length; i++) {
			if(c[i] > max) {
				max = c[i];
				key = i;
			}
		}
		String ans = "";
		char ch = (char)key;
		ans = String.valueOf(ch);
		for (int i = 0; i < c.length; i++) {
			if(i != key) { //중복 최대수가 있다면
				if(c[i] == max) {
					ans = "?";
				}
			}
		}
		System.out.println(ans);
	}
}