import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();

        int len = genres.length;
        Map<String, Integer> totalPlays = new HashMap<>();
        Map<String, HashMap<Integer , Integer>> genreInfo = new HashMap<>();

        for(int idx =0 ; idx<len ; idx++){
            String genre = genres[idx];
            int play = plays[idx];
            if(!genreInfo.containsKey(genre)) {
                HashMap<Integer, Integer> map = new HashMap<>();
                map.put(idx, play);
                genreInfo.put(genre, map);
            } else {
                genreInfo.get(genre).put(idx , play);
            }
            totalPlays.put(genre, totalPlays.getOrDefault(genre, 0) + play);
        }

        List<String> keySet = new ArrayList(totalPlays.keySet());
     
        Collections.sort(keySet, (o1 , o2) -> totalPlays.get(o2) - totalPlays.get(o1));

        for(String key : keySet) {
            Map<Integer, Integer> map = genreInfo.get(key);

            List<Integer> sortedMap = new ArrayList(map.keySet());
            Collections.sort(sortedMap, (o1 , o2) -> map.get(o2) - map.get(o1));

            answer.add(sortedMap.get(0));
            if(sortedMap.size() > 1) {
                answer.add(sortedMap.get(1));
            }
        } 
        return answer.stream().mapToInt(i -> i).toArray();
    }
}