package list;

public interface CList {
    public int findKth(int index);//按照索引获取元素
    public int find(int x);//获取元素x第一次出现的位置 
    public boolean insert(int x, int index);//在index后插入元素x
    public boolean delete(int index);//删去index处的元素
    public int length();//返回线性表长度
    public boolean add(int x);//向线性表尾部添加元素
}