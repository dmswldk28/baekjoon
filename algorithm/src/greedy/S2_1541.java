package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 잃어버린 괄호
public class S2_1541 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 먼저 '-'를 기준으로 나누어준다
		String[] splitMinus = br.readLine().split("-");

		// 첫 번째 부분은 더하고, 나머지 부분은 빼는 방식으로 처리
		int result = 0;

		// 첫 번째 "-" 앞의 부분을 처리
		String[] firstPart = splitMinus[0].split("\\+");
		result += calculate(firstPart);

		// 그 뒤의 부분들을 모두 빼기
		for (int i = 1; i < splitMinus.length; i++) {
			String[] part = splitMinus[i].split("\\+");
			result -= calculate(part);
		}

		// 결과 출력
		System.out.println(result);

	}

	// "+"로 나누어진 부분을 처리하는 함수
	public static int calculate(String[] part) {
		int sum = 0;
		for (String num : part) {
			sum += Integer.parseInt(num);
		}
		return sum;
	}

}
