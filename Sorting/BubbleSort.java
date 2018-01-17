import java.util.*;
class BubbleSort{
	void sort(int A[],int n){
		int temp=0;
		for(int i=0; i<n-1; i++){
			for(int j=0; j<n-i-1; j++){
				if(A[j]>A[j+1]){
					// swap
					temp = A[j];
					A[j] = A[j+1];
					A[j+1] = temp;
				}
			}
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
		
		BubbleSort obj = new BubbleSort();
		obj.sort(A,numElements);
		
		System.out.println("Here are the sorted elements: ");
		for(int i=0; i<numElements; i++){
			System.out.print(" "+ A[i]);
		}
	}
}