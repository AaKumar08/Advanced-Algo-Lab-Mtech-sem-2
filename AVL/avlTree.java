public class avlTree{
	
	
	
	// Creating a nil node 
	static Node nil = new Node(-1);
	
	
	// Blueprint for Node class
	static class Node{
		int key;
		Node left;
		Node right;
		Node parent;
		int height;
		
		Node(int key){
			this.key = key;
			this.left = null;
			this.right = null;
			this.parent = null;
			this.height = -1;
		}
	}
	
	// Method to find height of a node
	static int heightNode(Node root){
		int hLeftChild = 0;
		int hRightChild = 0;
		int h = -2;
		
		if(root==nil)
			return -1;
		else if(root.left==nil && root.right==nil)
			return 0;
		else{
			hLeftChild = heightNode(root.left);
			hRightChild = heightNode(root.right);
			if(hLeftChild > hRightChild)
				h = hLeftChild+1;
			else if(hLeftChild < hRightChild)
				h = hRightChild+1;
		}
		// updating height as we trace back
		root.height = h;
		return h;
	}
	
	// Method to left rotate
	Node leftRotate(Node root, Node x){
		Node y = x.right; 				//set y
		
		x.right = y.left;				// turns y's left subtree into x's right subtree
		if(y.left!=nil)
			y.left.parent = x;
		y.parent = x.parent;			// link x'parent to y's parent
		if(x.parent==nil)
			root = y;
		else if(x == x.parent.left)
			x.parent.left = y;
		else
			x.parent.left = y;
		y.left = x;					// put x on y's left
		x.parent = y;
		
		return root;
	}
	
	// Method to right rotate
	Node rightRotate(Node root, Node y){
		Node x = y.left; 				//set x
		
		y.left = x.right;				// turns x's right subtree into y's left subtree
		if(x.right!=nil)
			x.right.parent = y;
		x.parent = y.parent;			// link y'parent to x's parent
		if(y.parent==nil)
			root = x;
		else if(y == y.parent.right)
			y.parent.right = x;
		else
			y.parent.right = x;
		x.right = y;					// put y on x's right
		y.parent = x;
		
		return root;
	}
	// Method for searching a key
	Node search(Node root, int key){
		if((root == nil)||(key == root.key)){
			return root;
		}
		if(key > root.key)
			return search(root.right, key);
		else
			return search(root.left, key);
	}
	
	Node insert(Node root, int key){
		Node y = nil;
		Node x = root;
		
		while(x!=nil){
			y = x;
			if(key < x.key)
				x = x.left;
			else
				x = x.right;
		}
		Node z = new Node(key);
		z.parent = y;
		
		z.left = nil;
		z.right = nil;
		
		if(y==nil){
			root = z;
		}
		else if(z.key < y.key)
			y.left = z;
		else
			y.right = z;
		
		heightNode(root);
		return root;
	}
	
	// avlInsert 
	Node insertAVL(Node root, int key){
		root = insert(root,key);
		
		Node z = search(root,key);
		Node current = z;
		Node currentParent = z.parent;
		Node currentGp = currentParent.parent;
		int hLeftChild = 0;
		int hRightChild = 0;
		int balanceFactorGP =0;
		if(currentGp!=null && currentParent!=null){
			while(currentGp!=root){
				// Calculating balance factor of grandparent
				hLeftChild = currentGp.left.height;
				hRightChild = currentGp.right.height;
				balanceFactorGP = hLeftChild - hRightChild;
				
				if((balanceFactorGP==-1)||(balanceFactorGP==0)||(balanceFactorGP==1)){
					current = currentParent;
					currentParent = currentGp;
					currentGp = currentGp.parent;
				}
				else
					break;
			}
		}
		if(currentGp==root)
			return root;
		else{
				// perform rotations
				if((currentGp.left==currentParent)&&(currentGp.left.left==current)){
					root = rightRotate(root,currentGp);
				}
				else if((currentGp.right==currentParent)&&(currentGp.right.right==current))
					root = leftRotate(root,currentGp);
				else if((currentGp.left==currentParent)&&(currentGp.left.right==current)){
					root = leftRotate(root,currentParent);
					root = rightRotate(root,currentParent);
				}
				else if((currentGp.right==currentParent)&&(currentGp.right.left==current)){
					root = rightRotate(root,currentParent);
					root = leftRotate(root,currentParent);
				}
			}
		
		return root;
	}
	
	// avlInsert 
	Node z = nil;
	Node deleteAVL(Node root, int key){
		root = delete(root,key);
		
		//Node z = search(root,key);
		
		// updating the heights of z's parent
		if(z.parent!=nil){
			z.parent.height = heightNode(z.parent);
			
			// checking if the bst property is violated at the parent or not
			Node p = z.parent;
			
			int hLeftChild = p.left.height;
			int hRightChild = p.right.height;
			int balanceFactorP = hLeftChild - hRightChild;
			if((balanceFactorP==-1)||(balanceFactorP==0)||(balanceFactorP==1)){
				return root;
			}
			else{
				if((p.left!=nil)&&(p.left.left!=nil)){
					root = rightRotate(root,p);
				}
				else if((p.right!=nil)&&(p.right.right!=nil))
					root = leftRotate(root,p);
				else if((p.right!=nil)&&(p.right.left!=nil)){
					root = leftRotate(root,z.parent.left);
					root = rightRotate(root,z.parent);
				}
				else if((p.left!=nil)&&(p.left.right!=nil)){
					root = rightRotate(root,z.parent.right);
					root = leftRotate(root,z.parent);
				}
			}
			
		}
		
		return root;
	}
	
	Node transplant(Node root, Node u, Node v){
		if(u.parent == nil){
			root = v;
		}
		else if(u == u.parent.left)
			u.parent.left = v;
		else
			u.parent.right = v;
		if(v!=nil)
			v.parent = u.parent;
		return root;
	}
	
	Node inorderSuccessor(Node r){
		Node start = r;
		while(r.left!=nil){
			r = r.left;
		}
		return r;
	}
	Node delete(Node root, int key){
		z = search(root,key);
		Node t = nil;
		
		if(z.left==nil){
			t = transplant(root,z,z.right);
			//z = nil;
		}
		else if((z.right==nil)&&(z!=nil)){
			t = transplant(root,z,z.left);
			//z = nil;
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
			 //z = nil;
		}
		return t;
	}
	
	// Display the avl
	void display(Node root){
		if(root == nil){
			return;
		}
		else{
			display(root.left);
			System.out.print(" "+ root.key);
			display(root.right);
		}
	}
	// Display the avl
	void display_height(Node root){
		if(root == nil){
			return;
		}
		else{
			display_height(root.left);
			System.out.print(" "+ root.height);
			display_height(root.right);
		}
	}
	public static void main(String[] args){
		Node root = nil;
		avlTree avl = new avlTree();
		
		// Inserting phase
		/*root = avl.insertAVL(root, 41);
		root = avl.insertAVL(root, 20);
		root = avl.insertAVL(root, 65);
		root = avl.insertAVL(root, 11);
		root = avl.insertAVL(root, 29);
		root = avl.insertAVL(root, 50);
		root = avl.insertAVL(root, 26);
		
		root = avl.insertAVL(root, 23);
		root = avl.insertAVL(root, 42);
		
		// Display
		avl.display(root);
		
		root = avl.deleteAVL(root, 11);
		// Display
		avl.display(root);
		*/
		root = avl.insertAVL(root, 25);
		System.out.println("root.key: "+root.key);
		
		root = avl.insertAVL(root, 29);
		System.out.println("root.key: "+root.key);
		root = avl.insertAVL(root, 24);
		System.out.println("root.key: "+root.key);
		
		
		root = avl.insertAVL(root, 26);
		System.out.println("root.key: "+root.key);
		//root = avl.insertAVL(root, 30);
		//root = avl.insertAVL(root, 31);
		
		// Display
		avl.display(root);
		
		//int ht = avl.heightNode(root.left);
		// printing heights of all the nodes
		//avl.display_height(root);
		
		// Printing root of the tree 
		System.out.println("root.key: "+root.key);
		System.out.println("root left : "+root.left.key);
		System.out.println("root right : "+root.right.key);
		
		System.out.println("");
		//root = avl.deleteAVL(root, 25);
		// Display
		//avl.display(root);
		
		
	}
}