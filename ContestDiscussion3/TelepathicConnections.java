import java.util.*;

class Solution {
    @SuppressWarnings("unchecked")
	//https://course.acciojob.com/idle?question=65677454-50cc-45df-a699-4dba2b8be361

	public class Pair{
		int node;
		int wsf;
		Pair(int  node,int wsf){
			this.node = node;
			this.wsf = wsf;
		}
	}
    public int thanosTelepath(int[][] edges, int[] patience) {
       // Write your code 
		int n = patience.length;

		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for(int i = 0;i<n;i++) graph.add(new ArrayList<>());
		for(int[] e:edges){
			int u = e[0];
			int v = e[1];
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		//dijkstra for shortest paths
		boolean[] vis = new boolean[n];
		int[] dist  = new int[n];
		PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
			return a.wsf - b.wsf;
		});
		pq.add(new Pair(0,0));

		while(pq.size()>0){
			//remove
			Pair curr = pq.remove();
			//mark
			if(vis[curr.node]) continue;
			vis[curr.node] = true;
			//work
			dist[curr.node] =curr.wsf;
			//add nbrs
			for(int nbr: graph.get(curr.node)){
				if(!vis[nbr]) pq.add(new Pair(nbr,curr.wsf + 1));
			}
		}
		//now i have the shortest distance from every node to thanos
		int MaxidleTime = 0;
		for(int i = 1;i<n;i++){
			int timeToRecieveFirstReply = dist[i]*2;
			int timeSendLastMessage = timeToRecieveFirstReply - (timeToRecieveFirstReply%patience[i]);
			if(timeSendLastMessage == timeToRecieveFirstReply) timeSendLastMessage-=patience[i];

			int timeAtWhichIRecieveTheReplyToLastMessage = timeSendLastMessage + dist[i]*2;
			int idleTime = timeAtWhichIRecieveTheReplyToLastMessage + 1;
			MaxidleTime = Math.max(MaxidleTime,idleTime);
		}
		return MaxidleTime;
		
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] edges = new int[n][2];
        for (int i = 0; i < n; i++) {
        edges[i][0] = sc.nextInt();
        edges[i][1] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] patience = new int[m];
        for (int i = 0; i < m; i++) {
        patience[i] = sc.nextInt();
        }
        sc.close();
        
        Solution Obj = new Solution();
        System.out.println(Obj.thanosTelepath(edges,patience));

    }
}