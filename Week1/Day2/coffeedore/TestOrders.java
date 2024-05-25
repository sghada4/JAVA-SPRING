import java.util.ArrayList;

public class TestOrders {

  public static void main(String[] args) {
    CoffeeKiosk coffeeKiosk = new CoffeeKiosk();
    // Menu items
    coffeeKiosk.addMenuItem("mocha", 6.5);
    coffeeKiosk.addMenuItem("latte", 4.5);
    coffeeKiosk.addMenuItem("capuccino", 5.9);
    coffeeKiosk.displayMenu();
    coffeeKiosk.newOrder();
  }
}
