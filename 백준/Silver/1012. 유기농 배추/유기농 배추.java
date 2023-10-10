
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static int[] dr = { -1, 0, 1, 0 };
	public static int[] dc = { 0, 1, 0, -1 };
	static int[][] map;
	static int N, M;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); //tc
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); //가로
			M = sc.nextInt(); //세로
			int K = sc.nextInt(); //배추 심어져있는 위치 개수
			map = new int[N][M];
			int cnt = 0;
			
			for (int i = 0; i < K; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				map[x][y] = 1;
			} //밭 배열 입력
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					for (int m = 0; m < 4; m++) {
						if(i>=0 && i<N && j>=0 && j<M && map[i][j]==1) {
							DFS(i,j);
							cnt++;
						}
					}
				}
			}
			System.out.println(cnt);
		}
	}

	private static void DFS(int r, int c) {
		map[r][c] = 0; //방문처리
		
		for (int m = 0; m < 4; m++) {
			int nr = r+dr[m];
			int nc = c+dc[m];
			
			if(nr>=0&&nr<N&&nc>=0&&nc<M&&map[nr][nc]==1) {
				map[nr][nc]=0;
				DFS(nr, nc);
			}
		}
	}
}