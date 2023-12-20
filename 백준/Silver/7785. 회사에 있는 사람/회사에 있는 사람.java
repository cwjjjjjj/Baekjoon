
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Set<String> hset = new HashSet<String>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N; //로그에 기록된 출입 기록의 수
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for (int i = 0; i < N; i++) {
			//n개의 줄에 각 사람의 이름과 enter / leave가 주어짐
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String order = st.nextToken();
			
			if(order.equals("enter")) {
				//출근했으면 set에 add
				hset.add(name);
			} else {
				hset.remove(name);
			}
		}
		
		//회사에 있는 사람을 사전 순의 역순으로 출력
		String[] names = new String[hset.size()];
		int i = 0;
		for (String name : hset) {
			names[i++] = name;
		}
		
		Arrays.sort(names);
		for (int j = names.length-1; j >= 0; j--) {
			System.out.println(names[j]);
		}
	}
}
