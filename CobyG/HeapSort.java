// Coby Goldberg
// APCS2 pd 9
// HW42
// 2014-05-20

/*
 * In a block comment at the top of your .java file,
 * describe the best and worst case scenarios for your sort
 * along with their associated execution times and memory consumption.

Algorithm: This works in a similar manner to the add and removeMin functions of the heap class.
Add: Treat the input array as if it is an actual heat. Walk through the data. At each position, compare said value to its parent in the data set ((index - 1)/2). If the value is less than that of its parent, swap it with the parent. Otherwise, move on to the next value (next relative to the original index). In this way, the array will become sorted like a heap.
RemoveMin: Walk through the heap. Place the current lowest value, stored at heap[0], in its correct spot, as denoted by the current index of your walk through. Place the value formerly at your current index at heap[0]. Then walk that value up the heap, comparing it to the least of its two children, until it is no longer smaller than either of its children or has no children. If it is smaller than one of its children, swap the value with that of the child.
*/

import java.util.*;

public class HeapSort{

    public static int[] sort( int[] data ){
	for (int i = 0; i < data.length; i++){
	    int pos = i;
	    while (pos > 0){
		int parentPos = (pos-1)/2;
		if (data[pos] < data[parentPos]){
		    int temp = data[parentPos];
		    data[parentPos] = data[pos];
		    data[pos] = temp;
		    pos = parentPos;
		    /*System.out.println("The heap: ");
		    for (int j : data)
			System.out.print(j + ",");
			System.out.println();*/
		}	
		else
		    break;
	    }
	}
	for (int i = 0; i < data.length; i++){
	    int minVal = data[0];
	    int ender = data[i];
	    data[i] = minVal;
	    //System.out.println("Data " + i + ": " + data[i]);
	    data[0] = ender;
	    int pos = i;
	    int minChild;
	    while (pos <= data.length - i){
		//System.out.println("in!");
		int lc = pos*2 + 1;
		int rc = pos*2 + 2;
		if (lc >= data.length - i - 1)
		    break;
		else if (rc >= data.length - i - 1)
		    minChild = lc;
		else if (data[lc] < data[rc])
		    minChild = lc;
		else
		    minChild = rc;
		if (ender <= data[minChild])
		    break;
		else{
		    int temp = data[minChild];
		    data[minChild] = data[pos];
		    data[pos] = temp;
		    pos = minChild;
		}
	    }
	    /*System.out.println("The heap: ");
	    for (int j : data)
		System.out.print(j + ",");
		System.out.println();*/
	}
	return data;
    }//O(1)

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
