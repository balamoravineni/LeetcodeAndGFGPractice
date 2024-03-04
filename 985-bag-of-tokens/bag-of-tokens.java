class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int i = 0;
        int j = tokens.length-1;
        int score = 0;
        int ans = 0;
        Arrays.sort(tokens);
        while(i<=j) {
            while (i<=j && power>=tokens[i]){
               power-=tokens[i++];
               score++;
            }
            ans=Math.max(ans, score);
            if (i<j && score>0) { 
                power+= tokens[j--];
                score--;
            }
            else break;
        }
        return ans;
    }
}