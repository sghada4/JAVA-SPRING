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
    Order order4 = new Order("Sam");
    // Application Simulations
    order2.items.add(item1);
    order2.total = item1.price;

    order3.items.add(item4);
    order3.total = item4.price;

    order4.items.add(item2);
    order4.total = item4.price;

    order1.ready = true;

    order4.items.add(item2);
    order4.total += item4.price;
    order4.items.add(item2);
    order4.total += item4.price;

    order2.ready = true;
    // Use this example code to test various orders' updates
    System.out.printf("Name: %s\n", order1.name);
    System.out.printf("Total: %s\n", order1.total);
    System.out.printf("Ready: %s\n", order1.ready);
    for (int i=0; i < order1.items.size(); i++) {
      System.out.printf("Items: %s\n", order1.items.get(i).name);
    }
    System.out.printf("-------------------------\n");
    System.out.printf("Name: %s\n", order2.name);
    System.out.printf("Total: %s\n", order2.total);
    System.out.printf("Ready: %s\n", order2.ready);
    for (int i=0; i < order2.items.size(); i++) {
      System.out.printf("Items: %s\n", order2.items.get(i).name);
    }
    System.out.printf("-------------------------\n");
    System.out.printf("Name: %s\n", order3.name);
    System.out.printf("Total: %s\n", order3.total);
    System.out.printf("Ready: %s\n", order3.ready);
    for (int i=0; i < order3.items.size(); i++) {
      System.out.printf("Items: %s\n", order3.items.get(i).name);
    }
    System.out.printf("-------------------------\n");
    System.out.printf("Name: %s\n", order4.name);
    System.out.printf("Total: %s\n", order4.total);
    System.out.printf("Ready: %s\n", order4.ready);
    for (int i=0; i < order4.items.size(); i++) {
      System.out.printf("Items: %s\n", order4.items.get(i).name);
    }
  }
}
