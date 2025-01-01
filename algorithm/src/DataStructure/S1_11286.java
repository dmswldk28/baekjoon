package DataStructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

// 절댓값 힙
public class S1_11286 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator
			    .comparingInt((Integer n) -> Math.abs(n))  // 절댓값 기준 정렬
			    .thenComparingInt(n -> n));
		
		for(int i=0; i<N; i++) {
			int n = Integer.parseInt(br.readLine());
			
			if(n == 0) {
				if(pq.isEmpty()) {
					sb.append(0).append('\n');
				}else {
					sb.append(pq.poll()).append('\n');
				}
			}else {
				pq.add(n);
			}
		}
		
		bw.write(sb.toString());
        bw.flush();
		
	}

}
