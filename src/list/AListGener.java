package list;

public class AListGener<T> implements ListGener<T>{
    private static final int DEFAULT_SIZE = 20;
    private int msize;
    private Object[] listArray;
    private int curLen = 0;

    public AListGener(){
        setup(DEFAULT_SIZE);
    }

    public AListGener(int size){
        setup(size);
    }

    private void setup(int size){
        msize = size;
        listArray = new Object[msize];
    }

    @Override
    public void clear() {
        curLen = 0;
    }

    @Override
    public void insert(T item, int i){
        if(i<0 || i>curLen) System.out.println("Index Error or list is empty");
        else if(curLen==msize) System.out.println("List is full");
        else{
            for(int j=curLen; j>i ; j--)
                listArray[j] = listArray[j-1];
            listArray[i] = item;
            curLen++;
        }    
    }

    @Override
    public void append(T item) {
        if(curLen==msize) System.out.println("List is full");
        else{
            listArray[curLen++] = item;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public T remove(int i) {
        if(i<0 || i>=curLen){
            System.out.println("Index Error or list is empty");
            return null;
        }else{
            T temp = (T)listArray[i];
            for(int j=i; j<curLen; j++)
                listArray[j] = listArray[j+1];
            curLen--;
            return temp;
        }
    }

    @Override
    public int length() {
        return curLen;
    }

    @Override
    public void setValue(T item, int i) {
        if(i<0 || i>=curLen) System.out.println("Index Error or list is empty");
        else listArray[i] = item;
    }

    @Override
    public boolean isEmpty() {
        return curLen == 0;
    }

    @Override
    public void print() {
        if(isEmpty()) System.out.println("List is empty");
        else{
            for(int i=0; i<curLen; i++) 
                System.out.println(listArray[i] + " ");
        }
    }

    @Override
    public int indexOf(T item) {
        int i = 0;
        while(i<curLen && !listArray[i].equals(item))
            i++;
        if(i<curLen) return i;
        else return -1;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T get(int i){
        if(i<0 || i>=curLen){
            System.out.println("Index Error or list is empty");
            return null;
        }else{
            return (T)listArray[i];
        } 
    }
}