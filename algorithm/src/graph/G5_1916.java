package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 최소비용 구하기
public class G5_1916 {
	
	static final int INF = Integer.MAX_VALUE;
	
	static int N, M, start, end;
	static ArrayList<City>[] list;
	static StringTokenizer st;
	
	static class City{
		int next, cost;
		
		public City(int next, int cost) {
			this.next = next;
			this.cost = cost;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N+1];
		
		for(int i=0; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[a].add(new City(b, c));
		}
		
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		int[] dist = dijk(start);
		
		System.out.println(dist[end]);
		
	}
	
	public static int[] dijk(int now) {
		int[] dist = new int[N+1];
		Arrays.fill(dist, INF);
		dist[start] = 0;
		
		PriorityQueue<City> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.cost));
		pq.add(new City(start, 0));
		
		while(!pq.isEmpty()) {
			City c = pq.poll();
			int ccity = c.next;
			int ccost = c.cost;
			
			// 이미 처리된 도시라면 넘어감
			if(ccost > dist[ccity]) continue;
			
			// 현재 도시에서 연결된 다른 도시들 확인
			for(City next : list[ccity]) {
				int ncity = next.next;
				int ncost = next.cost;
				
				// 새로운 경로가 더 저렴하다면 갱신
				if(dist[ncity] > ccost + ncost) {
					dist[ncity] = ccost + ncost;
					pq.add(new City(ncity, dist[ncity]));
				}
			}
			
		}
		
		return dist;
	}

}
