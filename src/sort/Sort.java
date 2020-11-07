package sort;

//import java.util.*;
public class Sort {
    private static int cpNum = 0;
    private static int swNum = 0;

    public static void swap(int[] list,int i,int j){
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
        swNum++;
    }

    public static void printList(int[] list){
        for(int i =0;i<list.length;i++) System.out.print(list[i] + " ");
        System.out.println();
    }
    //冒泡排序
    public static void bubbleSort(int[] list){
        int i,j;
        for(i=0;i<list.length;i++)
            for(j=list.length-1;j>i;j--)
                if(list[j]<list[j-1]){
                    swap(list,j,j-1);
                    cpNum++;//------------------------
                }
    }
    //简单选择排序
    public static void selSort(int[] array){
        for(int i=0;i<array.length-1;i++){
            int lowIndex = i;
            for(int j=array.length-1;j>i;j--){
                if(array[lowIndex]>array[j]){
                    lowIndex = j;
                    cpNum++;//------------------------
                } 
            }
            swap(array,i,lowIndex);
        }
    }
    //直接插入排序
    public static void insSort(int[] list){
        for(int i=1;i<list.length;i++)
            for(int j=i;(j>0)&&(list[j]<list[j-1]);j--){
                swap(list,j,j-1);
                cpNum++;//------------------------
            }
    }

    public static void shellSort(int[] list){
        for(int i=list.length/2;i>2;i/=2)
            for(int j=0;j<i;j++)
                inssort2(list,j,i);
        inssort2(list,0,1);
    }
    public static void inssort2(int[] list,int start, int incr){
        for(int i=start+incr;i<list.length;i+=incr){
            for(int j=i;(j>=incr)&&(list[j]<list[j-incr]);j-=incr){
                swap(list,j,j-incr);
            }
        }
    }
    //快速排序
    public static void qsort(int[] array, int i,int j){
        int pivotIndex = findPivot(array,i,j);
        swap(array,pivotIndex,j);
        int k = partion(array,i-1,j,array[j]);
        swap(array,k,j);
        if((k-i)>1) qsort(array,i,k-1);
        if((j-k)>1) qsort(array,k+1,j);
    }
    public static int findPivot(int[] array,int i,int j){
        return (i+j)/2;
    }
    public static int partion(int[] array,int l,int r,int pivot){
        do{
            while(array[++l]<pivot) cpNum++;
            while((r!=0)&&(array[--r]>pivot)) cpNum++;
            swap(array,l,r);
        }while(l<r);
        swap(array,l,r);
        return l;
    }

    public static void qsort2(int[] array, int i,int j){
        int pivotIndex = findPivot(array,i,j);
        swap(array,pivotIndex,j);
        int k = partion(array,i-1,j,array[j]);
        swap(array,k,j);
        if((j-i)>=10){
            if((k-i)>1) qsort(array,i,k-1);
            if((j-k)>1) qsort(array,k+1,j);
        }else{
            inssort3(array, i, j);
        }
    }

    public static void inssort3(int[] list, int l, int r){
        for(int i=l;i<r+1;i++)
            for(int j=i;(j>l)&&(list[j]<list[j-1]);j--)
                swap(list,j,j-1);
    }
    //归并排序
    public static void mergeSort(int[] array, int[] temp, int left, int right){
        int mid;
        mid = (left + right)/2;
        if(left==right)return;
        mergeSort(array,temp,left,mid);
        mergeSort(array,temp,mid+1,right);

        for(int i=left;i<=right;i++){
            temp[i] = array[i];
        }
        int leftcurr=left,rightcurr=mid+1;
        for(int curr=left;curr<=right;curr++){
            if(leftcurr==mid+1){
                array[curr] = temp[rightcurr++];
                cpNum++;
            } //left越界，则把右子序列剩余的部分（right之后）接到归并序列之后
            else if(rightcurr>right){
                array[curr] = temp[leftcurr++];
                cpNum++;
            } //right越界，则把左子序列剩余的部分（left之后）接到归并序列之后
            else if(temp[leftcurr]<temp[rightcurr]){
                array[curr] = temp[leftcurr++];
                swNum++;
                cpNum++;
            } 
            else{
                array[curr] = temp[rightcurr++];
                swNum++;
                cpNum++;
            } 
        }
    }

