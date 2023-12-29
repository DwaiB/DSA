package LeetCode.tree;

/*
You are given a tree with n nodes numbered from 0 to n - 1 in the form of a parent array parent where parent[i] is the parent of the ith node. 
The root of the tree is node 0, so parent[0] = -1 since it has no parent. You want to design a data structure that allows users to lock, unlock, 
and upgrade nodes in the tree.

The data structure should support the following functions:

Lock: Locks the given node for the given user and prevents other users from locking the same node. 
You may only lock a node using this function if the node is unlocked.
Unlock: Unlocks the given node for the given user. 
You may only unlock a node using this function if it is currently locked by the same user.
Upgrade: Locks the given node for the given user and unlocks all of its descendants regardless of who locked it. 
You may only upgrade a node if all 3 conditions are true:
The node is unlocked,
It has at least one locked descendant (by any user), and
It does not have any locked ancestors.
Implement the LockingTree class:

LockingTree(int[] parent) initializes the data structure with the parent array.
lock(int num, int user) returns true if it is possible for the user with id user to lock the node num, or false otherwise.
 If it is possible, the node num will become locked by the user with id user.
unlock(int num, int user) returns true if it is possible for the user with id user to unlock the node num, or false otherwise.
 If it is possible, the node num will become unlocked.
upgrade(int num, int user) returns true if it is possible for the user with id user to upgrade the node num, or false otherwise. 
If it is possible, the node num will be upgraded
 */

/*
    Constraints:

    n == parent.length
    2 <= n <= 2000
    0 <= parent[i] <= n - 1 for i != 0
    parent[0] == -1
    0 <= num <= n - 1
    1 <= user <= 104
    parent represents a valid tree.
    At most 2000 calls in total will be made to lock, unlock, and upgrade.
 */
public class OperationsOnATree {

    public static void main(String[] args) {
        int[] parent = {-1,0,0,1};
        LockingTree tree = new LockingTree(parent);
        tree.display();
    }
}

class LockingTree {
    int[] head,child,next,lock,parent_t;
    int ptr,size;
    boolean found;
    public LockingTree(int[] parent) {
        this.size = parent.length;
        this.ptr = -1;
        this.head = new int[size];
        this.child = new int[size];
        this.next = new int[size];
        this.lock = new int[size];
        this.parent_t = new int[size];
        for(int i=0;i<size;++i){
            head[i] = -1;
            child[i] = -1;
            next[i] = -1;
            lock[i] = -1;
            parent_t[i] = parent[i];
        }
        for(int i=0;i<size;++i){
            if(parent[i] == -1) continue;
            //i has the node, parent[i] contains parent
            //check head and traverese to last node
            int par = parent[i];
            if(head[par] == -1){
                ++ptr;
                child[ptr] = i;
                head[par] = ptr;
            }else{
                int k = head[par];
                while(next[k] != -1){
                    k = next[k];
                }
                ++ptr;
                next[k] = ptr;
                child[ptr] = i;
            }
        }
    }
    public void display(){
        System.out.print("\nITR");
        for(int i=0;i<size;++i){
            System.out.print("\t"+i);
        }
        System.out.print("\nHEAD");
        for(int i=0;i<size;++i){
            System.out.print("\t"+head[i]);
        }
        System.out.print("\nCHILD");
        for(int i=0;i<size;++i){
            System.out.print("\t"+child[i]);
        }
        System.out.print("\nNEXT");
        for(int i=0;i<size;++i){
            System.out.print("\t"+next[i]);
        }
        System.out.println();
    }

    public boolean lock(int num, int user) {
        if(lock[num] != -1) return false;
        lock[num] = user;
        return true;
    }

    public boolean unlock(int num, int user) {
        if(lock[num] != user) return false;
        lock[num] = -1;
        return true;
    }

    public boolean upgrade(int num, int user) {
        if(lock[num] != -1) return false; // condition 1
        int k = parent_t[num];
        while(k != -1){
            if(lock[k] != -1) return false; // condition 3
            k = parent_t[k];
        }
        found = false;
        dfs(num);
        return true;
    }
    public void dfs(int num){
        if(head[num] == -1){
            return;
        }
        int itr = head[num];
        while(itr != -1){
            int edge = child[itr];
            if(lock[edge] != -1) {
                found = true;
                lock[edge] = -1;
            }
            dfs(edge);
            itr = next[itr];
        }
    }
}

/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */
