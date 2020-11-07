package homework_list;

public class SortedAList implements List{
    private static final int DEFAULT_SIZE = 20;
    private int msize;
    private int[] listArray;
    private int curLen = 0;
    private int curr;

    public SortedAList(){
        setup(DEFAULT_SIZE);
    }

    public SortedAList(int size){
        setup(size);
    }

    private void setup(int size){
        msize = size;
        listArray = new int[msize];
    }
    @Override
    public boolean search(int x) {
        int i = 0;
        while(i<curLen && listArray[i]!=x)
            i++;
        if(i<curLen) return true;
        else return false;
    }

    @Override
    public boolean insert(int x){
        if(curLen==msize){
            System.out.println("list is full");
            return false;
        }else{
            if(isEmpty()){
                listArray[0] = x;
                curLen++;
                return true;
            }else{
                curr = 0;
                while(listArray[curr]<x && curr<=curLen) curr++;
                for(int i=curLen;i>curr;i--){
                    listArray[i] = listArray[i-1];
                }
                listArray[curr] = x;
                curLen++;
                return true;
            }
        } 
    }

    @Override
    public int delete(int x) {
        int index = -1;
        for(int i=0;i<curLen;i++){
            if(listArray[i]==x){
                for(int j=i; j<curLen; j++)
                    listArray[j] = listArray[j+1];
                curLen--;
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public int successor(int x) {
        int i = 0;
        if(!search(x)){
            System.out.println("x is not in the list");
            return -1;
        }else{
            while(i<curLen && listArray[i]!=x)
                i++;
            return listArray[i+1];
        }
    }

    @Override
    public int predecessor(int x) {
        int i = 0;
        if(!search(x)){
            System.out.println("x is not in the list");
            return -1;
        }else{
            while(i<curLen && listArray[i]!=x)
                i++;
            if(i==0)
                System.out.println("x is the first one in the list");
            return listArray[i-1];
        }
    }

    @Override
    public int minimum() {
        if(isEmpty()){
            System.out.println("List is empty");
            return -1;
        }else{
            return listArray[0];
        }
    }

    @Override
    public int maximum() {
        if(isEmpty()){
            System.out.println("List is empty");
            return -1;
        }else{
            return listArray[curLen-1];
        }
    }

    @Override
    public int KthElement(int k) {
        if(isEmpty()){
            System.out.println("List is empty");
            return -1;
        }else{
            return listArray[curLen-k];
        }
    }
    
    public boolean isEmpty() {
        return curLen == 0;
    }

    public void print() {
        if(isEmpty()) System.out.println("List is empty");
        else{
            for(int i=0; i<curLen; i++) 
                System.out.print(listArray[i] + " ");
        }
    }
}