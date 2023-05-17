import java.util.*;

class Solution {
    static int maxOne(int arr[], int n,int k){
        //Write your code here
		int ans = 0;
		int sp = 0;
		int ep = 0;
		int zc = 0;

		while(ep<n){
			//step1: introduce new person to window
			if(arr[ep] == 0) zc++;

			//now due to the intro of new person, it is possible that
			//window might have become invalid, so shrink until the window is invalid
			while(zc > k){
				if(arr[sp] == 0) zc--;
				sp++;
			}
			//after the above loop, my window will always be valid
			//we should consider it for the answer
			ans = Math.max(ans,ep-sp+1);
			//expand the window
			ep++;
		}
		return ans;
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int k= sc.nextInt();
        int array[] = new int[n];

        for(int i=0; i<n; i++){
            array[i]= sc.nextInt();
        }
        Solution Obj = new Solution();
        System.out.println(Obj.maxOne(array,n,k));
    }
}