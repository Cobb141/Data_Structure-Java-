package homework_binTree;

import java.io.*;
public class Test3 {
    
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
            for(int j=0;j<line.length();j++){
                temp = line.charAt(j);
                if((temp>=65 && temp<=122) && temp1==-1){
                    temp1 = j;
                }
                if((temp<65||temp>122) && temp2==-1 && temp1!=-1){
                    temp2 = j;
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