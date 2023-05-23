import java.io.*;
import java.util.*;
class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(read.readLine());
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0; i<N; i++)
        {
            String S[] = read.readLine().split(" ");
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j=0; j<N; j++)
                temp.add(Integer.parseInt(S[j]));
            adj.add(temp);
        }

        Solution ob = new Solution();
        System.out.println(ob.components(adj,N));
    }
}

class Solution {

	void dfs(ArrayList<ArrayList<Integer>> graph,boolean[] vis,int node){
		int N = vis.length;
		vis[node] =true;
		//work - nothing
		for(int nbr = 0;nbr<N;nbr++){
			if(nbr == node) continue;
			if(graph.get(node).get(nbr) == 1){
				if(!vis[nbr]) dfs(graph,vis,nbr);
			}
		}
	}
	
    int components(ArrayList<ArrayList<Integer>> graph, int N) {
       //Your code here

		int components = 0;
		boolean[] vis = new boolean[N];

		for(int i  = 0;i<N;i++){
			if(vis[i]) continue;
			dfs(graph,vis,i);
			components++;
		}
		return components;
    }
};













