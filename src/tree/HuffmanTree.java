package tree;

import list.*;
import queue.AQueue;
public class HuffmanTree {
    private BinNode root;
    private static AQueue<BinNode> levelQ = new AQueue<>();

    public HuffmanTree(LettFreq val){
        root = new BinNodePtr(val);
    }
    public HuffmanTree(LettFreq val, HuffmanTree l, HuffmanTree r){
        root = new BinNodePtr(val, l.getRoot(), r.getRoot());
    }

    public BinNode getRoot(){ return root; }
    public int weight(){
        return ((LettFreq)root.getElem()).weight();
    }

    public static HuffmanTree buildTree(List huffList){
        HuffmanTree temp1, temp2, temp3;
        LettFreq tempNode;

        for(int i=1;i<huffList.length();i=1){
            temp1 = (HuffmanTree)huffList.remove(0);
            temp2 = (HuffmanTree)huffList.remove(0);
            tempNode = new LettFreq(temp1.weight() + temp2.weight());
            temp3 = new HuffmanTree(tempNode, temp1, temp2);
            int j = 0;
            for(j=0;j<huffList.length();j++){
                if(temp3.weight()<=((HuffmanTree)huffList.get(j)).weight()){
                    huffList.insert(temp3, j);
                    break;
                }
            }
            if(j>=huffList.length())
                    huffList.append(temp3);
        }
        return (HuffmanTree)huffList.remove(0);
    }

    public static void levelOrder(BinNode rt){
        levelQ.enQueue(rt);
        visit(levelQ.deQueue());
        if(rt.left()!=null) levelOrder(rt.left());
        if(rt.right()!=null) levelOrder(rt.right());
    }

    public static void visit(BinNode rt){
        if(((LettFreq)(rt.getElem())).letter()!='#')
            System.out.println(((LettFreq)(rt.getElem())).letter() + ":" + ((LettFreq)(rt.getElem())).weight());
    }

    public static void inOrder(BinNode rt){
        if(rt==null) return;
        inOrder(rt.left());
        visit(rt);
        inOrder(rt.right());
    }

    public static void main(String[] args)throws Exception{
        List huff = new AList();
        huff.append(new HuffmanTree(new LettFreq(2, 'Z')));
        huff.append(new HuffmanTree(new LettFreq(7, 'K')));
        huff.append(new HuffmanTree(new LettFreq(24, 'F')));
        huff.append(new HuffmanTree(new LettFreq(32, 'C')));
        huff.append(new HuffmanTree(new LettFreq(37, 'U')));
        huff.append(new HuffmanTree(new LettFreq(42, 'D')));
        huff.append(new HuffmanTree(new LettFreq(42, 'L')));
        huff.append(new HuffmanTree(new LettFreq(120, 'E')));
        HuffmanTree h1 = HuffmanTree.buildTree(huff);
        HuffmanTree.inOrder(h1.getRoot());
      }
}


