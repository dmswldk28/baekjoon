package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 통계학
public class S3_2108 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		int[] arr = new int[N];
		int sum = 0;

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			sum += num;
			arr[i] = num;
		}

		double mean = (double) sum / N ;
		sb.append(Math.round(mean)).append('\n');

		Arrays.sort(arr);

		sb.append(arr[N / 2]).append('\n');

		// 최빈값
		Map<Integer, Integer> frequencyMap = new HashMap<>();
		for (int num : arr) {
			frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
		}

		// 빈도수 기준으로 정렬 (빈도가 높은 것부터, 빈도수가 같으면 값이 작은 것부터)
		List<Map.Entry<Integer, Integer>> sortedEntries = new ArrayList<>(frequencyMap.entrySet());
		sortedEntries.sort((entry1, entry2) -> {
			if (entry2.getValue() == entry1.getValue()) {
				return entry1.getKey() - entry2.getKey(); // 빈도수가 같으면 값이 작은 순
			}
			return entry2.getValue() - entry1.getValue(); // 빈도수 높은 순
		});

		// 최빈값 중 두 번째로 작은 값
		int mode = sortedEntries.get(0).getKey();
		int modeCount = sortedEntries.get(0).getValue();
		List<Integer> modeList = new ArrayList<>();

		for (Map.Entry<Integer, Integer> entry : sortedEntries) {
			if (entry.getValue() == modeCount) {
				modeList.add(entry.getKey());
			} else {
				break;
			}
		}

		// 최빈값 중 두 번째로 작은 값 출력
		if (modeList.size() > 1) {
			sb.append(modeList.get(1)).append('\n');
		} else {
			sb.append(modeList.get(0)).append('\n');
		}

		// 범위
		int range = arr[N - 1] - arr[0];
		sb.append(range);
		
		System.out.println(sb.toString());

	}

}
