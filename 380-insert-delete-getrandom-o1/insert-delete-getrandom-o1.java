// commented code is initial code, implemented optimised one in uncommented code
class RandomizedSet {

    // int count = 0;
    // Map<Integer,Integer> mapCountToVal = new HashMap<>();
    // Map<Integer,Integer> mapValToCount = new HashMap<>();
    // Queue<Integer> removedCount = new LinkedList<>();
    Random random = new Random();
    List<Integer> list = new LinkedList<>();
    Map<Integer,Integer> mapValToIndex = new HashMap<>();

    public RandomizedSet() {
        
    }
    
    public boolean insert(int val) {
        // if(mapValToCount.containsKey(val)) return false;
        // int temp = count;
        // if(!removedCount.isEmpty()) temp = removedCount.remove();
        // else count++;
        // mapValToCount.put(val, temp);
        // mapCountToVal.put(temp, val);
        // return true;
        if(mapValToIndex.containsKey(val)) return false;
        list.add(val);
        mapValToIndex.put(val, list.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        // if(!mapValToCount.containsKey(val)) return false;
        // int temp = mapValToCount.get(val);
        // mapValToCount.remove(val);
        // mapCountToVal.remove(temp);
        // removedCount.add(temp);
        // return true;
        if(!mapValToIndex.containsKey(val)) return false;
        int index = mapValToIndex.get(val);
        list.set(index, list.get(list.size()-1));
        mapValToIndex.put(list.get(list.size()-1), index);
        list.remove(list.size()-1);
        mapValToIndex.remove(val);
        return true;
    }
    
    public int getRandom() {
        // int number = -1;
        // while(true) {
        //     number = random.nextInt(count);
        //     if(mapCountToVal.containsKey(number)) break;
        // }
        // return mapCountToVal.get(number);
        return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */