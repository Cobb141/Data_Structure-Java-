package homework_binTree;

import java.io.*;
import tree.BinNode;
import tree.BinNodePtr;
public class BST02<K extends Comparable<K>, V> extends BST01<K,V>{
    private BinNode root;
    private int num;

    public BST02(){ root = null; }

    @Override
    public void clear(){ root = null; num = 0; }
    
    public BinNode getRoot(){ return root; }

    @Override
    public void insert(K key, V value) {
        Elem<K,V> e = new Elem03<>(key, value);
        if(search(key)==null)
            root = insertHelp(root, e);
        else update(key, value);
        num++;
    }

    @Override
    public V remove(K key) {
        V val = null;
        if(search(key)!=null){
            val = search(key);
            root = removeHelp(root, key);
            num--;
        }
        return val;
    }

    @Override
    public V search(K key) {
        V val = findHelp(root, key);
        return val;
    }

    @Override
    public boolean update(K key, V value) {
        if(search(key)!=null){
            return updateHelp(root, key, value);
        }
        return false;
    }
    @SuppressWarnings("unchecked")
    public boolean updateHelp(BinNode rt, K key, V value){
        if(rt==null){
            System.out.println("Element is not found");
            return false;
        } 
        Elem<K,V> it = (Elem03<K,V>)rt.getElem();
        if(it.key().compareTo(key)>0) return updateHelp(rt.left(), key, value);
        else if(it.key().compareTo(key)==0){
            it.setValue(value);
            return true;
        } 
        else return updateHelp(rt.right(), key, value);
    }

    @Override
    public boolean isEmpty() {
        return root==null;
    }

    @SuppressWarnings("unchecked")
    private V findHelp(BinNode rt, K key){
        if(rt==null){
            //System.out.println("Element is not found");
            return null;
        } 
        Elem<K,V> it = (Elem03<K,V>)rt.getElem();
        if(it.key().compareTo(key)>0) return findHelp(rt.left(), key);
        else if(it.key().compareTo(key)==0) return it.value();
        else return findHelp(rt.right(), key);
    }

    @SuppressWarnings("unchecked")
    public BinNode insertHelp(BinNode rt, Elem<K,V> e){
        if(rt==null) return new BinNodePtr(e);
        Elem<K, V> it = (Elem<K,V>)rt.getElem();
        if(it.key().compareTo(e.key())>0)
            rt.setLeft(insertHelp(rt.left(), e));
        else rt.setRight(insertHelp(rt.right(), e));
        return rt;
    }

    @SuppressWarnings("unchecked")
    private Elem<K,V> getMin(BinNode rt){
        if(rt.left()==null) return (Elem<K,V>)rt.getElem();
        else return getMin(rt.left());
    }
    private BinNode deleteMin(BinNode rt){
        if(rt.left()==null) return rt.right();
        else{
            rt.setLeft(deleteMin(rt.left()));
            return rt;
        }
    }

    @SuppressWarnings("unchecked")
    private BinNode removeHelp(BinNode rt, K key){
        if(rt==null) return null;
        Elem<K,V> it = (Elem<K,V>)rt.getElem();
        if(key.compareTo(it.key())<0) 
            rt.setLeft(removeHelp(rt.left(), key));
        else if(key.compareTo(it.key())>0)
            rt.setRight(removeHelp(rt.right(), key));
        else{
            if(rt.left()==null) rt = rt.right();
            else if(rt.right()==null) rt = rt.left();
            else{
                Elem<K,V> temp = getMin(rt.right());
                rt.setElem(temp);
                rt.setRight(deleteMin(rt.right()));
            }
        }
        return rt;
    }

    @Override
    public void showStructure(PrintWriter pw) throws IOException {
        pw.println("-----------------------------");
        pw.println("There are " + num + " nodes in this BST.");
        pw.println("The height of this BST is " + height(root) +".");
        pw.println("-----------------------------");
    }

    public int height(BinNode rt){
        int h = 0, lefth = 0, righth = 0;
        if(rt==null) return 0;
        lefth = height(rt.left());
        righth = height(rt.right());
        h = (lefth>righth ? lefth:righth) + 1;
        return h;
    }

    @Override
    public void printInorder(PrintWriter pw) throws IOException {
        printHelp(root, pw);
    }

    public void printHelp(BinNode rt, PrintWriter pw){
        if(rt==null) return;
        printHelp(rt.left(), pw);
        visit2(rt, pw);
        printHelp(rt.right(), pw);
    }
    @SuppressWarnings("unchecked")
    public void visit2(BinNode rt, PrintWriter pw){
        pw.println("[" + ((Elem<K,V>)rt.getElem()).key() + " --- " + "< " + 
            ((Elem03<K,V>)rt.getElem()).getArray() + ">" + "]");
    }

    public void inOrder(BinNode rt){
        if(rt==null) return;
        inOrder(rt.left());
        visit(rt);
        inOrder(rt.right());
    }

    @SuppressWarnings("unchecked")
    public void visit(BinNode rt){
        System.out.print(((Elem<K,V>)rt.getElem()).key() + ":" + ((Elem03<K,V>)rt.getElem()).getArray());
        System.out.println();
    }

}