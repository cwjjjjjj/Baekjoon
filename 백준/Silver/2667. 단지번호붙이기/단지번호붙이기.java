
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static int N;
//	static boolean[][] visited = new boolean[N][N];
	static int[][] map;
	static ArrayList<Integer> ans = new ArrayList<Integer>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 지도의 크기
		// 단지 수와 각 단지의 집 수를 저장할 배열(크기 유동)
		map = new int[N][N];
		

		for (int i = 0; i < N; i++) {
			String str = br.readLine(); // 스캐너로 쭉 이어진 숫자 받으면 통째로 들어옴
			for (int j = 0; j < N; j++) {
				map[i][j] = Character.getNumericValue(str.charAt(j)); // 쪼개서 가져와야 함!
			}
		} //입력
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int m = 0; m < 4; m++) { // 4방 탐색하며 1 찾기
					if (i >= 0 && i < N && j >= 0 && j < N && map[i][j] == 1) { // 유효성 통과했고 집 찾았으면 BFS 호출
//						visited[i][j] = true; // 출발지점 방문체크 -> map 상에서 1을 0으로 바꾸는 것으로 대체
						int cnt = 0;
						BFS(i, j, cnt);
					}
				}
			}
		} // BFS 호출
		
		System.out.println(ans.size());
		Collections.sort(ans);
		for (int i : ans) {
			System.out.println(i);
		}
	} // main

	private static void BFS(int r, int c, int cnt) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { r, c }); // 큐에 현재 지점 넣기
		map[r][c] = 0; //출발지점 방문체크!!
		while (!q.isEmpty()) {
			int[] hear = q.poll();
			int cr = hear[0];
			int cc = hear[1];
			cnt++; //여기 왔다는 건 어차피 유효하다는 거임. 간선 말고 정점에서 체크

			for (int m = 0; m < 4; m++) {
				int nr = cr + dr[m];
				int nc = cc + dc[m];

				if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] == 1) { // 집이 있으면
//					cnt++; //여기아님
					q.add(new int[] { nr, nc }); // 그 지점 큐에 add
					map[nr][nc] = 0; // 방문체크 의미로 0으로 바꿔줌
				}
			}
		}
		ans.add(cnt); // BFS 결과로 나온 집 수를 ans에 add
	} // BFS
} // class