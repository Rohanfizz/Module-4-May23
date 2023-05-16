import java.util.*;

class Solution {

    public long solve(int grid[][]) {
        // Your code here
		int n = grid[0].length;
        int[] prefRow1 = new int[n];
		int[] suffRow0 = new int[n];

		prefRow1[0] = grid[1][0];
		for(int i = 1;i<n;i++){
			prefRow1[i] = prefRow1[i-1] + grid[1][i];
		}

		suffRow0[n-1] = grid[0][n-1];
		for(int i = n-2;i>=0;i--){
			suffRow0[i] = suffRow0[i+1] + grid[0][i];
		}

		//now we have to consider the minimum possible sum
		//robot 2 can make out of all of the choices robot 1 can make
		//if robot 2 chooses best choice
		int res = Integer.MAX_VALUE;

		for(int i = 0;i<n;i++){
			//robot 1 will be switching rows on the ith column
			//robot 2 is left with 2 choices
			int choice1 = i == n-1 ?0:suffRow0[i+1];
			int choice2 = i == 0 ? 0 : prefRow1[i-1];
			int robot2 = Math.max(choice1,choice2);
			res = Math.min(res,robot2);
		}
		return res;
    }
}

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int grid[][]=new int[2][n];
        for(int i=0;i<2;i++)
        {
            for(int j=0;j<n;j++)
                grid[i][j]=sc.nextInt();

        }
        
        Solution obj=new Solution();
        System.out.println(obj.solve(grid));
        sc.close();
    }
}