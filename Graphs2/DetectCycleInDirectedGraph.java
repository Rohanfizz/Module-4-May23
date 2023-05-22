import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {


	public boolean dfs(int node,ArrayList<Integer>[] graph,boolean[] visited,boolean[] path){
		//mark
		visited[node] = true;
		path[node]= true;
		//work - there is  no work for this problem. all the work is handled while adding nbrs
		for(int nbr:graph[node]){
			if(!visited[nbr]){
				boolean cycleFound = dfs(nbr,graph,visited,path);
				if(cycleFound) return true;
			}else if(path[nbr]  == true){
				//the snake is cutting itself
				return true;//cycle has been detected
			}
		}
		path[node] = false;
		return false;
	}

	public boolean isCyclic(int V, ArrayList<Integer>[] graph) {
	    // Your code here
		boolean[] visited = new boolean[V];
		boolean[] path = new boolean[V];
		
		for(int i = 0;i<V;i++){//detect cycle in all components
			if(visited[i]) continue;//if sm1 is already visited this means it was covered in some prev component
			boolean cycleFound = dfs(i,graph,visited,path);
			if(cycleFound) return true;
	   }
		return false;
	}
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V, E;
        V = sc.nextInt();
        E = sc.nextInt();
        ArrayList<Integer>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < E; i++) {
            int u, v;
            u = sc.nextInt();
            v = sc.nextInt();
            adj[u].add(v);
        }
        Solution obj = new Solution();
        boolean ans = obj.isCyclic(V, adj);
        if (ans == true) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}