package LeetCode.graphs;
import java.util.ArrayList;
import java.util.List;

public class RerouteToZero {
    class City{
        public int name;
        public boolean to;
        public List<City> roads;
        public City(int name){
            this.name = name;
            roads = new ArrayList<City>();
        }
        public City(int name, boolean to){
            this.name = name;
            this.to = to;
            this.roads = new ArrayList<City>();
        }
        public void add(int road, boolean to){
            roads.add(new City(road, to));
        }
    }
    City [] cities;
    public int minReorder(int n, int[][] connections) {
        boolean[] visited = new boolean[n];
        cities = new City[n];
        for(int i=0;i<n;i++) {
            cities[i] = new City(i);
        }
        int count = 0;
        for(int[] conn : connections) {
            cities[conn[0]].add(conn[1],true); 
            cities[conn[1]].add(conn[0], false);
        }
        List<City> zeroCityRoads = cities[0].roads;
        for(City route : zeroCityRoads) {
            count = count + calcPathCost(route,visited);
        }
        return count;
    }
    public int calcPathCost(City city,boolean[] visited) {
        if(city == null || visited[city.name]){
            return 0;
        }
        visited[city.name] = true;
        int cmin = 0;
        if(!city.to){
            cmin++;
        }
        for(City roadConn : cities[city.name].roads){
            cmin += calcPathCost(roadConn, visited);
        }
        visited[city.name] = false;
        return cmin;
    }
}
