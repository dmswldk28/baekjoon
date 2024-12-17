package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// 트리 순회
public class S1_1991 {

	// 트리를 구성할 HashMap: 각 노드에 대해 왼쪽, 오른쪽 자식 정보를 저장
    static Map<Character, char[]> tree = new HashMap<>();
    
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			String[] data = br.readLine().split(" ");
			
			char parent = data[0].charAt(0);
			char left = data[1].charAt(0);
			char right = data[2].charAt(0);
			
			// 부모 노드에 대해 왼쪽, 오른쪽 자식을 기록
            tree.put(parent, new char[]{left, right});
		}
		
		// 트리의 순회 결과 출력
        preorder('A');
        System.out.println();
        inorder('A');
        System.out.println();
        postorder('A');
        System.out.println();

	} // main
	
	// 전위 순회 (Preorder Traversal): 루트 -> 왼쪽 -> 오른쪽
    static void preorder(char node) {
        if (node == '.') return; // null 노드는 무시
        System.out.print(node);  // 루트 출력
        char[] children = tree.get(node);  // 왼쪽, 오른쪽 자식 얻기
        preorder(children[0]);  // 왼쪽 자식 순회
        preorder(children[1]);  // 오른쪽 자식 순회
    }
    
    // 중위 순회 (Inorder Traversal): 왼쪽 -> 루트 -> 오른쪽
    static void inorder(char node) {
        if (node == '.') return;
        char[] children = tree.get(node);
        inorder(children[0]);  // 왼쪽 자식 순회
        System.out.print(node);  // 루트 출력
        inorder(children[1]);  // 오른쪽 자식 순회
    }
    
    // 후위 순회 (Postorder Traversal): 왼쪽 -> 오른쪽 -> 루트
    static void postorder(char node) {
        if (node == '.') return;
        char[] children = tree.get(node);
        postorder(children[0]);  // 왼쪽 자식 순회
        postorder(children[1]);  // 오른쪽 자식 순회
        System.out.print(node);  // 루트 출력
    }

}
