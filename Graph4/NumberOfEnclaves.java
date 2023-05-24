import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int m = sc.nextInt(), n = sc.nextInt();
    int[][] grid = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        grid[i][j] = sc.nextInt();
      }
    }
    sc.close();
    System.out.println(numEnclaves(grid));
  }

	public static void destroy(int[][] a,int i,int j){
		if(i<0 || j<0 || i==a.length || j ==a[0].length || a[i][j] == 0) return;
		
		a[i][j] = 0; //i have destroyed this land cell

		destroy(a,i-1,j);//top
		destroy(a,i,j-1);//left
		destroy(a,i+1,j);//bottom
		destroy(a,i,j+1);//right
	}
	
  public static int numEnclaves(int[][] a) {
    // your code here
	  int n = a.length;
	  int m = a[0].length;
	  for(int j =0;j<m;j++){
		  destroy(a,0,j);
		  destroy(a,n-1,j);
	  }
	  for(int i = 0;i<n;i++){
		  destroy(a,i,0);
		  destroy(a,i,m-1);
	  }

	  int cnt = 0;
	  for(int i =0;i<n;i++){
		  for(int j = 0;j<m;j++){
			  if(a[i][j] == 1) cnt++;
		  }
	  }
	  return cnt;
  }
}



