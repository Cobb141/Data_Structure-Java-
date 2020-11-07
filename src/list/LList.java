package list;

public class LList implements List{
    private Node head;
    private Node tail;
    private int curLen = 0;

    public LList(int size){
        setup();
    }

    public LList(){
        setup();
    }

    private void setup(){
        tail = head = new Node(null);
    }

    @Override
    public void clear() {
        head.setNext(null);
        tail = head;
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
}