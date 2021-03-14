package graph;

import queue.*;
public class GraphAlgor {
    
    static void dijkstra(Graph g, int start, int[] dist, int[] path){
        for(int v=0;v<g.numOfVertices();v++)
            g.setMark(v, 0);
        for(int i=0;i<g.numOfVertices();i++)
            dist[i] = Integer.MAX_VALUE;
        dist[start] = 0;
        path[start] = -1;
        for(int i=0;i<g.numOfVertices();i++){
            int v = minVertex(g,dist);
            g.setMark(v, 1);
            if(dist[v]==Integer.MAX_VALUE) return;//unreachable vertices
            for(Edge w=g.first(v);g.isEdge(w);w=g.next(w)){
                if(dist[g.edgeTo(w)]>(dist[v]+g.weight(w))){
                    dist[g.edgeTo(w)] = dist[v] + g.weight(w);
                    path[g.edgeTo(w)] = g.edgeFrom(w);
                }
            }
        }
    }
    static int minVertex(Graph g, int[] dist){
        int v = 0;
        for(int i=0;i<g.numOfVertices();i++)
            if(g.getMark(i)==0){
                v = i;
                break;
            }    
        for(int i=0;i<g.numOfVertices();i++){
            if((g.getMark(i)==0) && (dist[i]<dist[v]))
                v = i;
        }
        return v;   
    }

    static void floyd(Graph g, int[][] D, int[][] path){//path矩阵中存储的是起点到终点的中转结点
        for(int i=0;i<g.numOfVertices();i++)
            for(int j=0;j<g.numOfVertices();j++){
                D[i][j] = g.weight(i, j);
                path[i][j] = -1;
            }
                
        for(int k=0;k<g.numOfVertices();k++)
            for(int i=0;i<g.numOfVertices();i++)
                for(int j=0;j<g.numOfVertices();j++)
                    if((D[i][k]!=Integer.MAX_VALUE) && (D[k][j]!=Integer.MAX_VALUE) && 
                       (D[i][j]>(D[i][k] + D[k][j]))){
                        D[i][j] = D[i][k] + D[k][j];
                        path[i][j] = k;
                    }
    }

    public static void DFS(Graph g){
        for(int v=0;v<g.numOfVertices();v++)
            g.setMark(v, 0);
        for(int v=0;v<g.numOfVertices();v++){
            if(g.getMark(v)==0)
                DFSHelp(g,v);
        }
    }
    private static void DFSHelp(Graph g, int v){
        //preVisit(g,v);
        g.setMark(v, 1);
        for(Edge w=g.first(v);g.isEdge(w);w=g.next(w)){
            if(g.getMark(g.edgeTo(w))==0)
                DFSHelp(g, g.edgeTo(w));
        }
        postVisit(g,v);
    }

    public static void BFS(Graph g, int start){
        AQueue<Integer> q = new AQueue<>(g.numOfVertices());
        for(int v=0;v<g.numOfVertices();v++)
            g.setMark(v, 0);
        q.enQueue(start);
        g.setMark(start, 1);
        while(!q.isEmpty()){
            int v = q.deQueue();
            postVisit(g,v);
            for(Edge w=g.first(v);g.isEdge(w);w=g.next(w)){
                if(g.getMark(g.edgeTo(w))==0){
                    g.setMark(g.edgeTo(w), 1);
                    q.enQueue(g.edgeTo(w));
                }
            }
            //postVisit(g, v);
        }
    }

    public static void postVisit(Graph g, int v){
        System.out.println(v);
    }

    public void topSort(Graph g){
        AQueue<Integer> q = new AQueue<>(g.numOfVertices());
        int[] count = new int[g.numOfVertices()];
        int v;
        for(v=0;v<g.numOfVertices();v++) count[v] = 0;
        for(v=0;v<g.numOfVertices();v++)
            for(Edge w=g.first(v);g.isEdge(w);w=g.next(w))
                count[g.edgeTo(w)]++;
        for(v=0;v<g.numOfVertices();v++)
            if(count[v]==0)
                q.enQueue(v);
        while(!q.isEmpty()){
            v = q.deQueue();
            System.out.println(v);
            for(Edge w=g.first(v);g.isEdge(w);w=g.next(w)){
                count[g.edgeTo(w)]--;
                if(count[g.edgeTo(w)]==0)
                    q.enQueue(g.edgeTo(w));
            }
        }
    }

    public static int prim(Graph g, int s, int[] dist){
        int[] V = new int[g.numOfVertices()];
        int cost = 0;
        for(int i=0;i<g.numOfVertices();i++){
            //dist[i] = Integer.MAX_VALUE;
            dist[i] = g.weight(s, i);
            V[i] = s;
        }
        dist[s] = 0;
        V[s] = 0;
        for(int i=0;i<g.numOfVertices();i++){
            int v = minVertex(g, dist);
            g.setMark(v, 1);
            if(v!=s){
                System.out.println("V" + V[v] + "-" + "V" + v + "=" + g.weight(V[v], v));
                cost = cost + g.weight(V[v], v);
            }
            if(dist[v]==Integer.MAX_VALUE){
                System.out.println("不存在MST");
                return 0;
            }
            for(Edge w=g.first(v);g.isEdge(w);w=g.next(w))
                if(dist[g.edgeTo(w)]>g.weight(w)){
                    dist[g.edgeTo(w)] = g.weight(w);
                    V[g.edgeTo(w)] = v;
                }
        }
        return cost;
    }

}