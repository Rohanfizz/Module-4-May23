import java.util.*;

class Solution {

	public class Pair{
		int node;
		int color;
		Pair(int node,int color){
			this.node  = node;
			this.color = color;
		}
	}
	
	public boolean bfs(ArrayList<ArrayList<Integer>> graph,int[] visited,int src){
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(src,1));
		while(q.size()>0){
			Pair curr = q.remove();
			//mark
			if(visited[curr.node] != 0) continue;
			visited[curr.node] = curr.color;
			int oppColor = curr.color == 1?-1:1;
			//add nbrs
			for(int nbr:graph.get(curr.node)){
				if(visited[nbr] == 0){
					//nbr is colorless and i can color it with oppColor
					q.add(new Pair(nbr,oppColor));
				}else if(visited[nbr] == curr.color) return false;
				//the nbr is already having oppcolor, i will continue
			}
		}
		return true;
	}
	
    public int possibleBipartition(int n, int[][] dislikes) {
        // Write your code here
		ArrayList<ArrayList<Integer>> graph = new  ArrayList<>();
		for(int i = 0;i<=n;i++) graph.add(new ArrayList<Integer>());

		for(int[] edge: dislikes){
			int u= edge[0];
			int v = edge[1];
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		//visited array is of type integer, representing colors
		//0 = colorless/unvisited
		//1 = blue
		//-1 = red
		int[] visited = new int[n+1];//n+1 because 1 based indexing

		for(int i = 1;i<=n;i++){//handling components by applying bfs on all the unvisited vertices
			if(visited[i] != 0) continue;
			boolean isBipartate = bfs(graph,visited,i);
			if(!isBipartate) return 0;
		}
		return 1;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        int M= sc.nextInt();

        int dislike[][] = new int[M][2];

        for(int i=0; i<M; i++){
            for(int j=0; j<2; j++)
                dislike[i][j]= sc.nextInt();
        }
        
        Solution Obj = new Solution();
        System.out.println(Obj.possibleBipartition(N,dislike));

    }
}