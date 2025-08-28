import java.util.Arrays;
import java.util.Comparator;

class Solution {
	static int[] island;
	public static int findPoint(int a) {
		if(island[a] == a)
			return a;
		else
			return findPoint(island[a]);
	}
	public static int solution(int n, int[][] costs) {
		Arrays.sort(costs, new Comparator<int []>() {
			@Override
			public int compare(int o1[], int o2[]) {
				return o1[2] - o2[2];
			}
		});
		int ans=0;
		island = new int[n];
		for(int i=0;i<n;i++)	island[i]=i;
		for(int[] i : costs) {
			int a = findPoint(i[0]);
			int b = findPoint(i[1]);
			if(a != b) {	
				ans+=i[2];
				island[a] = b;	
			}
				
		}		
		return ans;
	}
}