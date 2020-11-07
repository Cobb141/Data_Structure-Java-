package list;

public interface List {
    public void clear();
    public void insert(Object item, int i);
    public void append(Object item);
    public Object remove(int i);
    public int length();
    public void setValue(Object item, int i);
    public boolean isEmpty();
    public void print();
    public int indexOf(Object item);
    public Object get(int i);
}