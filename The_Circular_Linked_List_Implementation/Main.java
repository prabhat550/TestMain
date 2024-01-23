package The_Circular_Linked_List_Implementation;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CircularLinkedList circularLinkedList = new CircularLinkedList();
		circularLinkedList.createCircularLinkedList();
		circularLinkedList.displayElements();
		
		circularLinkedList.insertAtTheStart(12);
		circularLinkedList.displayElements();

	}

}
