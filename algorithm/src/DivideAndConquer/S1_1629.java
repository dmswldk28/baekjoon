package DivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 곱셈
public class S1_1629 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long A = Integer.parseInt(st.nextToken());
		long B = Integer.parseInt(st.nextToken());
		long C = Integer.parseInt(st.nextToken());
		
		long result = 1;
		A = A % C;
		
		while(B > 0) {
			if(B%2 == 1) {
				result = (result * A) % C;
			}
			A = (A * A) % C;
			B = B / 2;
		}
		
		System.out.println(result);

	}

}
