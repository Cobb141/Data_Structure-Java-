package list.practicelist;

import list.*;
public class LList2 implements List2{
    private Node2 head;
    private Node2 tail;
    protected Node2 curr;
    private int curLen = 0;

    public LList2(){setup();}
    public LList2(int sz){setup();}

    private void setup(){
        tail = head = curr = new Node2(null); //哑结点
    }

    @Override
    public void clear() {
        head.setNext(null);
        curr = tail = head;
    }

    @Override
    public void insert(Object item) {
        if(curr==null){
            System.out.println("there is no curr element!");
            return;
        }
        curr.setNext(new Node2(item, curr.next()));
        curLen++;
        if(tail==curr)
            tail = curr.next();
    }

    @Override
    public void append(Object item) {
        tail.setNext(new Node2(item, null));
        tail = tail.next();
        curLen++;
    }

    @Override
    public Object remove() {
        if(!isInList()){
            System.out.println("Error with the position of curr!");
            return null;
        }
        if(isEmpty()){
            System.out.println("List is empty!");
            return null;
        }
        Object it = curr.next().element();
        if(tail==curr.next()) tail = curr;
        curr.setNext(curr.next().next());
        curLen--;
        return it;
    }

    @Override
    public void setFirst() {
        curr = head;
    }

    @Override
    public void next() {
        if(curr!=null) curr = curr.next();
    }

    @Override
    public void prev() {
        if(curr==null || curr==head){
            System.out.println("curr is null or curr is at head");
            curr = null;
            return;
        }
        Node2 temp = head;
        while((temp!=null) && (temp.next()!=curr))
            temp = temp.next();
        curr = temp;
    }

    @Override
    public int length() {
        return curLen;
    }

    @Override
    public void setPos(int pos) {
        curr = head;
        for(int i=0;(curr!=null)&&(i<pos);i++)
            curr = curr.next();
    }

    @Override
    public void setValue(Object val) {
        if(!isInList()){
            System.out.println("Error with the position of curr!");
            return;
        }
        if(isEmpty()){
            System.out.println("List is empty!");
            return;
        }
        curr.next().setElement(val);
    }

    @Override
    public Object currValue() {
        if(!isInList()) return null;
        return curr.next().element();
    }

    @Override
    public boolean isEmpty() {
        return head.next()==null;
    }

    @Override
    public boolean isInList() {
        return (curr!=null)&&(curr.next()!=null);
    }

    @Override
    public void print() {
        if(isEmpty()){
            System.out.println("List is empty!");
            return;
        }
        for(setFirst();isInList();next()){
            System.out.print(currValue() + " ");
        }
        System.out.println();
    }

    public void reverse(){
        if(isEmpty()) return;
        Node2 temp1 = head;
        Node2 temp2 = head.next();
        tail = head.next();
        while(temp2!=null){
            Node2 temp3 = temp2.next(); //temp3用于存储temp2的后继节点
            temp2.setNext(temp1);  //反转，将temp2指向temp1
            temp1 = temp2;  //后移一格
            temp2 = temp3;  //后移一格
        }
        tail.setNext(null);
        head.setNext(temp1); //最后temp1会移动到原链表的尾结点，反转之后它变成第一个结点
    }

    //求倒数第n个元素，当能快速获取长度时
    public Object removeNthFromButtom(int n){
        int len = length();
        if(n>len){
            System.out.println("n is bigger than the length of list");
            return null;
        }
        setFirst();
        for(int i=0;(curr!=null)&&(i<(len-n));i++)
            curr = curr.next();
        Object temp = remove();
        return temp;
    }

    //求倒数第n个元素，使用快慢指针
    public Object removeNthFromButtom2(int n){
        Node2 quick = head;
        setFirst();
        for(int i=0;(i<n)&&(quick!=null);i++){
            quick = quick.next();
            if(quick==null){
                System.out.println("n is bigger than the length of list");
                return null;
            }
        }
        while(quick.next()!=null){
            quick = quick.next();
            curr = curr.next();
        }
        return remove();
    }

    public Object midNode(){
        if(isEmpty()){
            System.out.println("List is empty!");
            return null;
        }
        Node2 quick = head;
        if(quick.next().next()==null){
            return quick.next().element();
        }
        Node2 slow = head;
        while(quick.next().next()!=null){
            quick = quick.next().next();
            slow = slow.next();
            //下面两行是判断边界条件
            if(quick.next()==null) break; 
            if(quick.next().next()==null) slow = slow.next();
        }
        return slow.element();
    }
    
    public void merge(LList2 l2){
        if(isEmpty() || l2.isEmpty())
            return;
        Node2 t1 = head;
        Node2 t2 = head.next();
        Node2 t3 = l2.head;
        Node2 t4 = l2.head.next();
        while((t2!=null) && (t4!=null)){
            if((int)t2.element()>=(int)t4.element()){
                t3 = t4;
                t4 = t4.next();
                t1.setNext(t3);
                t3.setNext(t2);
                t1 = t1.next();
            }else{
                t1 = t2;
                t2 = t2.next();
            }
            if(t2==null){
                t1.setNext(t4);
                break;
            }
            if(t4==null) break;
        }
    }
}