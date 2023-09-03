package LeetCode.heap;

import java.util.PriorityQueue;

public class Order_Log {
    PriorityQueue<Pair<Integer,Integer>> buy_log;
    PriorityQueue<Pair<Integer,Integer>> sell_log
    public int getNumberOfBacklogOrders(int[][] orders) {
        buy_log = new PriorityQueue<Pair<Integer,Integer>>();
        sell_log = new PriorityQueue<Pair<Integer,Integer>>();
    }
}
