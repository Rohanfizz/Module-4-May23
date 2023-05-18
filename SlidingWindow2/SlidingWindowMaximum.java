import java.util.*;

class Solution{
    static int[] SlidingWindowMaximum(int N, int K, int[] arr){
        // write code here
		LinkedList<Integer> dq = new LinkedList<>();
		int[] ans = new int[N-K+1];

		for(int i = 0;i<K;i++){
			while(dq.size() > 0 && arr[dq.getLast()] < arr[i]) dq.removeLast();
			dq.addLast(i);
		}
		ans[0] = arr[dq.getFirst()];
		int sp = 0;
		int ep = K;
		int window = 1;

		while(ep<N){
			//epth person enters the window, so it should be introduced to dq
			while(dq.size() > 0 && arr[dq.getLast()] < arr[ep]) dq.removeLast();
			dq.addLast(ep);

			//it is possible that front of the window is out of the window
			if(dq.getFirst() == sp) dq.removeFirst();

			ans[window] = arr[dq.getFirst()];
			ep++;
			sp++;
			window++;
		}
		return ans;
    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int nums[]=new int[n];
        for(int i = 0; i < n; i++)
        {
            nums[i] = sc.nextInt();
        }
        Solution obj = new Solution();
        int[] ans=obj.SlidingWindowMaximum(n,k,nums);
        for(int i=0;i<ans.length;++i){
            System.out.print(ans[i] + " ");
        }
    }
}
