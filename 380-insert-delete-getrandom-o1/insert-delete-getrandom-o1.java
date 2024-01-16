class RandomizedSet {

    int count = 0;
    Map<Integer,Integer> mapCountToVal = new HashMap<>();
    Map<Integer,Integer> mapValToCount = new HashMap<>();
    Queue<Integer> removedCount = new LinkedList<>();
    Random random = new Random();

    public RandomizedSet() {
        
    }
    
    public boolean insert(int val) {
        if(mapValToCount.containsKey(val)) return false;
        int temp = count;
        if(!removedCount.isEmpty()) temp = removedCount.remove();
        else count++;
        mapValToCount.put(val, temp);
        mapCountToVal.put(temp, val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!mapValToCount.containsKey(val)) return false;
        int temp = mapValToCount.get(val);
        mapValToCount.remove(val);
        mapCountToVal.remove(temp);
        removedCount.add(temp);
        return true;
    }
    
    public int getRandom() {
        int number = -1;
        while(true) {
            number = random.nextInt(count);
            if(mapCountToVal.containsKey(number)) break;
        }
        return mapCountToVal.get(number);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */