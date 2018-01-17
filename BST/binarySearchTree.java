public class binarySearchTree{
	
	// Blueprint for Node class
	static class Node{
		int key;
		Node left;
		Node right;
		
		Node(int key){
			this.key = key;
		}
	}
	
	// Method for searching a key
	Node search(Node root, int key){
		if(root == null){
			return root;
		}
		else{
			if(key == root.key){
				return root;
			}
			else if(key > root.key){
				return search(root.right, key);
			}
			else if(key < root.key){
				return search(root.left, key);
			}
		}
		return root;
	}
	
	Node insert(Node root, int key){
		if(root == null){
			root = new Node(key);
		}
		else{
			if(root.key == key){
				return root;
			}
			else if(key > root.key){
				root.right = insert(root.right, key);
			}
			else if(key < root.key){
				root.left = insert(root.left, key);
			}
		}
		return root;
	}
	
	// To delete a node in the BST
	Node delete(Node root, int key){
		// t is reference of node to be deleted
		Node t = null;
		
		if(key == root.key){
			t = root;
		}
		else if(key < root.key){
			delete(root.left, key);
		}
		else if(key > root.key){
			delete(root.right, key);
		}
		
		
		// Case 1 : t having no child
		if(t.left==null && t.right==null){
			if(root.left.key==t.key)
				root.left = null;
			
			if(root.right.key==t.key)
				root.right = null;
		}
		
		// Case 2: t having one child 
		if(t.left!=null && t.right==null){
			if(root.left == t)
				root.left = t.left;
			else
				root.right = t.left;
		}
		if(t.left==null && t.right!=null){
			if(root.left == t)
				root.left = t.right;
			else
				root.left = t.right;
		}
		
		// Case 3: t having two child
		if(t.left!=null && t.right!=null){
			// r is reference of the node's inorder successor to be deleted
			Node r = null;
			
			r = inorderSuccessor(t.right);
			int v = r.key;
			
			// now delete inorderSuccessor
			delete(root,v);
			
			t.key = v;
			
		}
		return root;
	}
	Node inorderSuccessor(Node r){
		Node start = r;
		while(r.left!=null){
			r = r.left;
		}
		return r;
	}
	
	// Display the bst
	void display(Node root){
		if(root == null){
			return;
		}
		else{
			display(root.left);
			System.out.print(" "+ root.key);
			display(root.right);
		}
	}
	public static void main(String[] args){
		Node root = null;
		binarySearchTree bst = new binarySearchTree();
		// Inserting phase
		root = bst.insert(root, 50);
		root = bst.insert(root, 30);
		root = bst.insert(root, 70);
		root = bst.insert(root, 20);
		root = bst.insert(root, 40);
		root = bst.insert(root, 60);
		root = bst.insert(root, 80);
		
		// Display
		bst.display(root);
		
		// Deleting phase
		root = bst.delete(root, 20);
		
		// Display
		System.out.println("");
		bst.display(root);
		
		//root = bst.delete(root, 30);
		
		// Display
		//bst.display(root);
		
		//root = bst.delete(root, 70);
		
		// Display
		//bst.display(root);
		
		
	}
}