    public static void mergeSort2(int[] array, int[] temp, int left, int right){
        int mid;
        mid = (left + right)/2;
        if(left==right)return;
        if((right-left)>=10){
            mergeSort(array,temp,left,mid);
            mergeSort(array,temp,mid+1,right);
        }else inssort3(array,left,right);
        
        for(int i=left;i<=right;i++){
            temp[i] = array[i];
        }
        int leftcurr=left,rightcurr=mid+1;
        for(int curr=left;curr<=right;curr++){
            if(leftcurr==mid+1) array[curr] = temp[rightcurr++];//left越界，则把右子序列剩余的部分（right之后）接到归并序列之后
            else if(rightcurr>right) array[curr] = temp[leftcurr++];//right越界，则把左子序列剩余的部分（left之后）接到归并序列之后
            else if(temp[leftcurr]<temp[rightcurr]) array[curr] = temp[leftcurr++];
            else array[curr] = temp[rightcurr++];
        }
    }
    public static void main(String[] args){
        long[] time = new long[100];
        long[] time2 = new long[100];
        long[] time3 = new long[100];
        long[] time4 = new long[100];
        long[] time5 = new long[100];
        int k=0;
        for(int len=100;len<=10000;len=len+100){
            int[] list = new int[len];
            int[] list2 = new int[len];
            int[] list3 = new int[len];
            int[] list4 = new int[len];
            int[] list5 = new int[len];
            //int[] list2 = new int[len];
            for(int i=0;i<len;i++){
                list[i] = (int)(Math.random()*10000);
            }
            for(int i=0;i<len;i++){
                list2[i] = list[i];
                list3[i] = list[i];
                list4[i] = list[i];
                list5[i] = list[i];
            }
            /*
            for(int i=0;i<len;i++){
                list2[i] = list[i];
            }
            for(int i=0;i<len/2;i++){
                swap(list2,i,len-i-1);
            }
            */
        
            long start = System.currentTimeMillis( );
            bubbleSort(list);
            long end = System.currentTimeMillis( );
            time[k] = end - start;
            swNum = 0;

            long start2 = System.currentTimeMillis( );
            selSort(list2);
            long end2 = System.currentTimeMillis( );
            time2[k] = end2 - start2;
            swNum  = 0;

            long start3 = System.currentTimeMillis( );
            insSort(list3);
            long end3 = System.currentTimeMillis( );
            time3[k] = end3 - start3;
            swNum = 0;

            long start4 = System.currentTimeMillis( );
            qsort(list4,0,len-1);
            long end4 = System.currentTimeMillis( );
            time4[k] = end4 - start4;
            swNum = 0;

            int[] temp2 = new int[len];
            long start5 = System.currentTimeMillis( );
            mergeSort(list5,temp2,0,len-1);
            long end5 = System.currentTimeMillis( );
            time5[k] = end5 - start5;
            swNum = 0;

            k++;
        }
        for(int i =0;i<time.length;i++) System.out.print(time[i] + " ");
        System.out.println("-----------");

        for(int i =0;i<time2.length;i++) System.out.print(time2[i] + " ");
        System.out.println("-----------");

        for(int i =0;i<time3.length;i++) System.out.print(time3[i] + " ");
        System.out.println("-----------");

        for(int i =0;i<time4.length;i++) System.out.print(time4[i] + " ");
        System.out.println("-----------");

        for(int i =0;i<time5.length;i++) System.out.print(time5[i] + " ");
        System.out.println();
        

        /*
        int len = 100;
        int[] list = new int[len];
        for(int i=0;i<len;i++){
            list[i] = (int)(Math.random()*10000);
        }
        //printList(list);
        long start = System.currentTimeMillis( );
        bubbleSort(list);
        long end = System.currentTimeMillis( );
        System.out.println(end-start);
        //printList(list);
        */
    }
}