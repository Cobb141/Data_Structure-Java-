package list.practicelist;

import list.*;
public class TestList {
    public static void test(List2 l1){
        System.out.println("currvalue:" + l1.currValue());
        System.out.println("isEmpty:" + l1.isEmpty());
        System.out.println("isInList:" + l1.isInList());
        System.out.println("length:" + l1.length());
        System.out.println("print:");
        l1.print();
        System.out.println();
    }
    public static void main(String[] args){
        List2 l1 = new LList2();
        System.out.println("表为空时：");
        test(l1);
        System.out.println("插入12345之后：");
        l1.append(1);
        l1.append(2);
        l1.append(3);
        l1.append(4);
        l1.append(5);
        test(l1);
        System.out.println("删除3：");
        l1.setPos(2);
        l1.remove();
        test(l1);
    }
}