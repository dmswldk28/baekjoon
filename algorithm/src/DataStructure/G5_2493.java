package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 탑
public class G5_2493 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        int[] towers = new int[N];
        int[] results = new int[N];

        for (int i = 0; i < N; i++) {
            towers[i] = Integer.parseInt(input[i]);
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && towers[stack.peek()] < towers[i]) {
                stack.pop(); // 현재 탑이 더 높으면 스택에서 제거
            }

            if (stack.isEmpty()) {
                results[i] = 0; // 수신할 탑이 없는 경우
            } else {
                results[i] = stack.peek() + 1; // 수신할 탑의 번호 저장 (1-based index)
            }

            stack.push(i); // 현재 탑의 인덱스를 스택에 추가
        }

        StringBuilder sb = new StringBuilder();
        for (int result : results) {
            sb.append(result).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}
