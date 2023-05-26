import java.util.*;

class test {

  public static void printBinary(int n) {
    String s = "";
    int nn = n;
    int i = 0;
    while (i < 32) {
      s = (n & 1) + "" + s;
      n >>= 1;
      i++;
    }
    System.out.println(s+" : "+nn);
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = Integer.MAX_VALUE;
    int i = 0;
    while(i<32){
        printBinary((n<<i));
        i++;
    }
    
    scn.close();
  }
}
