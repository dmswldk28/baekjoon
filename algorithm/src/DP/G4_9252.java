package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//LCS 2
public class G4_9252 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		String str2 = br.readLine();
		
		int size1 = str1.length();
		int size2 = str2.length();
		
		int[][] dp = new int[size1+1][size2+1];
		
		for(int i=1; i<=size1; i++) {
			for(int j=1; j<=size2; j++) {
				if(str1.charAt(i-1) == str2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		System.out.println(dp[size1][size2]);
		
		StringBuilder sb = new StringBuilder();
		int i = size1, j = size2;
		
		while(i>0 && j>0) {
			if(str1.charAt(i-1) == str2.charAt(j-1)) {
				sb.append(str1.charAt(i-1));
				i--;
				j--;
			}else if(dp[i-1][j] >= dp[i][j-1]) {
				i--;
			}else {
				j--;
			}
		}
		
		System.out.println(sb.reverse().toString());

	}

}
