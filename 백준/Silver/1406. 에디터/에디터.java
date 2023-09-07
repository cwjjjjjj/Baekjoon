import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack1 = new Stack<>(); // 커서의 왼쪽
		Stack<Character> stack2 = new Stack<>(); // 커서의 오른쪽
		String str = br.readLine(); // N길이의 문자열

		for (int i = 0; i < str.length(); i++) { // N번 돌면서 왼쪽 배열에 넣기
			stack1.push(str.charAt(i)); // 시작 시 커서는 맨뒤에 위치하므로 모두 1에 넣기
		}

		int M = Integer.parseInt(br.readLine()); // 명령어의 개수 M
		for (int i = 1; i <= M; i++) { // M번 돌면서 명령 수행
			String order = br.readLine();
			if (order.equals("L")) {
				if (!stack1.isEmpty()) {
					stack2.push(stack1.pop()); // 1에서 하나 빼서 2로 옮김
				}
			} else if (order.equals("D")) {
				if (!stack2.isEmpty()) {
					stack1.push(stack2.pop()); // 2에서 하나 빼서 1로 옮김
				}
			} else if (order.equals("B")) {
				if (!stack1.isEmpty()) {
					stack1.pop(); // 1에서 하나 삭제
				}
			} else { // P라면
				String tmp[] = order.split(" ");
				stack1.push(tmp[1].charAt(0));
			}
		}
		br.close();

		// 하나의 스택으로 합하기
		while (!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
//		int size = stack2.size();
		while(!stack2.isEmpty()) {
			sb.append(stack2.pop());
		}

		System.out.println(sb);
	}
}