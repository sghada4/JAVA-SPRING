import java.util.ArrayList;

public class Order {

  private String name;
  private double total;
  private boolean ready;
  public ArrayList<Item> items;

  public Order(String name) {
    this.name = name;
    this.items = new ArrayList<Item>();
  }

  public Order() {
    this.name = "Guest";
    this.items = new ArrayList<Item>();
  }

  public void addItem(Item item) {
    setItems(item);
  }

  public String getStatusMessage() {
    if (this.ready) {
      return "Your order is ready.";
    } else {
      return "Thank you for waiting. Your order will be ready soon.";
    }
  }

  public double getOrderTotal() {
    double sum = 0;
    for (int i = 0; i < this.items.size(); i++) {
      sum += this.items.get(i).getPrice();
    }
    return sum;
  }

  public void display() {
    System.out.println("Customer Name: " + this.name);
    for (int i = 0; i < this.items.size(); i++) {
      System.out.println(
        this.items.get(i).getName() + " - $" + this.items.get(i).getPrice()
      );
    }
    System.out.println(
        "Total: $"+ getOrderTotal()
      );
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getTotal() {
    return this.total;
  }

  public void setTotal(double total) {
    this.total = total;
  }

  public boolean getReady() {
    return this.ready;
  }

  public void setReady(boolean ready) {
    this.ready = ready;
  }

  public ArrayList<Item> getItems() {
    return this.items;
  }

  public void setItems(Item item) {
    this.items.add(item);
  }
}
