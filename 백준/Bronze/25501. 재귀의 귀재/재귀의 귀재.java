
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int times = 0;
	public static void main(String[] args) throws IOException {
		//팰린드롬 여부 판단
		//S를 함수의 인자로 전달, rec 함수 몇 번 호출되는지 확인
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int TC = Integer.parseInt(st.nextToken());
		for(int t = 0; t < TC; t++) {
			times = 0;
			st = new StringTokenizer(br.readLine(), " ");
			String str = st.nextToken();
			isPalindrome(str);
			System.out.println();
		}
	}
	
	public static void isPalindrome(String s) {
		System.out.printf(recursion(s, 0, s.length()-1) +" "+times);			
	}
	
	public static int recursion(String s, int l, int r) {
		times++;
		if(l >= r) {
			return 1;
		} else if (s.charAt(l) != s.charAt(r)) {
			return 0;
		} else {
			return recursion(s, l+1, r-1);
		}
	}
}