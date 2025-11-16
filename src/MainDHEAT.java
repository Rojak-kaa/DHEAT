
import java.util.Scanner;

public class MainDHEAT 
{

    
    public static void main(String[] args) 
    {
        
        InventoryData inventory = new InventoryData();
        Scanner scan = new Scanner(System.in);
        Order order = new Order();

        
        System.out.println("---------------------------------------------");
        System.out.println("Welcome to DHEAT Restaurant Management System");
        System.out.println("---------------------------------------------");
        System.out.println("1.Waiter&Casher");
        System.out.println("2. Kitchen");
        System.out.println("3..Manager");
        System.out.print("Select your role: ");
        int userChoiceM = scan.nextInt();
        switch(userChoiceM)
        {
            case 1->
            {
                System.out.println("You have selected Waiter&Casher");
                System.out.print("Enter your ID:");
                String id = scan.nextLine();
                System.out.println("What do you need to do?");
                System.out.println("1.Take Order");
                System.out.println("2.View Orders");
                System.out.println("3.Update Order");
                System.out.println("4.Track Status");
                System.out.println("5.Pay Bill");
                int choice = scan.nextInt();
                switch(choice)
                {
                    case 1->
                    {
                        inventory.showMenu();
                        order.getOrder();
                        
                    }
                    case 2->
                    {
                        order.showOrderDetails();
                    }
                    case 3->
                    {
                        order.updatedOrder();
                    }
                    case 4->
                    {
                        System.out.println("Tracking order status...");
                    }
                    case 5->
                    {
                        System.out.println("Processing bill payment...");
                    }

                    default ->
                    {
                        System.out.println("Invalid Choice");
                    }
                }

            }
            case 2->
            {
                System.out.println("You have selected Kitchen");
            }

            case 3 ->
            {
                System.out.println("You have selected Manager");
            }
        }
    }


        

}

