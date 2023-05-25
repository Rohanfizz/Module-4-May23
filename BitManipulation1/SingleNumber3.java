import java.util.*;

class Solution {
	public boolean kthBitIsSet(int n,int k){
		int mask = 1<<k;
		int res = n & mask;
		if(res == 0) return false;
		return true;
	}
    public int[] singleNumber3(int n, int[] nums) {
        // write code here
		int xorAll = 0;
		for(int x: nums) xorAll ^= x;
		int k = 0;
		while(!kthBitIsSet(xorAll,k)) k++;
		
		int kthBitSet = 0;
		int kthBitUnset = 0;
		for(int x: nums){
			if(kthBitIsSet(x,k)){
				kthBitSet ^= x;
			}else{
				kthBitUnset ^= x;
			}
		}
		int[] res = new int[2];
		res[0] = kthBitSet;
		res[1] = kthBitUnset;
		Arrays.sort(res);
		return res;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        Solution Obj = new Solution();
        scn.close();
        int[] ans = Obj.singleNumber3(n, arr);
        System.out.print(ans[0] + " " + ans[1]);
    }
}