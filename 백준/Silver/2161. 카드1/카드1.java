import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<Integer>();
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i <= N; i++) {
			queue.add(i);
		}

		while(queue.size()>1) {
			sb.append(queue.poll()+" "); //제일 위의 카드 버림, 버린 카드 출력	
			queue.offer(queue.poll()); //제일 위의 카드 제일 아래에 넣음
		}
		sb.append(queue.poll());
		System.out.println(sb);
	}
}