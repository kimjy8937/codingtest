import java.util.*;
class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        //어떤 돗자리가 젤 큰지 저장하기 위함 list
        List<Integer> list = new ArrayList<>();
        //공원 크기 
        int n = park.length;
        int m = park[0].length;
        for(int i = 0 ; i<n ; i++){
            for(int j = 0; j<m; j++){
                //돗자리를 필 수 있다면 로직 시작
                if(park[i][j].equals("-1")){
                    // mats에 있는 모든 돗자리를 탐색
                    //5,3,2 이면 5*5, 3*3 ,2*2가 가능한 지 탐색
                    for(int k = 0; k<mats.length; k++){
                        int num = mats[k];
                        int count = 0 ;
                        for(int x = i; x<i+num; x++){
                            for(int y = j; y<j+num; y++){
                                if(x < 0 || x >= n || y < 0|| y >= m){
                                    continue;
                                }
                                if(park[x][y].equals("-1")){
                                    count++;
                                }
                            }
                        }
                        
                        if(count == num*num){
                            list.add(num);
                        }
                    }
                }
            }
        }
        
        //가능한 돗자리가 없다면 -1
        if(list.size() == 0){
            answer = -1;
        }else{
            //가능한 돗자리가 있다면 그중에 젤 큰 사이즈 저장
            Collections.sort(list);
            answer = list.get(list.size()-1);
        }
        return answer;
    }
}