import java.util.List;
import java.util.ArrayList;

class Solution {

    public long solution(int[] sequence) {
        long initialValue = 0L;

        List<Long> result = new ArrayList<>();
        result.add(initialValue);

        long maxValue = initialValue;
        long minValue = initialValue;

        int lastIndex = 0;

        for (int i = 0; i < sequence.length; i ++) {
            int pulse = i % 2 == 0 ? 1 : -1;

            long lastElement = result.get(lastIndex++);

            long cumulativeSumValue = lastElement + pulse * sequence[i];

            result.add(cumulativeSumValue);

            maxValue = Math.max(maxValue, cumulativeSumValue);
            minValue = Math.min(minValue, cumulativeSumValue);
        }

        return maxValue - minValue;
    }

}