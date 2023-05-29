import java.io.*;
import java.lang.*;
import java.util.*;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

public class Main {
    
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        Item arr[] = new Item[n];
        for(int i=0;i<n;i++) {
            int value = sc.nextInt();
            arr[i] = new Item(value,0);
        }
        for(int i=0;i<n;i++) {
            arr[i].weight = sc.nextInt();
        }
        double ans = (new Solution()).fractionalKnapsack(w,arr,n);
        System.out.println(String.format("%.2f",ans));
    }
}// } Driver Code Ends


/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/


class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int cap, Item arr[], int n) {
       // Write your code here
		Arrays.sort(arr,(a,b)->{
			double perKgA = 1.0*(a.value / (1.0*a.weight));
			double perKgB = 1.0*(b.value/(1.0*b.weight));
			if(perKgA >= perKgB){
				return -1;
			}else return 1;
		});

		double total = 0.0;
		for(Item curr: arr){
			if(cap > curr.weight){
				//i can engulf this whole item into my knapsack
				total+=curr.value;
				cap -= curr.weight;
			}else{
				double perKg = 1.0 * (curr.value/(1.0*curr.weight));
				total += 1.0*(cap * (1.0*perKg));
				break; //because my capacity will become zero
			}
		}
		return total;
    }











	
}