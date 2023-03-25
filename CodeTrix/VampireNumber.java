import java.util.ArrayList;
import java.util.List;

public class VampireNumber {

    public List<Integer> VampireCalc(){
        List<Integer> list = new ArrayList<>();
        int d1,d2,d3,d4,n;
        for(int i = 1000;i<10000;i++){
            n = i;
            d4 = n%10;
            n= n/10;
            d3 = n%10;
            n= n/10;
            d2 = n%10;
            n= n/10;
            d1 = n%10;
            n= n/10;
            if((d1*10+d2)*(d3*10+d4) == i ||
                (d1*10+d2)*(d4*10+d3) == i ||
                (d2*10+d1)*(d3*10+d4) == i ||
                (d2*10+d1)*(d4*10+d3) == i ||

                (d1*10+d3)*(d2*10+d4) == i ||
                (d1*10+d3)*(d4*10+d2) == i ||
                (d3*10+d1)*(d2*10+d4) == i ||
                (d3*10+d1)*(d4*10+d2) == i ||

                (d2*10+d3)*(d1*10+d4) == i ||
                (d2*10+d3)*(d4*10+d1) == i ||
                (d3*10+d2)*(d1*10+d4) == i ||
                (d3*10+d2)*(d4*10+d1) == i ||

                (d2*10+d4)*(d1*10+d3) == i ||
                (d2*10+d4)*(d3*10+d1) == i ||
                (d4*10+d2)*(d1*10+d3) == i ||
                (d4*10+d2)*(d3*10+d1) == i 
                ){
                    list.add(i);
                }
        }
        return list;
    }

    public static void main(String[] args) {
        VampireNumber vn = new VampireNumber();
        List<Integer> list = new ArrayList<>();

        list = vn.VampireCalc();
        for( Integer i : list){
            System.out.println(i);
        }
    }
}
