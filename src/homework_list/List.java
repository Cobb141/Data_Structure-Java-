package homework_list;

public interface List {
    boolean search(int x);       
    boolean insert(int x);       
    int delete(int x);       
    int successor(int x);//获得该线性表中x 元素的直接后继元素       
    int predecessor(int x);//获得该线性表中x 元素的直接前驱元素       
    int minimum();//获得该线性表的最小元素       
    int maximum();//获得该线性表的最大元素       
    int KthElement(int k);//获得线性表中第k 大元素，参数为指定的k 值的大小       
    //此处根据需要自己添加行为定义   
}