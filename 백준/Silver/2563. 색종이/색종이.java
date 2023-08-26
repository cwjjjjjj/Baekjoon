import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] white = new int[100][100]; //흰색 도화지의 크기 100*100
		
		int N = sc.nextInt(); //검은색 도화지의 수. 크기는 10*10
		for(int i = 0; i < N; i++) { //검은 종이 수만큼 반복
			int a = sc.nextInt(); //왼쪽 변 위치
			int b = sc.nextInt(); //아래쪽 변 위치
			//각 검은 종이의 왼쪽 위 시작지점은 (b-10, a)
			for(int j = 100-b-10; j < 100-b; j++) {
				for(int k = a; k < a+10; k++) {
					white[j][k] = 1;
				}
			}
		}
		//종이 다 올림
		
		int cnt = 0;
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(white[i][j] == 1) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}