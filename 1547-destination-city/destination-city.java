class Solution {
    public String destCity(List<List<String>> paths) {
        Map<String, String> pathMap = new HashMap<>();
        for(List<String> cities: paths) {
            pathMap.put(cities.get(0), cities.get(1));
        }
        for(String key: pathMap.keySet()) {
            if(pathMap.get(pathMap.get(key))==null) return pathMap.get(key);
        }
        return "";
    }
}