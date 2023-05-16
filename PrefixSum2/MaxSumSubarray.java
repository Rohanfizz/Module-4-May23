import java.util.*;

class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++){
            a[i] = input.nextInt();
        }
        Solution ob =new Solution();
        long ans = ob.maxSubarraySum(a,n);
        System.out.println(ans);
    }
}
class Solution{
    public long maxSubarraySum(int a[],int n){
        //Write code here
		long train = 0;
		long res = Integer.MIN_VALUE;
		int cs = 0;
		int ce = 0;
		int os = -1;
		int oe = -1;

		for(int i = 0;i<n;i++){
			long prev = train + a[i];
			long startnew = a[i];
			
			if(startnew > prev){
				train = startnew;
				cs =i;
			}else train = prev;
			
			if(train > res){
				res = train;
				os = cs;
				oe = ce;
			}
			ce++;
		}
		System.out.println(os+" "+oe); //comment this line 
		return res;
		
    }
}