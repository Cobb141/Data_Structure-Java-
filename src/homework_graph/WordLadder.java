package homework_graph;

import java.io.*;
import java.util.*;

import graph.GraphList;
import queue.*;
import homework_graph.WordGraph.Vertex;
public class WordLadder {

    public static boolean isAdj(String w1, String w2){
        if(w1.length()!=w2.length()) return false;
        int num = 0;
        for(int i=0;i<w1.length();i++){
            if(w1.charAt(i)!=w2.charAt(i))
                num++;
            if(num>1) break;
        }
        if(num==1) return true;
        else return false;
    }

    public static void buildWordGraph(WordGraph g){
        Vertex[] arr = g.getArray();
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++)
                if(isAdj(arr[i].getWord(), arr[j].getWord()))
                    g.addEdge(i, j);
        }
    }

    public static void playGame(WordGraph g){
        Vertex[] arr = g.getArray();
        int i1=0,i2=0;
        while(i1==i2 || !BFS(g, i1, i2)){
            i1 = getRandom(arr.length);
            i2 = getRandom(arr.length);
        }
        String start = arr[i1].getWord();
        String end = arr[i2].getWord();
        System.out.println("start word: " + start + "   " + "end word: " + end);
        Scanner in = new Scanner(System.in); 
        String ans,temp;
        temp = start;
        while(!temp.equals(end)){
            System.out.print("Please input next word: ");
            ans = in.next();
            if(!isAdj(ans, temp) || g.find(ans)==-1){
                System.out.println("You input a wrong word! Game Over!");
                break;
            }else{
                temp = ans;
                if(temp.equals(end)){
                    System.out.println("Well done!");
                    break;
                }
            }
        }
        in.close();
    }
    public static int getRandom(int num) {
        int rnd = new Random().nextInt(num);
        return rnd;
    }
    
    @SuppressWarnings("uncheck")
    public static boolean BFS(WordGraph g, int start, int end){
        AQueue<Integer> q = new AQueue<>(g.getArray().length);
        for(int v=0;v<g.getArray().length;v++)
            g.setMark(v, 0);
        Vertex[] arr = g.getArray();
        q.enQueue(start);
        g.setMark(start, 1);
        while(!q.isEmpty()){
            int v = q.deQueue();
            if(arr[v].getWord().equals(arr[end].getWord())){
                return true;
            }
            GraphList adjlist = arr[v].getAdj();
            if(adjlist.isEmpty()) continue;
            for(adjlist.setFirst();adjlist.isInList();adjlist.next()){
                int temp = g.find((String)adjlist.currValue());
                if(g.getMark(temp)==0){
                    g.setMark(temp, 1);
                    q.enQueue(temp);
                }
            }
        }
        return false;
    }
    public static void main(String[] args)throws Exception{
        WordGraph g = new WordGraph(2415);
        BufferedReader in = new BufferedReader(new FileReader
            ("C:/VScode_Java/Data_Structure/src/homework_graph/words5.txt"));
        String line = "";
        while(line!=null){
            line = in.readLine();
            if(line==null) break;
            g.setWord(line);
        }

        PrintWriter pw = new PrintWriter(new FileWriter
            ("C:/VScode_Java/Data_Structure/src/homework_graph/noladder.txt")) ;               
        
        buildWordGraph(g);
        
        Vertex[] arr = g.getArray();
        for(int i=0;i<g.getArray().length;i++){
            if(arr[i].getAdj().isEmpty()){
                pw.println(arr[i].getWord());
                pw.flush();
            }
        }

        pw.close();
        in.close();

        playGame(g);
    }
}