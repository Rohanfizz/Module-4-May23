import java.util.*;

class Solution {
    public int latestTimeCatchTheBus(int[] b, int[] p, int c) {
        //Write code here
		//https://course.acciojob.com/idle?question=e260f038-9afa-4f3c-b975-52f7aae042e6
		int bidx = 0;
		int pidx = 0;
		Arrays.sort(b);
		Arrays.sort(p);

		HashSet<Integer> hs = new HashSet<Integer>();
		for(int x: p) hs.add(x);

		int lastPassTime = -1;
		int lastBusCapacity = c;
		
		while(pidx<p.length && bidx<b.length){
			int currBusCap = c;
			while(currBusCap > 0 && pidx<p.length && p[pidx] <= b[bidx]){
				//i will fill passengers in the bidxth bus
				currBusCap--;
				lastPassTime = p[pidx];
				pidx++;
			}
			lastBusCapacity = currBusCap;
			bidx++;
		}
		if(bidx<b.length){
			//extra busses
			return b[b.length-1];//i will onboard on the departure time of the last bus
		}
		if(lastBusCapacity>0) lastPassTime = b[b.length-1]; //last bus having empty seats
		while(hs.contains(lastPassTime)) lastPassTime--;
		return lastPassTime;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nums1[] = new int[n];
        for (int i = 0; i < n; i++)
            nums1[i] = sc.nextInt();
        int m = sc.nextInt();
        int nums2[] = new int[m];
        for (int i = 0; i < m; i++)
            nums2[i] = sc.nextInt();
        int cap = sc.nextInt();
        Solution Obj = new Solution();
        int res = Obj.latestTimeCatchTheBus(nums1, nums2, cap);
        System.out.println(res);
        sc.close();
    }
}