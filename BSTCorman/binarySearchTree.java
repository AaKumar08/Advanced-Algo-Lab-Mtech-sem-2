public class binarySearchTree{
	
	// Blueprint for Node class
	static class Node{
		int key;
		Node left;
		Node right;
		Node parent;
		
		Node(int key){
			this.key = key;
		}
	}
	
	// Method for searching a key
	Node search(Node root, int key){
		if((root == null)||(key == root.key)){
			return root;
		}
		if(key > root.key)
			return search(root.right, key);
		else
			return search(root.left, key);
	}
	
	Node insert(Node root, int key){
		Node y = null;
		Node x = root;
		
		while(x!=null){
			y = x;
			if(key < x.key)
				x = x.left;
			else
				x = x.right;
		}
		Node z = new Node(key);
		z.parent = y;
		
		if(y==null){
			root = z;
		}
		else if(z.key < y.key)
			y.left = z;
		else
			y.right = z;
		
		return root;
	}
	
	Node transplant(Node root, Node u, Node v){
		if(u.parent == null){
			root = v;
		}
		else if(u == u.parent.left)
			u.parent.left = v;
		else
			u.parent.right = v;
		if(v!=null)
			v.parent = u.parent;
		return root;
	}
	
	Node inorderSuccessor(Node r){
		Node start = r;
		while(r.left!=null){
			r = r.left;
		}
		return r;
	}
	Node delete(Node root, int key){
		Node z = search(root,key);
		Node t = null;
		
		if(z.left==null){
			t = transplant(root,z,z.right);
			z = null;
		}
		else if((z.right==null)&&(z!=null)){
			t = transplant(root,z,z.left);
			z = null;
		}
		else{
			 Node y = inorderSuccessor(z.right);
			 if(y.parent!=z){
				 t = transplant(root,y,y.right);
				 y.right = z.right;
				 y.right.parent = y;
			 }
			 t = transplant(root,z,y);
			 y.left = z.left;
			 y.left.parent = y;
			 z = null;
		}
		return t;
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
		
		root = bst.delete(root, 30);
		
		// Display
		System.out.println("");
		bst.display(root);
		
		root = bst.delete(root, 70);
		
		// Display
		System.out.println("");
		bst.display(root);
		
		
	}
}