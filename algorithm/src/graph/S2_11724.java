package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.ArrayList;
import java.util.StringTokenizer;

// 연결 요소의 개수
public class S2_11724 {

	static boolean[] visited;
	static boolean[][] graph;
	static int N, M, result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		result = 0;

		graph = new boolean[N + 1][N + 1];
		visited = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph[u][v] = graph[v][u] = true;

		}

		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				dfs(i);
				result++;
			}
		}

		System.out.println(result);

	}

	public static void dfs(int n) {
		if (visited[n])
			return;
		else {
			visited[n] = true;
			for (int i = 1; i <= N; i++) {
				if (graph[n][i])
					dfs(i);
			}
		}
	}

}
