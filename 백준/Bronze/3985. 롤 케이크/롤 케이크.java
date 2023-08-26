
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt(); //롤케이크의 길이
		int N = sc.nextInt(); //방청객 수
		
		int exp = 0;
		int[] cake = new int[L]; //각 조각이 누구에게 배분될지
		int max1 = 0;//돌기 전에 빼주지 않아서 계속 0으로 갱신되고 있었음
		for(int i = 1; i <= N; i++) { //각 방청객을 돌면서 케이크에 번호를 적음
			int P = sc.nextInt(); //부터 //받아와야 되는데 0으로 초기화만 해줘서 오류남!!!
			int K = sc.nextInt(); //까지
			if(K-P+1 > max1) { //기대한 조각 최대수 갱신
				max1 = K-P+1;
				exp = i;
//				System.out.println(max1+" "+exp);
			}
//			System.out.println(exp);
//			System.out.println(i+" "+P+" "+K);
			for(int j = P-1; j <= K-1; j++) {
				if(cake[j] == 0) { //그 칸이 비어있으면
					cake[j] = i; //케이크 배열은 1부터 시작이므로 인덱스에 1 더해줌
				}
			}
		}
		//케이크 배열 완성
//		System.out.println(Arrays.toString(cake));
		
		int real = 0;
			int[] ppl = new int[N]; //각 사람이 가져가는 수
			int max2 = 0;
			for(int k = 0; k < L; k++) { //케이크를 돌면서 번호가 적힌 사람들에게 1씩 더해줌
				if(cake[k] != 0) {
					ppl[cake[k]-1]++;
				}
			}
			for(int l = 0; l < N; l++) {
				if(ppl[l]>max2) {
					real = l+1;
					max2=ppl[l];
				}
			}
		System.out.println(exp);
		System.out.println(real);
	}
}