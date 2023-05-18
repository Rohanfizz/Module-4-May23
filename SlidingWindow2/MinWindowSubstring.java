import java.io.*;
import java.util.*;

class Solution {

	
	public boolean isValid(int[] wfreq,int[] ideal){
		for(int i = 0;i<123;i++){
			if(ideal[i] > wfreq[i]) return false; //window is invalid, i should expand and have more number of people in wfreq
		}
		return true;
	}
	
    public String minWindow(String s, String t) {
		// write code here
		int[] wfreq = new int[123];//keeps track of freq of chars in window
		int[] ideal = new  int[123]; //keep the track of freq of chars in t

		for(int i = 0;i<t.length();i++){
			ideal[t.charAt(i)]++;
		}

		int sp = 0;
		int ep = 0;
		int ans = s.length(); //length of the smallest substring
		int osp = 0;
		int oep = s.length()-1;

		while(ep<s.length()){
			//introduce
			wfreq[s.charAt(ep)]++;
			//while the  window  is valid, consider for the ans, and shrink
			while(isValid(wfreq,ideal)){
				//consider curr window for the answer
				if(ep-sp+1 < ans){
					ans = ep-sp+1;
					osp = sp;
					oep = ep;
				}
				wfreq[s.charAt(sp)]--;
				sp++;
			}
			//i am sure that window will be having a deficit of characters
			ep++;
		}
		
		return s.substring(osp,oep+1);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s,t;
        s = sc.next();
		t = sc.next();
        Solution Obj = new Solution();
        System.out.print(Obj.minWindow(s,t));
    }
}