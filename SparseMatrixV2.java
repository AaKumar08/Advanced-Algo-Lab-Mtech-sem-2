import java.util.*;

class SparseMatrixTwo{
	static class node{
		int value;
		int row_index;
		int col_index;
		node next;
	}
	static node start = null;
	static node insertAtLast(node newNode,node start){
		node ptr = start;
		if(start==null){
			start = newNode;
		}
		else{
			while(ptr.next!=null){
				ptr = ptr.next;
			}
			ptr.next = newNode;
		}
		return start;
	}
			
	public static void main(String[] args){
		int n=0;
		int row=0,col=0;
		System.out.println("\nEnter number of elements: ");
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();

		System.out.println("\nEnter number of rows: ");
		row = scan.nextInt();

		System.out.println("\nEnter number of columns: ");
		col = scan.nextInt();

		//int arr[][] = new int[n][3];

		// Getting input from the user
		int data=0;
		node newNode = null;
		
		System.out.println("\nEnter the elements in format:\nElement row_index col_index: ");
		for(int i=0;i<n;i++){
				data = scan.nextInt();
				// Creating a new node
				newNode = new node();
				newNode.value = data;
				newNode.row_index = scan.nextInt();
				newNode.col_index = scan.nextInt();
				start = insertAtLast(newNode,start);
		}

		// printing sparse matrix
		System.out.print("\n Sparse matrix is :  \n");
		node ptr = start;
		
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				if(ptr!=null && i==ptr.row_index && j==ptr.col_index){
					System.out.print("  "+ptr.value);
					ptr = ptr.next;
				}
				else{
					System.out.print("  "+0);
				}
			}
			System.out.println(" ");
		}
	}
}
