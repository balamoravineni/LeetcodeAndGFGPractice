class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        
        String init = Integer.toString(low);
        String end = Integer.toString(high);

        List<Integer> ans = new ArrayList<>();

        // System.out.println(init.length() + " -> " + end.length());
        for(int i=init.length();i<=end.length() && i<=9;i++) {
            StringBuilder start = new StringBuilder();
            int temp = i;
            for(int j=1;j<=temp;j++) start.append(j + "");
            // System.out.println(temp + ": " + start.toString());
            while(true) {
                Integer curr = new Integer(start.toString());
                if(curr<low) {
                    start.deleteCharAt(0);
                    if(++temp>9) break;
                    start.append(temp + "");
                    continue;
                }
                else if(curr>high) break;
                ans.add(curr);
                start.deleteCharAt(0);
                if(++temp>9) break;
                start.append(temp + "");
            }
        }

        return ans;
    }
}