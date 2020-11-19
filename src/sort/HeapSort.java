package sort;

import tree.*;
public class HeapSort {
    
    public static void heapSort(int[] array){
        Elem[] temp = new Elem01[array.length];
        for(int i=0;i<temp.length;i++){
            temp[i] = new Elem01(array[i]);
        }
        MinHeap h = new MinHeap(temp, temp.length, temp.length + 20);
        int j = 0;
        while(h.heapSize()>0){
            array[j] = h.removeMin().key();
            j++;
        }
    }

    public static void heapSort2(int[] array){
        Elem[] temp = new Elem01[array.length];
        for(int i=0;i<temp.length;i++){
            temp[i] = new Elem01(array[i]);
        }
        TriadiusMinHeap h = new TriadiusMinHeap(temp, temp.length, temp.length + 20);
        int j = 0;
        while(h.heapSize()>0){
            array[j] = h.removeMin().key();
            j++;
        }
    }
    public static void main(String[] args){
        int[] a = {3,6,9,1,7,100,4,3};
        HeapSort.heapSort(a);
        for(int i=0;i<a.length;i++)
            System.out.print(a[i] + " ");
    }
}