import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;
import java.lang.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class Main {

    static void printLevelOrder(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {

            Node tempNode = queue.poll();
            System.out.print(tempNode.data + " ");

            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i)
            arr[i] = sc.nextInt();
        Solution Obj = new Solution();
        Node ans = Obj.bstFromLevel(arr, n);
        printLevelOrder(ans);
        sc.close();
    }
}

class Solution {
	class Pair{
		Node parent;
		int lower;
		int upper;
		Pair(Node parent,int lower,int upper){
			this.parent = parent;
			this.lower = lower;
			this.upper = upper;
		}
	}
	
    Node bstFromLevel(int arr[], int n) {
        // write code here
		Queue<Pair> q = new LinkedList<>();
		Node root = new Node(arr[0]);//the 0th index of a node will have the root data
		int idx = 1;//idx points to the next person we want to place in the tree

		q.add(new Pair(root, Integer.MIN_VALUE, root.data-1));//root's left child container
		q.add(new Pair(root, root.data+1,Integer.MAX_VALUE));

		while(q.size()>0){
			Pair curr = q.remove();
			//i want to place arr[idx]
			//but if idx == arr.length, this means im having no more people left
			if(idx == arr.length) continue;
			else if(arr[idx] < curr.lower || arr[idx] > curr.upper) continue;//if we are out of bounds, continue

			//we are in the bounds, and curr.parent will be the parent of arr[idx]
			Node nn= new Node(arr[idx]);
			//i have to decide if nn  is left child or right child
			if(nn.data < curr.parent.data) curr.parent.left = nn;//nn will go in the left side of parent
			else curr.parent.right = nn;
			//we have successfully placed the node, we should increment idx
			idx++;
			//nn can also be a potential parent for the future elements
			q.add(new Pair(nn,curr.lower,nn.data-1));//left child for nn
			q.add(new Pair(nn,nn.data+1,curr.upper));//right
		}

		return root;
    }
}















