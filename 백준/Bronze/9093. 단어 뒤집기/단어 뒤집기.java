import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int tokenCount=st.countTokens();

            Stack<Character>chStack = new Stack<>();
            Queue<String>stQueue=new LinkedList<>();

            for(int a=0;a<tokenCount;a++) {
                String token = st.nextToken();

                StringBuilder reversedWord=new StringBuilder();//여기서 reverseWord를 초기화해줘야 함

                for (int b = 0; b < token.length(); b++) {
                    chStack.push(token.charAt(b));//charAt(n): String에서 n번째 character을 의미하는 메서드
                }//알파벳 뒤집어져서 스택에 저장됨

                while(!chStack.isEmpty()) {
                    reversedWord.append(chStack.pop());//뒤집어진 단어가 완성됨
                }
                    stQueue.offer(String.valueOf(reversedWord));//뒤집어진 단어덩어리를 큐에 저장(단어는 큐에 저장해야 단어 순서가 안뒤집힘)
                    if(a<tokenCount-1){//(단어덩어리-1)개만큼 공백 필요
                        stQueue.offer(" ");//공백 추가
                    }
            }

            StringBuilder reversedSentence=new StringBuilder();
            while(!stQueue.isEmpty()){
                reversedSentence.append(stQueue.poll());
            }
            String newSentence=reversedSentence.toString();
            System.out.println(newSentence);
        }
        br.close();
    }
}