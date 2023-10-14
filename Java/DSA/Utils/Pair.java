package Java.DSA.Utils;

public class Pair<T,V> {
    private T key;
    private V value;
    public Pair(T _key,V _value){
        this.key = _key;
        this.value = _value;
    }
    public T getKey(){
        return key;
    }
    public V getValue(){
        return value;
    }
    public void setKey(T _key){
        this.key = _key;
        this.value = null;
    }
    public void setValue(V _value){
        this.value = _value;
        this.key = null;
    }
    @Override
    public String toString() {
        return String.format("KEY: %d VALUE: %d",key,value);
    }
    
}
