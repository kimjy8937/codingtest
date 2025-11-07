import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> idMap = new HashMap<>(); // (아이디 - 닉네임) Map
        int count = 0; // 메시지에 뿌려지지 않을 경우(Change일 때) 카운트
        
        for(int i = 0; i < record.length; i++){
            String[] info = record[i].split(" ");
            
            if(info[0].equals("Leave")){        // 나가는 경우
                continue;
            } else if(info[0].equals("Enter")){ // 들어오는 경우
                idMap.put(info[1], info[2]);
            } else {                            // 닉네임을 변경하는 경우
                idMap.put(info[1], info[2]);
                count++;
            }
        }
        
        String[] answer = new String[record.length - count];
        int idx = 0;
        
        for(int i = 0; i < record.length; i++){
            String[] info = record[i].split(" ");
            String nickname = idMap.get(info[1]);
            
            if(info[0].equals("Enter")){                      // 들어오는 경우
                answer[idx++] = nickname + "님이 들어왔습니다.";
            } else if(info[0].equals("Leave")){               // 나가는 경우
                answer[idx++] = nickname + "님이 나갔습니다.";
            }
        }
        
        return answer;
    }
}
