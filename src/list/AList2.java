package list;

public class AList2 implements List2{
    private static final int DEFAULT_SIZE = 20;

    private int msize;
    private int numInList;
    private int curr;
    private Object[] listArray;

    public AList2(){
        setup(DEFAULT_SIZE);
    }
    public AList2(int sz){
        setup(sz);
    }

    private void setup(int sz){
        msize = sz;
        numInList = curr = 0;
        listArray = new Object[sz];
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub

    }

    @Override
    public void insert(Object item) {
        // TODO Auto-generated method stub

    }

    @Override
    public void append(Object item) {
        // TODO Auto-generated method stub

    }

    @Override
    public Object remove() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setFirst() {
        // TODO Auto-generated method stub

    }

    @Override
    public void next() {
        // TODO Auto-generated method stub

    }

    @Override
    public void prev() {
        // TODO Auto-generated method stub

    }

    @Override
    public int length() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void setPos(int pos) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setValue(Object val) {
        // TODO Auto-generated method stub

    }

    @Override
    public Object currValue() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void print() {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean isInList() {
        // TODO Auto-generated method stub
        return false;
    }
    
}