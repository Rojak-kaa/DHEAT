import java.util.Scanner;
import java.util.ArrayList;


class Manager {
    private String name;
    private String id;
    
    public Manager(String name, String id) {
        this.name = name;
        this.id = id;
    }
    
    public void viewUpdatedOrder() {
        System.out.println("Manager: Viewing updated orders...");
    }
    
    public String getName() { return name; }
    public String getId() { return id; }
}


class KitchenStaff {
    private String name;
    private String id;
    
    public KitchenStaff(String name, String id) {
        this.name = name;
        this.id = id;
    }
    
    public void updateStatus() {
        System.out.println("Kitchen Staff: Updating order status...");
    }
    
    public void viewOrder() {
        System.out.println("Kitchen Staff: Viewing orders...");
    }
    
    public void viewUpdatedOrder() {
        System.out.println("Kitchen Staff: Viewing updated orders...");
    }
    
    public String getName() { return name; }
    public String getId() { return id; }
}


class Casher {
    private String name;
    private String id;
    
    public Casher(String name, String id) {
        this.name = name;
        this.id = id;
    }
    
    public void viewOrder() {
        System.out.println("Casher: Viewing orders...");
    }
    
    public void viewTotalBills() {
        System.out.println("Casher: Viewing total bills...");
    }
    
    public void generateBill() {
        System.out.println("Casher: Generating bill...");
    }
    
    public void viewUpdatedOrder() {
        System.out.println("Casher: Viewing updated orders...");
    }
    
    public String getName() { return name; }
    public String getId() { return id; }
}


class Waiter {
    private String name;
    private String id;
    
    public Waiter(String name, String id) {
        this.name = name;
        this.id = id;
    }
    
    public void loginAcc() {
        System.out.println("Waiter: Logging in...");
    }
    
    public void viewMenu() {
        System.out.println("Waiter: Viewing menu...");
    }
    
    public void newOrder() {
        System.out.println("Waiter: Taking new order...");
    }
    
    public void takeOrder() {
        System.out.println("Waiter: Processing order...");
    }
    
    public void updateOrder() {
        System.out.println("Waiter: Updating order...");
    }
    
    public void trackStatus() {
        System.out.println("Waiter: Tracking order status...");
    }
    
    public void viewUpdatedOrder() {
        System.out.println("Waiter: Viewing updated orders...");
    }
    
    public String getName() { return name; }
    public String getId() { return id; }
}

public class DHEATGROUP {
    
    
    private static final int APPETIZER_SIZE = 4;
    private static final String[] APPETIZER_ITEMS = {"Spring Rolls", "Garlic Bread", "Chips and Salsa", "Big Shrimp"};
    private static final double[] APPETIZER_PRICE = {5.99, 4.00, 6.00, 7.00};
    
    private static final int MAIN_COURSE_SIZE = 4;
    private static final String[] MAIN_COURSE_ITEMS = {"Vegetable Stir-Fry", "Grilled Chicken Breast", "Chicken Alfredo", "Vegetarian Lasagna"};
    private static final double[] MAIN_COURSE_PRICE = {12.00, 15.49, 20.00, 18.99};
    
    private static final int DESSERTS_SIZE = 4;
    private static final String[] DESSERTS_ITEMS = {"Chocolate Lava Cake", "Cheesecake", "Fruit Tart", "Ice Cream"};
    private static final double[] DESSERTS_PRICE = {6.99, 5.99, 6.59, 7.55};
    
