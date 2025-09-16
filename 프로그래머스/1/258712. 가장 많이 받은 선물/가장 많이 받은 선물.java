import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int solution(String[] friends, String[] gifts) {
    	// 이름별로 Array의 인덱스를 저장해두는 HashMap 생성
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<friends.length; i++) {
            map.put(friends[i], i);
        }

		// 이차원배열 생성 후, 선물을 주고 받은 횟수를 저장 
        int[][] giftsArr = new int[friends.length][friends.length];
        // 선물지수를 저장하는 배열 생성
        int[] giftPoint = new int[friends.length];

		// 문제에서 주어진 gifts 갯수만큼 반복문 실행
        // 선물을 주고받은 횟수를 저장하는 동시에, 선물지수도 같이 연산해준다
        for(int i=0; i<gifts.length; i++) {
            String[] split = gifts[i].split(" ");
            String giver = split[0];
            String taker = split[1];
            int giverIndex = map.get(giver);
            int takerIndex = map.get(taker);

            giftsArr[giverIndex][takerIndex]++;
            giftPoint[giverIndex]++;
            giftPoint[takerIndex]--;
        }

		// 다음달에 선물을 받을 횟수 저장할 배열 생성
        int[] nextMonthGift = new int[friends.length];

        for(int i=0; i<giftsArr.length; i++) {

            for(int j=i+1; j<giftsArr[i].length; j++) {
				// i가 j보다 선물을 준 횟수가 많다면 -> nextMonthGift[i]++;
                // j가 i보다 선물을 준 횟수가 많다면 -> nextMonthGift[j]++;
                if(giftsArr[i][j] > giftsArr[j][i]) {
                    nextMonthGift[i]++;
                } else if (giftsArr[i][j] < giftsArr[j][i]) {
                    nextMonthGift[j]++;
                } else {
					// i, j 서로 선물을 주고받은 횟수가 같다면, 선물지수로 비교
                    if(giftPoint[i] > giftPoint[j]) {
                        nextMonthGift[i]++;
                    } else if (giftPoint[i] < giftPoint[j]) {
                        nextMonthGift[j]++;
                    }

                }

            }
        }
        // 선물받은 횟수중에서 가장 큰 수 return
        return Arrays.stream(nextMonthGift).max().getAsInt();
    }
}
 