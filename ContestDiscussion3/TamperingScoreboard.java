import java.util.*;

public class Main {
//https://course.acciojob.com/idle?question=c4fc0e56-a4f6-4bdf-97c9-b6acd5d80796
  public static int matrixScore(int[][] arr) {
    // your code here
	//try to flip rows if a[i][0] == 0, as i want msb to be set;
	  for(int  i = 0;i<arr.length;i++){
		  if(arr[i][0] == 0){
			  for(int j = 0;j<arr[0].length;j++) arr[i][j] = arr[i][j] == 1?0:1;
		  }
	  }

	  //flip the cols of zc > oc in any col
	  for(int j = 0;j<arr[0].length;j++){
		  int zc = 0;
		  int oc = 0;
		  for(int i = 0;i<arr.length;i++){
			  if(arr[i][j] == 0) zc++;
			  else oc++;
		  }
		  if(zc > oc){
			  //flip the col
			  for(int i = 0;i<arr.length;i++){
				  arr[i][j] = arr[i][j] == 1?0:1;
			  }
		  }
	  }
	  int total = 0;
	  for(int i = 0;i<arr.length;i++){
		  int pow = 1;
		  for(int j = arr[0].length-1;j>=0;j--){
			  if(arr[i][j] == 1) total+=pow;
			  pow*=2;
		  }
	  }
	  return total;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int m = sc.nextInt(), n = sc.nextInt();
    int[][] matrix = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        matrix[i][j] = sc.nextInt();
      }
    }
    sc.close();
    System.out.println(matrixScore(matrix));
  }
}