package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 패션왕 신해빈
public class S3_9375 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<T; tc++) {
			int n = Integer.parseInt(br.readLine());
			int total = 1;
			Map<String, Integer> map = new HashMap<>();
			
			for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                String c = st.nextToken();  // 의상 이름
                String category = st.nextToken();  // 의상 카테고리
                
                // 카테고리별 의상 개수 증가
                map.put(category, map.getOrDefault(category, 0) + 1);
            }
			
			// 각 카테고리에서 의상을 고를 수 있는 방법의 수를 곱함
            for (String key : map.keySet()) {
                total *= (map.get(key) + 1); // 의상 1개 고를 경우 + 의상 0개 고를 경우
            }
            
            // 아무것도 고르지 않는 경우를 제외
            total -= 1;
            
            sb.append(total).append('\n');
        }//tc
		
		System.out.println(sb.toString());

	}//main

}
