package list;

public class DNode {
    private Object elem;
    private DNode next;
    private DNode prev;

    public DNode(Object it, DNode next, DNode prev){
        elem = it;
        this.next = next;
        this.prev = prev;
    }
    public DNode(DNode n, DNode p){
        next = n;
        prev = p;
    }

    public DNode next(){ return next; }
    public DNode setNext(DNode nextval){
        return next = nextval;
    }
    public DNode prev(){ return prev; }
    public DNode setPrev(DNode prevval){
        return prev = prevval;
    }
    public Object getElem(){ return elem; }
    public Object setElem(Object it){
        return elem = it;
    }
}