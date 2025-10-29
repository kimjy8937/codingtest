class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        long min = 1;
        long max = limit;
        int len = diffs.length;
        while (min <= max) {
            long level = (min + max) / 2;
            long spentTime = 0;

            for (int i = 0; i < len; ++i) {
                if (level < diffs[i])
                    spentTime += (times[i] + times[i - 1]) * (diffs[i] - level) + times[i];
                else
                    spentTime += times[i];
            }

            if(spentTime > limit)
                min = level + 1;
            else
                max = level - 1;
        }
        return (int)min;
    }
}
