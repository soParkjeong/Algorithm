import java.util.Scanner;
 
class SWEA_이진트리 
{
    static Scanner sc=new Scanner(System.in);
    static int[] tree;//배열로 트리를 표현
    static int cnt=1;//트리에 저장할 값(1부터 시작)
    public static void main(String args[]) throws Exception
    {
        int T=sc.nextInt();
        for(int t=0;t<T;t++){
            int N=sc.nextInt();//노드 개수
            tree=new int[N+1];//tree의 인덱스를 1부터 시작하도록 지정
            cnt=1;
             
            inorder(1,N);//루트 노드(루트: 트리 인덱스 1)부터 중위 순회
             
            //결과 출력
            System.out.println("#"+(t+1)+" "+tree[1]+" "+tree[N/2]);
            }
    }
             
        //중위 순회(L-V-R)
        static void inorder(int v,int N){
            if(v>N) return; //트리 인덱스가 배열 범위를 벗어나면 종료
                 
            inorder(2*v,N);//왼쪽 자식 방문(L)
            tree[v]=cnt++;//현재 노드 저장(v)
            inorder(2*v+1,N);//오른쪽 자식 방문(R)
            }
        }
