import java.util.*;
class SelectionSort{
	void sort(int A[],int n){
		int temp = 0;
		int largestEle=0;
		int j = 0;
		int largestIndex = 0;
		for(int i=0; i<n; i++){
			j=0;
			largestEle = A[j];
			largestIndex = j;
			// Find the largest element
			for(j=1; j<n-i; j++){
				if(A[j] > largestEle){
					largestEle = A[j];
					largestIndex = j;
				}
			}
			// swap elements at index largestIndex and index2
			int index2 = j-1;
			temp = A[largestIndex];
			A[largestIndex] = A[index2];
			A[index2] = temp;
		}
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
		
		SelectionSort obj = new SelectionSort();
		obj.sort(A,numElements);
		
		System.out.println("Here are the sorted elements: ");
		for(int i=0; i<numElements; i++){
			System.out.print(" "+ A[i]);
		}
	}
}