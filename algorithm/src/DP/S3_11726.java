package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//2xn 타일링
public class S3_11726 {
	
	static int n;
	static long[] dp = new long[1001];
	
	static {
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		
		for(int i=3; i<=1000; i++) {
			dp[i] = (dp[i-1] + dp[i-2])%10007;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n =Integer.parseInt(br.readLine());
		
		System.out.println(dp[n]);
		
	}

}
