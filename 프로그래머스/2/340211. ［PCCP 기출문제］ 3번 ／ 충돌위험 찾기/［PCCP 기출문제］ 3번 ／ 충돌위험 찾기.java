import java.util.*;

class Solution {
    
    int pointCnt;
    int robotCnt;
    int routeLen;
    int[][] points;
    int[][] routes;
    
    
    class Robot{
        int y,x;
        boolean isOut;
        int nextCmd;
        
        Robot(int y, int x){
            this.y= y;
            this.x=x;
            this.isOut=false;
            nextCmd = 1;
        }
    } 
    
    Robot[] robo;
    
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        
        pointCnt = points.length;
        robotCnt = routes.length;
        routeLen = routes[0].length;
        this.points = points;
        this.routes = routes;
        
        robo = new Robot[robotCnt];
        
        for(int i=0; i<robotCnt; i++){
            
            int y = points[routes[i][0]-1][0];
            int x = points[routes[i][0]-1][1];
            
            robo[i] = new Robot(y,x); 
        }
        
        while(checkNext()){
            //로봇들이 겹치는지 확인
            answer += checkEmg();
            
            //아직 나가지 않은 모든 로봇을 다음 목적지로 1만큼 이동
            for(int i=0;i<robotCnt;i++){
                Robot robot = robo[i];
                
                //만약 nextCmd가 routeLen보다 크다면 isOut true
                if(robot.nextCmd >= routeLen) robot.isOut = true;
                //이미 나간 로봇은 고려하지 않는다.
                if(robot.isOut) continue;
                
                int nextCmd = robot.nextCmd;
                int y = points[routes[i][nextCmd]-1][0];
                int x = points[routes[i][nextCmd]-1][1];
                
                if(y != robot.y){
                    robot.y += y>robot.y ? 1 : -1;
                }else if(x != robot.x){
                    robot.x += x>robot.x ? 1 : -1;
                }
                
                if(y == robot.y && x==robot.x) robot.nextCmd++;
                
            }
            
        }

        return answer;
    }
    int checkEmg(){
        HashMap<Integer, Integer> hm = new HashMap<>();
        int result = 0;
        
        for(int i=0;i<robotCnt;i++){
            int hash;
            Robot robot = robo[i];
            if(robot.isOut) continue;
            
            
            hash = robot.y*101 + robot.x;
            // System.out.println(i+": "+hash);
            
            if(hm.containsKey(hash)){
                hm.replace(hash, hm.get(hash)+1);
            }else{
                hm.put(hash,1);
            }
        }
        
        for(int key : hm.keySet()){
            int value = hm.get(key);
            
            if(value >= 2) result++;
        }
        
        return result;
    }
    
    boolean checkNext(){
        for(int i=0;i<robotCnt;i++){
            if(!robo[i].isOut) return true; 
        }
        return false;
    }
}
