import java.io.*;
import java.util.*;
class Main{
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
        int n,k;
        n=sc.nextInt();
        k=sc.nextInt();
        int[] a= new int[n];
        for(int i=0;i<n;i++){
          a[i] = sc.nextInt();
        }
        Solution obj=new Solution();
        System.out.println(obj.findPairs(a,n,k));		    
    }
}

class Solution
{
    public int findPairs(int[] nums,int n, int k) {
        //Write code 
		Arrays.sort(nums);
		int i = 0;
		int j = 1;
			int ans = 0;

		while(j<n){
			int currDiff = (nums[j] - nums[i]);
			if(currDiff == k){
				if(i != j) ans++;
				j++;
			}else if(currDiff < k) j++;
			else if(currDiff > k) i++;
		}
		return ans;
		
    }
}











