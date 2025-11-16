
import java.util.Scanner;

public class Order {
    protected String orderId;
    protected String itemName;
    protected int quantity;
    protected double price;

    Scanner scan= new Scanner(System.in);

    public Order() {
        orderId = null;
        itemName = null;
        quantity = 0;
        price = 0.0;
    }

    public void getOrder() {
        System.out.println("Enter Order Details:");
        System.out.println("Order ID: ");
        orderId = scan.nextLine();
        // System.out.println("Item Name: " + itemName);
        // String name = scan.nextLine();
        System.out.println("Quantity: " );
        quantity = scan.nextInt();

    }

    public void showOrderDetails() {
        System.out.println("Order Details:");
        System.out.println("Order ID: " + orderId);
        System.out.println("Item Name: " + itemName);
        System.out.println("Quantity: " + quantity);
        System.out.println("Price: " + (price*quantity));
    }

    public void updatedOrder() {
       System.out.println("-------------------------------");
       System.out.println("     Update Order Details      ");
       System.out.println("-------------------------------");
       showOrderDetails();
       System.out.print("Which detail do you want to update? ");
       System.out.println("1. Item ");
       System.out.println("2. Quantity");
       int userChoiceO = scan.nextInt();
         switch (userChoiceO) {
              case 1 -> {
                  System.out.print("Enter new item name: ");
                  String newItemName = scan.next();
                  itemName = newItemName;
            }
              case 2 -> {
                  System.out.print("Enter new quantity: ");
                  int newQuantity = scan.nextInt();
                  quantity = newQuantity;
            }
              default -> {
                  System.out.println("Invalid choice.");
                  return;
            }
         }
         showOrderDetails();
    }

}
