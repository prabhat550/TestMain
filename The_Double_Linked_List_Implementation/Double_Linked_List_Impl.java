package The_Double_Linked_List_Implementation;



public class Double_Linked_List_Impl {

	private Node head;
	private Node end;
	int size;

	public boolean isEmpty() {
		return head == null;
	}

	public int getSize() {
		return size;
	}

	public void insertAtStart(int value) {

		Node node = new Node(value, null, null);
		if (head == null) {
			head = node;
			end = head;
		} else {
			head.setLinkPrev(node);
			node.setLinkNext(head);
			head = node;
		}
		size++;
	}

	public void insertAtEnd(int value) {

		Node node = new Node(value, null, null);
		if (head == null) {
			head = node;
			end = head;
		} else {
			node.setLinkPrev(end);
			end.setLinkNext(node);
			node = end;
		}
	}

	public void insertAt(int index, int value) {
		Node node = new Node(value, null, null);
		if (index == 0) {
			insertAtStart(value);
		}
		Node str = head;
		for (int i = 1; i < size; i++) {
			if (i == index) {
				Node temp = str.getLinkNext();
				node.setLinkNext(temp);
				node.setLinkPrev(str);
				str.setLinkNext(node);
				temp.setLinkPrev(node);
			}
			str = str.getLinkNext();
		}
		size++;
	}
	
	public void removeNodeAtHead() {
		
		Node node = new Node();
		node = head;
		head = head.getLinkNext();
		node.setLinkNext(null);
		size--;		
		
	}
	
	public void removeAtTail() {
		
		Node node = new Node();
		node = head;
		Node temp = head;
		while (node.getLinkNext() != null) {
			temp = node;
			node = node.getLinkNext();
		}
		temp.setLinkNext(null);
		size--;
	}
	
	public void removeAtIndex(int index) {

		Node node = head;
		if (index == 0) {
			head = head.getLinkNext();
		} else {
			for (int i = 0; i < index - 1; i++) {
				node = node.getLinkNext();
			}
			node.setLinkNext(node.getLinkNext().getLinkNext());
		}
		size--;

	}
	
	
	public void show() {
		
		Node n = head;
		while (n.getLinkNext() != null) {
			System.out.print(n.getData() + "->");
			n = n.getLinkNext();

		}
		System.out.println(n.getData());
	}
	

}
