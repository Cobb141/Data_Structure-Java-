package tree;

public class TriaNode {
    private Object element;
    private TriaNode left;
    private TriaNode right;
    private TriaNode mid;

    public TriaNode(){left = right = mid = null;}
    public TriaNode(Object val){
        left = right = mid = null;
        element = val;
    }

    public TriaNode(Object val, TriaNode l, TriaNode r, TriaNode m){
        left = l;
        right = r;
        mid = m;
        element = val;
    }

    
    public Object getElem() {
        return element;
    }

    
    public Object setElem(Object v) {
       return element = v;
    }

    public TriaNode left() {
        return left;
    }

    public void setLeft(TriaNode left) {
        this.left = left;
    }

    public TriaNode right() {
        return right;
    }

    public void setRight(TriaNode right) {
        this.right = right;
    }

    public TriaNode mid() {
        return mid;
    }

    public void setMid(TriaNode mid) {
        this.mid = mid;
    }

    public boolean isLeaf() {
        return (left==null) && (right==null) && (mid==null);
    }
}