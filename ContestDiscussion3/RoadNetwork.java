import java.util.*;

class Solution {
	//https://course.acciojob.com/idle?question=eba27af6-e709-4ece-a8fc-ed3d1cdbf6d6
	public class Pair{
		int idx;
		int degree;
		Pair(int idx,int degree){
			this.idx = idx;
			this.degree = degree;
		}
	}
	
    public long maxUseful(int n, int[][] roads) {
        // write code here
		int[] degree = new int[n];
		for(int[] e: roads){
			int u = e[0];
			int v = e[1];
			degree[u]++;
			degree[v]++;
		}
		ArrayList<Pair> arr = new ArrayList<>();
		for(int i = 0;i<n;i++){
			arr.add(new Pair(i,degree[i]));
		}

		Collections.sort(arr,(a,b)->{
			return a.degree - b.degree;
		});
		int[] usefullness = new int[n];
		int curr = 1;
		for(Pair p:arr){
			usefullness[p.idx]= curr;
			curr++;
		}
		int total = 0;
		for(int[] road:roads){
			total += usefullness[road[0]] + usefullness[road[1]];
		}
		return total;
    }
}

class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int arr[][] = new int[m][2];
        for (int i = 0; i < m; i++) {
            int u, v;
            u = sc.nextInt();
            v = sc.nextInt();
            arr[i][0] = u;
            arr[i][1] = v;
        }
        sc.close();
        Solution Obj = new Solution();
        System.out.println(Obj.maxUseful(n, arr));
    }
}