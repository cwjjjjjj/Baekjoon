
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int P, a, c, g, t;
	public static char[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int S = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		String str = br.readLine();
		arr = str.toCharArray();
		
		st = new StringTokenizer(br.readLine());
		//초기에 a, c, g, t는 해당 문자열 내에 각 알파벳이 몇 개 있어야 하는지 나타냄
		a = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		g = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		int ans = 0;
		
		for(int i = 0; i < S-P+1; i++) {
			if(isPossible(i)) {
				ans++;
			}
		}
		System.out.println(ans);
	}
	
	public static boolean isPossible(int i) {
		if(i==0) {
			//모두 다 직접 세어주는 과정은 제일 처음에만 수행하면 됨
			//지금부터 a, c, g, t는 해당 문자열 내에 각 알파벳 필요개수 - 존재개수를 나타냄
			for(int k = 0; k < P; k++) {
				minus(arr[k]);
			}
		} else if(i > 0) {
			//그 다음 차례부터는 나가는 인덱스와
			plus(arr[i-1]);
			
			//들어오는 인덱스만 체크
			minus(arr[i+P-1]);
		}
		
		//필요 개수 <= 존재 개수 라면 조건 만족함
		if(a<=0 && c<=0 && g<=0 && t<=0) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void minus(char ch) {
		//초기에 알파벳 개수 셀 때,
		//인덱스를 옮기면서, 새로 들어오는 알파벳 개수 셀 때
		switch(ch) {
		//break문이 없다면 걸린 다음의 연산들도 수행함
		case 'A': a--; break;
		case 'C': c--; break;
		case 'G': g--; break;
		case 'T': t--; break;
		}
	}
	
	public static void plus(char ch) {
		//인덱스를 옮기면서, 나가는 알파벳 개수 셀 때
		switch(ch) {
		case 'A': a++; break;
		case 'C': c++; break;
		case 'G': g++; break;
		case 'T': t++; break;
		}
	}
}