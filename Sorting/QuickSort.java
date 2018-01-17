import java.util.*;
class QuickSort{
	
	void sort(int A[],int p, int q){
		int mid=0;
		
		// Question: Why p<=q not used as if Condition?
		if(p<q){
			mid = partition(A,p,q);
			sort(A,p,mid-1);
			sort(A,mid+1,q);
		}
	}
	int partition(int A[], int p, int q){
		int i=-1;
		int j=0;
		int n=q-p+1;
		int pivot = A[p];
		int temp = 0;
		
		int pivotIndex = p;
		
		for(j=0; j<n; j++){
			if(pivot>A[j]){
				i=i+1;
				//swap 
				temp = A[i];
				A[i] = A[j];
				A[j] = temp;
				pivotIndex = j;
			}
		}	
		return pivotIndex;
	}
	public static void main(String[] args){
		int numElements = 0;
		System.out.println("Dear user!!, please enter number of elements you want to enter: ");
		Scanner scan = new Scanner(System.in);
		
		numElements = scan.nextInt();
		
		System.out.println("Now enter the elements: ");
		int A[] = new int[numElements];
		for(int i=0; i<numElements; i++){
			A[i] = scan.nextInt();
		}
		
		QuickSort obj = new QuickSort();
		obj.sort(A,0,numElements-1);
		
		System.out.println("Here are the sorted elements: ");
		for(int i=0; i<numElements; i++){
			System.out.print(" "+ A[i]);
		}
	}
}