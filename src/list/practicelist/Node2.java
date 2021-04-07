package list.practicelist;

public class Node2 {
    private Object element;
    private Node2 next;
    public Node2(){}

    public Node2(Object item, Node2 nextval){
        element = item;
        next = nextval;
    }
    public Node2(Node2 nextval){ next = nextval; }
    
    public Node2 next(){return next;}
    public Node2 setNext(Node2 nextval){
        return next = nextval;
    }
    public Object element(){ return element; }
    public Object setElement(Object it){
        return element = it;
    }
}