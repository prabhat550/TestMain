package The_Single_Linked_List_Implementation;

public class Main {

	public static void main(String[] args) {

		Single_Linked_List_Impl list = new Single_Linked_List_Impl();
		
		list.insertAtHead(5);
		list.insertAtHead(7);
		list.insertAtHead(9);
		list.insertAtIndex(11, 1);

		list.show();

	}

}
