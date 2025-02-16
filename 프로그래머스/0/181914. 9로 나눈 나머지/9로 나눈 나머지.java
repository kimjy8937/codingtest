class Solution {
    public int solution(String number) {
        int answer = 0;
        int sum = 0;
        for(char c : number.toCharArray()){
            sum += Character.getNumericValue(c);
        }
        return sum % 9;
    }
}