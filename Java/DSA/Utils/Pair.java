package Java.DSA.Utils;

public class Pair<T,V> {
    private T first;
    private V second;
    public Pair(T _first,V _second){
        this.first = _first;
        this.second = _second;
    }
    public T first(){
        return first;
    }
    public V second(){
        return second;
    }
    public void setFirst(T _first){
        this.first = _first;
        this.second = null;
    }
    public void setSecond(V _second){
        this.second = _second;
        this.first = null;
    }
}
