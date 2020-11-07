package queue;

public class AQueue<T> {
    private static final int DEFAULT_SIZE = 20;
    private int size;
    private int front;
    private int rear;
    private Object[] queue;

    public AQueue(){ setup(DEFAULT_SIZE); }
    public AQueue(int size){ setup(size); }

    private void setup(int size){
        this.size = size + 1;
        front = rear = 0;
        queue = new Object[this.size];
    }

    public void clear(){
        front = rear = 0;
    }

    public void enQueue(T item){
        if((rear+1)%size == front){
            System.out.println("Queue is full");
            return;
        }else{
            rear = (rear+1) % size;
            queue[rear] = item;
        }
    }

    @SuppressWarnings("unchecked")
    public T deQueue(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return null;
        }else{
            front = (front + 1) % size;
            return (T)queue[front];
        }
    }

    public boolean isEmpty(){
        return front == rear;
    }

    @SuppressWarnings("unchecked")
    public T getFirst(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return null;
        }else{
            return (T)queue[(front + 1) % size];
        }
    }
}