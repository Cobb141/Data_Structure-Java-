package homework_binTree;

public class Elem02<K extends Comparable<K>, V> implements Elem<K, V>{
    private K key;
    private V value;

    public Elem02(){}
    public Elem02(K k, V val){
        key = k;
        value = val;
    }
    @Override
    public K key() {
        return key;
    }

    @Override
    public void setKey(K key) {
        this.key = key;
    }

    @Override
    public V value() {
        return value;
    }

    @Override
    public void setValue(V val) {
        value = val;
    }
    
}