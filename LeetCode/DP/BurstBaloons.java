import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BurstBaloons {
    int [] [] t;
    Map<List<Integer>,Integer> map;
    public int maxCoins(int[] nums) {
        // for(int i = 0; i< nums.length;i++){
        //     for(int j =0; j < nums.length;j++){
        //         if(i == j){
        //             t[i][j] = nums[i];
        //         }else{
        //             t[i][j] = Math.max(nums[i]*nums[j]+nums[i],nums[i]*nums[j]+nums[j]);
        //         }
        //     }
        // }
        List<Integer> list = new LinkedList<Integer>();
        map = new HashMap<List<Integer>,Integer>();
        for(int i : nums){
            list.add(i);
        }
        return dfs(list,list.size());
    }

    public int dfs(List<Integer> list,int balloons) {
        if(map.containsKey(list)){
            return map.get(list);
        }
        if(list.size() == 1){
            return list.get(0);
        }
        if(list.size() == 2){
            return Math.max(list.get(0)*list.get(1)+list.get(0),list.get(0)*list.get(1)+list.get(1));
        }
        if(list.size() == 0){
            return 0;
        }
        int max = 0, temp, coins=0,burst =1;
        for (int k = 0; k < balloons; k++) {
            if(map.containsKey(list)){
                logger("From Cache Max: "+max);
                coins = map.get(list);
            }else{
                temp = list.get(k);
                list.remove(k);
                coins = dfs(list,balloons-1);
                list.add(k, temp);
                burst = (k<=0)? 1 : list.get(k-1);
                burst *= (k >= balloons-1)?1 : list.get(k+1);
                burst *= temp;
                coins = coins + burst;
                print(list);
            }
            
            logger(" total coins = "+coins);
            max = Math.max(max, coins);
        }
        // print(list);
        map.put(list,max);
        
        return max;
    }

    public int getIndex(int[] nums, int i, int k) {
        int j = -1;
        for (j = i + k; j >= 0 && j < nums.length; j += k) {
            if (nums[j] != -1) {
                break;
            }
        }
        if (j < 0 || j >= nums.length) {
            return 1;
        }
        return nums[j];
    }
    public void print(List<Integer> list){
        System.out.print("[");
        for(int i : list){
            System.out.print(i+" ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        BurstBaloons BB = new BurstBaloons();
        Scanner sc = new Scanner(System.in);
        // BB.getIndexTest(sc);
        int [] nums = {7,9,8,0,7,1,3,5,5,2,3,3};
        // BB.logger("Hello");
        // BB.list();
        System.out.println(BB.maxCoins(nums));
        sc.close();
    }

    public void list(){
        List<Integer> list = new LinkedList<Integer>();
        list.add(3);
        list.add(5);
        list.add(4);
        list.add(8);
        list.remove(2);
        System.out.println(list.get(2));
        for( int i : list){
            System.out.println(i);
        }
        
    }


    public void getIndexTest(Scanner sc) {
        int[] nums = {7,9,8,0,7,1,3,5,5,2,3,3};
        
        int val = -1;
        do {
            int i = sc.nextInt();
            int k = sc.nextInt();
            val = getIndex(nums, i, k);
            System.out.println("Index: " + val);
        } while (val != -1);

       
    }
    public void logger(String msg){
        System.out.println(msg);
    }
}
