package list;

public class Node {
    private Object elem = null;
    private Node next = null;

    public Node(){
    }

    public Node(Object item, Node nextVal){
        elem = item;
        next = nextVal;
    }

    public Node(Node nextVal){
        next = nextVal;
    }

    public Node next(){return next;}

    public void setNext(Node nextVal){next = nextVal;}

    public Object getElem(){return elem;}

    public void setElem(Object item){elem = item;}
}