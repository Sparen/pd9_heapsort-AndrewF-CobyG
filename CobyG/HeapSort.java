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
		retPrep[i] = data[i];
		int pos = i;
		while (pos > 0){
			int parentPos = (pos-1)/2;
			if (retPrep[pos] < retPrep[parentPos]){
				int temp = ret[parentPos];
				retPrep[parentPos] = retPrep[pos];
				retPrep[pos] = temp;
				pos = parentPos;
			}
			else
				break;
		}
	}
	for (int i = 0; i < data.length; i++){
		int minVal = retPrep[0];
		int ender = retPrep[data.length - i - 1];
		ret[i] = minVal;
		retPrep[0] = ender;
		retPrep[data.length - i - 1] = null;
		int pos = 0;
		int minChild;
		while (pos < data.length - i - 1){
			minChild = mindChildPos(pos);
			if (minChild == -1)
				break;
			else if (ender.compareTo(retPrep[minChild]) <= 0)
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
	Integer[] tester = {8, 5, 2, 12, 3, 5, 10, 11, 6};
	System.out.print("Input: ");
	for (Integer i : tester)
	    System.out.print(i + ",");
	System.out.println();
	Integer[] printer = sort(tester);
	System.out.print("Sorted result: ");
	for (Integer i : printer)
	    System.out.print(i + ",");
    }

}
