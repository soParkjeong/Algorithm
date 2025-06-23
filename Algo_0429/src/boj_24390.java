import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_24390 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), ":");

		int m = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());

		int time = m * 60 + s;
		int cnt = 1;

		if (time == 0) {
			cnt = 0;
		} else {
			cnt += time / 600;
			time %= 600;

			cnt += time / 60;
			time %= 60;

			if (time / 30 != 0) {
				cnt--;
			}
			cnt += time / 30;
			time %= 30;

			cnt += time / 10;
		}

		System.out.println(cnt);
	}
}