import java.util.*;
public class MinimumSpanTree {

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
    static class Pair implements Comparable<Pair>{
        int node;
        int cost;

        public Pair(int n , int c){
            this.node = n;
            this.cost = c;
        }

        @Override
        // pair has two parameters cost and the node by using 
        // comparable the sorting will be done on the basis of the cost in asc order
        public int compareTo(Pair p2){
            return this.cost - p2.cost;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        Scanner sc = new Scanner(System.in);
        
        for (int i = 0; i < graph.length; i++) {
            
            graph[i] = new ArrayList<>();
            
            System.out.println("Enter the neighbours of " + i + " (Enter -1 to stop): ");
            
            
            while (true) {
                System.out.print("Enter the neighbors :" );
                int input = sc.nextInt();
                System.out.print("Enter the weight of the neighbors :");
                int wt = sc.nextInt();
                if (input == -1) {
                    break;
                }
                graph[i].add(new Edge(i, input, wt));
               
            }
        }
            // graph[0].add(new Edge(0, 1, 10));
            // graph[0].add(new Edge(0, 2, 15));
            // graph[0].add(new Edge(0, 3, 30));
            // graph[1].add(new Edge(1, 0, 10));
            // graph[1].add(new Edge(1, 3, 40));
            // graph[2].add(new Edge(2, 0, 15));
            // graph[2].add(new Edge(2, 3, 50));
            // graph[3].add(new Edge(3, 1, 40));
            // graph[3].add(new Edge(3, 2, 50));

    }

    public static void minCost(ArrayList<Edge> graph[] , int V){
        PriorityQueue<Pair>  pq = new PriorityQueue<>();
        boolean vis[] = new boolean[V];

        pq.add(new Pair(0,0));
        int minCost = 0;

        while(!pq.isEmpty()){
            Pair curr = pq.remove();

            if(!vis[curr.node]){
                vis[curr.node] = true;
                minCost = minCost + curr.cost;

                for(int i =0 ; i<graph[curr.node].size() ;i++){
                    Edge e = graph[curr.node].get(i);

                    if(!vis[e.dest]){
                        pq.add(new Pair(e.dest, e.wt));
                    }
                }
            }
        }

        System.out.println("Minimum Cost is :"+ minCost);

    }

    
    public static void main(String args[]){

        
        Scanner sc = new Scanner(System.in);
        
        
        System.out.print("Enter the number of vertices :");
        int V = sc.nextInt();


        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        minCost(graph, V);

    }
}
