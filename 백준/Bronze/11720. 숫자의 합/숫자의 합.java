
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(),"");
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(),"");
		char[] arr = st.nextToken().toCharArray();
		int sum = 0;
		for(int i = 0; i < N; i++) {
			sum += Character.getNumericValue(arr[i]);
		}
		
		System.out.println(sum);
	}

}
