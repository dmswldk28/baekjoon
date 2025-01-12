package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

// 듣보잡
public class S4_1764 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Set<String> set = new HashSet<>();
		List<String> list = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			set.add(br.readLine().trim());
		}
		
		for(int i=0; i<M; i++) {
			String name = br.readLine().trim();
			if(set.contains(name)) {
				list.add(name);
			}
		}
		
		Collections.sort(list);
		
		StringBuilder sb = new StringBuilder();
		sb.append(list.size()).append('\n');
		
		for(int i=0; i<list.size(); i++) {
			sb.append(list.get(i)).append('\n');
		}
		
		System.out.println(sb.toString());

	}

}
