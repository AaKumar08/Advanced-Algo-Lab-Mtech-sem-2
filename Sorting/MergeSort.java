import java.util.*;
class MergeSort{
	static int B[] = new int[8];
	void sort(int A[],int p, int q){
		
		if(p==q){
			return;
		}
		else{
			// divide
			int mid = (q-p)/2 + p;
			sort(A,p,mid);
			sort(A,mid+1,q);
		
			// combine 
			merge(A,p,mid,q);
		}
	}
	void merge(int A[], int p, int mid, int q){
		int i=p,j=mid+1, k = p;
		
		while((i<=mid)&&(j<=q)){
			if(A[i]>A[j]){
				B[k] = A[j];
				k = k + 1;
				j = j + 1;
			}
			else{
				B[k] = A[i];
				k = k + 1;
				i = i + 1;
			}
		}
		if((i<=mid)&&(j>q)){
			while(i<=mid){
				B[k] = A[i];
				k = k + 1;
				i = i + 1;
			}
		}
		else{
			while(j<=q){
				B[k] = A[j];
				k = k + 1;
				j = j + 1;
			}
		}
		// Copying back result to A
		for(int m=p; m<=q; m++)
			A[m] = B[m];
	}
	public static void main(String[] args){
		int n=8;
		int A[] = new int[n];
		// Enter the elements
		Scanner scan = new Scanner(System.in);
		System.out.println("\nEnter eight elements to sort: ");
		for(int i=0;i<n;i++){
			A[i] = scan.nextInt();
		}
		MergeSort obj = new MergeSort();
		obj.sort(A,0,n-1);
		System.out.println("\nSorted elements are: ");
		for(int i=0;i<n;i++){
			System.out.print(" "+B[i]);
		}
	}
}