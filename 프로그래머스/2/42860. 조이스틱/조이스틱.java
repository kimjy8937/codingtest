class Solution {
    public int solution(String name) {
        int n = name.length();
        int upDown = 0;

        for (int i = 0; i < n; i++) {
            int diff = name.charAt(i) - 'A';
            upDown += Math.min(diff, 26 - diff);
        }

        int move = n - 1; 
        for (int i = 0; i < n; i++) {
            int next = i + 1;
            while (next < n && name.charAt(next) == 'A') next++;
            move = Math.min(move, 2 * i + (n - next));
            move = Math.min(move, i + 2 * (n - next));
        }

        return upDown + move;
    }
}