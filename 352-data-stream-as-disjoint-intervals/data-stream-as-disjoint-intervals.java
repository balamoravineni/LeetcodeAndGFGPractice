class SummaryRanges {

    Set<Integer> set = new TreeSet<>();

    public SummaryRanges() {
        
    }
    
    public void addNum(int value) {
        set.add(value);
        System.out.println(set);
    }
    
    public int[][] getIntervals() {
        List<Pair<Integer,Integer>> ans = new ArrayList<>();
        int prev = -2;
        int size = set.size();
        for(int curr: set) {
            if(prev==-2) {
                ans.add(new Pair(curr, curr));
                prev = curr;
                size--;
                continue;
            }
            if(curr==prev+1) {
                if(size==1) {
                    Pair<Integer,Integer> last = ans.remove(ans.size()-1);
                    ans.add(new Pair(last.getKey(), curr));
                }
                size--;
                prev = curr;
                continue;
            }
            Pair<Integer,Integer> last = ans.remove(ans.size()-1);
            ans.add(new Pair(last.getKey(), prev));
            ans.add(new Pair(curr, curr));
            prev = curr;
            size--;
        }
        // if(ans.size()>1) {
        //     if(ans.get(ans.size()-2).getValue()==ans.get(ans.size()-1).getKey()) ans.remove(ans.size()-1);
        // }
        int[][] a = new int[ans.size()][2];
        int i = 0;
        for(Pair<Integer,Integer> temp: ans) {
            a[i][0] = temp.getKey();
            a[i][1] = temp.getValue();
            i++;
        }
        return a;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */