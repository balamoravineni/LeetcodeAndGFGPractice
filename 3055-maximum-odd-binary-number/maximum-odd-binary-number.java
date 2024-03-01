class Solution {
    public String maximumOddBinaryNumber(String s) {
        char[] arr = new char[s.length()];
        int first = 0;
        int last = arr.length-1;
        for(char temp: s.toCharArray()) {
            if(temp=='1') {
                arr[first++] = '1';
            }
            else {
                arr[last--] = '0';
            }
        }
        arr[first-1] = '0';
        arr[arr.length-1] = '1';
        return new String(arr);
     }
}