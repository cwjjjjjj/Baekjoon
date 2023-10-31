
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m; //가로, 세로 크기
    static int[][] map; //그림 배열
    static ArrayList<Integer> size; //몇 개가 될지는 모르지만 그림 크기를 넣는 배열
    static ArrayList<int[]> start;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        start = new ArrayList<>();
        size = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        } //map 입력받음

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 1) {
                    int cnt = 0;
                    BFS(i, j, 0);
                }
            }
        }

        int len = size.size();
        int max = 0;
//        for(int i = 0; i < len; i++){
//            if(size)
//        }
        //노노!! sort하자
        Collections.sort(size);
        if(len>0) {
            max = size.get(len-1);
        }
        System.out.println(len);
        System.out.println(max);
    }//main

    private static void BFS(int r, int c, int cnt) {
        Queue<int[]> q = new LinkedList<>(); //BFS를 위한 큐
        q.add(new int[] {r, c}); //시작 지점 넣기
        map[r][c] = 0; //방문 처리 의미로 시작 지점 0으로 바꿈

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int cr = curr[0]; //현재 좌표
            int cc = curr[1];
            cnt++; //여기서 체크하자!!!

            for(int k = 0; k < 4; k++){
                int nr = cr+dr[k];
                int nc = cc+dc[k];

                if(nr>=0 && nc >=0 && nr <n && nc<m && map[nr][nc]==1) {
                    //유효성 검사 통과했고 다음 칸이 1이면
                    q.add(new int[] {nr, nc});
                    map[nr][nc] = 0; //방문체크
                }
            }
        }
        size.add(cnt);
    }
}//class
