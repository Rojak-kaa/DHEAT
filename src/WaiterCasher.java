public class WaiterCasher
{
    protected String staffName;
    protected int staffId;
    
    public WaiterCasher(String staffName, int staffId)
    {
        this.staffName = staffName;
        this.staffId = staffId;
    }

    public void viewMenu()
    {
        System.out.println("Displaying menu for waiter: " + staffName);
    }

    public void viewOrders()
    {
        System.out.println("Viewing orders for waiter: " + staffName);
    }

    public void takeOrder()
    {
        System.out.println("Taking order by waiter: " + staffName);
    }

    public void updateOder()
    {
        System.out.println("Updating order by waiter: " + staffName);
    }

    public void viewUpdatedOders()
    {
        System.out.println("Viewing updated orders for waiter: " + staffName);
    }

    public void trackStatus()
    {
        System.out.println("Tracking order status by waiter: " + staffName );
    }

    ///bill related methods
    public void viewTotalBills()
    {
        System.out.println("Viewing total bills for waiter: " + staffName);
    }

    public void generateBill()
    {
        System.out.println("Generating bill by waiter: " + staffName);
    }
    

}
