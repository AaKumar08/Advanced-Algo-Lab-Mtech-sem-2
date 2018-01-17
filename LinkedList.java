public class LinkedList{
	Node head = null;
	static class Node{
		int data;
		Node next;
		
		Node(){
			next = null;
		}
	}
	
	void insertAtFirst(Node node, int data){
		if(head == null){
			head = node;
			node.data = data;
		}
		else{
			node.next = head;
			node.data = data;
			head = node;
		}			
	}
	
	void insertAtEnd(Node node, int data){
		if(head == null){
			head = node;
			node.data = data;
		}
		else{
			 // traverse till last node
			 Node ptr = head;
			 while(ptr.next!=null){
				 ptr = ptr.next;
			 }
			 ptr.next = node;
			 node.data = data;
		}	
	}
	
	void removeStart(){
		if(head == null){
			return;
		}
		else{
			Node ptr = head;
			head = head.next;
			ptr.next = null;	
		}
	}
	
	void remove(int data){
		if(head==null){
			return;
		}
		else{
			Node s1 = head;
			Node s2 = head.next;
			
			if(s1!=null && s2 == null){
				if(s1.data==data){
					head = null;
				}
			}
			else if(s1!=null && s2 != null){
				if(s1.data == data){
					head = s1.next;
					s1.next = null;
					return;
				}
				while(s2!=null && s2.data != data){
					s1 = s2;
					s2 = s2.next;
				}
				if(s2!=null){
					if(s2.data == data){
					s1.next = s2.next;
					s2.next = null;
				}
				}
					
			}
			
		}
	}
	void display(){
		Node ptr = head;
		if(ptr != null){
			while(ptr!=null){
				System.out.print(ptr.data + " ");
				ptr=ptr.next;
			}
		}
	}
	public static void main(String[] args){
		LinkedList ls = new LinkedList();
		Node node = new Node();
		ls.insertAtFirst(node, 10);
		
		node = new Node();
		ls.insertAtEnd(node, 12);
		
		node = new Node();
		ls.insertAtEnd(node, 15);
		
		node = new Node();
		ls.insertAtFirst(node, 6);
		ls.display();
		System.out.println("");
		
		ls.removeStart();
		
		ls.display();
		
		System.out.println("");
		ls.remove(10);
		
		ls.display();
		System.out.println("");
		
	}
}