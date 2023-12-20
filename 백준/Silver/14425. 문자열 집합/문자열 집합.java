
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		//총 N개의 문자열로 이루어진 집합 S가 주어짐
		//입력으로 주어지는 M개의 문자열중에서 집합 S에 포함되어 있는 것이 몇 개인지 구해 출력
	
		Set<String> hset = new HashSet<String>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			hset.add(str);
		}
		
		int ans = 0;
		for (int i = 0; i < M; i++) {
			String check = br.readLine();
			if(hset.contains(check)) {
				ans++;
			}
		}
		System.out.println(ans);
	}
}