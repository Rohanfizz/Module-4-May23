import java.util.*;

class Solution {

	public int longestSubstringXuniqueRepK(String s,int x,int k){
		//i should return the length of longest substring having
		//exactly x unique characters and all of them should be occuring at least k times
		int charAtLeastKTimes = 0;
		int uniqueCharacters = 0;
		int sp = 0;
		int ep = 0;
		int ans= 0;
		int[] freq = new int[123];
		
		while(ep<s.length()){
			//introduction
			freq[s.charAt(ep)]++;
			if(freq[s.charAt(ep)] == 1) uniqueCharacters++;
			if(freq[s.charAt(ep)] == k) charAtLeastKTimes++;
			//shrink until invalid
			while(uniqueCharacters > x){
				freq[s.charAt(sp)]--;
				if(freq[s.charAt(sp)] == 0) uniqueCharacters--;
				if(freq[s.charAt(sp)] == k-1) charAtLeastKTimes--;
				sp++;
			}
			//consider for answer
			if(uniqueCharacters == x && charAtLeastKTimes==x) ans = Math.max(ans,ep-sp+1);
			//expand
			ep++;
		}
		return ans;
	}

    public int longestSubstring(String s, int k) {
        // write code here
		int ans = 0;
		for(int unique = 1;unique<=26;unique++){
			ans = Math.max(ans,longestSubstringXuniqueRepK(s,unique,k));
		}
		return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
        Solution Obj =  new Solution();
        System.out.println(Obj.longestSubstring(str,k));
    }
}
