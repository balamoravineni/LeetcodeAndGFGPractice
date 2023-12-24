class Solution {
    public int minOperations(String s) {
        // return initialApproach(s);
        return optimisedApproach(s);
    }

    int optimisedApproach(String s) {
        int first0_num=0;
        for(int i=0;i<s.length();i++) {
            if(i%2==0 && s.charAt(i)=='1') first0_num++;
            else if(i%2==1 && s.charAt(i)=='0') first0_num++;
        }
        return Math.min(first0_num, s.length()-first0_num++);
    }

    int initialApproach(String s) {
        int first0_num=0, first1_num=0;
        for(int i=0;i<s.length();i++) {
            if(i%2==0) {
                if(s.charAt(i)=='1') first0_num++;
                else first1_num++;
            }
            else {
                if(s.charAt(i)=='0') first0_num++;
                else first1_num++;
            }
        }
        return Math.min(first0_num, first1_num);
    }
}