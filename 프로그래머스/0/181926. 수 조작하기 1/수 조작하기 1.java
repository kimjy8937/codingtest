class Solution {
    public int solution(int n, String control) {
        char[] control_arr = control.toCharArray();
        for(char c : control_arr){
            switch(c){
                case 'w':
                    n += 1;
                    break;
                case 's':
                    n -= 1;
                    break;
                case 'd':
                    n += 10;
                    break;
                case 'a':
                    n -= 10;
                    break;
            }
        }
        return n;
    }
}