import java.util.*;

public class Main {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

	public static class Pair{
		TreeNode node;
		int state;
		Pair(TreeNode node,int state){
			this.node = node;
			this.state = state;
		}
	}

	public static TreeNode getNextInorder(Stack<Pair> st){
		while(st.size()>0){
			Pair top = st.peek();
			if(top.state == 1){//this is the first time , add to pre and go to left
				//preorder
				top.state++;
				if(top.node.left != null) st.push(new Pair(top.node.left,1));
				
			}else if(top.state == 2){//this is the second time, add to in and go to right
				//inorder
				top.state++;
				if(top.node.right != null) st.push(new Pair(top.node.right,1));
				return top.node;
			}else{//this is the third time, add to post and remove
				//post
				st.pop();
			}
		}
		return null;
	}
	
    public static void recoverTree(TreeNode root) {
        //Write code here
		
		Stack<Pair> st = new  Stack<>();
		st.push(new Pair(root,1));

		TreeNode curr = getNextInorder(st);//curr will point to the first person in inorder
		TreeNode prev = null;

		TreeNode a = null;
		TreeNode b = null;

		while(curr != null){
			if(prev == null){
				prev = curr;
				curr = getNextInorder(st); 
			}else{
				if(prev.val > curr.val){
					//invalid pair
					if(a == null) a = prev;//only once, a will get updated
					b = curr; //b will get updated in the first pair and second pair as well
				}
				prev = curr;
				curr = getNextInorder(st); 
			}
		}
		
		int temp = a.val;
		a.val = b.val;
		b.val = temp;
    }

    // input_section=================================================

    public static void display(TreeNode node) {
        if (node == null)
            return;

        StringBuilder sb = new StringBuilder();
        sb.append((node.left != null ? node.left.val : "."));
        sb.append(" -> " + node.val + " <- ");
        sb.append((node.right != null ? node.right.val : "."));

        System.out.println(sb.toString());

        display(node.left);
        display(node.right);

    }

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
            IDX[0]++;
            return null;
        }

        TreeNode node = new TreeNode(arr[IDX[0]++]);
        node.left = createTree(arr, IDX);
        node.right = createTree(arr, IDX);

        return node;
    }

    public static void solve() {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int[] IDX = new int[1];
        TreeNode root = createTree(arr, IDX);
        recoverTree(root);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}