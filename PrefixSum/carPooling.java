
import java.util.*;
import java.lang.*;
import java.io.*;
public class Main {
	   public static void main(String args[]) {
		  
		        Scanner sc = new Scanner(System.in);
		        int n = sc.nextInt();
		        int[][] trips = new int[n][3];
		        for (int i = 0; i < n; i++) {
		            for (int j = 0; j < 3; j++) {
		                trips[i][j] = sc.nextInt();
		            }
		        }
		        int k = sc.nextInt();
	           
	        Solution obj= new Solution();
	        System.out.println(obj.carPooling(trips,k));
	    }
}
class Solution{
  
    public boolean carPooling(int[][] trips, int capacity) {
	//your code
		// o(n) space, o(n) time
		int[] stations  = new  int[1001];//1001 because of constraints

		//o(n) time
		for(int[] trip : trips){
			int numPass = trip[0];
			int sp = trip[1];
			int  ep= trip[2];
			stations[sp] += numPass;
			stations[ep] -= numPass;
		}

		//o(n) time
		for(int i = 1;i<stations.length;i++){//creating the prefix sum array
			stations[i] += stations[i-1];
		}
		//o(n) time
		for(int i = 0;i<stations.length;i++){//we are checking if at one station the capacity exceeds
			if(stations[i] > capacity) return false;
		}
		return true;

		
	}
}














