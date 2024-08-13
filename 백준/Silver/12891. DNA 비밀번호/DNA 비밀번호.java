
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
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
			for(int k = i; k < i+P; k++) {
				if(arr[k] == 'A') a--;
				else if(arr[k] == 'C') c--;
				else if(arr[k] == 'G') g--;
				else if(arr[k] == 'T') t--;
			}			
		} else if(i > 0) {
			//그 다음 차례부터는 나가는 인덱스와
			if(arr[i-1] == 'A') a++;
			else if(arr[i-1] == 'C') c++;
			else if(arr[i-1] == 'G') g++;
			else if(arr[i-1] == 'T') t++;
			
			//들어오는 인덱스만 체크
			if(arr[i+P-1] == 'A') a--;
			else if(arr[i+P-1] == 'C') c--;
			else if(arr[i+P-1] == 'G') g--;
			else if(arr[i+P-1] == 'T') t--;
		}
		
		if(a<=0 && c<=0 && g<=0 && t<=0) {
			return true;
		} else {
			return false;
		}
	}
}