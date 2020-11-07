package stack;

import list.*;
public class LStack <T>{
    private Node top;

    public LStack(){
        setup();
    }
    public LStack(int size){
        setup();
    }

    private void setup(){
        top =null;
    }

    public void clear(){ top = null;}

    public void push(Object item){
        top = new Node(item, top);
    }

    @SuppressWarnings("unchecked")
    public T pop(){
        if(!isEmpty()){
            T item = (T)top.getElem();
            top = top.next();
            return item;
        }else{
            System.out.println("Stack is empty");
            return null;
        } 
    }

    public boolean isEmpty(){
        return top == null;
    }

    @SuppressWarnings("unchecked")
    public T getTop(){
        if(!isEmpty()){
            return (T)top.getElem();
        }else{
            System.out.println("Stack is empty");
            return null;
        }
    }

    public int length(){
        Node temp = top;
        int len = 0;
        while(temp!=null){
            len++;
            temp = temp.next();
        }
        return len;
    }
}