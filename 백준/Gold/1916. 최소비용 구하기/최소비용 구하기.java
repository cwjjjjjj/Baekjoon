
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
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
	static int N, M; //정점의 개수 N, 간선 개수 M
	static ArrayList<Node>[] adjList;
	static int [] dist; //최단길이
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer sto = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(sto.nextToken());
		
		sto = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(sto.nextToken());
		
		adjList = new ArrayList[N+1];
		visited = new boolean[N+1];
		
		for (int i = 1; i < N+1; i++) {
			adjList[i] = new ArrayList<>();
			//????
		}
		
		dist = new int[N+1];
		
		for (int i = 0; i < M; i++) {
			sto = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(sto.nextToken());
			int B = Integer.parseInt(sto.nextToken());
			int W = Integer.parseInt(sto.nextToken());
			
			adjList[A].add(new Node(B, W));
			
		}

		sto = new StringTokenizer(br.readLine(), " ");
		int st = Integer.parseInt(sto.nextToken());
		int ed = Integer.parseInt(sto.nextToken());
		
		dijkstra(st);
		System.out.println(dist[ed]);
	}

	private static void dijkstra(int st) {
		PriorityQueue<Node> pq = new PriorityQueue<>();

		pq.add(new Node(st, 0));
		Arrays.fill(dist, INF);
		dist[st] = 0;
		
		while(!pq.isEmpty()) {
			Node curr = pq.poll(); //현재위치
			if(visited[curr.v]) {
				continue;
			}
			visited[curr.v]= true;
			
			if(curr.w == INF) {
				break;
			}
			
			for (Node i : adjList[curr.v]) {
//				if(visited[i.v]) {
//					continue;
//				}
				//???
				
				if(dist[i.v] > dist[curr.v]+i.w) {
					dist[i.v] = dist[curr.v]+i.w;
					pq.add(new Node(i.v, dist[i.v]));
				}
			}
			visited[curr.v] = true;
		}
	}
}