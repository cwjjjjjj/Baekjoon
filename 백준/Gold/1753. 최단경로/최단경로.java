

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Node implements Comparable<Node> {
        int v, w;

        public Node(int v, int w) {
            super();
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.w, o.w);
        }
    }

    static final int INF = Integer.MAX_VALUE;
    static int V, E;
    static ArrayList<Node>[] adjList;
    static int[] dist; //최단길이
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        V = Integer.parseInt(st.nextToken()); //정점의 개수. 번호는 1부터
        E = Integer.parseInt(st.nextToken()); //간선의 개수

        st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        adjList = new ArrayList[V + 1];
        visited = new boolean[V + 1];
        for (int i = 1; i < V + 1; i++) {
            adjList[i] = new ArrayList<>(); //0번 인덱스는 비워두자
        }
        dist = new int[V + 1];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            adjList[A].add(new Node(B, W));
        }

        dijkstra(start);
        for(int i = 1; i < V+1; i++) {
            if(dist[i] == INF) {
                sb.append("INF").append("\n");
            } else {
                sb.append(dist[i]).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static void dijkstra(int st) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(st, 0));
        Arrays.fill(dist, INF);
        dist[st] = 0;

        while (!q.isEmpty()) {
            Node curr = q.poll(); //현재위치
            if (visited[curr.v]) {
                continue;
            }
            visited[curr.v] = true;

            if (curr.w == INF) {
                break;
            }
            for (Node i : adjList[curr.v]) {
                if (dist[i.v] > dist[curr.v] + i.w) {
                    dist[i.v] = dist[curr.v] + i.w;
                    q.add(new Node(i.v, dist[i.v]));
                }
            }
            visited[curr.v] = true;
        }
    }
}
