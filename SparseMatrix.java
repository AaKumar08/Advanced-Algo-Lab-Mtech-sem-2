import java.util.*;

class SparseMatrix{
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

		int arr[][] = new int[n][3];

		// Getting input from the user
		System.out.println("\nEnter the elements in format:\nElement row_index col_index: ");
		for(int i=0;i<n;i++){
			for(int j=0;j<3;j++){
				arr[i][j] = scan.nextInt();
			}
		}

		// printing sparse matrix
		System.out.print("\n Sparse matrix is :  \n");
		int ptr = 0;
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				if(i==arr[ptr][1] && j==arr[ptr][2]){
					System.out.print("  "+arr[ptr][0]);
					ptr = ptr+1;
				}
				else{
					System.out.print("  "+0);
				}
			}
			System.out.println(" ");
		}
	}
}
