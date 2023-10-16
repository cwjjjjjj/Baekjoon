
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken()); //과목 수
		int M = Integer.parseInt(st.nextToken()); //선수 조건 수
		int[][] adjArr = new int[N][N];
		int[] degree = new int[N];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken())-1; //B의 선수과목
			int B = Integer.parseInt(st.nextToken())-1;
			//0번 인덱스부터 사용할 것이므로 -1 해주자
			
			adjArr[A][B] = 1; //가중치 없으므로 1
			//진입차수 증가시키기
			degree[B]++;
			//A->B 방향으로 가기 때문
 		}
		
		Queue<Integer> q = new LinkedList<>();
		int sem = 1;
		int[] when = new int[N];
		
		//진입차수가 0이면 큐에 넣기
		for (int i = 0; i < N; i++) {
			if(degree[i] == 0) {
				q.add(i);
				when[i] = sem;
			}
		}
//		int sem = 2;
		
		while(!q.isEmpty()) {
			int work = q.poll(); //현재 할 작업
			
			for (int i = 0; i < N; i++) {
				
				if(adjArr[work][i] == 1) {
					adjArr[work][i] = 0; //처리했다는 의미로 간선 제거
					degree[i]--; //진입차수 감소
					
					if(degree[i] == 0) {
//						sem++;
						q.add(i);
						when[i] = when[work]+1;
					}
				}
			}
//			//아무것도 듣지 않고 지나가는 학기는 없으므로 이럴 경우 학기 복구
//			boolean b = true;
//			for (int i : when) {
//				if(i==sem) {
//					b = false;
//				}
//			}
//			if(b) {
//				sem--;
//			}
		}
		for (int i : when) {
			System.out.print(i+" ");
		}
	} //main
} //class