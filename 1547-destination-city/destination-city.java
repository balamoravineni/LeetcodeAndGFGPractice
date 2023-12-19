class Solution {
    public String destCity(List<List<String>> paths) {
        Map<String, String> pathMap = new HashMap<>();
        for(List<String> cities: paths) {
            pathMap.put(cities.get(0), cities.get(1));
        }
        for(String value: pathMap.values()) {
            if(pathMap.get(value)==null) return value;
        }
        return "";
    }
}