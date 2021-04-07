package sort;

//import java.util.*;
public class Sort {
    public static void swap(int[] list,int i,int j){
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
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
                }
    }
    //简单选择排序
    public static void selSort(int[] array){
        for(int i=0;i<array.length-1;i++){
            int lowIndex = i;
            for(int j=array.length-1;j>i;j--){
                if(array[lowIndex]>array[j]){
                    lowIndex = j;
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
            while(array[++l]<pivot);
            while((r!=0)&&(array[--r]>pivot));
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
            } //left越界，则把右子序列剩余的部分（right之后）接到归并序列之后
            else if(rightcurr>right){
                array[curr] = temp[leftcurr++];
            } //right越界，则把左子序列剩余的部分（left之后）接到归并序列之后
            else if(temp[leftcurr]<temp[rightcurr]){
                array[curr] = temp[leftcurr++];
            } 
            else{
                array[curr] = temp[rightcurr++];
            } 
        }
    }

    //归并排序：当子数组较小时使用插入排序
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

    //归并排序：一种简洁的实现方式
    public static void mergeSort3(int[] array, int[] temp, int left, int right){
        if(right-left==1) return;  //递归终止条件
        int mid = left + (right - left)/2;
        int leftcurr = left;
        int rightcurr = mid;
        int index = left;
        mergeSort3(array, temp, left, mid);
        mergeSort3(array, temp, mid, right);
        //下面的循环判断条件十分巧妙，简化了实现
        while(leftcurr<mid || rightcurr<right){
            if(rightcurr>=right || (leftcurr<mid && array[leftcurr]<array[rightcurr]))
                temp[index++] = array[leftcurr++];  //归并左子序列
            else
                temp[index++] = array[rightcurr++];  //归并右子序列
        }
        for(int i=left;i<right;i++) //将temp复制到原数组
            array[i] = temp[i];
    }

    public static void main(String[] args){
        int[] a = {3,6,2,8,5,0,9,-1,20,-102,666,89};
        int[] temp = new int[a.length];
        qsort(a, 0, a.length-1);
        for(int i = 0;i<a.length;i++)
            System.out.print(a[i] + " ");
    }
}