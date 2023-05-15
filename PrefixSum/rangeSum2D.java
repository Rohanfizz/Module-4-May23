import java.util.*;

class Pair {
    int row1;
    int row2;
    int col1;
    int col2;
}

class Solution {

    public List<Integer> solve(int arr[][], Pair query[]) {
        // Your code here
		//sc o(n*m)
		//tc o(n*m + q)
		int n = arr.length;
		int m = arr[0].length;
		int[][] pref = new int[n][m];
		List<Integer> ans = new ArrayList<>();
		for(int i = 0;i<n;i++){
			for(int j = 0;j<m;j++){
				int A = j==0? 0 : pref[i][j-1];
				int B = i==0? 0 : pref[i-1][j];
				int D = i==0 || j==0 ? 0 : pref[i-1][j-1];
				pref[i][j] = arr[i][j] + A + B - D;
			}
		}

		for(Pair q: query){
			int row1 = q.row1;
			int col1 = q.col1;
			int row2 = q.row2;
			int col2 = q.col2;

			int A = pref[row2][col2];
			int B = col1 == 0 ? 0 : pref[row2][col1-1];
			int C = row1 == 0 ? 0 : pref[row1-1][col2];
			int D = row1 == 0 || col1 == 0? 0 : pref[row1-1][col1-1];
			int matrixSum = A - B - C + D;
			ans.add(matrixSum);
		}
		return ans;
		
    }
}

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int matrix[][] = new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            matrix[i][j]=sc.nextInt();
        }
        int q = sc.nextInt();
        Pair query[] = new Pair[q];

        Solution obj = new Solution();
        for (int i = 0; i < q; i++) {
            Pair p=new Pair();
            p.row1 = sc.nextInt();
            p.col1 = sc.nextInt();
            p.row2 = sc.nextInt();
            p.col2 = sc.nextInt();
            query[i]=p;
        }
        List<Integer> ans = obj.solve(matrix, query);
        for(int x: ans)
        System.out.println(x);
        sc.close();
    }
}