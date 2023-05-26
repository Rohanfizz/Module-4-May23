import java.util.*;

class Accio{

	static int countSetBits(int x){
		int cnt = 0;
		while(x > 0){
			x = (x & (x-1));
			cnt++;
		}
		return cnt;
	}
	
    static int HammingDistance(int a,int b){
        //write code here
		int x = a^b;
		return countSetBits(x);
    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        Accio obj = new Accio();
        int ans=obj.HammingDistance(a,b);
        System.out.println(ans);
    }
}
