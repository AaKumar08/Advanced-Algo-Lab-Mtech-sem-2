import java.util.*;
class InsertionSort{
	void sort(int A[],int n){
		int temp=0;
		int i,j;
		int element=0;
		int index2=0;
		for(i=0; i<n-1; i++){
			element = A[i+1];
			index2 = i+1;
			for(j=i; j>-1; j--){
				if(element<A[j]){
					//swap 
					temp = A[j];
					A[j] = element;
					A[index2] = temp;
					index2 = j;
				}
			}
		}
	}
	public static void main(String[] args){
		int numElements = 0;
		System.out.println("Please enter number of elements you want to enter: ");
		Scanner scan = new Scanner(System.in);
		
		numElements = scan.nextInt();
		
		System.out.println("Now enter the elements: ");
		int A[] = new int[numElements];
		for(int i=0; i<numElements; i++){
			A[i] = scan.nextInt();
		}
		
		InsertionSort obj = new InsertionSort();
		obj.sort(A,numElements);
		
		System.out.println("Here are the sorted elements: ");
		for(int i=0; i<numElements; i++){
			System.out.print(" "+ A[i]);
		}
	}
}