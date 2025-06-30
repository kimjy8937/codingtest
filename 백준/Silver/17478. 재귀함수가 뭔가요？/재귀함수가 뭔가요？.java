import java.util.*;
import java.io.*;

public class Main{
    static StringBuilder sb;
    static int N;
    static String pre = "";
    public static void chat() {
        if(N < 0){
            return;
        }
        sb.append(pre + "\"재귀함수가 뭔가요?\"\n");
        if(N == 0){
            sb.append(pre + "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
        } else {
            sb.append(pre + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
            sb.append(pre + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
            sb.append(pre + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
        }
        pre = pre + "____";
        N--;
        chat();
        pre = pre.substring(0, pre.length()-4);
        sb.append(pre + "라고 답변하였지.\n");  
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        sb = new StringBuilder("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
        chat();
        System.out.println(sb.toString());
    }
}