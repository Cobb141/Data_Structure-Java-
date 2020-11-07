package tree;


import queue.AQueue;

public class BinNodePtr implements BinNode {// 用指针实现的二叉树节点类
    private Object element;
    private BinNode left;
    private BinNode right;
    private static AQueue<BinNode> levelQ = new AQueue<>();

    public BinNodePtr(){left = right = null;}
    public BinNodePtr(Object val){
        left = right = null;
        element = val;
    }

    public BinNodePtr(Object val, BinNode l, BinNode r){
        left = l;
        right = r;
        element = val;
    }

    @Override
    public Object getElem() {
        return element;
    }

    @Override
    public Object setElem(Object v) {
       return element = v;
    }

    @Override
    public BinNode left() {
        return left;
    }

    @Override
    public BinNode setLeft(BinNode p) {
        return left = p;
    }

    @Override
    public BinNode right() {
        return right;
    }

    @Override
    public BinNode setRight(BinNode p) {
        return right = p;
    }

    @Override
    public boolean isLeaf() {
        return (left==null) && (right==null);
    }
    
    //traversal
    public static void visit(BinNode rt){
        System.out.print(rt.getElem());
    }

    public static void preOrder(BinNode rt){
        if(rt==null) return;
        visit(rt);
        preOrder(rt.left());
        preOrder(rt.right());
    }

    public static void inOrder(BinNode rt){
        if(rt==null) return;
        inOrder(rt.left());
        visit(rt);
        inOrder(rt.right());
    }

    public static void postOrder(BinNode rt){
        if(rt==null) return;
        postOrder(rt.left());
        postOrder(rt.right());
        visit(rt);
    }

    public static void levelOrder(BinNode rt){
        levelQ.enQueue(rt);
        visit(levelQ.deQueue());
        if(rt.left()!=null) levelOrder(rt.left());
        if(rt.right()!=null) levelOrder(rt.right());
    }

    public static void createBinTree(BinNode rt, String s, int i){
        if(s.charAt(i)=='#') rt = null;
        else{
            rt.setElem(s.charAt(i));
            if((i+1)<s.length()){
                rt.setLeft(new BinNodePtr());
                rt.setRight(new BinNodePtr());
                createBinTree(rt.left(),s,i+1);
                createBinTree(rt.right(),s,i+1);
            }
        }
    }
}