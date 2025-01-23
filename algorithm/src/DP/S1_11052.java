package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//카드 구매하기
public class S1_11052 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] card = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][] dp = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			for(int j=0; j<i; j++) {
				dp[i][j] = dp[i-1][j];
			}
			
			for(int k=i; k<=N; k++) {
				dp[i][k] = Math.max(dp[i-1][k], dp[i][k-i] + card[i]);
			}
		}
		
		System.out.println(dp[N][N]);		
		
	}

}
