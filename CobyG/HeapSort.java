// Coby Goldberg
// APCS2 pd 9
// HW41
// 2014-05-19

/*
 * In a block comment at the top of your .java file,
 * describe the best and worst case scenarios for your sort
 * along with their associated execution times and memory consumption.

 No matter what, heapsort runs in O(nlogn) time because heap.removeMin() always runs in logn time and is called n number of times. However, if the input array is already sorted, heap.add runs in constant time, as it would simply be appending the new value to the end. At worst,  heap.add runs in logn times. Since heap.add is call n times, the difference between the best (sorted input) and worst (reverse sorted input) is a constant factor of nlogn - n.
*/

import java.util.*;

public class HeapSort{

    public static int[] sort( int[] data ){
	int[] retPrep = new int[data.length];
	int[] ret = new int[data.length];
	for (int i = 0; i < data.length; i++){
	    retPrep[i] = -1;
	}
	for (int i = 0; i < data.length; i++){
	    retPrep[i] = data[i];
	    int pos = i;
	    while (pos > 0){
		int parentPos = (pos-1)/2;
		if (retPrep[pos] < retPrep[parentPos]){
		    int temp = retPrep[parentPos];
		    retPrep[parentPos] = retPrep[pos];
		    retPrep[pos] = temp;
		    pos = parentPos;
		    /*System.out.println("The heap: ");
		    for (int j : retPrep)
			System.out.print(j + ",");
			System.out.println();*/
		}
			
		else
		    break;
	    }
	}
	for (int i = 0; i < data.length; i++){
	    int minVal = retPrep[0];
	    int ender = retPrep[data.length - i - 1];
	    ret[i] = minVal;
	    //System.out.println("i index: " + ret[i]);
	    retPrep[0] = ender;
	    retPrep[data.length - i - 1] = -1;
	    int pos = 0;
	    int minChild;
	    while (pos < data.length - i - 1){
		int lc = pos*2 + 1;
		int rc = pos*2 + 2;
		if (lc >= data.length - i - 1)
		    break;
		else if (rc >= data.length - i - 1)
		    minChild = lc;
		else if (retPrep[lc] < retPrep[rc])
		    minChild = lc;
		else
		    minChild = rc;
		if (ender <= retPrep[minChild])
		    break;
		else{
		    int temp = retPrep[minChild];
		    retPrep[minChild] = retPrep[pos];
		    retPrep[pos] = temp;
		    pos = minChild;
		}
	    }
	}
	return ret;
    }//O(nlogn)

    public static void main(String[] args) {
	int[] tester = {8, 5, 2, 12, 3, 7, 10, 11, 6};
	System.out.print("Input: ");
	for (int i : tester)
	    System.out.print(i + ",");
	System.out.println();
	int[] printer = sort(tester);
	System.out.print("Sorted result: ");
	for (int i : printer)
	    System.out.print(i + ",");
    }

}
