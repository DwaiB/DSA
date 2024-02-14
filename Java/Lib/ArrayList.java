package Java.Lib;

public class ArrayList<T> {
    T [] array;
    int[] next;
    int ptr,size,avail;
    @SuppressWarnings(value = { "unchecked" })
    public ArrayList(){
        array =(T[]) new Object[100];
        next = new int[100];
        size = 0;
        ptr = -1;avail = 0;
        next[avail] = 1;
        for(int i=1;i<100;++i){
            next[i] = next[i-1];
        }
    }
    public T get(int index){
        return (T) array[index];
    }

}
