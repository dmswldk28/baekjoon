package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2xn 타일링 2
public class S3_11727 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] dp = new int[1001];
		
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 3;
		
		if(n > 2) {
			for(int i=3; i<=n; i++) {
				dp[i] = (dp[i-1] + dp[i-2]*2)%10007;
			}
		}
		
		System.out.println(dp[n]);

	}

}
