package list;

public class DLList implements List2{
    private DNode head;
    private DNode tail;
    protected DNode curr;
    private int currLen = 0;

    public DLList(int sz){ setup(); }
    public DLList(){ setup(); }

    private void setup(){
        tail = head = curr = new DNode(null, null);
    }
    @Override
    public void clear() {
        head.setNext(null);
        curr = tail = head;
        currLen = 0;
    }

    @Override
    public void insert(Object item) {
        if(curr==null){
            System.out.println("No curr element");
            return;
        }
        curr.setNext(new DNode(item, curr.next(), curr));
        if(curr.next().next()!=null)
            curr.next().next().setPrev(curr.next());
        if(tail == curr)
            tail = tail.next();
        currLen++;
    }

    @Override
    public void append(Object item) {
        tail.setNext(new DNode(item, null, tail));
        tail = tail.next();
        currLen++;
    }

    @Override
    public Object remove() {//删除的实际上是curr的下一个元素
        if(!isInList()){
            System.out.println("No curr elelment");
            return null;
        }
        Object it = curr.next().getElem();
        if(curr.next().next()!=null)
            curr.next().next().setPrev(curr);
        else tail = curr;
        curr.setNext(curr.next().next());
        currLen--;
        return it;
    }

    @Override
    public boolean isInList() {
        return (curr!=null) && (curr.next()!=null);
    }

    @Override
    public void setFirst() {
        curr = head;
    }

    public void next(){
        if(curr!=null) curr = curr.next();
    }

    public void prev(){
        curr = curr.prev();
    }

    public void setPos(int pos){
        curr = head;
        for(int i=0;(curr!=null)&&(i<pos);i++)
            curr = curr.next();
    }

    public void setValue(Object it){
        if(!isInList()){
            System.out.println("curr is not in list");
            return;
        }
        curr.next().setElem(it);
    }

    public Object currValue(){
        if(!isInList()) return null;
        return curr.next().getElem();
    }

    @Override
    public boolean isEmpty() {
        return head.next()==null;
    }

    @Override
    public void print() {
        if(isEmpty()) System.out.println("List is empty");
        else{
            for(setFirst();isInList();next()){
                System.out.print(currValue() + " ");
            }
            System.out.println();
        }
    }

    @Override
    public int length(){ return currLen; }

    public static void main(String[] args)throws Exception{
        DLList l1 = new DLList();
        l1.append(5);
        l1.append(8);
        l1.append(90);
        l1.append(100);
        l1.print();
        l1.setPos(3);
        System.out.println(l1.currValue());
        System.out.println(l1.isInList());
    }
}