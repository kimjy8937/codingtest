import java.util.*;

class Solution {
    public static ArrayList<Node> nodeList = new ArrayList<>();
	public static int index = 0;
    
    public int[][] solution(int[][] nodeinfo) {
		for(int i = 0; i < nodeinfo.length; i++) {
			nodeList.add(new Node(i+1, nodeinfo[i][0], nodeinfo[i][1]));
		}
		Collections.sort(nodeList);
		
		Node root = nodeList.get(0);
		
		for(int i = 1; i < nodeList.size(); i++) {
			Node child = nodeList.get(i);
			connectNode(root, child);
		}
		
		int[][] answer = new int[2][nodeList.size()];
	
		preOrder(answer, root);
		index = 0;

		postOrder(answer, root);

		return answer;
    }
    
	public static void connectNode(Node parent, Node child) {
		if(child.x < parent.x) {
			if(parent.left == null) {
				parent.left = child;
			} else {
				connectNode(parent.left, child);
			}
		} else {
			if(parent.right == null) {
				parent.right = child;
			} else {
				connectNode(parent.right, child);
			}
		}
	}
	
	public static void preOrder(int[][] arr, Node node) {
		if(node != null) {
			arr[0][index++] = node.data;
			if(node.left != null) preOrder(arr, node.left);
			if(node.right != null) preOrder(arr, node.right);
		}
	}

	public static void postOrder(int[][] arr, Node node) {
		if(node != null) {
			if(node.left != null) postOrder(arr, node.left);
			if(node.right != null) postOrder(arr, node.right);
			arr[1][index++] = node.data;
		}
	}
}

class Node implements Comparable<Node>{
	int data;
	int x;
	int y;
	Node left;
	Node right;


	Node(int data, int x, int y){ 
		this.data = data;
		this.x = x;
		this.y = y;
	}
	
	@Override
    public int compareTo(Node n) {
        return n.y - this.y;
    }
}