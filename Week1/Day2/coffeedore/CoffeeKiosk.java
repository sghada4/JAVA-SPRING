import java.util.ArrayList;

public class CoffeeKiosk {

  private ArrayList<Item> menu;
  private ArrayList<Order> orders;

  public CoffeeKiosk() {
    this.menu = new ArrayList<Item>();
    this.orders = new ArrayList<Order>();
  }

  public void addMenuItem(String name, double price) {
    Item newItem = new Item(name, price);
    this.menu.add(newItem);
    newItem.setIndex(menu.indexOf(newItem));
  }

  public void displayMenu() {
    for (int i = 0; i < this.menu.size(); i++) {
      System.out.println(
        this.menu.get(i).getIndex() + " "+
        this.menu.get(i).getName() +
        " -- $" +
        this.menu.get(i).getPrice()
      );
    }
  }

      public void newOrder() {
        
    	// Shows the user a message prompt and then sets their input to a variable, name
        System.out.println("Please enter customer name for new order:");
        String name = System.console().readLine();
    
    	// Your code:
        // Create a new order with the given input string
        Order order = new Order(name);
        // Show the user the menu, so they can choose items to add.
        displayMenu();
        
    	// Prompts the user to enter an item number
        System.out.println("Please enter a menu item index or q to quit:");
        String itemNumber = System.console().readLine();
        
        // Write a while loop to collect all user's order items
        while(!itemNumber.equals("q") ) {
            int itemNumberInteger = Integer.parseInt(itemNumber);
            // Get the item object from the menu, and add the item to the order
            // Item item = new Item(menu.get(Integer.parseInt(itemNumber)).getName(), menu.get(Integer.parseInt(itemNumber)).getPrice());
            if(itemNumberInteger < menu.size()){
                Item item = menu.get(itemNumberInteger);
                order.items.add(item);
                break;
            }else{
                System.out.println("Please enter a valid menu item index or q to quit:");
                itemNumber = System.console().readLine();
            }
            
            // Ask them to enter a new item index or q again, and take their input
        }
        // After you have collected their order, print the order details 
    	// as the example below. You may use the order's display method.
        System.out.println("***************");
        order.display();
        
    }

}
