
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int[] A = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);
		
		st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken());
		int[] B = new int[M];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < M; i++) {
			int sta = 0;
			int end = N-1;
			int mid;
			boolean check = false;
			
			 while(sta <= end) {
				mid = (sta+end)/2;
				if(A[mid] == B[i]) {
					sb.append(1).append('\n');
					check = true;
					break;
				} else if(A[mid] < B[i]) {
					sta = mid+1;
				} else {
					end = mid-1;
				}
			}
			if(!check) sb.append(0).append("\n");
		}
		System.out.println(sb);
	}
}