package list;

public interface ListGener<T> {
    public void clear();
    public void insert(T item, int i);
    public void append(T item);
    public T remove(int i);
    public int length();
    public void setValue(T item, int i);
    public boolean isEmpty();
    public void print();
    public int indexOf(T item);
    public T get(int i);
}