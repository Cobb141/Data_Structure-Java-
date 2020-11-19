
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
        BST02<String, Integer> t1 = new BST02<>();
        BufferedReader in = new BufferedReader(new FileReader
            ("C:/VScode_Java/Data_Structure/src/homework_binTree/files/article.txt"));
        PrintWriter pw2 = new PrintWriter(
            new FileWriter("C:/VScode_Java/Data_Structure/src/homework_binTree/files/index_result.txt"));
        String line = " ";
        int temp1=-1, temp2=-1;
        char temp;
        int i = 1;
        while(line!=null){
            line = in.readLine();
            if(line==null) break;
            temp1 = -1; temp2 = -1;
            //System.out.println(i);
            for(int j=0;j<line.length();j++){
                temp = line.charAt(j);
                if((temp>=65 && temp<=122) && temp1==-1){
                    temp1 = j;
                }
                if((temp<65||temp>122) && temp2==-1 && temp1!=-1){
                    temp2 = j;
                    //if(j==line.length()-1) temp2 = j + 1;
                }
                if(temp1!=-1 && temp2!=-1){
                    t1.insert(line.substring(temp1, temp2),i);
                    temp1 = temp2 = -1;
                }
            }
            i++;
        }
       //t1.inOrder(t1.getRoot());
       t1.printInorder(pw2);
       in.close();
       pw2.flush();
       pw2.close();
    }
}