package list;

public class LList implements List{
    private Node head;
    private Node tail;
    private int curLen = 0;
    protected Node current;

    public LList(int size){
        setup();
    }

    public LList(){
        setup();
    }

    private void setup(){
        tail = head = current = new Node(null);
    }

    @Override
    public void clear() {
        head.setNext(null);
        current = tail = head;
        curLen = 0;
    }

    @Override
    public void insert(Object item, int i) {
        if(i<0 || i>curLen) System.out.println("Index Error or list is empty");
        else{
            Node curr = head;
            for(int j=0; j<i-1;j++) curr = curr.next();
            curr.setNext(new Node(item, curr.next()));//一行代码完成插入动作
            if(tail == curr){
                tail = curr.next();
            }
            curLen++;
        }
    }

    @Override
    public void append(Object item) {
        tail.setNext(new Node(item,null));
        tail = tail.next();
        curLen++;
    }

    @Override
    public Object remove(int i) {
        if(i<0 || i>=curLen){
            System.out.println("Index Error or list is empty");
            return null;
        }else{
            Node curr = head;
            for(int j=0; j<i;j++) curr = curr.next();
            Object temp = curr.next().getElem();
            curr.setNext(curr.next().next());
            curLen--;
            return temp;
        }
    }

    @Override
    public int length() {
        return curLen;
    }

    @Override
    public void setValue(Object item, int i) {
        if(i<0 || i>=curLen) System.out.println("Index Error or list is empty");
        else{
            Node curr = head;
            for(int j=0; j<i-1;j++) curr = curr.next();
            curr.next().setElem(item);
        }
    }

    @Override
    public boolean isEmpty() {
        return head.next()==null;
    }

    @Override
    public void print() {
        if(isEmpty()) System.out.println("List is empty");
        else{
            Node curr = head;
            while(curr.next()!=null){
                curr = curr.next();
                System.out.print(curr.getElem() + " ");
            }
        }
    }

    public String print2(){
        StringBuilder s = new StringBuilder();
        if(isEmpty()){
            System.out.println("List is empty");
            return null;
        }
        else{
            Node curr = head;
            while(curr.next()!=null){
                curr = curr.next();
                s.append(curr.getElem() + " ");
                //System.out.print(curr.getElem() + " ");
            }
            return s.toString();
        }
    }

    @Override
    public int indexOf(Object item) {
        int i = 0;
        Node curr = head.next();
        while(i<curLen && !curr.getElem().equals(item)){
            curr = curr.next();
            i++;
            if(curr==null) break;
        }
        if(i<curLen) return i;
        else return -1;
    }

    @Override
    public Object get(int i) {
        if(i<0 || i>=curLen){
            System.out.println("Index Error or list is empty");
            return null;
        }else{
            Node curr = head.next();
            for(int j=0; j<i;j++) curr = curr.next();
            return curr.getElem();
        }
    }

    //为current新增的方法
    public void setFirst(){
        current = head;
    }

    public void next(){
        if(current!=null) current = current.next();
    }

    public void prev(){
        if(current==null || current==head){
            current = null;
            return;
        }
        Node temp = head;
        while(temp!=null && temp.next()!=current)
            temp = temp.next();
        current = temp;
    }

    public void setPos(int pos){
        current = head;
        for(int i=0;(current!=null)&&(i<pos);i++)
            current = current.next();
    }

    public void setValue(Object it){
        if(!isInList()){
            System.out.println("current is not in list");
            return;
        }
        current.next().setElem(it);
    }

    public Object currValue(){
        if(!isInList()) return null;
        return current.next().getElem();
    }

    public boolean isInList(){
        return (current!=null) && (current.next()!=null);
    }
    public Object remove(){
        if(!isInList()) return null;
        Object it = current.next().getElem();
        if(tail==current.next()) tail = current;
        current.setNext(current.next().next());
        return it;
    }
}