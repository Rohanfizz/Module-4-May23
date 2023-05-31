import java.util.*;

class Solution{

	public static class Pair{
		int node;
		int wt;
		Pair(int node,int  wt){
			this.node = node;
			this.wt = wt;
		}
	}
	
    static void primMST(List<List<Integer>> graph) {
        // Your code here
		PriorityQueue<Pair> pq = new  PriorityQueue<>((a,b)->{
			return a.wt - b.wt;
		});

		pq.add(new Pair(0,0));
		boolean[] vis = new boolean[graph.size()];
		int cost = 0;
		while(pq.size() > 0){
			//remove
			Pair curr = pq.remove();
			//mark
			if(vis[curr.node] == true) continue;
			vis[curr.node] = true;
			//work
			cost += curr.wt;
			//add nbr edges
			for(int i =0;i<graph.size();i++){
				if(graph.get(curr.node).get(i) == 0 || vis[i] == true || i == curr.node) continue;
				int nbr = i;
				int wt = graph.get(curr.node).get(i);
				pq.add(new Pair(nbr,wt));//prims, only single edge weight is added
			}
		}
		System.out.println(cost);
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            List<Integer> temp = new ArrayList<>(V);
            for (int j = 0; j < V; j++) {
                temp.add(sc.nextInt());
            }
            graph.add(temp);
        }
        Solution.primMST(graph);
        sc.close();
    }
}
