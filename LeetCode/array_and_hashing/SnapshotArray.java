package LeetCode.array_and_hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SnapshotArray {
    class Pair{
        Map<Integer,Integer> map;
        Pair(){
            map = new HashMap<>();
        }
        public void put(Integer key,Integer val) {
            map.put(key, val);
        }
        public int get(Integer key) {
            if(map.containsKey(key)){
                return map.get(key);
            }
            return -1;
        }
    }
    List<Pair> snapshots;
    int size, snap;

    public SnapshotArray(int length) {
        this.snap = 0;
        this.size = length;
        snapshots = new ArrayList<Pair>(length);
        for(int i =0;i < length;i++){
            Pair pair = new Pair();
            pair.put(0,0);
            snapshots.add(i, pair);
        }
    }

    public void set(int index, int val) {
        Pair pair = snapshots.get(index);
        pair.put(snap,val);
        snapshots.set(index, pair);
    }

    public int snap() {
        snap++;
        return snap - 1;
    }

    public int get(int index, int snap_id) {
        Pair pair =  snapshots.get(index);
        if(pair.get(snap_id) != -1){
            return pair.get(snap_id);
        }
        // display(pair.map,index,snap_id);
        List<Integer> list = pair.map.keySet().stream().toList();
        int pos = binarySearch(list, snap_id);
        System.out.println("position:"+pos);
        if(snap_id < list.get(pos)){
            return (pos > 0)? pair.get(list.get(pos-1)): pair.get(0); 
        }else{
            return pair.get(list.get(pos));
        }
    }

    public int binarySearch(List<Integer>  list, int item) {
        int left = 0, mid = 0, right = list.size() - 1;
        while (left < right) {
            mid = (left + right) / 2;
            if (list.get(mid) == item) {
                return mid;
            } else if (list.get(mid) < item) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    // public void display(Map<Integer, Integer> map, int index, int snap_id) {

    //     System.out.println("Index: " + index + " Snap Id: " + snap_id);
    //     for (Map.Entry<Integer, Integer> data : map.entrySet()) {
    //         System.out.println(data.getKey() + " " + data.getValue());
    //     }
    //     System.out.println();
    // }

    public static void main(String[] args) {
        SnapshotArray snap = new SnapshotArray(3);
        snap.set(1, 1);
        System.out.println("Snap:" + snap.snap());
        snap.set(0, 3);
        System.out.println("Snap:" + snap.snap());
        System.out.println("Snap:" + snap.snap());
        snap.set(0, 4);
        System.out.println("Get Index 0 of snap 2 =" + snap.get(0, 2));
        System.out.println("Get Index 0 of snap 3 =" + snap.get(0, 3));
        System.out.println("Snap:" + snap.snap());
        System.out.println("Get Index 0 of snap 6 =" + snap.get(0, 6));
        System.out.println("Snap:" + snap.snap());
        snap.set(0, 6);
         System.out.println("Get Index 0 of snap 4 =" + snap.get(0, 4));
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */