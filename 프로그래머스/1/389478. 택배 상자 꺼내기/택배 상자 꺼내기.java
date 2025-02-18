class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        int numw;
        int nw;
        int nh = n%w == 0 ? n/w : n/w+1;
        int numh = num%w == 0 ? num/w : num/w+1;
        if(w == 1){
            return n-num+1;
        }
        if(nh == 1){
            return 1;
        }
        
        
        
        
        
        if(numh%2 == 0){
            if(num%w == 0)
                numw = 0;
            else
                numw = w-num%w;
        }else{
            if(num%w == 0)
                numw = w - 1;
            else
                numw = num%w-1;
        }
        
        if(nh%2 == 0){
            if(n%w == 0)
                nw = 0;
            else
                nw = w-n%w;
        }else{
            if(n%w == 0)
                nw = w - 1;
            else
                nw = n%w-1;
        }
        
        if(nh % 2 == 0)
            answer = nw > numw ? nh - numh : nh - numh +1;
        else
            answer = nw >= numw ? nh - numh + 1 : nh - numh;
        
        return answer;
    }
}