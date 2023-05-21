import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        Solution s = new Solution();
        int[] ans = s.bestProducts(arr);
        for (int i = 0; i < m; i++) {
            System.out.println(ans[i]);
        }
    }
}

class Solution {
    public static int[] bestProducts(int[][] arr) {
       // Write your code
		//https://course.acciojob.com/idle?question=a83c0071-ae7b-4bd4-9fdf-7a5b4081f79c
		int days = arr.length;
		int n = arr[0].length;
		int bestIdx  = 0;
		for(int i = 0;i<n;i++){
			if(arr[0][bestIdx] < arr[0][i]) bestIdx = i;
		}
		int[] res = new int[days];
		res[0] = bestIdx;
		for(int i = 1;i<days;i++){
			for(int j = 0;j<n;j++){
				arr[i][j] +=arr[i-1][j];
				if(arr[i][bestIdx] < arr[i][j]) bestIdx = j;
			}
			//after deciding the ans for ith row
			res[i] = bestIdx;
		}
		return res;
    }
}




