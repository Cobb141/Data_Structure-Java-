package graph;

import list.*;
public class LGraph implements Graph{
    private GraphList[] vertex;
    private int numEdge;
    private int[] mark;

    class LEdge implements Edge{
        private int vert1, vert2;
        private Node itself;

        public LEdge(int vt1, int vt2, Node it){
            vert1 = vt1;
            vert2 = vt2;
            itself = it;
        }

        @Override
        public int edgeFrom() {
            return vert1;
        }

        @Override
        public int edgeTo() {
           return vert2;
        }

        public Node getItself(){ return itself; }
    }

    public void LGragh(){
    }
    public void LGragh(int n){
        mark = new int[n];
        vertex = new GraphList[n];
        for(int i=0;i<n;i++)
            vertex[i] = new GraphList();
        numEdge = 0;
    }

    @Override
    public int numOfVertices() {
        return mark.length;
    }

    @Override
    public int numOfEdges() {
        return numEdge;
    }

    @Override
    public Edge first(int v) {
        vertex[v].setFirst();
        if(vertex[v].currValue()==null) return null;
        return new LEdge(v, ((int[])vertex[v].currValue())[0], vertex[v].currNode());
    }

    @Override
    public Edge next(Edge e) {
        vertex[e.edgeFrom()].setCurr(((LEdge)e).getItself());
        vertex[e.edgeFrom()].next();
        if(vertex[e.edgeFrom()].currValue()==null) return null; 
        return new LEdge(e.edgeFrom(), ((int[])vertex[e.edgeFrom()].currValue())[0], 
            vertex[e.edgeFrom()].currNode());
    }

    @Override
    public boolean isEdge(Edge e){
        if(e==null) return false;
        vertex[e.edgeFrom()].setCurr(((LEdge)e).getItself());
        if(!vertex[e.edgeFrom()].isInList()) return false;
        return ((int[])vertex[e.edgeFrom()].currValue())[0] == e.edgeTo();

    }

    @Override
    public boolean isEdge(int i, int j) {
        GraphList temp = vertex[i];
        for(temp.setFirst();((temp.currValue()!=null)&&(((int[])temp.currValue())[0]<j));temp.next());
        return (temp.currValue()!=null)&&(((int[])temp.currValue())[0]==j);
    }

    @Override
    public int edgeFrom(Edge w) {
        return w.edgeFrom();
    }

    @Override
    public int edgeTo(Edge w) {
        return w.edgeTo();
    }

    @Override
    public void setEdge(int i, int j, int weight) {
        if(weight==0){
            System.out.println("Connot set weight to 0");
            return;
        } 
        int[] currEdge = {j, weight};
        if(isEdge(i, j))
            vertex[i].setValue(currEdge);
        else{
            vertex[i].append(currEdge);
            numEdge++;
        }
    }

    @Override
    public void setEdge(Edge w, int weight) {
        if(w != null) setEdge(w.edgeFrom(), w.edgeTo(), weight);
    }

    @Override
    public void delEdge(Edge w) {
        if(w!=null)
            delEdge(w.edgeFrom(), w.edgeTo());
    }

    @Override
    public void delEdge(int i, int j) {
        if(isEdge(i, j)){
            vertex[i].remove();
            numEdge--;
        }
    }

    @Override
    public int weight(Edge e) {
        if(isEdge(e)) return((int[])vertex[e.edgeFrom()].currValue())[1];
        else return Integer.MAX_VALUE;
    }

    @Override
    public int weight(int i, int j) {
        if(isEdge(i, j)) return((int[])vertex[i].currValue())[1];
        else return Integer.MAX_VALUE;
    }

    @Override
    public void setMark(int v, int val) {
        mark[v] = val;
    }

    @Override
    public int getMark(int v) {
        return mark[v];
    }
}