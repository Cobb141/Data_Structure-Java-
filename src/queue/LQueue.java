package queue;

import list.*;
public class LQueue<T> {
    private Node front;
    private Node rear;

    public LQueue(){ setup(); }
    public LQueue(int size){ setup(); }

    private void setup(){
        front = rear = null;
    }

    public void clear(){
        front = rear = null;
    }

    public void enQueue(Object item){
        if(rear!=null){
            rear.setNext(new Node(item, null));
            rear = rear.next();
        }else front = rear = new Node(item, null);
    }

    @SuppressWarnings("unchecked")
    public T deQueue(){
        if(!isEmpty()){
            Object it = front.getElem();
            front = front.next();
            if(front==null) rear = null;
            return (T)it;  
        }else{
            System.out.println("queue is empty");
            return null;
        }
    }

    public boolean isEmpty(){
        return front == null;
    }

    @SuppressWarnings("unchecked")
    public T getFirst(){
        if(!isEmpty()) return (T)front.getElem();
        else{
            System.out.println("Queue is empty");
            return null;
        }
    }
}