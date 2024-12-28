package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Four Squares
public class S3_17626 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i; // 최악의 경우는 모두 1^2로 이루어진 경우
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
		
		System.out.println(dp[n]);

	}

}
