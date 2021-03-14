package sort;

import queue.*;
public class Radix {

    public static int digOfMax(int[] arr){
        int max = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max) max = arr[i];
        }
        int digit = 0;
        while(max>0){
            max = max/10;
            digit++;
        }
        return digit;
    }

    @SuppressWarnings("unchecked")
    public static int[] radix(int[] arr){
        AQueue<Integer>[] buckets = new AQueue[10];
        for(int i=0;i<10;i++){
            buckets[i] = new AQueue<Integer>();
        }
        int dig = digOfMax(arr);
        int num = 10;
        for(int i=0;i<dig;i++){
            for(int j=0;j<arr.length;j++){
                int index = arr[j]%num;
                if(arr[j]*10<num) index = 0;
                if(index>10){
                    while(index>10)
                        index = index/10;
                }
                buckets[index].enQueue(arr[j]);
            }
            num *= 10;
            int index2 = 0;
            for(int k=0;k<10;k++){
                while(!buckets[k].isEmpty()){
                    arr[index2] = buckets[k].deQueue();
                    index2++;
                }
            }
        }
        return arr;
    } 

    @SuppressWarnings("unchecked")
    public static String[] radix(String[] arr){
        AQueue<String>[] buckets = new AQueue[26];
        for(int i=0;i<26;i++){
            buckets[i] = new AQueue<String>();
        }
        int dig = arr[0].length();
        for(int i=dig-1;i>=0;i--){
            for(int j=0;j<arr.length;j++){
                buckets[arr[j].charAt(i)-'a'].enQueue(arr[j]);
            }
            int index2 = 0;
            for(int k=0;k<26;k++){
                while(!buckets[k].isEmpty()){
                    arr[index2] = buckets[k].deQueue();
                    index2++;
                }
            }
        }
        return arr;
    }

    public static void swap(String[] arr, int i,int j){
        String t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
    public static void main(String[] args){
        int[] arr = {1, 21, 12, 322, 44, 123, 1312, 765, 56};
        String[] arr2 = {"abc","bde","fab","abd","bef","fdd","abe"};
        arr = radix(arr);
        arr2 = radix(arr2);
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i] + " ");
        System.out.println();
        for(int i=0;i<arr2.length;i++)
            System.out.print(arr2[i] + " ");
    }
}