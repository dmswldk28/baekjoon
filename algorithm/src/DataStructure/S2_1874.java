package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//스택 수열
public class S2_1874 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		int idx = 0;
		int i = 1;

		while (i <= N) {
			stack.push(i);
			sb.append('+').append('\n');
			i++;

			// 현재 스택의 top 값이 arr[idx]와 같으면 pop하고 결과에 '-' 추가
			while (!stack.isEmpty() && stack.peek() == arr[idx]) {
				stack.pop();
				sb.append('-').append('\n');
				idx++;
			}
		}

		// 모든 연산 후 스택에 값이 남아있다면, 불가능한 수열이므로 "NO" 출력
		if (!stack.isEmpty()) {
			System.out.println("NO");
		} else {
			System.out.println(sb.toString());
		}

	}

}
