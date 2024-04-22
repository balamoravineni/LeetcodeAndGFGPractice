/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

class Pair {
    List<NestedInteger> nestedList;
    int index;
    Pair(List<NestedInteger> nestedList, int index) {
        this.nestedList = nestedList;
        this.index = index;
    }
}

public class NestedIterator implements Iterator<Integer> {

    Deque<Pair> stack = new ArrayDeque<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        stack.push(new Pair(nestedList, 0));
    }

    @Override
    public Integer next() {
        while(!stack.isEmpty()) {
            Pair current = stack.peek();
            NestedInteger temp = current.nestedList.get(current.index);
            if(temp.isInteger()) {
                while(current.index+1==current.nestedList.size()) {
                    stack.pop();
                    if(!stack.isEmpty()) current = stack.peek();
                    else break;
                }
                if(!stack.isEmpty()) {
                    current = stack.pop();
                    stack.push(new Pair(current.nestedList, current.index+1));
                }
                return temp.getInteger();
            }
            else {
                if(!temp.getList().isEmpty()) stack.push(new Pair(temp.getList(), 0));
                else {
                    while(current.index+1==current.nestedList.size()) {
                        stack.pop();
                        if(!stack.isEmpty()) current = stack.peek();
                        else break;
                    }
                    if(!stack.isEmpty()) {
                        current = stack.pop();
                        stack.push(new Pair(current.nestedList, current.index+1));
                    }
                }
            }
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        while(!stack.isEmpty()) {
            Pair current = stack.peek();
            NestedInteger temp = current.nestedList.get(current.index);
            if(temp.isInteger()) {
                return true;
            }
            else {
                if(!temp.getList().isEmpty()) stack.push(new Pair(temp.getList(), 0));
                else {
                    while(current.index+1==current.nestedList.size()) {
                        stack.pop();
                        if(!stack.isEmpty()) current = stack.peek();
                        else break;
                    }
                    if(!stack.isEmpty()) {
                        current = stack.pop();
                        stack.push(new Pair(current.nestedList, current.index+1));
                    }
                }
            }
        }
        return !stack.isEmpty();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */