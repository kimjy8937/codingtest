class Solution {
    char[][] cboard=new char[3][3];
    int[] my={1,0,1,-1},mx={0,1,1,1}; // 아래,오른,대각,대각
    public int solution(String[] board) {
        for(int i=0;i<3;i++) for(int j=0;j<3;j++) cboard[i][j]=board[i].charAt(j);
        // count
        int cntO=0,cntX=0;
        for(int i=0;i<3;i++) for(int j=0;j<3;j++) {
            cntO+=cboard[i][j]=='O'?1:0;
            cntX+=cboard[i][j]=='X'?1:0;
        }
        // 메인로직
        if(cntO==cntX) return !isBingo('O')?1:0;
        else if(cntO==cntX+1) return !isBingo('X')?1:0;
        else return 0;
    }
    boolean isBingo(char c) {
        for(int i=0;i<3;i++) for(int j=0;j<3;j++) for(int k=0;k<my.length;k++) {
            int cnt=0;
            for(int l=0;l<3;l++) {
                int ny=i+my[k]*l,nx=j+mx[k]*l;
                if(ny<0 || ny>=3 || nx<0 || nx>=3) break;
                if(cboard[ny][nx]!=c) break;
                cnt++;
            }
            if(cnt==3) return true;
        }
        return false;
    }
}