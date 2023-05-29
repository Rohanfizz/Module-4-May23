import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        String inputLine[] = br.readLine().trim().split(" ");
    
        int n = Integer.parseInt(inputLine[0]);
        Job[] arr = new Job[n];
        inputLine = br.readLine().trim().split(" ");
        
        //adding id, deadline, profit
        for(int i=0, k=0; i<n; i++){
            arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
        }
        
        Solution ob = new Solution();
        
        //function call
        int[] res = ob.solve(arr, n);
        System.out.println (res[0] + " " + res[1]);
    
    }
}

class Solution
{
    
    int[] solve(Job arr[], int n){
        // Your code here
		//Sort the array in descending order of jobs
		//so that the better paying job is placed first
		Arrays.sort( arr , (a,b)->{
			return b.profit - a.profit;
		});

		//Start placing jobs
		boolean[] day = new boolean[5005];

		int cnt =0;
		int profit = 0;

		for(Job curr:arr){

			int i = curr.deadline;
			while(i>0){
				if(day[i] == false){
					day[i] = true;
					cnt++;
					profit+=curr.profit;
					break;
				}
				i--;
			}
		}
		int[] res = new int[2];
		res[0] = cnt;//number of jobs done
		res[1] = profit;//total profit accumulated
		return res;

    }
}











