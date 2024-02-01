import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());

        int M=Integer.parseInt(br.readLine());
        StringTokenizer stTarget=new StringTokenizer(br.readLine());

        int[] intArr=new int[N];


        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(intArr);

        int[] intArr2=new int[M];
        for(int i=0;i<M;i++){
            intArr2[i]=Integer.parseInt(stTarget.nextToken());
        }

        StringBuilder finalResult=new StringBuilder();
        for(int i=0;i<M;i++){
            int target=intArr2[i];
            int result=findSameInt(intArr,M,target);

            finalResult.append(result).append("\n");
        }

        System.out.print(finalResult.toString());

        br.close();
    }
    private static int findSameInt(int[] arr,int N, int target){
        int left=0;
        int right=arr.length-1;

        int result = 0;

        while(left<=right) {
            int mid = (left + right) / 2;

            if (arr[mid] < target) {
                left = mid + 1;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                result = 1;
                break;
            }
        }
        return result;
        }
    }