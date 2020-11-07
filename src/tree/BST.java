package tree;

public class BST {
    private BinNode root;

    public BST(){ root = null; }
    public void clear(){ root = null; }
    
    public BinNode getRoot(){ return root; }
    public void insert(Elem val){
        root = insertHelp(root, val);
    }
    public void remove(int key){
        root = removeHelp(root, key);
    }
    public Elem find(int key){
        return findHelp(root, key);
    }
    public boolean isEmpty(){ return root==null; }

    private Elem findHelp(BinNode rt, int key){
        if(rt==null){
            System.out.println("Element is not found");
            return null;
        } 
        Elem it = (Elem)rt.getElem();
        if(it.key()>key) return findHelp(rt.left(), key);
        else if(it.key()==key) return it;
        else return findHelp(rt.right(), key);
    }

    private BinNode insertHelp(BinNode rt, Elem val){
        if(rt==null) return new BinNodePtr(val);
        Elem it = (Elem)rt.getElem();
        if(it.key()>val.key())
            rt.setLeft(insertHelp(rt.left(), val));
        else rt.setRight(insertHelp(rt.right(), val));
        return rt;
    }

    private Elem getMin(BinNode rt){
        if(rt.left()==null) return (Elem)rt.getElem();
        else return getMin(rt.left());
    }
    private BinNode deleteMin(BinNode rt){
        if(rt.left()==null) return rt.right();
        else{
            rt.setLeft(deleteMin(rt.left()));
            return rt;
        }
    }

    private BinNode removeHelp(BinNode rt, int key){
        if(rt==null) return null;
        Elem it = (Elem)rt.getElem();
        if(key<it.key()) 
            rt.setLeft(removeHelp(rt.left(), key));
        else if(key>it.key())
            rt.setRight(removeHelp(rt.right(), key));
        else{
            if(rt.left()==null) rt = rt.right();
            else if(rt.right()==null) rt = rt.left();
            else{
                Elem temp = getMin(rt.right());
                rt.setElem(temp);
                rt.setRight(deleteMin(rt.right()));
            }
        }
        return rt;
    }

    public static void inOrder(BinNode rt){
        if(rt==null) return;
        inOrder(rt.left());
        visit(rt);
        inOrder(rt.right());
    }
    public static void visit(BinNode rt){
        System.out.print(((Elem)rt.getElem()).key() + " ");
    }

    public void print(){
        if(root==null)
            System.out.println("BST is empty");
        else{
            printHelp(root, 0);
            System.out.println();
        }
    }
    private void printHelp(BinNode rt, int level){
        if(rt==null) return;
        printHelp(rt.left(), level+1);
        for(int i=0;i<level;i++)
            System.out.print(" ");
        System.out.println(((Elem)rt.getElem()).key());
        printHelp(rt.right(), level+1);
    }

    public static void main(String[] args){
        BST t1 = new BST();
        t1.insert(new Elem01(32));
        t1.insert(new Elem01(120));
        t1.insert(new Elem01(42));
        t1.insert(new Elem01(40));
        t1.insert(new Elem01(7));
        t1.insert(new Elem01(37));
        t1.insert(new Elem01(24));
        t1.insert(new Elem01(42));
        BST.inOrder(t1.getRoot());
        System.out.println();
        t1.remove(37);
        BST.inOrder(t1.getRoot());
    }
}