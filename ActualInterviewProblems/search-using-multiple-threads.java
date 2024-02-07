/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;



class GFG {
    
    static int[] arr;
    static int target;
    static volatile boolean targetFound;
    static Thread[] threadArr;
    
    static Random random = new Random();
    
	public static void main (String[] args) throws InterruptedException {
	    int arrSize = 10000000;
	    arr = new int[arrSize];
	    for(int i=0;i<arrSize;i++) {
	        arr[i] = random.nextInt(500);
	    }
	    // arr[1000000] = 650;
        arr[9000009] = 650;
	    target = 650;
	    
	    int numThreads = 5;
	    int size = arr.length/numThreads;
	    
	    
	    threadArr = new Thread[numThreads];
	    
	    for(int i=0;i<numThreads;i++) {
	        threadArr[i] = new Thread(new ChildThread(i, i*size, (i+1)*size));
	        threadArr[i].start();
	    }
		
		for(int i=0;i<numThreads;i++) {
	        threadArr[i].join();
	    }
	    
		if(!targetFound) {
		    System.out.println("Target Not Found.");
		}
	}
	
	
	static class ChildThread implements Runnable {
	    int id;
	    int start;
	    int end;
	    ChildThread(int id, int start, int end) {
	        this.id = id;
	        this.start = start;
	        this.end = end;
	    }
	    
        public void run() {
            
            System.out.printf("Started search in Thread Id: %d. Index: %d\n", id, start);
            for(int i=start;i<end;i++) {
                if(targetFound) {
                    System.out.printf("Exiting thread. Id: %d. while searching index: %d\n", id, i);
                    break;
                }
                if(arr[i]==target) {
                    targetFound = true;
                    System.out.printf("Target Found in Thread Id: %d. Index: %d\n", id, i);
                    break;
                }
            }
        }
    }
	
}
