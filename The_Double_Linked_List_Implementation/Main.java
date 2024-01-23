package The_Double_Linked_List_Implementation;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Double_Linked_List_Impl double_Linked_List_Impl = new Double_Linked_List_Impl();
		double_Linked_List_Impl.insertAtStart(5);
		double_Linked_List_Impl.insertAtStart(10);
		double_Linked_List_Impl.insertAtStart(15);
		double_Linked_List_Impl.insertAtStart(20);
		
		double_Linked_List_Impl.show();
		
		// double_Linked_List_Impl.removeNodeAtHead();
		
		// double_Linked_List_Impl.removeAtTail();
		
		double_Linked_List_Impl.removeAtIndex(1);
		
		double_Linked_List_Impl.show();

	}

}
