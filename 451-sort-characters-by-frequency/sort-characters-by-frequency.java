class Pair {
    Character ch;
    int count;
    Pair(char a, int b) {
        ch = a;
        count = b;
    }
}

class Solution {
    public String frequencySort(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++) {
            if(map.containsKey(s.charAt(i))) map.put(s.charAt(i), map.get(s.charAt(i))+1);
            else map.put(s.charAt(i), 1);
        }
        List<Pair> list = new ArrayList<>();
        for(char ch: map.keySet()) {
            list.add(new Pair(ch, map.get(ch)));
        }
        Collections.sort(list, (p1, p2) -> p2.count-p1.count);
        StringBuilder ans = new StringBuilder();
        for(Pair temp: list) {
            ans.append(String.join("", Collections.nCopies(temp.count, new String(new char[]{temp.ch}))));
        }
        return ans.toString();
    }
}