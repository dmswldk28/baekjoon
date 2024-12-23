package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 요세푸스 문제 0
public class S4_11866 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		sb.append('<');
		
//		Queue<Integer> q = new LinkedList<>();
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i=1; i<=N; i++) {
//			q.add(i);
			list.add(i);
		}
		
//		int k = 1;
//		while(!q.isEmpty()) {
//			int curr = q.poll();
//			if(k == K) {
//				k = 1;
//				sb.append(curr);
//				if(q.size() > 0) {
//					sb.append(", ");
//				}
//			}else {
//				q.add(curr);
//				k++;
//			}
//		}
		
		int t = 0;
		while(list.size() > 0) {
			t = (t+K-1)%(list.size());
			sb.append(list.get(t));
			list.remove(t);
			if(list.size() > 0) {
				sb.append(", ");
			}
		}
		
		sb.append('>');
		
		System.out.println(sb.toString());
	}

}
