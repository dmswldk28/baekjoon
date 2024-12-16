package DivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 피보나치 수 6
public class G2_11444 {

	// 행렬 곱셈 함수
    public static long[][] multiply(long[][] a, long[][] b, long mod) {
        long[][] result = new long[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                result[i][j] = 0;
                for (int k = 0; k < 2; k++) {
                    result[i][j] = (result[i][j] + a[i][k] * b[k][j]) % mod;
                }
            }
        }
        return result;
    }

    // 행렬 거듭제곱 함수
    public static long[][] power(long[][] matrix, long n, long mod) {
        long[][] result = new long[2][2];
        result[0][0] = 1;
        result[1][1] = 1;
        long[][] base = matrix;

        while (n > 0) {
            if (n % 2 == 1) {
                result = multiply(result, base, mod);
            }
            base = multiply(base, base, mod);
            n /= 2;
        }

        return result;
    }

    // n번째 피보나치 수를 구하는 함수
    public static long fibonacci(long n, long mod) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        long[][] matrix = {{1, 1}, {1, 0}};
        long[][] result = power(matrix, n - 1, mod);

        return result[0][0];
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long mod = 1000000007;

        // n번째 피보나치 수 구하기
        System.out.println(fibonacci(n, mod));
    }

}
