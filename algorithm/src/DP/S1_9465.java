package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 스티커
public class S1_9465 {
	
	static int T, n;
	static StringTokenizer st;
	static StringBuilder sb;
	static int[][] table, dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		
		for(int tc=1; tc<=T; tc++) {
			n = Integer.parseInt(br.readLine());
			table = new int[2][n];
			dp = new int[2][n+1];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				table[0][i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				table[1][i] = Integer.parseInt(st.nextToken());
			}
			
			dp[0][0] = table[0][0];
			dp[1][0] = table[1][0];
			int result = Math.max(dp[0][0], dp[1][0]);
			
			if(n > 1) {
				dp[0][1] = table[0][1] + dp[1][0];
				dp[1][1] = table[1][1] + dp[0][0];
				result = Math.max(Math.max(dp[0][1], dp[1][1]), result);
			}
			
			if(n > 2) {
				for(int i=2; i<n; i++) {
					dp[0][i] = table[0][i] + Math.max(dp[1][i-1], dp[1][i-2]);
					dp[1][i] = table[1][i] + Math.max(dp[0][i-1], dp[0][i-2]);
				}
				
				dp[0][n] = Math.max(dp[0][n-1], dp[0][n-2]);
				dp[1][n] = Math.max(dp[1][n-1], dp[1][n-2]);
				result = Math.max(Math.max(dp[0][n], dp[1][n]), result);
			}
			
			sb.append(result).append('\n');
			
		}// tc
		
		System.out.println(sb.toString());
		
	}// main

}
