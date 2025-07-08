package Grocery.ToDoList;
import java.util.LinkedList;
public class Groceries {
	LinkedList<ItemsClass> groceryList=new LinkedList<>();
	public void addItems(String item) {
		groceryList.add(new ItemsClass(item));
	}
	
	public void removeItems(String removeitem) {
		boolean removed=false;
		for(int i=0;i<groceryList.size();i++) {
			if(groceryList.get(i).getItem().equals(removeitem)) {
				groceryList.remove(i);
				removed=true;
				System.out.println("Items were removed successfully!");
				break;
			}
		}
		if(!removed) {
			System.out.println("[Error] Item not found in the list.");
		}
	}
	
	public void viewList() {
		 if (groceryList.isEmpty()) {
	            System.out.println("[Empty List]");
	        } else {
	            for (ItemsClass item : groceryList) {
	                System.out.println("- " + item.getItem());
	            }
	        }
	}
	
	public void exit() {
		System.out.println("Your List: "+groceryList.toString());
		System.exit(0);
	}
}
