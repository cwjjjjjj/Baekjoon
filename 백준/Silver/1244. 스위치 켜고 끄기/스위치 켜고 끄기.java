
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int S = sc.nextInt(); //스위치의 개수
		int N = S+1; //스위치 번호는 1부터 시작하므로 1씩 빼주기, 그럼 이후에 1씩 안 빼줘도 됨
		int[] swch = new int[N];
		for(int i = 1; i < N; i++) {
			swch[i] = sc.nextInt();
		} //스위치의 상태 배열 입력
		
		int student = sc.nextInt(); //학생수
		for(int i = 0; i < student; i++) { //학생을 한 명씩 돌면서
			int s = sc.nextInt(); //학생의 성별
			int p = sc.nextInt(); //학생이 받은 수
			if(s == 1) { //남학생이라면
				for(int j = 1; j <= S/p; j++) { //p, p, 3p, ...
					if(swch[j*p]==1) {
						swch[j*p] = 0;
					} else {
						swch[j*p] = 1;
					}
				}
				
			} else if(s==2) { //여학생이라면
				//일단 시작점부터 바꿈
				if(swch[p]==1) {
					swch[p] = 0;
				} else {
					swch[p] = 1;
				}
				
				//p-i++, p+i++ 대칭 검사하며 두 수가 같으면 바꾸기
				for(int j = 1; j < S; j++) { //최대 스위치의 수는 100개
					if(p-j>0 && p+j<N && swch[p-j] == swch[p+j]) { //인덱스 유효검사 + 대칭검사 //0번 인덱스는 버리므로 1부터 인덱스 유효 
						if(swch[p-j]==0) {
							swch[p-j] = 1;
							swch[p+j] = 1;
						} else {
							swch[p-j] = 0;
							swch[p+j] = 0;
						}
					} else {
						break;
					}
				}
			}
		}
//		for(int i = 1; i < N; i++) {
//			System.out.printf(swch[i]+" ");
//		}
		//20개씩 출력
		for(int i = 1; i < N; i++) {
			System.out.printf(swch[i]+" ");
			if(i%20==0) {
				System.out.println();
			}
		}
	}
}