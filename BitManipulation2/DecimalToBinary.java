import java.util.*;
import java.io.*;

class Main{
	public static void main(String [] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		
        int N = sc.nextInt();
        Solution obj = new Solution();
        obj.toBinary(N);
        System.out.println();
    
	}
}

class Solution{
	void toBinary(int N) {
		//Write your code here
		String s ="";
		// while(N>0){
		// 	s = ( N & 1) + s;
		// 	N>>=1;
		// }

		while(N>0){
			s = (N%2) + s;
			N/=2;
		}
		System.out.println(s);
	}
}









