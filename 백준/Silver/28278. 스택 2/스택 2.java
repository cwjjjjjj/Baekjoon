
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //명령의 수
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			String o = br.readLine(); 
			if(o.equals("2")) {
				if(!stack.isEmpty()) {
					sb.append(stack.pop()+"\n");
				} else {
					sb.append(-1+"\n");
				}
			} else if(o.equals("3")) {
				sb.append(stack.size()+"\n");
			} else if(o.equals("4")) {
				if(stack.isEmpty()) {
					sb.append(1+"\n");
				} else {
					sb.append(0+"\n");
				}
			} else if(o.equals("5")) {
				if(!stack.isEmpty()) {
					sb.append(stack.peek()+"\n");
				} else {
					sb.append(-1+"\n");
				}
			} else {
				String tmp[] = o.split(" ");
				stack.add(Integer.parseInt(tmp[1]));
			}
		}
		System.out.println(sb);
	}
}