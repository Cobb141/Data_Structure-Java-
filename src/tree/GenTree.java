package tree;

public class GenTree {
    private GTNode[] array;
    
    public GenTree(int size){
        array = new GTNode[size];
        for(int i=0;i<size;i++)
            array[i] = new GTNode();
    }

    public boolean differ(int a,int b){
        GTNode root1 = FIND(array[a]);
        GTNode root2 = FIND(array[b]);
        return root1!=root2;
    }

    public void UNION(int a,int b){
        GTNode root1 = FIND(array[a]);
        GTNode root2 = FIND(array[b]);
        if(root1!=root2) root2.setParent(root1);
    }

    private GTNode FIND(GTNode curr){ //路径压缩
        if(curr.parent()==null) return curr;
        return curr.setParent(FIND(curr.parent()));
    }
}