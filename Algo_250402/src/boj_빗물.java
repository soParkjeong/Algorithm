import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class boj_빗물 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int H=sc.nextInt();
		int W=sc.nextInt();
		
		ArrayList<Integer>list=new ArrayList<>();
		for(int i=0;i<W;i++) {
			list.add(sc.nextInt());
		}
		
		int map_idx=0;
		int idx=0;
		int[][]map=new int[H][W];

		for(int k=0;k<list.size();k++) {
			int a=list.get(k);
			map_idx=H-1;
			for(int t=0;t<a;t++) {
				map[map_idx--][k]=1;//블록 1로 바꾸기 
			}
		}//맵 완성 
		
		for(int i=0;i<H;i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		
		int result=0;
		int[]arr=new int[H];

        for (int i = 0; i < H; i++) {
            int jdx = 0;
            boolean flag = false;
            int count1 = 0;

            while (jdx < W) { 
                if (map[i][jdx] == 1) { 
                    if (flag) { 
                        arr[i] += count1;
                    }
                    flag = true; 
                    count1 = 0;
                } else if (flag) { 
                    count1++;
                }
                jdx++;
            }
        }
		
		for(int k=0;k<H;k++) {
			result+=arr[k];
		}
		
		System.out.println(result);
	}
}
