import java.util.Arrays;
class Solution {
	public int solution(int[] people, int limit) {
		int answer = 0;
		int i = 0;
        int j;

		Arrays.sort(people);

		for(j=people.length-1; i<=j; j--) {
			if(people[j] + people[i] > limit)
				answer ++;

			else {
				answer ++;
				i ++;
			}
		}

		return answer;
	}

}