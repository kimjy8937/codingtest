import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.StringTokenizer;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, Set<String>> reportMap = new HashMap<>(); 
        HashMap<String, Integer> mailMap = new HashMap<>();
        
        for(int i = 0; i < report.length; i++){
            StringTokenizer st = new StringTokenizer(report[i]);
            String reporter = st.nextToken();
            String reported = st.nextToken();
            
            if(!reportMap.containsKey(reported)){
                reportMap.put(reported, new HashSet<String>());
                reportMap.get(reported).add(reporter);
            }else {
                reportMap.get(reported).add(reporter);
            }
            
        
        }
        
        for(int i = 0; i < id_list.length; i++){
            if(reportMap.containsKey(id_list[i])){
                if(reportMap.get(id_list[i]).size() >= k){
                    
                    for(int j = 0; j < id_list.length; j++){
                        if(reportMap.get(id_list[i]).contains(id_list[j])){
                            if(!mailMap.containsKey(id_list[j])){
                                mailMap.put(id_list[j], 1);
                            }else{
                                mailMap.put(id_list[j], mailMap.get(id_list[j])+1);
                            }
                        }
                    }
                }
            }  
        }
        
        
        
        for(int i = 0; i < id_list.length; i++){
            if(!mailMap.containsKey(id_list[i]))
                answer[i] = 0;
            else
                answer[i] = mailMap.get(id_list[i]);
        }
        
        return answer;
    }
}