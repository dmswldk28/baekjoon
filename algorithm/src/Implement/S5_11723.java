package Implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 집합
public class S5_11723 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine());
//		int num = 0;
		boolean[] set = new boolean[21];
		
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			
			if("add".equals(cmd)) {
				int number = Integer.parseInt(st.nextToken());
				set[number] = true;
			}
			
			else if("remove".equals(cmd)) {
				int number = Integer.parseInt(st.nextToken());
				set[number] = false;
			}
			
			else if("check".equals(cmd)) {
				int number = Integer.parseInt(st.nextToken());
				if(set[number]) {
					sb.append(1).append('\n');
				}else {
					sb.append(0).append('\n');
				}
			}
			
			else if("toggle".equals(cmd)) {
				int number = Integer.parseInt(st.nextToken());
				if(set[number]) set[number] = false;
		        else set[number] = true;
			}
			
			else if("all".equals(cmd)) {
				 Arrays.fill(set,true);
			}
			
			else {
				set = new boolean[21];
			}
			
		}
		
//		for(int i=0; i<M; i++) {
//			String[] cmd = br.readLine().split(" ");
//			int x = 0;
//			switch (cmd[0]) {
//			case "add": 
//				x = Integer.parseInt(cmd[1]);
//				num |= (1 << (x-1)); // x번째 비트를 1로 설정
//				break;
//			case "remove":
//				x = Integer.parseInt(cmd[1]);
//				num &= ~(1 << (x - 1));  // x번째 비트를 0으로 설정
//				break;
//			case "check":
//				x = Integer.parseInt(cmd[1]);
//				if((num & (1 << (x-1))) != 0) {
//					sb.append(1).append('\n'); // x번째 비트가 1이면 1 출력
//				}else {
//					sb.append(0).append('\n'); // x번째 비트가 0이면 0 출력
//				}
//				break;
//			case "toggle":
//				x = Integer.parseInt(cmd[1]);
//				num ^= (1 << (x-1)); // x번째 비트를 반전
//				break;
//			case "all":
//				num = (1 << 20) -1; // 모든 비트를 1로 설정
//				break;
//			case "empty":
//				num = 0; // 모든 비트를 0으로 설정
//				break;
//			}
//		}
		
		bw.write(sb.toString());
        bw.flush();

	}

}
