package The_Double_Linked_List_Implementation;

public class Node {
	

	int data;
	Node linkNext;
	Node linkPrev;
	
	public Node() {
		super();
	}

	public Node(int data, Node linkNext, Node linkPrev) {
		super();
		this.data = data;
		this.linkNext = linkNext;
		this.linkPrev = linkPrev;
	}

	
	
	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getLinkNext() {
		return linkNext;
	}

	public void setLinkNext(Node linkNext) {
		this.linkNext = linkNext;
	}

	public Node getLinkPrev() {
		return linkPrev;
	}

	public void setLinkPrev(Node linkPrev) {
		this.linkPrev = linkPrev;
	}



}
