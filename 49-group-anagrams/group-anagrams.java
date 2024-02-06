class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // return usingSorting(strs);
        return usingSignature(strs);
    }

    List<List<String>> usingSignature(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String temp: strs) {
            String signature = getSignature(temp);
            if(map.containsKey(signature)) map.get(signature).add(temp);
            else map.put(signature, new ArrayList<>(Arrays.asList(temp)));
        }
        List<List<String>> ans = new ArrayList<>();
        for(String key: map.keySet()) ans.add(map.get(key));
        return ans;
    }

    String getSignature(String str) {
        int[] freq = new int[26];
        for(int i=0;i<str.length();i++) freq[str.charAt(i)-'a']++;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<26;i++) {
            if(freq[i]!=0) sb.append(i+"-"+freq[i]+"$");
        }
        return sb.toString();
    }

    List<List<String>> usingSorting(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String temp: strs) {
            char[] tempArr = temp.toCharArray();
            Arrays.sort(tempArr);
            String sorted = new String(tempArr);
            if(map.containsKey(sorted)) map.get(sorted).add(temp);
            else map.put(sorted, new ArrayList<>(Arrays.asList(temp)));
        }
        List<List<String>> ans = new ArrayList<>();
        for(String key: map.keySet()) ans.add(map.get(key));
        return ans;
    }
}