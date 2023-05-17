import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    public static int[] twoSum(int[] A, int target) {
       // Your code here
		int  l = 0;
		int r = A.length-1;

		while(l<r){
			int currSum = A[l] + A[r];
			if(currSum == target){
				//return indexex of l and r
				int[] res = new int[2];
				res[0] = l+1;//+1 for fixing for 1 based indexing
				res[1] = r+1;
				return res;
			}else if(currSum < target) l++;//so that i can increase currSum by placing left pointer to a bigger value
			else if(currSum > target) r--;
		}
		//dummy return
		int[] dummy = new int[0];
		return dummy;
    }
	
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
        long n = Long.parseLong(br.readLine().trim());
        String inputLine[] = br.readLine().trim().split(" ");
        int[] arr = new int[(int)n];
        for(int i=0; i<n; i++)arr[i]=Integer.parseInt(inputLine[i]);
        int m = Integer.parseInt(br.readLine().trim());
        int[] ans = (twoSum(arr, m));
        System.out.println(ans[0] + " " + ans[1]);
	}
}



