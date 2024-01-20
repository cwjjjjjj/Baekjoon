
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
public class Main {


		public static void main(String[] args) throws IOException   {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			StringBuilder sb = new StringBuilder();
			
			int N = Integer.parseInt(st.nextToken());
			int[] before = new int[N];
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < N; i++) {
				before[i] = Integer.parseInt(st.nextToken());
			}
			
			int[] after = before.clone(); //정렬 안 된 before 배열 클론
			Arrays.sort(after); //after 정렬
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			int idx = 0;
			
			for(int i = 0; i < after.length; i++) { //after의 작은 수부터 확인하면서
				if(!map.containsKey(after[i])) { //한 번도 들어간 적 없으면
					map.put(after[i], idx++); //앞에 들어간 수보다 rank를 1 올려서 저장
				} //들어간 적 있으면 전에 넣은 idx 값 유지
			}
			
			for (int i = 0; i < before.length; i++) {
				sb.append(map.get(before[i])).append(" ");
			} //before 배열의 인자들을 하나씩 돌면서 해당하는 idx를 가져와 출력

			System.out.println(sb);
		}
	}

