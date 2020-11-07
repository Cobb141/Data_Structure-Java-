package reversinglinkedlist;

import java.util.*;
public class Main {
    private static Node[] array = new Node[100000];
    static class Node{
        int elem;
        //int ad;
        int next;
    }

    public static void main(String[] args){
        for(int i=0;i<100000;i++){
            array[i] = new Node();
        }
        int first, N, K;
        int elem,ad,next;
        //String ad2,next2;
        Scanner in = new Scanner(System.in);
        first = in.nextInt();
        N = in.nextInt();
        K = in.nextInt();
        for(int i=0;i<N;i++){
            ad = in.nextInt();
            elem = in.nextInt();
            next = in.nextInt();
            array[ad].elem = elem;
            array[ad].next = next;
        }
        int t1, t2=0, t3=0, t4, cnt=0,head,head2;
        int flag = 0;
        head2 = t1 = first;
        outer:while(t3!=-1){
            if(K==1) break;
            if(t1==first) t4 = t1;
            else t4 = t2;
            cnt = 0;
            while(cnt<K){
                if(t4!=-1){
                    t4 = array[t4].next;
                    cnt++;
                }else break;
            }
            if(cnt<K) break;
            flag++;
            if(t1!=first) t1 = array[t1].next;
            head = t1;
            t2 = array[t1].next;
            t3 = array[t2].next;
            for(int i=0;i<K-1;i++){
                if(t3==-1){
                    array[t2].next = t1;
                    array[head].next = -1;
                    if(flag==1) head2 = t2;
                    break outer;
                }else{
                    array[t2].next = t1;
                    t1 = t2;
                    t2 = t3;
                    t3 = array[t3].next;
                } 
            }
           
            array[head].next = t2;
            int tt = array[head].next;
            for(int i=0;i<K-1;i++){
                tt = array[tt].next;
                if(tt==-1) break;
            }
            if(tt!=-1) array[head].next = tt;

            if(flag==1) head2 = t1;
        }
        int j = head2;
        do{
            if(array[j].next!=-1){
                System.out.println(String.format("%05d",j) + " " + array[j].elem + " " + String.format("%05d",array[j].next));
            }else{
                System.out.println(String.format("%05d",j) + " " + array[j].elem + " " + String.format("%d",array[j].next));
            }
            
            j = array[j].next;
        }while(j!=-1);
        in.close();
    }
}