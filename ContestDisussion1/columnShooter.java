import java.io.*;
import java.util.*;

class Main {
	//https://course.acciojob.com/idle?question=23f95909-3061-4171-9c68-2a49d6bce307
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = input.nextInt();
        }
        System.out.println(maxScore(heights));
    }

    public static int maxScore(int[] arr) {

        Stack<Integer> st = new Stack<>();
		int ans = 0;
		int[] ngel = new int[heights.length];
		for(int i = 0;i<heights.length;i++){
			while(st.size() > 0 && heights[st.peek()] <= heights[i]){
				 st.pop();
			}
			
			if(st.size() == 0) ngel[i] = -1;
			else ngel[i] = st.peek();

			st.push(i);
		}

		for(int i = 0;i<ngel.length;i++){
			if(ngel[i] == -1) continue;
			int distance = i-ngel[i];
			int diff = heights[ngel[i]] - heights[i];
			int score = diff*distance;
			ans = Math.max(ans,score);
		}
		
		return ans;
    }

}
