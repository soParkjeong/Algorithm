                                        import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class SWEA_나무{
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine().trim());
        int final_result=0;
        for(int tc=1;tc<=T;tc++) {
            int N=Integer.parseInt(br.readLine().trim());
            int[] tree=new int[N];
            int max=0;
            String[]tree_str=br.readLine().trim().split(" ");
            for(int i=0;i<N;i++) {
                tree[i]=Integer.parseInt(tree_str[i]);
                if(max<tree[i]) {
                    max=tree[i];
                }//나무 최대값 저장
            }//나무 배열 완성 
            int[] diff=new int[N];
            int day_sum=0;
            int count1=0;//차이%2를 더해주는 것 
            int count2=0;//차이/2를 더해주는 것 
            for(int i=0;i<N;i++) {
            	diff[i]=max-tree[i];
            	count1+=diff[i]%2;
            	count2+=diff[i]/2;
            }
            if(count1>count2) {
            	day_sum=2*count2;
            	day_sum+=2*(count1-count2)-1;
            }else if(count1==count2){
            	day_sum=2*count1;
            }else {
            	day_sum=2*count1;
            	int diff_sum=(count2-count1)*2;
            	if(diff_sum%3==0) {
            		day_sum+=((diff_sum)/3)*2;
            	}else if(diff_sum%3==1) {
            		day_sum+=((diff_sum)/3)*2+1;
            	}
            	else {
            		day_sum+=((diff_sum)/3+1)*2;
            	}
            }
            System.out.println("#"+tc+" "+day_sum);
        }
    }
}
 