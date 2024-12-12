package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// N과 M(12)
public class S2_15666 {
	
	static int N, M;
	static int[] list, out;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());

		list = new int[N];
		
		for(int i=0; i<N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		
		out = new int[M];
		
		Arrays.sort(list);
		
		dfs(0, 0);
		
		System.out.println(sb.toString());
		
	}
	
	public static void dfs(int idx, int d) {
		if(d == M) {
			for(int i=0; i<M; i++) {
				sb.append(out[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		int before = -1;
		for(int i=idx; i<N; i++) {
			if(before != list[i]) {
				before = list[i];
				out[d] = list[i];
				dfs(i, d+1);
			}
		}
	}

}
