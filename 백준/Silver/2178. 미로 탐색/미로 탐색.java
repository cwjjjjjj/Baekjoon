
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	
	public static int[] dr = { -1, 1, 0, 0 };
	public static int[] dc = { 0, 0, 1, -1 };
	static int N, M;
	static boolean[][] visited;
	static int[][] maze;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " "); 
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maze = new int[N][M]; //출발: 0,0 도착: N-1, M-1
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			 String str = br.readLine();
			 for (int j = 0; j < M; j++) {
				maze[i][j] = Character.getNumericValue(str.charAt(j)); 
			}
		}
		visited = new boolean[N][M];
		visited[0][0] = true; //첫번째 지점 방문 처리
		BFS(0, 0);
		System.out.println(maze[N-1][M-1]);
		
	}

	private static void BFS(int r, int c) {
		Queue<int[]> q = new LinkedList<>(); //배열을 넣는 큐
		q.add(new int[] {r, c});
		
		while(!q.isEmpty()) {
			int[] current = q.poll(); //큐 제일 첫인자가 지금 위치
			int cr = current[0];
			int cc = current[1];
			
			for (int m = 0; m < 4; m++) {
				int nr = cr+dr[m];
				int nc = cc+dc[m];
				
				if(nr<0 || nc <0 || nr>=N || nc>=M) {
					continue; //유효성 검사
				}
				if(visited[nr][nc]==true || maze[nr][nc]==0) {
					//방문체크, 길 있는지 체크
					continue;
				}
				q.add(new int[] {nr, nc});
				maze[nr][nc] = maze[cr][cc]+1; //한 칸 이동했으므로 +1
				visited[nr][nc]=true;
			}
		}
	}
}