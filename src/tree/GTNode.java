package tree;

public class GTNode {
    private GTNode pare;
    public GTNode(){
        pare = null;
    }
    public GTNode parent(){
        return pare;
    }
    public GTNode setParent(GTNode pare){
        return this.pare = pare;
    }
}