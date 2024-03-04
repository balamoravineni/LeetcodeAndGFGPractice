class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int i = 0;
        int j = tokens.length-1;
        int score = 0;
        int ans = 0;
        Arrays.sort(tokens);
        while(i<=j) {
            if(power>=tokens[i]) {
                score++;
                ans = Math.max(ans, score);
                power -= tokens[i++];
            }
            else if(score>=1){
                score--;
                power += tokens[j--];
            }
            else {
                break;
            }
        }
        return ans;
    }
}