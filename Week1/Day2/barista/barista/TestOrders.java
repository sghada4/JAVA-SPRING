import java.util.ArrayList;

public class TestOrders {

  public static void main(String[] args) {
    // Menu items
    Item item1 = new Item("mocha", 6.5);
    Item item2 = new Item("latte", 4.5);
    Item item3 = new Item("drip coffee", 3.0);
    Item item4 = new Item("capuccino", 5.9);
    // Order variables -- order1, order2 etc.
    Order order1 = new Order("Cindhuri");
    Order order2 = new Order("Jimmy");
    Order order3 = new Order("Noah");
    Order order4 = new Order();
    Order order5 = new Order();
    // Application Simulations
    order4.addItem(item1);
    order4.addItem(item2);

    order1.addItem(item3);
    order1.addItem(item4);

    order2.addItem(item1);
    order2.addItem(item4);    

    order3.addItem(item3);
    order3.addItem(item2);    

    order5.addItem(item2);
    order5.addItem(item1);    

    order2.setReady(true); 
    order3.setReady(true); 
    order4.setReady(true); 
    System.out.println(order2.getStatusMessage());
    System.out.println(order3.getStatusMessage());
    System.out.println(order4.getStatusMessage());

    System.out.println(order1.getOrderTotal());    
    order3.display();
  }
}
