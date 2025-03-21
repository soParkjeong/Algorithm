import java.util.Scanner;

public class boj_10448_유레카 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		int n1 = 0;
		int n2 = 0;
		int n3 = 0;

		boolean check = false;

		for (int t = 0; t < T; t++) {
			int samgak = sc.nextInt();
			outter: 
			for (int n_1 = 1; n_1 < 1000; n_1++) {
				for (int n_2 = n_1; n_2 < 1000; n_2++) {
					for (int n_3 = n_2; n_3 < 1000; n_3++) {
						check=false;
						n1 = n_1 * (n_1 + 1) / 2;
						n2 = n_2 * (n_2 + 1) / 2;
						n3 = n_3 * (n_3 + 1) / 2;
						if(n1+n2+n3>1000) {
							break;
						}
						if (n1 + n2 + n3 == samgak) {
							check = true;
							break outter;
						}
					}
				}
			}
			if (check) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}
	}
}