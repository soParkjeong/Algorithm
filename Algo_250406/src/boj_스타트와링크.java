import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_스타트와링크 {
	static int N;
	static int[] start;
	static int[] link;
	static int[] arr;
	static int[][] S;
	static int minDiff;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());

		start = new int[N / 2];
		link = new int[N / 2];
		S = new int[N + 1][N + 1];
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}

		minDiff = Integer.MAX_VALUE;
		for (int i = 1; i <= N; i++) {
			String[] str = br.readLine().trim().split(" ");
			for (int j = 1; j <= N; j++) {
				S[i][j] = Integer.parseInt(str[j - 1]);
			}
		} // S배열 완성

		comb(0, 0);
		System.out.println(minDiff);
	}

	static void comb(int idx, int sidx) {// idx:arr의 인덱스, sidx:조합의 인덱스
		if (sidx == N / 2) {
			boolean[] isStart = new boolean[N + 1];
			for (int i = 0; i < N / 2; i++) {
				isStart[start[i]] = true;// start에 뽑힌 애들만 true 처리
			}

			int link_idx = 0;
			for (int i = 0; i < N; i++) {
				if (!isStart[arr[i]]) {
					link[link_idx++] = arr[i];
				}
			}

			int startSum = syn(start);
			int linkSum = syn(link);
			minDiff = Math.min(minDiff, Math.abs(startSum - linkSum));

			return;
		}

		if (idx == N) {
			return;
		}

		start[sidx] = arr[idx];
		comb(idx + 1, sidx + 1);// 뽑는 경우

		comb(idx + 1, sidx);// 안뽑는 경우
	}

	static int syn(int[] team) {// idx:start의 인덱스, sidx: 조합의 인덱스
		int sum = 0;
		for (int i = 0; i < N / 2; i++) {
			for (int j = i + 1; j < N / 2; j++) {
				int x = team[i];
				int y = team[j];
				sum += (S[x][y] + S[y][x]);
			}
		}
		return sum;
	}
}
