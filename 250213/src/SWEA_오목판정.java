import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_오목판정 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim()); // 테스트 케이스 개수
        
        for(int t=0;t<T;t++) {
        	int N = Integer.parseInt(br.readLine().trim());
        	String[][] omok=new String[N][N];
        	
        	for(int i=0;i<N;i++) {
        		String line=br.readLine();
        		for(int j=0;j<N;j++) {
        			omok[i][j] = String.valueOf(line.charAt(j));
        		}
        	}//배열 완성
        	

        	
        	boolean check=false;
        	
        	outter:
        	for(int i=0;i<N;i++) {
        		for(int j=0;j<N;j++) {
                	int cnt1=0;
                	int cnt2=0;
                	int cnt3=0;
                	int cnt4=0;
        			if(omok[i][j].equals("o")) {
        				for(int k=0;k<N;k++) {
        					int new_j=j+k;
        					if(new_j<N) {
        						//가로 탐색 
        						if(omok[i][new_j].equals("o")) {
        							cnt1++;
        							
        						}
        						if(cnt1<5 && omok[i][new_j].equals(".")) {
        							cnt1=0;
        							break;
        						}
        						if(cnt1>=5) {
        							check=true;
        							System.out.println("#"+(t+1)+" "+"YES");
        							break outter;
        						}
        					}
        				}
        				
        				for(int k=0;k<N;k++) {
        					int new_i=i+k;
        					if(new_i<N) {
        						//세로 탐색 
        						if(omok[new_i][j].equals("o")) {
        							cnt2++;
        						}
        						if(cnt2<5 && omok[new_i][j].equals(".")) {
        							cnt2=0;
        							break;
        						}
        						if(cnt2>=5) {
        							check=true;
        							System.out.println("#"+(t+1)+" "+"YES");
        							break outter;
        						}
        					}
        				}
        				
        				for(int k=0;k<N;k++) {
        					int new_j=j+k;
        					int new_i=i+k;
        					if(new_j<N && new_i<N) {
        						//대각선1 탐색 
        						if(omok[new_i][new_j].equals("o")) {
        							cnt3++;
        						}
        						if(cnt3<5 && omok[new_i][new_j].equals(".")) {
        							cnt3=0;
        							break;
        						}
        						if(cnt3>=5) {
        							check=true;
        							System.out.println("#"+(t+1)+" "+"YES");
        							break outter;
        						}
        					}
        				}
        				
        				for(int k=0;k<N;k++) {
        					int new_j=j-k;
        					int new_i=i+k;
        					if(new_j>=0 && new_i<N) {
        						//대각선2 탐색 
        						if(omok[new_i][new_j].equals("o")) {
        							cnt4++;
        						}
        						if(cnt4<5 && omok[new_i][new_j].equals(".")) {
        							cnt4=0;
        							break;
        						}
        						if(cnt4>=5) {
        							check=true;
        							System.out.println("#"+(t+1)+" "+"YES");
        							break outter;
        						}
        					}
        				}
        			}
        		}
        	}
        	if(check==false) {
        		System.out.println("#"+(t+1)+" "+"NO");
        	}
        }
	}
}
      	

