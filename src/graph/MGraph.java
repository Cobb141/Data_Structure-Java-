package graph;

import list.*;
import queue.AQueue;
public class MGraph implements Graph{
    private int[][] matrix;
    private int numEdge;
    private int[] mark;

    class MEdge implements Edge{
        private int vert1, vert2;

        public MEdge(int vt1, int vt2){
            vert1 = vt1;
            vert2 = vt2;
        }
        @Override
        public int edgeFrom() {
            return vert1;
        }

        @Override
        public int edgeTo() {
           return vert2;
        }

    }

    public MGraph(){
    }
    public MGraph(int n){
        mark = new int[n];
        matrix = new int[n][n];
        numEdge = 0;
    }
    public MGraph(int n, int[][] mat){
        mark = new int[n];
        matrix = mat;
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
        if(v>=mark.length || v<0){
            System.out.println("Illegal vertex");
            return null;
        }
        for(int i=0;i<mark.length;i++){
            if(matrix[v][i]!=0)
                return new MEdge(v, i);
        }
        return null;
    }

    @Override
    public Edge next(Edge w) {
        if(w == null) return null;
        for(int i=w.edgeTo()+1;i<mark.length;i++){
            if(matrix[w.edgeFrom()][i]!=0)
                return new MEdge(w.edgeFrom(), i);
        }
        return null;
    }

    @Override
    public boolean isEdge(Edge w) {
        if(w == null) return false;
        else return matrix[w.edgeFrom()][w.edgeTo()]!=0;
    }

    @Override
    public boolean isEdge(int i, int j) {
        return matrix[i][j]!=0;
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
        if(matrix[i][j]==0) numEdge++;
        matrix[i][j] = weight;
    }

    @Override
    public void setEdge(Edge w, int weight) {
        if(w != null) setEdge(w.edgeFrom(), w.edgeTo(), weight);
    }

    @Override
    public void delEdge(Edge w) {
        if(w!=null){
            if(matrix[w.edgeFrom()][w.edgeTo()]!=0){
                matrix[w.edgeFrom()][w.edgeTo()] = 0;
                numEdge--;
            }
        }

    }

    @Override
    public void delEdge(int i, int j) {
        if(matrix[i][j]!=0){
            matrix[i][j] = 0;
            numEdge--;
        }
    }

    @Override
    public int weight(Edge w) {
        if(w==null){
            System.out.println("This edge is null");
            return Integer.MAX_VALUE;
        }
        if(matrix[w.edgeFrom()][w.edgeTo()]==0) return Integer.MAX_VALUE;
        else return matrix[w.edgeFrom()][w.edgeTo()];
    }

    @Override
    public int weight(int i, int j) {
        if(matrix[i][j]==0) return Integer.MAX_VALUE;
        return matrix[i][j];
    }

    @Override
    public void setMark(int v, int val) {
        mark[v] = val;
    }

    @Override
    public int getMark(int v) {
        return mark[v];
    }



    public static void main(String[] args)throws Exception{
        int[][] mat = {{0,10,3,20,0},
                       {0,0,0,5,0},
                       {0,2,0,0,15},
                       {0,0,0,0,11},
                       {0,0,0,0,0}};
        MGraph g = new MGraph(5, mat);
        // g.DFS(g);
        // System.out.println("---------------");
        // g.BFS(g, 4);
        //g.topSort(g);
        int[] dist = new int[g.numOfVertices()];
        int[][] path = new int[g.numOfVertices()][g.numOfVertices()];
        int[][] D = new int[g.numOfVertices()][g.numOfVertices()];
        //GraphAlgor.dijkstra(g, 0, dist, path);
        GraphAlgor.floyd(g, D, path);
        for(int i=0;i<dist.length;i++)
            for(int j=0;j<dist.length;j++){
                System.out.print(path[i][j] + " ");
                if(j==dist.length-1) System.out.println();
            }
        // System.out.println("---------------");
        // for(int i=0;i<dist.length;i++)
        //     System.out.println(path[i]);
    }
}