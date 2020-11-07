package homework_list;

import sort.Sort;
public class AList1 implements List{
    private static final int DEFAULT_SIZE = 20;
    private int msize;
    private int[] listArray;
    private int curLen = 0;
    private int curr;

    public AList1(){
        setup(DEFAULT_SIZE);
    }

    public AList1(int size){
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
    public boolean insert(int x) {
        if(curr<0 || curr>curLen){
            System.out.println("Error with index of curr or list is empty");
            return false;
        } 
        else if(curLen==msize){
            System.out.println("List is full");
            return false;
        } 
        else{
            curLen++;
            listArray[curLen-1] = listArray[curr];
            listArray[curr] = x;
            return true;
        }    
    }

    @Override
    public int delete(int x) {
        int index = -1;
        for(int i=0;i<curLen;i++){
            if(listArray[i]==x){
                swap(listArray, i, curLen-1);
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
        }
        int min = listArray[0];
        for(int i=0;i<curLen;i++){
            if(listArray[i]<min)
                min = listArray[i];
        }
        return min;
    }

    @Override
    public int maximum() {
        int max = listArray[0];
        if(isEmpty()){
            System.out.println("List is empty");
            return -1;
        }else{
            for(int i=0;i<curLen;i++){
                if(listArray[i]>max)
                    max = listArray[i];
            }
            return max;
        }
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
        for(int i=0;i<curLen;i++){
            temp[i] = listArray[i];
        }
        Sort.qsort2(temp, 0, curLen-1);
        return temp[curLen-k];
    }
    
    public boolean isEmpty() {
        return curLen == 0;
    }

    public void setFirst(){ curr = 0; }
    public void prev(){ curr --; }
    public void next(){ curr ++; }

    public void print() {
        if(isEmpty()) System.out.println("List is empty");
        else{
            for(int i=0; i<curLen; i++) 
                System.out.print(listArray[i] + " ");
        }
    }

    public void swap(int[] array, int i,int j){
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }
}