import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class Main {
    static Node treeBuilder(String str){  
        if(str.length()==0 || str.charAt(0)=='-'){
            return null;
        }
        String ip[] = str.split(" ");
        Node root = new Node(Integer.parseInt(ip[0]));
        Queue<Node> queue = new LinkedList<>(); 
        queue.add(root);
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            Node currNode = queue.peek();
            queue.remove();
            String currVal = ip[i];
            if(!currVal.equals("-1")) {
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }
            i++;
            if(i >= ip.length)
                break;
            currVal = ip[i];
            if(!currVal.equals("-1")) {
                currNode.right = new Node(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root){
        if(root == null)
            return;
        printInorder(root.left);
        System.out.print(root.data+" ");
        printInorder(root.right);
    }
    
  public static void main (String[] args) throws IOException{
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          int t=Integer.parseInt(br.readLine());
          while(t > 0){
              String s = br.readLine();
            Node root = treeBuilder(s);
              Solution g = new Solution();
              if(g.isBST(root))
              System.out.println("true");
          else
              System.out.println("false");
                t--;
        }
    }
  
}

class Solution{
	class Helper{
		boolean isBst;
		int maxi;
		int mini;
		Helper(boolean isBst,int maxi,int mini){
			this.isBst = isBst;
			this.maxi = maxi;
			this.mini = mini;
		}
	}


	Helper dfs(Node root){
		if(root == null){
			return new Helper(true,Integer.MIN_VALUE,Integer.MAX_VALUE);
		}
		Helper left = dfs(root.left);
		Helper right = dfs(root.right);

		boolean isBst = left.isBst && right.isBst && root.data > left.maxi && root.data < right.mini;

		if(!isBst) return new Helper(isBst,-1,-1);
		int myMax = Math.max(root.data,right.maxi);
		int myMin = Math.min(root.data,left.mini);
		return new Helper(isBst,myMax,myMin);
	}
	
    boolean isBST(Node root){
       // Your Code Here
		Helper ans = dfs(root);
		return ans.isBst;
		
    }
}




