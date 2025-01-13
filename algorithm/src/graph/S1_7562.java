package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//나이트의 이동
public class S1_7562 {
	
	static int l, sr, sc, er, ec, min;
	static boolean[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			l = Integer.parseInt(br.readLine());
			map = new boolean[l][l];
			
			st = new StringTokenizer(br.readLine());
			sr = Integer.parseInt(st.nextToken());
			sc = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			er = Integer.parseInt(st.nextToken());
			ec = Integer.parseInt(st.nextToken());
			
			if(sr == er && sc == ec) {
				sb.append(0).append('\n');
			}else {
				bfs();
				
				sb.append(min).append('\n');
				
			}
			
		}
		
		System.out.println(sb.toString());
		
	}
	
	static int[] dr = {-2, -2, -1, -1, 1, 1, 2, 2};
	static int[] dc = {-1, 1, -2, 2, -2, 2, -1, 1};
	
	static public void bfs() {
		int[] q = new int[l*l*3];
		map[sr][sc] = true;
		int size = 0;
		int point = 0;
		q[size++] = sr;
		q[size++] = sc;
		q[size++] = 0;
		
		while(point <= l*l*3) {
			int cr = q[point++];
			int cc = q[point++];
			int cd = q[point++];
			
			if(cr == er && cc == ec) {
				min = cd;
				return;
			}
			
			for(int d=0; d<8; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if(0<=nr && nr<l && 0<=nc && nc<l && !map[nr][nc]) {
					q[size++] = nr;
					q[size++] = nc;
					q[size++] = cd+1;
					map[nr][nc] = true;
				}
			}
		}
		
	}

}
