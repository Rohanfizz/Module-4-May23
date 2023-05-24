import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        ArrayList<ArrayList<Integer>> Edges = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < M; i++) {
            ArrayList<Integer> e = new ArrayList<Integer>();
            e.add(sc.nextInt());
            e.add(sc.nextInt());
            Edges.add(e);
        }
        Solution ob = new Solution();
        if (ob.check(N, M, Edges)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
        sc.close();
    }

}

class Solution {

	void dfs(ArrayList<ArrayList<Integer>> graph,boolean[] path,int curr,int src,ArrayList<Integer> psf){
		int V = graph.size()-1;
		path[curr] = true;
		psf.add(curr);

		if(psf.size() ==V){
			//i have detected hamiltonian path
			System.out.print(psf+" ");

			boolean isCycle = false;
			for(int nbr:  graph.get(curr)){
				if(nbr ==src) isCycle = true;
			}
			if(isCycle) System.out.print(" (Cycle)");
			System.out.println();
		}

		for(int nbr: graph.get(curr)){
			if(path[nbr] == false) dfs(graph,path,nbr,src,psf);
		}

		path[curr] = false;
		psf.remove(psf.size()-1);
	}
    boolean check(int V, int M, ArrayList<ArrayList<Integer>> edges) {
        // your code here
	    ArrayList<ArrayList<Integer>> graph= new ArrayList<>();
		for(int i = 0;i<=V;i++){
			graph.add(new ArrayList<Integer>());
		}
		for(ArrayList<Integer> edge: edges){
			int u = edge.get(0);
			int v = edge.get(1);
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		boolean[] path = new boolean[V+1]; // v+1 because 1 based indexing

		for(int i = 1;i<=V;i++){
			ArrayList<Integer> psf = new ArrayList<>();
			dfs(graph,path,i,i,psf);
		}
		return true;
    }
}







