import java.util.Stack;

 class Solution {
     public void makeNum(Stack st){//중복없는 3자리 숫자 생성
         for(int i=1;i<=9;i++){
             for(int j=1;j<=9;j++){
                 for(int k=1;k<=9;k++){
                     if(i!=j&&j!=k&&k!=i){
                         st.push(String.valueOf(100*i+10*j+k));
                     }
                 }
             }
         }
     }
     public boolean check(String num, int[][] baseball){
         String base="";
         int strike=0, ball=0;
         for(int i=0;i<baseball.length;i++){
             base=String.valueOf(baseball[i][0]);
             for(int j=0;j<3;j++){
                 if(num.charAt(j)==base.charAt(j)){//스트라이크 체크
                     strike++;
                 }
                 if(base.contains(String.valueOf(num.charAt(j)))){//볼 체크
                     ball++;
                 }
             }
             ball=ball-strike;//스트라이크와 볼은 겹치지 않으므로
             if(strike!=baseball[i][1]||ball!=baseball[i][2]){
                 return false;
             }
             strike=0;
             ball=0;
         }
         return true;
     }
     public int solution(int[][] baseball) {
         int answer = 0;
         Stack<String> st=new Stack<>();
         String num;
         boolean chk=false;
         makeNum(st);
         while(!st.isEmpty()){
             num=st.pop();
             if(check(num, baseball)){
                 answer++;
             }
         }
         return answer;
     }
 }