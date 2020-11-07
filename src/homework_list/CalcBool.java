package homework_list;

import java.util.HashMap;
import java.util.Scanner;
import stack.*;
public class CalcBool {
    private static HashMap<Character,Integer> sym = new HashMap<>();
        
    public static int compareTo(char t, Object o){
        if(o==null){
            return 1;
        }else{
            o = (char)o;
            if(sym.containsKey(o)){
                if(sym.get(t)<=sym.get(o)) return -1;
                else return 1;
            }else return 1;
        }
    }

    public static boolean calc(char a, char b, char c){
        boolean ta;
        boolean tb;
        if(a=='T') ta = true;
        else ta = false;
        if(b=='T') tb = true;
        else tb = false;

        if(c=='&') return ta && tb;
        else if(c=='|') return ta || tb;
        else{
            if(ta==tb) return false;
            else return true;
        }
    }

    public static boolean calc(char a){
        boolean ta;
        if(a=='T') ta = true;
        else ta = false;
        return !ta;
    }

    public static boolean check(String expr){
        AStack<Character> s3 = new AStack<>(100);
        for(int i=0;i<expr.length();i++){
            char temp = expr.charAt(i);
            if(temp=='(') s3.push(temp);
            else if(temp==')'){
                if(s3.isEmpty()) return false;
                s3.pop();
            }
        }
        if(!s3.isEmpty()) return false;
        else return true;
    }
    public static void main(String[] args){

        AStack<Character> s1 = new AStack<>(100);
        Scanner in = new Scanner(System.in);
        String expr = in.nextLine();
        boolean check = check(expr);
        if(!check){
            System.out.println("括号匹配错误");
            in.close();
            return;
        }
        char[] rpn = new char[expr.length()];
        for(int i=0;i<rpn.length;i++) rpn[i] = '#';
        int index = -1;
        for(int i=0;i<expr.length();i++){
            char temp = expr.charAt(i);
            //System.out.println(temp);
            if(temp=='T' || temp=='F'){
                rpn[++index] = temp;
            }
            else if(temp==' ') continue;
            else if(temp=='(') s1.push(temp);
            else{
                if(temp==')' || compareTo(temp, s1.getTop())<=0){
                    if(temp==')'){
                        while(s1.getTop()!='('){
                            char t2 = s1.pop();
                            if(t2!='(' && t2!=')')
                                rpn[++index] = t2;
                        }
                        if(!s1.isEmpty() && s1.getTop()=='(') s1.pop();
                    }
                    else{
                        while(!s1.isEmpty()){
                            char t2 = s1.pop();
                            if(t2!='(' && t2!=')'){
                                rpn[++index] = t2;
                            }
                        }
                        s1.push(temp);
                    }
                }else s1.push(temp);
            }
        }

        while(!s1.isEmpty()){
            char t3 = s1.pop();
            if(t3!='(' && t3!=')')
                rpn[++index] = t3;
        }

        AStack<Character> s2 = new AStack<>();
        int i=0;
        while(rpn[i]!='#'){
            char t = rpn[i];
            if(t=='T' || t=='F') s2.push(t);
            else{
                if(s2.isEmpty()){
                    System.out.println("缺少运算操作数");
                    break;
                } 
                boolean ans;
                if(t!='!'){
                    char a = s2.pop();
                    if(s2.isEmpty()){
                        System.out.println("缺少运算操作数");
                        break;
                    } 
                    char b = s2.pop();
                    ans = calc(a, b, t);
                }else{
                    char a = s2.pop();
                    ans = calc(a);
                }
                char temp;
                if(ans) temp = 'T';
                else temp = 'F';
                s2.push(temp);
            }
            i++;
            if(i>=rpn.length) break;
        }
        char result = ' ';
        if(!s2.isEmpty()){
            result = s2.pop();
        }
        if(!s2.isEmpty()) System.out.println("缺少运算符");
        else System.out.println(result);
        
        in.close();
    }
}