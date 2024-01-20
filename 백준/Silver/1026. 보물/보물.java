
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int[] A = new int[N];
		int[] B = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);
		Integer[] sortedB = Arrays.stream(B).boxed().toArray(Integer[]::new);
		Arrays.sort(sortedB, Collections.reverseOrder());
		
		int sum = 0;
		for(int i = 0; i < N; i++) {
			sum += A[i]*sortedB[i];
		}
		System.out.println(sum);
	}
}