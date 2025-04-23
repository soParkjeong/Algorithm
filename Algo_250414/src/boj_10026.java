import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj_10026 {
	static int N;
	static char[][] map;
	static boolean[][] visited; 
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	static class Node {
		int x, y;
		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().trim().toCharArray();
		}

		visited = new boolean[N][N];
		int normal = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					bfs(i, j, map[i][j], false);
					normal++;
				}
			}
		}

		visited = new boolean[N][N];
		int JR = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					bfs(i, j, map[i][j], true);
					JR++;
				}
			}
		}

		System.out.println(normal + " " +JR);
	}

	static void bfs(int x, int y, char color, boolean JR) {
		Queue<Node> q = new LinkedList<>();
		visited[x][y] = true;
		q.add(new Node(x, y));

		while (!q.isEmpty()) {
			Node node = q.poll();
			for (int k = 0; k < 4; k++) {
				int nx = node.x + dx[k];
				int ny = node.y + dy[k];

				if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
					if (JR) {
						if ((color == 'R' || color == 'G') && (map[nx][ny] == 'R' || map[nx][ny] == 'G')) {
							visited[nx][ny] = true;
							q.add(new Node(nx, ny));
						} else if (color == 'B' && map[nx][ny] == 'B') {
							visited[nx][ny] = true;
							q.add(new Node(nx, ny));
						}
					} else {
						if (map[nx][ny] == color) {
							visited[nx][ny] = true;
							q.add(new Node(nx, ny));
						}
					}
				}
			}
		}
	}
}