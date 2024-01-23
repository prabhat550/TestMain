package The_Single_Linked_List_Implementation;

public class Single_Linked_List_Impl {

	Node head;
	int size;

	// Insert At The Tail
	public void insertAtTail(int data) {

		Node node = new Node(data);
		node.setData(data);
		if (head == null) {
			head = node;

		} else {

			Node n = head;
			while (n.getNext() != null) {
				n = n.getNext();
			}
			n.setNext(node);
		}
		size++;
	}
	
	// Insert At The Head
	public void insertAtHead(int data) {
		Node node = new Node(data);
		node.setData(data);
		node.setNext(head);
		head = node;
		size++;

	}
	

	// Insert At Particular Index
	public void insertAtIndex(int data, int index) {
		Node node = new Node(data);
		node.setData(data);

		if (index == 0) {
			insertAtHead(data);
		} else {
			Node n = head;
			for (int i = 0; i < index - 1; i++) {
				n = n.getNext();
			}
			node.setNext(n.getNext());
			n.setNext(node);
		}
		size++;
	}

	public void removeAtHead() {

		Node node = new Node();
		node = head;
		head = head.getNext();
		node.setNext(null);
		size--;

	}

	public void removeAtEnd() {

		Node node = new Node();
		node = head;
		Node temp = head;
		while (node.getNext() != null) {
			temp = node;
			node = node.getNext();
		}
		temp.setNext(null);

	}

	// Delete At Index
	public void removeAtIndex(int index) {

		if (index == 0) {
			head = head.getNext();
		} else {
			Node n = head;
			for (int i = 0; i < index - 1; i++) {
				n = n.getNext();
			}
			n.setNext(n.getNext().getNext());
		}
		size--;

	}

	public int getSize() {
		return size;
	}

	public void show() {
		Node n = head;
		while (n.getNext() != null) {
			System.out.print(n.getData() + "->");
			n = n.getNext();

		}
		System.out.println(n.getData());
	}

}
