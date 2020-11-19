package homework_binTree;

import list.AList;
import list.LList;
public class Elem03 <K extends Comparable<K>, V> implements Elem<K, V>{
    private K key;
    private V value;
    private LList array = new LList();
    
    public Elem03(){}
    public Elem03(K k, V val){
        key = k;
        value = val;
        array.append(val);
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
        array.append(val);
    }
    
    public String getArray(){
        return array.print2();
    }
}