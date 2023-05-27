package Java.CodeTrix;

class window{
    window(int i){
        System.out.println("Window " + i);
    }
}
class house{
    window w1 = new window(1);
    house(){
        System.out.println("House");
        w2 = new window(0);
    }
    window w2 = new window(3);

    void f(){
        System.out.println("F()");
    }
}

public class constructors {
    public static void main(String[] args) {
        house h1 = new house();
        h1.f();
    }
}