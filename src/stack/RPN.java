package stack;

import java.util.*;
public class RPN {
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

    public static int calc(int a, int b, char c){
        if(c=='+') return b + a;
        else if(c=='-') return b - a;
        else if(c=='*') return b * a;
        else return b / a;
    }
    public static void main(String[] args){
        sym.put('+', 0);
        sym.put('-', 0);
        sym.put('*', 1);
        sym.put('/', 1);
        //sym.put('(', 2);

        AStack<Character> s1 = new AStack<>();
        Scanner in = new Scanner(System.in);
        String expr = in.nextLine();
        char[] rpn = new char[expr.length()];
        for(int i=0;i<rpn.length;i++) rpn[i] = '!';
        int index = -1;
        for(int i=0;i<expr.length();i++){
            char temp = expr.charAt(i);
            //System.out.println(temp);
            if(temp>='0' && temp<='9'){
                rpn[++index] = temp;
            }
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
        //System.out.println("----------------");
        while(!s1.isEmpty()){
            char t3 = s1.pop();
            if(t3!='(' && t3!=')')
                rpn[++index] = t3;
        }
        // for(int i=0;i<rpn.length;i++)
        //     System.out.println(rpn[i]);
        
        AStack<Integer> s2 = new AStack<>();
        int i=0;
        while(rpn[i]!='!'){
            char t = rpn[i];
            if(t>='0' && t<='9') s2.push((int)t-48);
            else{
                int a = s2.pop();
                int b = s2.pop();
                s2.push(calc(a,b,t));
            }
            i++;
            if(i>=rpn.length) break;
        }
        System.out.println(s2.pop());
        
        in.close();
    }
}