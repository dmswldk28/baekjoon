package DivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 색종이 만들기
public class S2_2630 {
	
	static int N;
	static int[][] arr;
	static int[] out;
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		out = new int[2];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0, N);
		
		System.out.println(out[0] + "\n" + out[1]);
		
	}
	
	public static void dfs(int ridx, int cidx, int d) { // 0 : white, 1 : blue
		int color = arr[ridx][cidx];
		if(d == 1) {
			out[color]++;
			return;
		}
		
		for(int i=ridx; i<ridx+d; i++) {
			for(int j=cidx; j<cidx+d; j++) {
				if(color != arr[i][j]) {
					dfs(ridx, cidx, d/2); //왼위
					dfs(ridx, cidx+d/2, d/2); //오위
					dfs(ridx+d/2, cidx, d/2); //왼아
					dfs(ridx+d/2, cidx+d/2, d/2); //오아
					return;
				}
			}
		}
		
		out[color]++;
	}

}
