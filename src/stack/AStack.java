package stack;

public class AStack<T> {
    private static final int DEFAULT_SIZE = 20;
    private int size;
    private int top;
    private Object[] stack;

    public AStack(){
        setup(DEFAULT_SIZE);
    }
    public AStack(int size){
        setup(size);
    }

    private void setup(int size){
        this.size = size;
        top = -1;
        stack = new Object[size];
    }

    public void clear(){ top = 0;}

    public void push(Object item){
        if(top>=size) System.out.println("Stack is full");
        else{
            stack[++top] = item;
        }
    }

    @SuppressWarnings("unchecked")
    public T pop(){
        if(!isEmpty()){
            return (T)stack[top--];
        }else{
            System.out.println("Stack is empty");
            return null;
        } 
    }

    public boolean isEmpty(){
        return top == -1;
    }

    @SuppressWarnings("unchecked")
    public T getTop(){
        if(!isEmpty()){
            return (T)stack[top];
        }else{
            //System.out.println("Stack is empty");
            return null;
        }
    }

    public int length(){
        return top+1;
    }
}