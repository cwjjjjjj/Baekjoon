
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//난쟁이 배열 받기
		int[] arr = new int[9];
		for(int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int l = 0; l < 9; l++) { //사이클 횟수를 위한 반복문
			for(int m = 1; m < 9; m++) { //비교를 위한 반복문
				if(arr[m-1]>arr[m]) {
					int tmp = arr[m-1];
					arr[m-1] = arr[m];
					arr[m] = tmp;
				}
			}
		}//오름차순 정렬
		
		outer: for(int j = 0; j < 8; j++) {
			int cnt = 0;
			for(int k = j+1; k < 9; k++) {
				for(int l = 0; l < 9; l++) {
					if(l!=j && l!=k) {
						cnt+=arr[l];
					} else {
						continue;
					}
				}
				if(cnt == 100) {//100이 되면 출력
					//하나만 출력해야 하는데 100이 되는 경우는 모두 출력됨!!!!!!!!!!!!!
					for(int m = 0; m < 9; m++) {
						if(m!=j && m!=k) {
							System.out.println(arr[m]);
						} else {
							continue;
						}
					}
					break outer;
				} else { //100이 되지 않으면 초기화하고 다시 돌기
					cnt = 0;
				}
			}
		}
	}
}