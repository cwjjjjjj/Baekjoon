
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Stack<Integer> stack = new Stack<>();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		 int N = Integer.parseInt(bf.readLine()); //명령의 수
		 for(int n = 1; n <= N; n++) {
			 String order = bf.readLine();
			  if (order.equals("top")) {
				 if(!stack.isEmpty()) {
				 System.out.println(stack.peek());
				 } else {
					 System.out.println(-1);
				 }
			 } else if(order.equals("pop")) {
				 if(!stack.isEmpty()) {
					 System.out.println(stack.pop());
				 } else { //비어있으면 -1 출력 
					 System.out.println(-1);
				 }
			 } else if(order.equals("size")) {
				 System.out.println(stack.size());
			 } else if(order.equals("empty")) {
				 System.out.println(stack.isEmpty()? 1:0);
			 } else {
				 String[] tmp = order.split(" ");
				 int num = Integer.parseInt(tmp[1]); //push일 경우 숫자까지 받음
				 stack.push(num);
			 }
		 }
	}
}