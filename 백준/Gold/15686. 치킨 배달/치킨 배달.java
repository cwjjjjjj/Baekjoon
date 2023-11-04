
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] map;
    static ArrayList<int[]> house;
    static ArrayList<int[]> shop;
    static int[] sel;
    static int[] nums;
    static int allshops;
    //  static ArrayList<int[]> combs;
    static int total;
    static int MinAns;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); // 도시의 크기
        M = Integer.parseInt(st.nextToken()); // 남길 치킨집의 개수
        map = new int[N][N]; // 도시 배열
        sel = new int[M]; // M개의 치킨집을 뽑아서 넣을 임시 배열
        house = new ArrayList<>(); //몇 개일지 모르는 집들의 위치 저장
        shop = new ArrayList<>(); //몇 개일지 모르는 치킨 가게들의 위치 저장
        total = 0; //현재 뽑은 M개의 치킨집에 대한 치킨거리의 (임시) 합
        MinAns = Integer.MAX_VALUE; //최소 치킨거리 (=> 정답)

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) { // 1 만나면 집 배열에 저장
                    house.add(new int[] { i, j });
                } else if (map[i][j] == 2) { // 2 만나면 식당 배열에 저장
                    shop.add(new int[] { i, j });
                }
            }
        } // map 입력

        allshops = shop.size(); //가게 개수와 크기가 같은 배열을 만들기
        nums = new int[allshops]; //M개의 가게 뽑을 때 사용하기 위함
        // 식당 allshops개에 각각 0~allshops까지의 번호 매기기
        for (int i = 0; i < allshops; i++) {
            nums[i] = i;
        }
        comb(0, 0);
        System.out.println(MinAns);
    } // main

    // allshops개의 식당 중 조합으로 m개 뽑는 모든 경우의 수 구해보고 getDist로 넘기는 메서드
    static void comb(int idx, int sidx) {
        if (sidx == M) {
//          combs.add(sel); //combs에 가능한 모든 경우 치킨집 조합을 넣음
            getDist(sel); //M개의 치킨집이 골라질 때마다 getDist 호출

        } else if (idx >= allshops) {
            return;
        } else {
            sel[sidx] = nums[idx];
            comb(idx + 1, sidx + 1);
            comb(idx + 1, sidx);
        }
    }

    private static void getDist(int[] sel) {
        total = 0; //다음 sel 돌 때 total 초기화
        for (int i = 0; i < house.size(); i++) { //하나씩, 모든 집이 모든 식당을 돈다
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < M; j++) { //모든 식당을 돌면서
//                int dist = Math.abs(house.get(i)[0] - sel[0]) + Math.abs(house.get(i)[1] - sel[1]);
                int dist = Math.abs(house.get(i)[0] - shop.get(sel[j])[0]) + Math.abs(house.get(i)[1] - shop.get(sel[j])[1]);
                //shop 리스트 j번째 식당의 좌표를 가져옴
                if(dist < min) { //min보다 작으면 갱신
                    min = dist;
                }
            } //집 하나가 모든 식당을 돌아봤음
            total += min; //각 집의 최소 치킨거리를 total(임시 도시의 치킨거리)에 더하기
        } //모든 집이 모든 식당에 가봄

        if(total < MinAns) { //한 세트의 [sel]을 돌고 나면 MinAns와 비교하고 갱신
            MinAns = total;
        }
    }
} // class