public class Solution {
    public int solution(int n, java.util.function.Function<Integer, String> submit) {
        // 가능한 모든 후보 1000~9999 중, 1~9 4개 서로 다르고 0 미포함
        java.util.List<Integer> candidates = new java.util.ArrayList<>();
        for (int a = 1; a <= 9; a++) {
            for (int b = 1; b <= 9; b++) {
                if (b == a) continue;
                for (int c = 1; c <= 9; c++) {
                    if (c == a || c == b) continue;
                    for (int d = 1; d <= 9; d++) {
                        if (d == a || d == b || d == c) continue;
                        candidates.add(1000 * a + 100 * b + 10 * c + d);
                    }
                }
            }
        }
        while (candidates.size() > 1) {
            // 단순히 리스트의 첫 번째를 guess로 사용
            int guess = candidates.get(0);
            String res = submit.apply(guess);
            // "xS yB" 형식 가정
            String[] parts = res.split(" ");
            int strike = Integer.parseInt(parts[0].substring(0, parts[0].length()-1));
            int ball   = Integer.parseInt(parts[1].substring(0, parts[1].length()-1));

            java.util.List<Integer> next = new java.util.ArrayList<>();
            for (int cand : candidates) {
                String s1 = String.valueOf(guess);
                String s2 = String.valueOf(cand);
                int st = 0, b = 0;
                for (int i = 0; i < 4; i++) {
                    if (s1.charAt(i) == s2.charAt(i)) {
                        st++;
                    } else if (s2.indexOf(s1.charAt(i)) != -1) {
                        b++;
                    }
                }
                if (st == strike && b == ball) {
                    next.add(cand);
                }
            }
            candidates = next;
        }
        return candidates.get(0);
    }
}