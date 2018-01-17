import java.util.*;

public class BFS{
	public static void main(String args[]){
		//Dear user enters the number of vertices in the graph
		Scanner scan = new Scanner(System.in);
		System.out.println("\nEnter number of vertices: ");
		int N = scan.nextInt(); 		// Number of vertices
		
		
		HashMap<String, LinkedList> graph = new HashMap<>();
		scan.nextLine();
		for(int i=0; i<N; i++){
			
			// 1. Creating Linked List for vertex i
			System.out.println("\nEnter neighbour values (space separated)of vertex: "+i);
			
			String neighbourString = scan.nextLine();
			String[] neighbourList = neighbourString.split(" ");
			
			LinkedList<String> neighbours = new LinkedList<String>();
			// 1.1 Now adding the neighbours of vertex i in its linked list
			for(int j=0; j<neighbourList.length; j++){
				neighbours.add(neighbourList[j]);
			}
			
			// 1.2 Now adding <i,neighbours> in the hashMap, graph
			graph.put(Integer.toString(i),neighbours);
		}
		
		System.out.println(graph);
	}
}