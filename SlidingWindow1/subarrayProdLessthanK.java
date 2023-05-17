import java.util.*;

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        //Write code here
		int prod = 1;
		int sp= 0;
		int ep =0 ;
		int ans = 0;
		while(ep<nums.length){
			//introduce ep
			prod *= nums[ep];
			//it is possible due to the introduction of new person in the window
			//it might have become invalid, shrink until valid
			while(prod >= k){
				//shrink since window  is invalid
				prod/=nums[sp];
				sp++;
			}
			ans += (ep-sp+1);
			ep++;
		}
		return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int k;
        k = sc.nextInt();
        Solution Obj = new Solution();
        int result = Obj.numSubarrayProductLessThanK(arr, k);
        System.out.println(result);
        sc.close();
    }
}