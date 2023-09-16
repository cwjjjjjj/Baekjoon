
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb = new StringBuilder();
	public static int num = 0;
	
	public static boolean recursion(char[] S, int l, int r) {
		num++;
		boolean b;
		if(l >= r) {
			b = true;
		} else if(S[l] != S[r]) {
			b = false;
		} else {
			return recursion (S, l+1, r-1);
		}
		return b;
	}
	
	public static boolean isPalindrome(char[] S) {
		return recursion(S, 0, S.length -1 );
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine()); //tc의 개수
		
		for(int tc = 0; tc < T; tc++) {
			String tmp = br.readLine(); //문자열 입력
			char[] S = new char[tmp.length()];
			for(int i = 0; i < tmp.length(); i++) {
				S[i] = tmp.charAt(i);
			}
			if(recursion(S, 0, S.length -1)) {
				sb.append(1+" ");
			} else {
				sb.append(0+" ");
			}
			sb.append(num+"\n");
			num = 0;
		}
		System.out.println(sb);
	}
}