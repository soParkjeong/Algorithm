import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_3085_상근 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		char[][]candy=new char[N][N];
		
		for(int i=0;i<N;i++) {
			char[]arr=br.readLine().trim().toCharArray();
			for(int j=0;j<N;j++) {
				candy[i][j]=arr[j];
			}
		}//배열 완성
		
		char[][]change=new char[N][N];
		boolean check=false;
		int max=0;
		int result_col=0;
		int result_row=0; 
		int cnt_col=1;
		int cnt_row=1;
		int max_col=0;
		int max_row=0;
		//System.out.println(Arrays.deepToString(change));
		for(int j=0;j<N;j++) {
			for(int i=0;i<N-1;i++) {
				check=false;
				change = new char[candy.length][];
		        for (int x = 0; x < candy.length; x++) {
		            change[x] = Arrays.copyOf(candy[x], candy[x].length);  // 각 행을 개별적으로 복사
		        }
				//행 요소끼리 바꾼 경우 
				if(change[i][j]!=change[i+1][j]) {
					check=true;
					char tmp=change[i][j];
					change[i][j]=change[i+1][j];
					change[i+1][j]=tmp;
				}//자리 교환 
				
//				for (int u = 0; u < N; u++) {
//					System.out.println(Arrays.toString(change[u]));
//				}
//				System.out.println("---------------------");
				
				if(check) {
					//열 별로 같은 개수만큼 세기 
					for(int x=0;x<N;x++) {
						cnt_col=1;
						for(int y=0;y<N-1;y++) {
							if(change[x][y]==change[x][y+1]) {
								cnt_col++;
								if(max_col<cnt_col){
									max_col=cnt_col;//나 자신 더해주기 
								}
							}else {
								cnt_col=1;
							}
						}
					}
					
					//행 별로 같은 개수만큼 세기 
					for(int	y=0;y<N;y++) {
						cnt_row=1;
						for(int x=0;x<N-1;x++) {
							if(change[x][y]==change[x+1][y]) {
								cnt_row++;
								if(max_row<cnt_row){
									max_row=cnt_row;//나 자신 더해주기 
								}
							}else {
								cnt_row=1;
							}
						}
					}
				}
				max=Math.max(max_col,max_row);
				result_col=Math.max(result_col,max);
			}
		}
		
		check=false;
		max=0;
		cnt_col=1;
		cnt_row=1;
		max_col=0;
		max_row=0;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N-1;j++) {
				check=false;
				change = new char[candy.length][];
		        for (int x = 0; x < candy.length; x++) {
		            change[x] = Arrays.copyOf(candy[x], candy[x].length);  // 각 행을 개별적으로 복사
		        }
				//행 요소끼리 바꾼 경우 
				if(change[i][j]!=change[i][j+1]) {
					check=true;
					char tmp=change[i][j];
					change[i][j]=change[i][j+1];
					change[i][j+1]=tmp;
				}//자리 교환 
				
				if(check) {
					for(int x=0;x<N;x++) {
						cnt_col=1;
						for(int y=0;y<N-1;y++) {
							if(change[x][y]==change[x][y+1]) {
								cnt_col++;
								if(max_col<cnt_col){
									max_col=cnt_col;//나 자신 더해주기 
								}
							}else {
								cnt_col=1;
							}
						}
					}
					for(int x=0;x<N;x++) {
						cnt_row=1;
						for(int y=0;y<N-1;y++) {
							if(change[y][x]==change[y+1][x]) {
								cnt_row++;
								if(max_row<cnt_row){
									max_row=cnt_row;//나 자신 더해주기 
								}
							}else {
								cnt_row=1;
							}
						}
					}
				}
				max=Math.max(max_col,max_row);
				result_row=Math.max(result_row,max);
			}
		}
		System.out.println(Math.max(result_row, result_col));
	}
}
