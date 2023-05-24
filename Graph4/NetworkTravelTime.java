import java.io.*;
import java.util.*;

public class Main {
   public static void main(String[] args){
      Scanner sc=new Scanner(System.in);
      int n,m,k;
      n=sc.nextInt();
      m=sc.nextInt();
      k=sc.nextInt();
      int[][] a= new int[m][3];
      for(int i=0;i<m;i++){
         int u,v,w;
         u=sc.nextInt();
         v=sc.nextInt();
         w=sc.nextInt();
         a[i][0]=u;
         a[i][1]=v;
         a[i][2]=w;   
      }
      Solution ob = new Solution();
      System.out.println(ob.networkDelayTime(a,n,k));
   }
}
class Solution {

		public class Edge{
			int nbr;
			int wt;
			Edge(int nbr,int wt){
				this.nbr = nbr;
				this.wt = wt;
			}
		}
		public class Pair{
			int node;
			int wsf;
			Pair(int node,int wsf){
				this.node  =node;
				this.wsf = wsf;
			}
		}
       public int networkDelayTime(int[][] edges, int N, int K) {
        //Write code here
		   ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
		   for(int i = 0;i<=N;i++){
			   graph.add(new ArrayList<Edge>());
		   }
		   for(int[] edge: edges){
			   int u = edge[0];
			   int v = edge[1];
			   int w = edge[2];
			   graph.get(u).add(new Edge(v,w));
		   }

		   int[] vis = new int[N+1];
		   Arrays.fill(vis,-1);

		   //apply dijkstra
		   PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
			   return a.wsf - b.wsf;
		   });

		   pq.add(new Pair(K,0));

		   //start applying normal bfs
		   while(pq.size()>0){
			   //remove
			   Pair curr = pq.remove();
			   //mark
			   if(vis[curr.node] != -1) continue;
			   vis[curr.node] = curr.wsf;
			   //add nbrs
			   for(Edge e:graph.get(curr.node)){
				   if(vis[e.nbr] == -1) pq.add(new Pair(e.nbr,curr.wsf+e.wt));
			   }
		   }
		   for(int i =1;i<=N;i++) if(vis[i] == -1) return -1; // ith node was not visited
			int maxi = 0;
		   for(int i = 1;i<=N;i++) maxi = Math.max(maxi,vis[i]);
		   return maxi;
    }
}













