package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 좌표 압축
public class S2_18890 {
	
//	static class Num implements Comparable<Num>{
//		int number, idx;
//		
//		public Num(int number, int idx) {
//			this.number = number;
//			this.idx = idx;
//		}
//
//		@Override
//		public int compareTo(Num o) {
//			return Integer.compare(this.number, o.number);
//		}
//
//	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
//		Num[] arr = new Num[N];
//		
//		for(int i=0; i<N; i++) {
//			arr[i] = new Num(Integer.parseInt(st.nextToken()), i);
//		}
//		
//		Arrays.sort(arr);
//		
//		int[] out = new int[N];
//		int curr = arr[0].number;
//		int k = 0;
//		
//		for(int i=0; i<N; i++) {
//			int idx = arr[i].idx;
//			if(arr[i].number == curr) {
//				out[idx] = k;
//			}else {
//				out[idx] = ++k;
//				curr = arr[i].number;
//			}
//		}
//		
//		for(int i=0; i<N; i++) {
//			sb.append(out[i]).append(' ');
//		}
		
		int[] original = new int[N];
		int[] sorted = new int[N];
		
		for(int i=0; i<N; i++) {
			original[i] = sorted[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(sorted);
		
		int k = 0;
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int n : sorted) {
			if(!map.containsKey(n)) {
				map.put(n, k++);
			}
		}
		
		for(int n : original) {
			int rank = map.get(n);
			sb.append(rank).append(' ');
		}
		
		System.out.println(sb.toString());
	}

}
