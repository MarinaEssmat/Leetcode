package LetCode.Examples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Implement a SnapshotArray that supports the following interface:

SnapshotArray(int length) initializes an array-like data structure with the given length.  Initially, each element equals 0.
void set(index, val) sets the element at the given index to be equal to val.
int snap() takes a snapshot of the array and returns the snap_id: the total number of times we called snap() minus 1.
int get(index, snap_id) returns the value at the given index, at the time we took the snapshot with the given snap_id
 

Example 1:

Input: ["SnapshotArray","set","snap","set","get"]
[[3],[0,5],[],[0,6],[0,0]]
Output: [null,null,0,null,5]
Explanation: 
SnapshotArray snapshotArr = new SnapshotArray(3); // set the length to be 3
snapshotArr.set(0,5);  // Set array[0] = 5
snapshotArr.snap();  // Take a snapshot, return snap_id = 0
snapshotArr.set(0,6);
snapshotArr.get(0,0);  // Get the value of array[0] with snap_id = 0, return 5
 

Constraints:

1 <= length <= 50000
At most 50000 calls will be made to set, snap, and get.
0 <= index < length
0 <= snap_id < (the total number of times we call snap())
0 <= val <= 10^9


 */
class SnapshotArray {

	Integer[] snaps;
	int count=0;
	int snap_id=0;
	 Map<Integer, Integer[]> snapsShots = new HashMap<Integer,Integer[]>();
	
    public SnapshotArray(int length) {
        snaps=new Integer[length];
        for ( int i=0;i<length ; i++)
        {
        	snaps[i]=0;
        }
        
    }
    
    public void set(int index, int val) {
        snaps[index]=val;
    }
    
    public int snap() {
       count++;
     snap_id = count-1;
     Integer[]snapsAtThisTime= snaps.clone();

    // System.arraycopy(snaps, 0, snapsAtThisTime, 0, snaps.length);
    
     this.snapsShots.put(snap_id, snapsAtThisTime);
       return count-1;
        
    }
    
    public int get(int index, int snap_id) {
    	
    	Integer[] snapsAtThisTime=this.snapsShots.get(snap_id);
    	return snapsAtThisTime[index];
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
public class Ex7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	

}
