package homework_binTree;

public interface Elem <K extends Comparable<K>, V>{
    public K key();
    public void setKey(K key);
    public V value();
    public void setValue(V val);
}