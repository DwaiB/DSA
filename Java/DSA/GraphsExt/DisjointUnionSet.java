package Java.DSA.GraphsExt;
/* Disjoint Union Set
 * 
 * Two sets are called Disjoint Set if a intersection of those two sets is an empty set
 * 
 * The disjoint data structure consists of the following operations:
 * 1. Adding new sets to the disjoint set
 * 2. Merging two disjoint sets into one disjoint set using union operation
 * 3. Finding representative of the disjoint set using find operation
 * 4. Check if two sets are disjoint set or not.
 */
public class DisjointUnionSet {
    int [] parent;
    int n;
    public DisjointUnionSet(int size){
        this.n = size+1;
        this.parent = new int[n];
    }
    public void make(){
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
    }
    public int find(int x){
        if(parent[x] == x) return x;
        int result = find(parent[x]);
        parent[x] = result;
        return result;
    }
    public void union(int x, int y){
        int xrep = find(x);
        int yrep = find(y);

        if(xrep == yrep) return;

        this.parent[xrep] = yrep;
    }

    public static void main(String[] args) {
        DisjointUnionSet set = new DisjointUnionSet(3);
        set.make();
        set.union(1, 2);
        set.union(1, 3);
        set.union(2, 3);
        if(set.find(1) == set.find(2)){
            System.out.println("1st Link");
        }
        if(set.find(1) == set.find(3)){
            System.out.println("Second Link");
        }
        if(set.find(2) == set.find(3)){
            System.out.println("Third Link");
        }
    }
}
