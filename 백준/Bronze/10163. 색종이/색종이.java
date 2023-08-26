
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //색종이의 장수
		int[][] arr = new int[1001][1001]; //색종이가 놓이는 평면의 크기
		
		for(int i = 1; i <= N; i++) { //1번 색종이, 2번 색종이...
			int r = sc.nextInt();
			int c = sc.nextInt();
			int wdh = sc.nextInt(); //너비
			int hgt = sc.nextInt(); //높이
			for(int j = r; j < r+wdh; j++) { //너비와 높이 각각 c, r에 더해줘야 함!!!
				for (int k = c; k <c +hgt; k++) {
					arr[j][k] = i; //1번 색종이부터 해당 칸에 색종이 번호(1~N) 적기
				}
			}
		}
		
		int[] res = new int[N]; //각 색종이가 몇 칸을 차지하고 있는지 담을 배열 
		for(int i = 0; i < 1001; i++) {
			for(int j = 0; j < 1001; j++) { //모든 칸을 돌면서 각 칸에 몇 번 색종이가 있는지 검사
				if(arr[i][j]!=0) { //아무 색종이도 없는 경우는 제외
					res[arr[i][j]-1]++;
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			System.out.println(res[i]);
		}
	}
}