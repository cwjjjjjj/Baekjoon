
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		//수의 개수
		long[] arr = new long[N];
		long[] sumArr = new long[N];
		
		int M = Integer.parseInt(st.nextToken());
		//합을 구해야 하는 횟수
		
	
		//수 입력받으면서 동시에 합배열을 생성해보자
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(i == 0) {
				sumArr[i] = arr[i];				
			} else {
				sumArr[i] = sumArr[i-1] + arr[i];
			}
		}
		//arr 입력과 sumArr 생성을 마침
		for(int k = 0; k < M; k++) {
			st = new StringTokenizer(br.readLine());
			//다음 줄의 구간 i와 j를 입력받기 위해 st 새로 선언
			
			//인덱스 맞춰주기 위해 1씩 미리 빼놓기
			int i = Integer.parseInt(st.nextToken())-1;
			int j = Integer.parseInt(st.nextToken())-1;
			long ans = 0;
			
			if(i==0) {
				//시작하는 숫자가 1(인덱스로 0)일 경우에는
				//뺄 필요 없이 구간합 그 자체를 구하면 됨
				ans = sumArr[j];
			} else {
				ans = sumArr[j] - sumArr[i-1];
			}
			System.out.println(ans);
		}
	}
}