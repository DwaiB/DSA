package Java.CodeTrix;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListToArray{
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<Integer,String>();
        map.put(1,"a");
        map.put(2,"b");
        map.put(3,"c");
        map.put(4,"d");
        map.put(5,"e");
        map.put(6,"f");
        List<Integer> keys = map.keySet().stream().sorted().toList();
        Integer [] timestamps =  keys.toArray(new Integer[keys.size()]);
        
    }
}