    private static final int BEVERAGES_SIZE = 3;
    private static final String[] BEVERAGE_ITEMS = {"Soft Drinks", "Fresh Juices", "Coffee"};
    private static final double[] BEVERAGE_PRICE = {2.49, 5.56, 1.56};
    
    
    private static Waiter waiter;
    private static Casher casher;
    private static KitchenStaff kitchenStaff;
    private static Manager manager;
    
    
    static Scanner scanner = new Scanner(System.in);
    static double totalSales = 0;
    static int orderCount = 0;
    static ArrayList<String> orders = new ArrayList<>();
     public static void main(String[] args) {
        
        waiter = new Waiter("John", "W001");
        casher = new Casher("Mike", "C001");
        kitchenStaff = new KitchenStaff("Chef David", "K001");
        manager = new Manager("Sarah", "M001");
        
        int choice;
        
        System.out.println("╔════════════════════════════════════╗");
        System.out.println("║  Welcome to DHEAT Restaurant!     ║");
        System.out.println("╚════════════════════════════════════╝");
        
        System.out.println("\n========== LOGIN ==========");
        System.out.println("1. Waiter");
        System.out.println("2. Casher");
        System.out.println("3. Kitchen Staff");
        System.out.println("4. Manager");
        System.out.print("Select role (1-4): ");
        
        int role = scanner.nextInt();
        
        do {
            switch(role) {
                case 1:
                    waiterMenu();
                    break;
                case 2:
                    casherMenu();
                    break;
                case 3:
                    kitchenMenu();
                    break;
                case 4:
                    managerMenu();
                    break;
                default:
                    System.out.println("Invalid role!");
                    return;
            }
            break;
        } while(true);
        
        scanner.close();
    }
    
    
    private static void waiterMenu() {
        int choice;
        waiter.loginAcc();
        
        do {
            System.out.println("\n========== WAITER MENU ==========");
            System.out.println("1. View Menu");
            System.out.println("2. Take New Order");
            System.out.println("3. Update Order");
            System.out.println("4. Track Order Status");
            System.out.println("5. Logout");
            System.out.print("Enter your choice (1-5): ");
            
            choice = scanner.nextInt();
            
            switch(choice) {
                case 1:
                    waiter.viewMenu();
                    displayMenu();
                    break;
                case 2:
                    waiter.newOrder();
                    placeOrder();
                    break;
                case 3:
                    waiter.updateOrder();
                    System.out.println("Order updated successfully!");
                    break;
                case 4:
                    waiter.trackStatus();
                    System.out.println("Order status: In preparation");
                    break;
                case 5:
                    System.out.println("Waiter logged out!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        } while(choice != 5);
    }
    
    
    private static void casherMenu() {
        int choice;
        
        do {
            System.out.println("\n========== CASHER MENU ==========");
            System.out.println("1. View Orders");
            System.out.println("2. Generate Bill");
            System.out.println("3. View Total Bills");
            System.out.println("4. View Updated Orders");
            System.out.println("5. Logout");
            System.out.print("Enter your choice (1-5): ");
            
            choice = scanner.nextInt();
            
            switch(choice) {
                case 1:
                    casher.viewOrder();
                    viewOrdersList();
                    break;
                case 2:
                    casher.generateBill();
                    System.out.println("Bill generated successfully!");
                    break;
                case 3:
                    casher.viewTotalBills();
                    System.out.printf("Total Bills: $%.2f\n", totalSales);
                    break;
                case 4:
                    casher.viewUpdatedOrder();
                    break;
                case 5:
                    System.out.println("Casher logged out!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        } while(choice != 5);
    }
    
    
    private static void kitchenMenu() {
        int choice;
        
        do {
            System.out.println("\n========== KITCHEN MENU ==========");
            System.out.println("1. View Orders");
            System.out.println("2. Update Order Status");
            System.out.println("3. View Updated Orders");
            System.out.println("4. Logout");
            System.out.print("Enter your choice (1-4): ");
            
            choice = scanner.nextInt();
            
            switch(choice) {
                case 1:
                    kitchenStaff.viewOrder();
                    viewOrdersList();
                    break;
                case 2:
                    kitchenStaff.updateStatus();
                    System.out.println("Order status updated to: Ready!");
                    break;
                case 3:
                    kitchenStaff.viewUpdatedOrder();
                    break;
                case 4:
                    System.out.println("Kitchen Staff logged out!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        } while(choice != 4);
    }
    
    
    private static void managerMenu() {
        int choice;
        
        do {
            System.out.println("\n========== MANAGER MENU ==========");
            System.out.println("1. View Total Sales");
            System.out.println("2. View Total Orders");
            System.out.println("3. View Updated Orders");
            System.out.println("4. Logout");
            System.out.print("Enter your choice (1-4): ");
            
            choice = scanner.nextInt();
            
            switch(choice) {
                case 1:
                    System.out.printf("Total Sales: $%.2f\n", totalSales);
                    break;
                case 2:
                    System.out.printf("Total Orders: %d\n", orderCount);
                    break;
                case 3:
                    manager.viewUpdatedOrder();
                    break;
                case 4:
                    System.out.println("Manager logged out!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        } while(choice != 4);
    }
    
    
    private static void displayMenu() {
        System.out.println("\n========== RESTAURANT MENU ==========");
        displayCategory("APPETIZERS", APPETIZER_ITEMS, APPETIZER_PRICE);
        displayCategory("MAIN COURSE", MAIN_COURSE_ITEMS, MAIN_COURSE_PRICE);
        displayCategory("DESSERTS", DESSERTS_ITEMS, DESSERTS_PRICE);
        displayCategory("BEVERAGES", BEVERAGE_ITEMS, BEVERAGE_PRICE);
    }
    
    
    private static void displayCategory(String categoryName, String[] items, double[] prices) {
        System.out.println("\n" + categoryName);
        System.out.println("─".repeat(40));
        for (int i = 0; i < items.length; i++) {
            System.out.printf("%d. %-25s $%.2f\n", (i + 1), items[i], prices[i]);
        }
    }
    
    
    private static void placeOrder() {
        System.out.print("\nEnter table number: ");
        int tableNumber = scanner.nextInt();
        
        System.out.print("Enter number of people: ");
        int numPeople = scanner.nextInt();
        
        double orderTotal = 0;
        boolean ordering = true;
        StringBuilder orderDetails = new StringBuilder("Table " + tableNumber + ": ");
        
        System.out.println("\n========== SELECT CATEGORY ==========");
        System.out.println("1. Appetizers");
        System.out.println("2. Main Course");
        System.out.println("3. Desserts");
        System.out.println("4. Beverages");
        System.out.println("5. Finish Ordering");
        
        while(ordering) {
            System.out.print("\nSelect category (1-5): ");
            int category = scanner.nextInt();
            
            switch(category) {
                case 1:
                    orderTotal += orderFromCategory("APPETIZERS", APPETIZER_ITEMS, APPETIZER_PRICE, APPETIZER_SIZE, orderDetails);
                    break;
                case 2:
                    orderTotal += orderFromCategory("MAIN COURSE", MAIN_COURSE_ITEMS, MAIN_COURSE_PRICE, MAIN_COURSE_SIZE, orderDetails);
                    break;
                case 3:
                    orderTotal += orderFromCategory("DESSERTS", DESSERTS_ITEMS, DESSERTS_PRICE, DESSERTS_SIZE, orderDetails);
                    break;
                case 4:
                    orderTotal += orderFromCategory("BEVERAGES", BEVERAGE_ITEMS, BEVERAGE_PRICE, BEVERAGES_SIZE, orderDetails);
                    break;
                case 5:
                    ordering = false;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
        
        if(orderTotal > 0) {
            orders.add(orderDetails.toString());
            processPayment(orderTotal, tableNumber);
            totalSales += orderTotal;
            orderCount++;
        }
    }
    
   
    private static double orderFromCategory(String categoryName, String[] items, double[] prices, int size, StringBuilder orderDetails) {
        System.out.println("\n" + categoryName);
        for (int i = 0; i < size; i++) {
            System.out.printf("%d. %s - $%.2f\n", (i + 1), items[i], prices[i]);
        }
        
        System.out.print("Select item (1-" + size + "), or 0 to go back: ");
        int itemChoice = scanner.nextInt();
        
        if(itemChoice < 1 || itemChoice > size) {
            return 0;
        }
        
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        
        double itemCost = prices[itemChoice - 1] * quantity;
        System.out.printf("\n✓ Added %d x %s = $%.2f\n", quantity, items[itemChoice - 1], itemCost);
        
        orderDetails.append(quantity).append("x ").append(items[itemChoice - 1]).append(" | ");
        
        return itemCost;
    }
    
    
    private static void processPayment(double amount, int tableNumber) {
        System.out.println("\n========== PAYMENT ==========");
        System.out.printf("Total Amount: $%.2f\n", amount);
        System.out.println("Payment Methods:");
        System.out.println("1. Cash");
        System.out.println("2. Card");
        System.out.print("Select payment method (1-2): ");
        
        int paymentMethod = scanner.nextInt();
        
        if(paymentMethod == 1) {
            System.out.print("Enter cash amount: $");
            double cashAmount = scanner.nextDouble();
            double change = cashAmount - amount;
            
            if(change >= 0) {
                System.out.printf("✓ Payment successful!\n");
                System.out.printf("Change: $%.2f\n", change);
            } else {
                System.out.println("✗ Insufficient cash!");
                return;
            }
        } else if(paymentMethod == 2) {
            System.out.print("Enter 16-digit card number: ");
            String cardNumber = scanner.next();
            
            if(cardNumber.length() == 16 && cardNumber.matches("\\d+")) {
                System.out.printf("✓ Card payment successful!\n");
            } else {
                System.out.println("✗ Invalid card number!");
                return;
            }
        }
        
        System.out.println("\nThank you for your order!");
    }
    
    
    private static void viewOrdersList() {
        if(orders.isEmpty()) {
            System.out.println("No orders yet!");
        } else {
            System.out.println("\n========== ORDERS ==========");
            for(String order : orders) {
                System.out.println(order);
            }
        }
    }
}
