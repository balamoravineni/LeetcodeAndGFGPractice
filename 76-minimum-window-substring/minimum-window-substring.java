class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length()) return "";
        Map<Character,Integer> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for(char ch: t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0)+1);
            set.add(ch);
        }
        // System.out.println(map);
        Map<Character, Integer> extra = new HashMap<>();
        List<Integer> start = new LinkedList<>();
        int ans = Integer.MAX_VALUE;
        int ansStart = -1;
        int ansEnd = -1;
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            if(set.contains(ch)) {
                start.add(i);
                if(!map.isEmpty()) {
                    if(!map.containsKey(ch)) {
                        extra.put(ch, extra.getOrDefault(ch, 0)+1);
                    } else {
                        map.put(ch, map.get(ch)-1);
                        if(map.get(ch)==0) map.remove(ch);
                    }
                    if(map.isEmpty()) {
                        while(!extra.isEmpty() && extra.containsKey(s.charAt(start.get(0)))) {
                            extra.put(s.charAt(start.get(0)), extra.get(s.charAt(start.get(0)))-1);
                            if(extra.get(s.charAt(start.get(0)))==0) {
                                extra.remove(s.charAt(start.get(0)));
                            }
                            start.remove(0);
                        }
                        ans = start.get(start.size()-1) - start.get(0) + 1;
                        ansStart = start.get(0);
                        ansEnd = start.get(start.size()-1)+1;
                    }
                }
                else {
                    extra.put(ch, extra.getOrDefault(ch, 0)+1);
                    if(s.charAt(start.get(0))==ch) {
                        while(extra.containsKey(s.charAt(start.get(0)))) {
                           extra.put(s.charAt(start.get(0)), extra.get(s.charAt(start.get(0)))-1);
                           if(extra.get(s.charAt(start.get(0)))==0) {
                               extra.remove(s.charAt(start.get(0)));
                           }
                           start.remove(0);
                        }
                        if(ans>(start.get(start.size()-1) - start.get(0) + 1)) {
                            ans = start.get(start.size()-1) - start.get(0) + 1;
                            ansStart = start.get(0);
                            ansEnd = start.get(start.size()-1)+1;
                        }
                    }
                }
            }
        }
        System.out.println(extra);
        System.out.println(start);
        while(map.isEmpty() && !extra.isEmpty() && extra.containsKey(s.charAt(start.get(0)))) {
            extra.put(s.charAt(start.get(0)), extra.get(s.charAt(start.get(0)))-1);
            if(extra.get(s.charAt(start.get(0)))==0) {
                extra.remove(s.charAt(start.get(0)));
            }
            start.remove(0);
            if(ans>(start.get(start.size()-1) - start.get(0) + 1)) {
                ans = start.get(start.size()-1) - start.get(0) + 1;
                ansStart = start.get(0);
                ansEnd = start.get(start.size()-1)+1;
            }
        }
        
        if(ansEnd==-1) return "";
        return s.substring(ansStart, ansEnd);
    }
}