package tree;

public class Elem01 implements Elem{
    private int key;

    public Elem01(){
    }
    public Elem01(int k){ key = k; }
    
    @Override
    public int key() {
        return key;
    }

    @Override
    public void setKey(int k) {
        key = k;
    }
    
}