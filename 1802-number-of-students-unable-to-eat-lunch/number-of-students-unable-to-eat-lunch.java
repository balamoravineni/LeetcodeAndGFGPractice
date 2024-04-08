class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int stud0 = 0;
        int stud1 = 0;
        for(int temp: students) {
            if(temp==0) stud0++;
            else stud1++;
        }
        for(int temp:sandwiches) {
            if(temp==1) {
                if(stud1>0) stud1--;
                else break;
            }
            else {
                if(stud0>0) stud0--;
                else break;
            }
        }
        return stud0+stud1;
    }
}