import java.util.*;

class Solution {

	public static void dfs(ArrayList<ArrayList<Integer>> graph,int node,boolean[] visited){
		//mark visited
		visited[node] = true;
		//work
		System.out.print(node+" ");
		//visited the unvisited neighbours
		for(int nbr: graph.get(node)){
			if(visited[nbr] == false){
				dfs(graph,nbr,visited);
			}
		}
	}
	
    public static void DFSTraversal(List<List<Integer>> edges, int n) {
        //Write your code here
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		//initializing the internal empty arraylists
		for(int i = 0;i<n;i++){
			graph.add(new ArrayList<Integer>());
		}
		//i will iterate on edges, and add edges one by one
		for(List<Integer> edge: edges){
			int u = edge.get(0); 
			int v = edge.get(1); 
			//undirected graph
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		//portal magic
		for(int i = 0;i<n;i++){
			Collections.sort(graph.get(i));
		}
		//the graph is ready	
		boolean[] visited = new boolean[n];
		dfs(graph,0,visited);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        List<List<Integer>> ed = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            List<Integer> l = new ArrayList<>();
            l.add(sc.nextInt());
            l.add(sc.nextInt());
            ed.add(l);
        }

        Solution ob = new Solution();
        ob.DFSTraversal(ed, n);
    }
}