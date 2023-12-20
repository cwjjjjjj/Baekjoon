
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		Set<String> hset1 = new HashSet<String>();
		Set<String> hset2 = new HashSet<String>();
		
		int N, M ; //듣도 못한 사람의 수, 보도 못한 사람의 수
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			String name = br.readLine();
			hset1.add(name);
		}
		for (int i = 0; i < M; i++) {
			String name = br.readLine();
			hset2.add(name);
		}
		
		int ans = 0;
		ArrayList<String> res = new ArrayList<String>();
		
		for (String str : hset2) {
			if(hset1.contains(str)) {
				ans++;
				res.add(str);
			}
		}
		Collections.sort(res);
		System.out.println(ans);
		for (String name : res) {
			System.out.println(name);
		}
	}
}