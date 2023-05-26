import java.util.*;
import java.lang.*;
import java.io.*;

class Solution{
	public static boolean checkIthBitIsSet(int n,int i){
		return (n & (1<<i))!=0;
	}
	
    public static int singleNumber(int[] nums) {
    // Your code here
		int[] freq = new int[32];
		for(int x: nums){
			int i = 0;
			while(i<32){
				if(checkIthBitIsSet(x,i)) freq[i]++;
				i++;
			}
		}

		int ans = 0;
		int pow = 1;
		for(int i = 0;i<32;i++){
			if(freq[i]%3 != 0){
				ans += pow;
			}
			pow*=2;
		}
		return ans;
	}
}

public class Main {
  public static void main (String[] args)
	{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(Solution.singleNumber(nums));
	}
}