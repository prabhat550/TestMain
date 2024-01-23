package The_Circular_Linked_List_Implementation;

public class CircularLinkedList {

	Node last;
	int length;

	public CircularLinkedList() {
		last = null;
		length = 0;
	}

	public int length() {
		return length;
	}

	public boolean isEmpty() {
		if (length == 0) {
			return true;
		}
		return false;
	}

	public void createCircularLinkedList() {

		Node node1 = new Node(3);
		Node node2 = new Node(4);
		Node node3 = new Node(5);
		Node node4 = new Node(6);
		Node node5 = new Node(7);

		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		node4.setNext(node5);
		node5.setNext(node1);

		last = node5;

	}

	// Insert At The Start
	public void insertAtTheStart(int data) {

		Node node = new Node(data);
		if (last == null) {
			last = node;
		} else {
			node.next = last.next;
		}
		last.next = node;
		length++;

	}

	// Insert At The End
	public void insertAtTheEnd(int data) {
		Node node = new Node(data);
		if(last == null) {
			last = node;
			node.next= last.next;
		}

	}

	public void displayElements() {

		if (last == null) {
			return;
		}

		Node node1 = last.next;
		while (node1 != last) {
			System.out.print(node1.data + " ");
			node1 = node1.next;
		}
		System.out.println(node1.data);

	}

}
