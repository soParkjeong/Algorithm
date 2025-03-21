import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class IM_test2 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(bReader.readLine());
        
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(bReader.readLine());    //배열의 크기
            int[][] board = new int[N][N];
            
            //보드 입력
            for (int i = 0; i < board.length; i++) {
                String[] temp = bReader.readLine().split(" ");
                for (int j = 0; j < board.length; j++) {
                    board[i][j]= Integer.parseInt(temp[j]);
                }
            }
            //보드 입력 완료
            
            int result = 0;
            String[][] waystoGo = new String[N][N];
            
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    int plusi = waytoMove(i, j, board)[0];
                    int plusj = waytoMove(i, j, board)[1];
                    
                    if(plusi == 0 && plusj == 0) {
                        waystoGo[i][j]="stop"; 
                    }else if(plusi == -1 && plusj == 0) {
                        waystoGo[i][j] = "up";
                    }else if(plusi == 1 && plusj == 0) {
                        waystoGo[i][j] = "down";
                    }else if(plusi == 0 && plusj == -1) {
                        waystoGo[i][j] = "left";
                    }else if(plusi == 0 && plusj == 1) {
                        waystoGo[i][j] = "right";
                    }
                    
                }
            }
            for (int i = 0; i < waystoGo.length; i++) {
                for (int j = 0; j < waystoGo.length; j++) {
                    int max = 0;
                    int nr = i;
                    int nc = j;
                    while (waystoGo[nr][nc] != "stop" ) {
                        String str = waystoGo[nr][nc];
                        if(str == "up") {
                            nr--;
                        }else if(str == "down") {
                            nr++;
                        }else if(str == "left") {
                            nc--;
                        }else if(str == "right") {
                            nc++;
                        }
                        max++;
                    }
                    max++;
                    result = Math.max(max, result);
                }
            }
            
            
            
            bWriter.write("#"+tc+" "+result+"\n");
        }//tc
        bWriter.flush();
    }
    
    public static int[] waytoMove(int i, int j, int[][] board) {
        int[] res = new int[2];    //이동할 방향
        
        int[] dr = {-1,1,0,0};    //상하좌우
        int[] dc = {0,0,-1,1};    //상하좌우
        int min = 500;    //4방향 중 최솟값
        
        int way= 0;
        
        for (int k = 0; k < dc.length; k++) {
            int nr = i+dr[k];
            int nc = j+dc[k];
            if(nr < 0 || nr >= board.length || nc < 0 || nc >= board.length) {
                continue;
            }
            if(min > board[nr][nc]) {
                min = board[nr][nc];
                way = k;
            }
        }//4방향 탐색
        if(board[i][j]>min) {
            res[0] = dr[way];
            res[1] = dc[way];
        }else {
            res[0] = 0;
            res[1] = 0;
        }

        return res;
    }
}
