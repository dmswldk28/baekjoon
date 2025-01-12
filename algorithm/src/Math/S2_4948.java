package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//베르트랑 공준
public class S2_4948 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int Max = 123456 * 2;
		
		boolean[] isPrime = new boolean[Max + 1];
		isPrime[0] = isPrime[1] = false;
		for(int i=2; i<=Max; i++) {
			isPrime[i] = true;
		}
		
		for(int i=2; i*i<=Max; i++) {
			if(isPrime[i]) {
				for(int j=i*i; j<=Max; j+=i) {
					isPrime[j] = false;
				}
			}
		}
		
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n == 0) break;
			
			int cnt = 0;
			for(int i=n+1; i<=2*n; i++) {
				if(isPrime[i]) {
					cnt++;
				}
			}
			
			sb.append(cnt).append('\n');
		}
		
		System.out.println(sb.toString());

	}

}
