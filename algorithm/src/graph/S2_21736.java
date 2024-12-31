package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 헌내기는 친구가 필요해
public class S2_21736 {

	static int N, M;
    static char[][] campus;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0}; // 상하좌우 이동
    static int[] dy = {0, 0, 1, -1};
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		campus = new char[N][M];
		int x = -1, y = -1;
		
		for(int i=0; i<N; i++) {
			String line = br.readLine()	;
			for(int j=0; j<M; j++) {
				campus[i][j] = line.charAt(j);
				if(campus[i][j] == 'I') {
					x = i;
					y = j;
				}
			}
		}
		
		// 방문 체크 배열
        visited = new boolean[N][M];
        
        // BFS 탐색
        int peopleCount = bfs(x, y);
        
        // 결과 출력
        if (peopleCount == 0) {
            System.out.println("TT");
        } else {
            System.out.println(peopleCount);
        }

	}
	
	// BFS 구현
    static int bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {startX, startY});
        visited[startX][startY] = true;
        
        int peopleCount = 0;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            
            // 현재 위치가 사람(P)이라면 사람을 만났으므로 카운트
            if (campus[x][y] == 'P') {
                peopleCount++;
            }
            
            // 상하좌우로 이동
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                // 캠퍼스를 벗어나지 않고, 벽(X)이 아니며, 방문하지 않은 곳이라면
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && campus[nx][ny] != 'X') {
                    visited[nx][ny] = true;
                    queue.offer(new int[] {nx, ny});
                }
            }
        }
        
        return peopleCount;
    }

}
