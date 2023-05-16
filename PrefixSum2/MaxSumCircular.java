import java.util.*;

class Solution {
    public int MaxSum(int[] arr, int n) {
        // Write your code here
		int sumMax = 0;
		int maxSubarraySum = Integer.MIN_VALUE;

		int sumMin = 0;
		int minSubarraySum = Integer.MAX_VALUE;
		
		int total = 0;
		for(int i = 0;i<n;i++){
			total += arr[i];

			//maxSumSubarray calculation
			sumMax = Math.max(sumMax + arr[i] , arr[i]);
			maxSubarraySum = Math.max(maxSubarraySum,sumMax);

			//minSumSubarray calculation
			sumMin = Math.min(sumMin+arr[i],arr[i]);
			minSubarraySum = Math.min(minSubarraySum,sumMin);
		}

		if(total == maxSubarraySum){//all +ve
			return maxSubarraySum;
		}else if(total  == minSubarraySum){//all -ve
			return maxSubarraySum;
		}

		int wrapAround = total - minSubarraySum;
		return Math.max(maxSubarraySum,wrapAround);

		
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
	    Solution Obj = new Solution();
        int ans = Obj.MaxSum(arr, n);
        System.out.println(ans);
    }
}