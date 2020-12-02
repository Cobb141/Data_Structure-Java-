package homework_graph;

import graph.*;
public class WordGraph {
    private Vertex[] array;
    private int[] mark;
    private int curr = 0;

    class Vertex{
        private String word;
        private GraphList adjNode;

        public Vertex(String str){
            word = str;
            adjNode = new GraphList();
        }
        public String getWord(){
            return word;
        }
        public GraphList getAdj(){
            return adjNode;
        }
        public void addNode(String word){
            adjNode.append(word);
        }
    }

    public WordGraph(int n){
        array = new Vertex[n];
        mark = new int[n];
    }

    public void setWord(String word){
        array[curr] = new Vertex(word);
        curr++;
    }

    public void addEdge(String word1, String word2){
        int index1 = find(word1);
        int index2 = find(word2);
        if(index1==-1 || index2==-1){
            System.out.println("No such word in graph");
            return;
        }
        array[index1].addNode(word2);
        array[index2].addNode(word1);
    }
    public void addEdge(int i, int j){
        array[i].addNode(array[j].getWord());
        array[j].addNode(array[i].getWord());
    }
    
    public int find(String word){
        for(int i=0;i<array.length;i++){
            if(word.equals(array[i].getWord()))
                return i;
        }
        return -1;
    }

    public Vertex[] getArray(){ return array; }

    public void setMark(int v, int val) {
        mark[v] = val;
    }

    public int getMark(int v) {
        return mark[v];
    }
}