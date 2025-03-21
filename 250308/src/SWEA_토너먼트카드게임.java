import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_토너먼트카드게임 {
    static int[] arr;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            arr = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }

            int winner = mergeSort(0, N - 1);
            System.out.println("#" + tc + " " + (winner + 1)); // 문제에서 1-based index 요구
        }
    }

    //분할 
    static int mergeSort(int start, int end) {
    	//기저 조건 
        if (start == end) return start; //한 명 남으면 반환 
        
        //중간값 구하기 
        int mid = (start + end) / 2;

        int l_w = mergeSort(start, mid);     // 왼쪽 사람  
        int r_w = mergeSort(mid + 1, end);  // 오른쪽 사람 
        
        return merge(l_w, r_w);
    }
    
    //병합 
    static int merge(int L_S, int R_S) {
        int a = arr[L_S];
        int b = arr[R_S];
        
        //무조건 왼오 비교 후 이긴 애만 
        if ((a == 1 && b == 2) || (a == 2 && b == 3) || (a == 3 && b == 1)) {
            return R_S; // B가 승리
        } else if (a == b) {
        	int result=Math.min(L_S, R_S);
            return result; // 같은 경우 작은 인덱스(앞쪽) 승리
        }
        return L_S; // A가 승리
    }
}