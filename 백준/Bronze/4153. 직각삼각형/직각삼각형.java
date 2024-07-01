
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		while (true) { // while 조건문에서 0 0 0을 잡는 방법은 없는 듯
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (a == 0)
				break;

			if (Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2) 
					|| Math.pow(b, 2) + Math.pow(c, 2) == Math.pow(a, 2)
					|| Math.pow(a, 2) + Math.pow(c, 2) == Math.pow(b, 2))
				sb.append("right").append('\n');
			else
				sb.append("wrong").append('\n');
		}
		System.out.println(sb);
	}
}