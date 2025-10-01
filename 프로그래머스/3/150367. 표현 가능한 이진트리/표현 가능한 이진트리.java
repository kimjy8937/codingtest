public class Solution {
	private static int[] answer;
	private static boolean dfs(String number) {
		boolean valid = true;
		
		int mid = (number.length()-1)/2;
		char root = number.charAt(mid);
		String left = number.substring(0,mid);
		String right = number.substring(mid+1,number.length());
		
		if(root == '0' && (left.charAt((left.length()-1)/2)=='1' || right.charAt((right.length()-1)/2)=='1')){
			return false;
		}
		
		if(left.length() >= 3) {
			valid = dfs(left);
			if(valid) {
				valid = dfs(right);
			}
		}
		return valid;
	}
    public int[] solution(long[] numbers) {
        answer = new int [numbers.length];
        
        for(int i = 0; i < numbers.length; i++) {
        	String cur = Long.toBinaryString(numbers[i]);
        	int j = 0;
        	while((int)Math.pow(2, j)-1 < cur.length()) {
        		j++;
        	}
        	while((int)Math.pow(2, j)-1 != cur.length()) {
        		cur = "0"+ cur;
        	}
        	if(dfs(cur)) {
        		answer[i] = 1;
        	}
        }
        return answer;
    }
}