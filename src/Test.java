
import list.*;
import queue.*;
import stack.*;
import tree.*;
import java.util.Scanner;
import java.io.*;
import homework_binTree.*;
import list.AList;
public class Test {  
    public static int fib(int n){
        if(n<=1) return 1;
        else{
            System.out.print(n + " ");
            return fib(n-1) + fib(n-2);
        }
    }

    public static int binSearch(int[] arr, int n, int val){
        int low = 0;
        int high = n-1;

        while(low<=high){
            int mid = (low + high)/2;
            if(arr[mid] == val){
                return mid;
            }else if(arr[mid] < val){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return -1;
    }
    public static void main(String[] args)throws Exception{
        System.out.println(10%10);
    }
}