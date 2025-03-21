import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj_숨바꼭질 {
	static boolean[] visited;
	static int[] sis;
	static int time;
	static int[] current_N;
	static int[] new_N;

	public static void main(String[] args) {
		// 입력 및 초기화 !!!!!!!!!!!!!
		// 빨간줄 뜨면 가슴 세번 치고 심호흡 한 뒤 천천히 에러 문구 살펴보기  
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		visited = new boolean[100001];
		sis = new int[2];
		new_N = new int[2];
		current_N = new int[2];
		sis[0] = N;
		sis[1] = time;
		time = 0;

		// 알고리즘
		int result = bfs(sis, K);

		// 출력
		System.out.println(result);
	}

	static int bfs(int[] sis, int K) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(sis);// 일단 언니 시작점 큐에 넣기
		visited[sis[0]] = true;

		while (true) {
			current_N = queue.poll();// 큐에서 꺼낸 것이 현재 위치
			// current_N[1] 을 갱신해주고 꺼내쓰는 코드는 어디에..?
			
			if(current_N[0] == K) {
				return current_N[1];
			}

			int[] arr = { -1, 1, current_N[0] };
			for (int i = 0; i < 3; i++) {
				new_N[0] = current_N[0] + arr[i];
				if (new_N[0] < 0 || new_N[0] > 100000 || visited[new_N[0]])
					continue;
				
				new_N[1] = current_N[1] + 1;
				visited[new_N[0]] = true;
				queue.add(new int[] { new_N[0], new_N[1]});
			}
		}
	}
	
}
