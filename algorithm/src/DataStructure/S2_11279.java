package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

//최대 힙
public class S2_11279 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> -(o1 - o2));
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num == 0) {
				if(pq.isEmpty()) {
					sb.append(0).append('\n');
				}else {
					sb.append(pq.poll()).append('\n');
				}
			}else {
				pq.add(num);
			}
		}
		
		System.out.println(sb.toString());
		
	}

}
