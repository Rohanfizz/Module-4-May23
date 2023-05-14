import java.util.Scanner;

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

	public static int idx;

	public static TreeNode dfs(int l,int u,int[] pre){
		if(idx == pre.length) return null;
		if(l > u) return null;
		if(pre[idx] < l || pre[idx] > u) return null;
		//if im standing on this line, i should be placed here
		TreeNode nn  = new TreeNode(pre[idx]);
		idx++;//because idx value has been used.
		nn.left = dfs(l,nn.val-1,pre);
		nn.right = dfs(nn.val+1,u,pre);
		return nn;
	}
	
    public static TreeNode CreateTree(int n,int[] preOrder) {
        // Write Your Code here
		idx = 0;
		TreeNode root = dfs(Integer.MIN_VALUE,Integer.MAX_VALUE,preOrder);
		return root;
    }

    // input_section=================================================

    public static void display(TreeNode node) {
        if (node == null) return;
        StringBuilder sb = new StringBuilder();
        sb.append((node.left != null ? node.left.val : "."));
        sb.append("->" + node.val + "<-");
        sb.append((node.right != null ? node.right.val : "."));
        System.out.println(sb.toString());
        display(node.left);
        display(node.right);

    }

    public static void solve() {
        int n = scn.nextInt();
        int[] pre = new int[n];
        for (int i = 0; i < n; i++)
            pre[i] = scn.nextInt();

        TreeNode root = CreateTree(n,pre);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}