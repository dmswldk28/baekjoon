package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 피보나치 함수
public class S3_1003 {
	
	static BufferedReader br;
	static StringBuilder sb = new StringBuilder();
	
	static int T;
	static int[][] dp = new int[2][41];
	
	static {
		
		dp[0][0] = 1;
		dp[1][0] = 0;
		dp[0][1] = 0;
		dp[1][1] = 1;
		
		for(int i=2; i<=40; i++) {
			dp[0][i] = dp[0][i-1] + dp[0][i-2];
			dp[1][i] = dp[1][i-1] + dp[1][i-2];
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			int num = Integer.parseInt(br.readLine());
			sb.append(dp[0][num]).append(' ').append(dp[1][num]).append('\n');
		}
		
		System.out.println(sb.toString());
	}

}
