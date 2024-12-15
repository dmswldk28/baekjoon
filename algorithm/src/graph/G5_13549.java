package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G5_13549 {
    
    static class Node implements Comparable<Node> {
        int curr, time;

        public Node(int curr, int time) {
            this.curr = curr;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.time, o.time);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if (N == K) {
            System.out.println(0);
            return;
        }

        int MAX = 100001;
        int[] arr = new int[MAX];
        Arrays.fill(arr, -1);

        PriorityQueue<Node> q = new PriorityQueue<>();
        arr[N] = 0;
        q.add(new Node(N, 0));

        while (!q.isEmpty()) {
            Node node = q.poll();
            int curr = node.curr;

            int[] next = {curr * 2, curr + 1, curr - 1};
            for (int n : next) {
                if (n >= 0 && n < MAX) {
                    if (n == curr * 2) {
                        if (arr[n] == -1 || arr[n] > arr[curr]) {
                            arr[n] = arr[curr];
                            q.add(new Node(n, arr[n]));
                        }
                    } else {
                        if (arr[n] == -1 || arr[n] > arr[curr] + 1) {
                            arr[n] = arr[curr] + 1;
                            q.add(new Node(n, arr[n]));
                        }
                    }
                }
            }
        }

        System.out.println(arr[K]);
    }
}
