import java.lang.reflect.Array;
import java.util.*;
public class Dijkstra {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0 ; i<graph.length ; i++){
            graph[i] = new ArrayList<Edge>();
        }
            graph[0].add(new Edge(0, 1, 2));
            graph[0].add(new Edge(0, 2, 4));
            graph[1].add(new Edge(1, 3, 7));
            graph[1].add(new Edge(1, 2, 1));
            graph[2].add(new Edge(2, 4, 3));
            graph[3].add(new Edge(3, 5, 1));
            graph[4].add(new Edge(4, 3, 2));
            graph[4].add(new Edge(4, 5, 5));

    }
    public static class Pair implements Comparable<Pair>{
        int node;
        int dist ;

        Pair(int n , int d){
            this.node = n;
            this.dist = d;
        }

        @Override
        public int compareTo(Pair p2){
            return this.dist - p2.dist; //priority queue need to know that on what basis it will compare Pair we want to compare it on the basis of distance
        }
    }
    public static void dijkstra(ArrayList<Edge> graph[] , int src , int V ){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int dist[] = new int[V];
        for(int i=0 ; i<V ; i++){
            if(i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }
        boolean vis[] = new boolean[V];

        pq.add(new Pair(0 , 0));

        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(!vis[curr.node]){
                vis[curr.node] = true;

                for(int i =0 ; i<graph[curr.node].size() ; i++){
                    Edge e = graph[curr.node].get(i);
                    int u = e.src;
                    int v = e.dest;

                    //relaxation step
                    if(dist[u] + e.wt < dist[v]){
                        dist[v] = dist[u] + e.wt;
                        pq.add(new Pair(v , dist[v]));

                    }
                }
            }
        }

        System.out.print("The minimum cost of the graph is :"+dist[V-1]);
        System.out.println();
    } 

    public static void main(String args[]){
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        int src = 0;

        dijkstra(graph, src , V);
    }
}
