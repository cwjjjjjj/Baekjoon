
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //시험장의 개수
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		} //각 시험장의 학생수 입력
		
		int B = sc.nextInt(); //총감독관 감독수
		int C = sc.nextInt(); //부감독관 감독수
		long ans = 0l; //필요한 감독관의 수
		
		for (int i = 0; i < N; i++) { //모든 방을 돌면서
			if(arr[i] >= B) { //총감독관 감독수보다 크면
				ans++; //감독수 1 증가하고
				arr[i] -= B; //총감독관 1명 감독수만큼 감소
			} else { //작으면 그냥 총감독관 1명만 있으면 됨
				ans++;
				arr[i] = 0;
			}
			
			if(arr[i] >= C) { //남은 수 또는 초기의 수가 부감독 감독수보다 크면
				int tmp = arr[i] / C; //부감독 감독수만큼 나누고
				ans += tmp;
				arr[i] -= tmp*C; //그만큼 감소
				if(arr[i] > 0) { //그래도 남았으면 부감독 1 추가
					ans++;
				}
			} else if(arr[i]>0 && arr[i] <= C) {
				ans++;
			}
		}
		System.out.println(ans);
	}
}