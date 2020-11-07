package tree;

public interface BinNode {
    public Object getElem();
    public Object setElem(Object v);

    public BinNode left();
    public BinNode setLeft(BinNode p);
    public BinNode right();
    public BinNode setRight(BinNode p);

    public boolean isLeaf();
}