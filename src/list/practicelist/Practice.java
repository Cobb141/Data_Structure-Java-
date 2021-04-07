package list.practicelist;

public class Practice {
    public static boolean isHaveHoop(LList2 l1){
        l1.setFirst();
        Node2 slow = l1.curr;
        Node2 quick = l1.curr;
        boolean ans = false;
        while(slow!=null && quick!=null){
            slow = slow.next();
            if(quick.next()!=null)
                quick = quick.next().next();
            else break;
            if(slow == quick){
                ans = true;
                break;
            } 
        }
        return ans;
    }
    public static void main(String[] args){
        LList2 l1 = new LList2();
        l1.append(1);
        // l1.append(2);
        // l1.append(3);
        // l1.append(4);
        l1.print();
        l1.reverse();
        l1.print();
        
    }
}