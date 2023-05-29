import java.util.*;

class Solution {
    public static int solve(List<List<Integer>> A) {
    // Write your code here
		//sorting on the basis of starting point
		Collections.sort(A,(a,b)->{
			return a.get(0) - b.get(0);
		});

		int psp = -1;
		int pep = -1;
		int cnt = 0;

		for(List<Integer> interval : A){
			int csp = interval.get(0);
			int cep = interval.get(1);
			//i will detect if this curr interval is overlapping with the prev interval
			if(csp<=pep){
				//now the intervals are overlapping
				//this means  i have to choose one of them
				//i will choose the interval which is having a smaller ep
				if(cep < pep){
					psp = csp;
					pep = cep;
				}
				//i will not increase the count since im making a choice.
			}else{
				//the intervals are not overlapping
				//i can safely select the curr interval as my next interval
				psp = csp;
				pep = cep;
				cnt++; //because i have introduced a new interval
			}
		}
		return cnt;
	}
}
public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<List<Integer>> A = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            List<Integer> interval = Arrays.asList(a, b);
            A.add(interval);
        }
        int ans = Solution.solve(A);
        System.out.println(ans);
    }
}
