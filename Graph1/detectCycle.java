import java.io.*;
import java.util.*;

class Solution {

	public static boolean bfs(ArrayList<ArrayList<Integer>> graph,int n,int src,boolean[] vis){
		Queue<Integer> q = new LinkedList<>();
		q.add(src);

		while(q.size()>0){
			//remove
			int currNode = q.remove();
			//mark if not marked
			if(vis[currNode]) return true;
			vis[currNode] = true;
			//work is nothing in this case
			//add unvisited neighbours
			for(int nbr:graph.get(currNode)){
				if(!vis[nbr]) q.add(nbr);
			}
		}
		return false;
	}
	
    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> graph) {
       // Your code here
		boolean[] vis = new boolean[V];
		
		for(int i = 0;i<V;i++){
			if(vis[i]) continue;
			boolean resOfThisComponent = bfs(graph,V,i,vis);
			if(resOfThisComponent) return true;
		}
		return false;
    }
}

public class Main{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int N, E;
        N = sc.nextInt();
        E = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0; i<N; i++) adj.add(i, new ArrayList<Integer>());    
        for(int i =0; i<E; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean ans = Solution.isCycle(N,adj);
        if(ans)
            System.out.println("1");
        else
            System.out.println("0");
    }
}