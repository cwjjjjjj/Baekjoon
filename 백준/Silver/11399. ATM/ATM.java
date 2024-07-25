
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //전체 인원수
		int[] time = new int[N];
		for(int i = 0; i < N; i++) {
			time[i] = sc.nextInt();
		} //각 사람이 인출하는 데 걸리는 시간 입력받음
		
		Arrays.sort(time);
		
		int ans = 0;
		for(int i = 0; i < N; i++) {
			ans += time[i] * (N-i);
		}
		
		System.out.println(ans);
	}
}