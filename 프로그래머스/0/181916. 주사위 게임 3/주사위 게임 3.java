import java.util.Arrays;
class Solution {
    public int solution(int a, int b, int c, int d) {
        int answer = 0;
        int[] nums = {a, b, c, d};
        Arrays.sort(nums);
        a = nums[0];
        b = nums[1];
        c = nums[2];
        d = nums[3];
        
        if(a == b && c == d && b == c){
            answer = 1111 * a;
        }else if(a != b && b == c && c == d){
            answer = (10 * b + a) * (10 * b + a);
        }else if(a == b && b == c && c!=d){
            answer = (10 * c + d) * (10 * c + d);
        }else if(a == b && c == d && b != c){
            answer = (b + c) * Math.abs(b-c);
        }else if(a != b && b != c && c != d){
            answer = a;  
        }else{
            if(a == b){
                answer = c * d;
            }else if(b == c){
                answer = a * d;
            }else if (a == c){
                answer = b * d;
            }else if (a == d)
                answer = b * c;
            else if (b == d)
                answer = a * d;
            else
                answer = a * b;
        }
            
            
        return answer;
    }
}