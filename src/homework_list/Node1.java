package homework_list;

public class Node1 {
    private int elem = 0;
    private Node1 next = null;

    public Node1(){
    }

    public Node1(int item, Node1 nextVal){
        elem = item;
        next = nextVal;
    }

    public Node1(Node1 nextVal){
        next = nextVal;
    }

    public Node1 next(){return next;}

    public void setNext(Node1 nextVal){next = nextVal;}

    public int getElem(){return elem;}

    public void setElem(int item){elem = item;}
}