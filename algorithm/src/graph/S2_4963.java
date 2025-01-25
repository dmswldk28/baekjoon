package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//섬의 개수
public class S2_4963 {

	static int w, h, cnt;
	static int[][] map;
	static boolean[][] visited;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if(w == 0 && h == 0) break;
			
			cnt = 0;
			map = new int[h][w];
			visited = new boolean[h][w];
			
			for(int i=0; i<h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					if(!visited[i][j] && map[i][j] == 1) {
						dfs(i,j);
						cnt++;
					}
				}
			}
			sb.append(cnt).append('\n');
		}
		
		System.out.println(sb.toString());
		
	}
	
	static int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
	static int[] dy = {0, 0, -1, 1, -1, -1, 1, 1};
	
	static void dfs(int r, int c) {
		for(int d=0; d<8; d++) {
			int nr = r + dx[d];
			int nc = c + dy[d];
			if(0<=nr && nr<h && 0<=nc && nc<w && !visited[nr][nc] && map[nr][nc] == 1) {
				visited[nr][nc] = true;
				dfs(nr, nc);
			}
		}
	}

}
