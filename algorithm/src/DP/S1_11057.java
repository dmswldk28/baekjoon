package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//오르막 수
public class S1_11057 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[][] dp = new int[N+1][10];
        
        Arrays.fill(dp[0], 1);
        
        for (int i = 1; i <= N; i++) {
            dp[i][0] = 1;
            for (int j = 1; j < 10; j++) {
                dp[i][j] = (dp[i-1][j]%10007+dp[i][j-1]%10007)%10007;
            }
        }
        
        System.out.print(dp[N][9]);
        
	}

}
