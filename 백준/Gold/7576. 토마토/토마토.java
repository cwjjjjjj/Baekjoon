
        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.ArrayList;
        import java.util.LinkedList;
        import java.util.Queue;
        import java.util.StringTokenizer;

public class Main {
        static int M, N;
        static int[][] map;
        static int[] dr = {1, -1, 0, 0};
        static int[] dc = {0, 0, -1, 1}; //4방 탐색 방향
        static boolean[][] visited;
        static ArrayList<int[]> location = new ArrayList<>();

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer sto = new StringTokenizer(br.readLine(), " ");

            M = Integer.parseInt(sto.nextToken());
            N = Integer.parseInt(sto.nextToken());
            map = new int[N][M];

            boolean check = true; //모든 토마토가 익어있다고 가정
            for (int i = 0; i < N; i++) {
                sto = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(sto.nextToken());
                    if(map[i][j] == 0) {
                        check = false; //안 익은 토마토 있어요
                    }
                    if(map[i][j] == 1) {
                        location.add(new int[] {i, j});
                    }

                }
            } //토마토 배열 입력받음

            //이미 모든 토마토가 익었으면 0 출력
            if(check) {
                System.out.println(0);
                return;
                //main 메서드를 걍 종료시켜
            }
            BFS();

            //BFS 다 호출했으면 토마토 모두 익었는지 확인
            boolean ripe = true;
            if(!check) { //처음부터 토마토가 모두 익어있지는 않았다면 (0을 이미 출력했으면 여기로 안 들어옴)
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        if(map[i][j] == 0) { //하나라도 안 익었으면
                            ripe = false; //안 익은 토마토 있어요
                        }
                    }
                }

                int max = 0;
                if(!ripe) { //다 돌아도 못 익는 토마토가 있으면
                    System.out.println(-1);
                } else { //다 익었으면 최대값 출력
                    for (int i = 0; i < N; i++) {
                        for (int j = 0; j < M; j++) {
                            if(map[i][j] > max) {
                                max = map[i][j];
                            }
                        }
                    }
                    System.out.println(max-1);
                }
            }
        }

        private static void BFS() {
            //이전 BFS 호출 시 방문했는지와는 상관이 없으니까 visited를 여기서 초기화
            visited = new boolean[N][M];
            Queue<int[]> q = new LinkedList<>();

            for (int i = 0; i < location.size(); i++) {
                int[] now = location.get(i);
                visited[now[0]][now[1]] = true;
                q.add(now); //현재 지점 큐에 넣고 시작
            }
//        q.add(new int[] {r, c}); //현재 지점 큐에 넣고 시작

            while(!q.isEmpty()) {
                int[] curr = q.poll(); //하나 뽑아서 현재 좌표로 만들자
                int cr = curr[0];
                int cc = curr[1]; //현재 내 좌표

                for (int m = 0; m < 4; m++) {
                    int nr = cr+dr[m];
                    int nc = cc+dc[m];
                    if(nr>=0 && nr<N && nc>=0 &&nc< M && map[nr][nc] != -1 && !visited[nr][nc]) {
                        q.add(new int[] {nr, nc}); //방문 X, 유효성 통과하고 토마토가 존재하면 큐에 넣기
                        visited[nr][nc] = true; //방문처리
                        if(map[nr][nc] == 0) { //토마토가 익지도 않았거나
                            //익었지만 더 빨리 익을 수 있으면 갱신
                            map[nr][nc] = map[cr][cc]+1;
                        }
                    }
                }
            }
        }
    }