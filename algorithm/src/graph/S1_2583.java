package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//영역 구하기
public class S1_2583 {

	static int M, N, K, sr, sc, er, ec, area;
	static int[][] map;
	static boolean[][] visited;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			sr = Integer.parseInt(st.nextToken());
			sc = Integer.parseInt(st.nextToken());
			er = Integer.parseInt(st.nextToken());
			ec = Integer.parseInt(st.nextToken());

			for (int r = sr; r < er; r++) {
				for (int c = sc; c < ec; c++) {
					map[r][c] = 1;
				}
			}
		}
		
		ArrayList<Integer> out = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && map[i][j] == 0) {
					visited[i][j] = true;
					area = 1;
					dfs(i, j);
					out.add(area);
				}
			}
		}
		
		out.sort(null);
		sb.append(out.size()).append('\n');
		
		for (Integer n : out) {
			sb.append(n).append(' ');
		}
		
		System.out.println(sb.toString());

	}
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static void dfs(int r, int c) {
		for(int d=0; d<4; d++) {
			int nr = r + dx[d];
			int nc = c + dy[d];
			if(0<=nr && nr<N && 0<=nc && nc<M && !visited[nr][nc] && map[nr][nc] == 0) {
				area++;
				visited[nr][nc] = true;
				dfs(nr, nc);
			}
		}
	}

}
