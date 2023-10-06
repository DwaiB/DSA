package Java.Collections;

import java.util.ArrayList;
import java.util.List;

public class Lists {
    public static void main(String[] args) {
        char[] a = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};

        List<String> list = new ArrayList<String>();
        
        list.add(new String(a));
        
    }
}
