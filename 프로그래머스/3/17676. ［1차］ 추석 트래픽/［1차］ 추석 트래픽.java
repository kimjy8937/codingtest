import java.util.*;
class Solution {
    public int solution(String[] lines) {
        int max = 0;
        List<int[]> list = new ArrayList<>();
        for(String data:lines){
            String[] temp =data.split(" ");
            String time=temp[1];
            int t=cal(time);
            String dur=temp[2];
            int d=cal2(dur);
            list.add(new int[]{t-d,0});
            list.add(new int[]{t+1000,1});
        }
        
        Collections.sort(list,(a,b)->(a[0]-b[0]));
        int cnt=0;
        
        for(int[] data:list){
            if(data[1]==0){
                cnt++;
            }
            else{
                cnt--;
            }
            max=Math.max(max,cnt);
        }              
        return max;
    }
    
    public int cal(String time){
        String[] temp = time.split(":");
        int sum=0;
        int hour=Integer.parseInt(temp[0]);
        int min=Integer.parseInt(temp[1]);
        int sec=(int)(Double.parseDouble(temp[2])*1000);
        
        sum+=3600*hour*1000+min*60*1000+sec;
        return sum;
    }
    public int cal2(String dur){
        dur=dur.substring(0,dur.length()-1);
        int time=(int)(Double.parseDouble(dur)*1000);
        return time-1;
    }
}