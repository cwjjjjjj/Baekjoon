
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int sum = 1;
		int count = 1;
		int start = 1;
		int end = 1;
		
		while(start < N) {
			//시작점이 N에 도달하기 전까지 loop
			
			if(sum == N) {
				
				//sum이 N이 되었다면 답을 찾은 것.
				//count++하고 end를 오른쪽으로 한 칸 밀어줌 (다음 답을 찾기 위해)
				count++;
				end++;
				sum += end;
			} else if (sum < N) {
				
				//sum이 N보다 작으면 end를 오른쪽으로 한 칸 밀어줌 (합이 더 커져야 하므로)
				end++;
				sum += end;
			} else if (sum > N) {
				
				//sum이 N보다 크면 start를 오른쪽으로 한 칸 밀어줌 (합이 더 작아져야 하므로)
				//주의!!!!! 뺄 start값은 ++ 연산 전의 start임.
				sum -= start;
				//연산 전의 start값 먼저 빼주고
				start++;
				//start 밀기!!!!
			}
		}
		System.out.println(count);
	}

}
