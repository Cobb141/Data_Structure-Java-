package homework_list;

import sort.Sort;
public class LList1 implements List{
    private Node1 head;
    private Node1 tail;
    private int curLen = 0;
    private Node1 curr;

    public LList1(int size){
        setup();
    }

    public LList1(){
        setup();
    }

    private void setup(){
        tail = head = curr = new Node1(null);
    }

    @Override
    public boolean search(int x) {
        if(isEmpty()){
            System.out.println("list is empty");
            return false;
        }else{
            curr = head.next();
            while(curr.getElem()!=x){
                curr = curr.next();
                if(curr==null) break;
            } 
            if(curr==null) return false;
            else return true;
        }
    }

    @Override
    public boolean insert(int x) {
        curr.setNext(new Node1(x, curr.next()));
        curLen ++;
        if(tail==curr) tail = curr.next();
        return true;
    }

    @Override
    public int delete(int x) {
        if(isEmpty()){
            System.out.println("list is empty");
            return -1;
        }
        else if(!search(x)){
            System.out.println("x is not in list");
            return -1;
        }
        Node1 curr = head;
        while(curr.next().getElem()!=x) curr = curr.next();
        int temp = curr.next().getElem();
        curr.setNext(curr.next().next());
        curLen--;
        return temp;
    }

    @Override
    public int successor(int x) {
        if(isEmpty()){
            System.out.println("list is empty");
            return -1;
        }else{
            curr = head.next();
            while(curr.getElem()!=x){
                curr = curr.next();
                if(curr==null) break;
            } 
            if(curr==null || curr.next()==null) return -1;
            else return curr.next().getElem();
        }
    }

    @Override
    public int predecessor(int x) {
        if(isEmpty()){
            System.out.println("list is empty");
            return -1;
        }else{
            curr = head.next();
            Node1 curr2 = head;
            while(curr.getElem()!=x){
                curr = curr.next();
                curr2 = curr2.next();
                if(curr==null) break;
            } 
            if(curr==null) return -1;
            else if(curr==head.next()){
                System.out.println("x is the first one in the list");
                return -1;
            }
            else return curr2.getElem();
        }
    }

    @Override
    public int minimum() {
        if(isEmpty()){
            System.out.println("List is empty");
            return -1;
        }
        int min = head.next().getElem();
        curr = head.next();
        while(curr!=null){
            if(curr.getElem()<min)
                min = curr.getElem();
            curr = curr.next();
        }
        return min;
    }

    @Override
    public int maximum() {
        if(isEmpty()){
            System.out.println("List is empty");
            return -1;
        }
        int max = head.next().getElem();
        curr = head.next();
        while(curr!=null){
            if(curr.getElem()>max)
                max = curr.getElem();
            curr = curr.next();
        }
        return max;
    }

    @Override
    public int KthElement(int k) {
        if(isEmpty()){
            System.out.println("List is empty");
            return -1;
        }
        else if(k<0 || k>=curLen){
            System.out.println("k is wrong");
            return -1;
        }
        int[] temp = new int[curLen];
        curr = head.next();
        int i = 0;
        while(curr!=null){
            temp[i] = curr.getElem();
            curr = curr.next();
            i++;
        }
        Sort.qsort2(temp, 0, curLen-1);
        return temp[curLen-k];
    }
    
    public boolean isEmpty() {
        return head.next()==null;
    }

    public void print() {
        if(isEmpty()) System.out.println("List is empty");
        else{
            Node1 curr = head;
            while(curr.next()!=null){
                curr = curr.next();
                System.out.print(curr.getElem() + " ");
            }
        }
    }
}