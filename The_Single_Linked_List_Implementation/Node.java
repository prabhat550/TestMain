package The_Single_Linked_List_Implementation;

public class Node {

	private int data;
	private Node next;
	
	public Node() {
		super();
	}
	
	public Node(int data) {
		super();
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

}
