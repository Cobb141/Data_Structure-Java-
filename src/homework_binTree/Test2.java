package homework_binTree;

import java.io.*;
public class Test2 {
    public static void main(String[] args)throws Exception{
        BST01<String, String> t1 = new BST01<>();
        BufferedReader in = new BufferedReader(new FileReader
            ("C:/VScode_Java/Data_Structure/src/homework_binTree/files/homework2_testcases.txt"));
       
        
        PrintWriter pw2 = new PrintWriter(
            new FileWriter("C:/VScode_Java/Data_Structure/src/homework_binTree/files/my_result.txt"));
        for(int j=0;j<1055;j++){
            String str = in.readLine();
            char op = str.charAt(0);
            String word;
            String tran;
            int a=2,b=0,c=0,d=0,flag1=0,flag2=0;
            switch(op){
                case '+':
                    for(int i=0;i<str.length();i++){
                        if(str.charAt(i)==' '){
                            flag1++;
                            if(flag1 == 2) b = i;
                        }
                        if(str.charAt(i)=='"'){
                            flag2++;
                            if(flag2 == 1) c = i;
                            else if(flag2 == 2) d = i;
                        }
                    }
                    word = str.substring(a+1, b);
                    tran = str.substring(c+1, d);
                    t1.insert(word, tran);
                    break;
                case '-':
                    for(int i=0;i<str.length();i++){
                        if(str.charAt(i)==' '){
                            flag1++;
                            if(flag1 == 2) b = i;
                        }
                    }
                    word = str.substring(a+1, b);
                    tran = t1.remove(word);
                    if(tran==null){
                        pw2.println("remove unsuccess ---" + word);
                    }else{
                        pw2.println("remove success ---" + word + " " + tran);
                    }
                    break;
                case '?':
                    for(int i=0;i<str.length();i++){
                        if(str.charAt(i)==' '){
                            flag1++;
                            if(flag1 == 2) b = i;
                        }
                    }
                    word = str.substring(a+1, b);
                    tran = t1.search(word);
                    if(tran==null){
                        pw2.println("search unsuccess ---" + word);
                    }else{
                        pw2.println("search success ---" + word + " " + tran);
                    }
                    break;
                case '=':
                    for(int i=0;i<str.length();i++){
                        if(str.charAt(i)==' '){
                            flag1++;
                            if(flag1 == 2) b = i;
                        }
                        if(str.charAt(i)=='"'){
                            flag2++;
                            if(flag2 == 1) c = i;
                            else if(flag2 == 2) d = i;
                        }
                    }
                    word = str.substring(a+1, b);
                    tran = str.substring(c+1, d);
                    boolean isUpdateSuccess = t1.update(word, tran);
                    if(isUpdateSuccess==false){
                        pw2.println("update unsuccess ---" + word);
                    }else{
                        pw2.println("update success ---" + word + " " + tran);
                    }
                    break;
                case '#':
                    t1.showStructure(pw2);
                    break;
            }
        }
        t1.inOrder(t1.getRoot());
        in.close();
        pw2.close();
    }
}