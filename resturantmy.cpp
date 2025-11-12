#include <iostream>
#include<String>
#include<iomanip>
#include<fstream>
// ***************************************************************************************
// *    Title: File Handling in C++
// *    Author: Smith, J
// *    Date: 2011
// *    Code version: 2.0
// *    Availability: http://www.graphicsdrawer.com
// ***************************************************************************************
using namespace std;

const int Appetizer_size = 4;
string Appertizer_items[Appetizer_size] = {"Spring Rolls","Garlic Bread","Chips and salsa","Big shrimp"};
double Apppertizer_Price[Appetizer_size] = {5.99,4.00,6.00,7.00};

const int Main_Course_size = 4;
string Main_Course_items[Main_Course_size] = {"Vegetable Stir-Fry","Grilled Chicken Breast","Chicken Alfredo","Vegitarian Lasagna"};
double Main_Course_Price[Main_Course_size] = {12.00,15.49,20.00,18.99};

const int Desserts_size = 4;
string Desserts_items[Desserts_size] = {"Chocolate Lava Cake","Cheesecake","Fruit Tart","Ice Cream"};
double Desserts_Price[Desserts_size] = {6.99,5.99,6.59,7.55};

const int Beverages_size = 3;
string Beverage_items[Beverages_size] = {"Soft Drinks"," Fresh Juices", "Coffee"};
double Beverage_Price[Beverages_size] = {2.49,5.56,1.56};

const int Kidsmenu_size = 3;
string Kidsmenu_items[Kidsmenu_size] = {"Chicken Tenders","Mini Cheeseburger","Mac & Cheese"};
double Kidsmenu_Price[Kidsmenu_size] = {4.67,5.00,7.00};

const int Chefspecial_size = 2;
string Chefspecial_items[Chefspecial_size] = {"Lobster Tail","Crab curry"};
double Chefspecial_Price[Chefspecial_size] = {20.00,17.89};

double TotalSalesPerDay = 0;
double TotalSalesPerMonth = 0;
int OrderCount = 0;

void displaymenu(string title,string item[],double Price[],int size )
{
    cout<<endl<< title <<":"<<endl;
    cout<< left<<setw(25)<<"items"<<right<<setw(10)<<"Price(RM)"<<endl;
    cout <<"-----------------------------------"<<endl;
    for (int i = 0; i < size; i++)
    {
        cout<<left<<setw(25)<<item[i]<<right<<setw(10)<<fixed<<setprecision(2)<< Price [i]<<endl;
    }
    
}
void generateReceipt(double totalCost, int paymentMethod) {
    ofstream receipt("receipt.txt"); 
    // ***************************************************************************************
    // *    Title: File Writing in C++
    // *    Author: Smith, J
    // *    Date: 2011
    // *    Code version: 2.0
    // *    Availability: http://www.graphicsdrawer.com
    // ***************************************************************************************
    receipt << "\n**** Moonbucks Restaurant ****\n";
    receipt << "Total Cost: RM" << fixed << setprecision(2) << totalCost << "\n";
    receipt << "Payment Method: " << paymentMethod << "\n";
    receipt << "Thank you for dining with us!\n";
    receipt.close();
    cout << "Receipt generated successfully.\n";
    
}


void addToTotalSales(double cost)
{
    TotalSalesPerDay += cost;
    TotalSalesPerMonth += cost;
}


void takeoders()
{
    int category,itemindex,quantity;
    cout<<endl<<"Select a Category to order from:"<<endl;
    cout<<"1. Appetizers"<<endl<<"2. Main Course"<<endl<<"3. Desserts"<<endl<<"4. Beverages"<<endl<<"5. Kids Menu"<<endl<<"6. Chef's Special"<<endl;
    cout<<"Enter Category Number:";
    cin>>category;
    if (category<1 || category>6)
    {
       cout<<"Invaild Category Selection.Please try again"<<endl;
       return;
    }
    string* menuitems;
    double * menuprices;
    int menusize;
    switch (category)
    {
    case 1:menuitems = Appertizer_items;menuprices = Apppertizer_Price;menusize =Appetizer_size;break;
    case 2 : menuitems = Main_Course_items;menuprices = Main_Course_Price;menusize = Main_Course_size;break;
    case 3: menuitems = Desserts_items;menuprices=Desserts_Price;menusize = Desserts_size;break;
    case 4: menuitems = Beverage_items;menuprices =Beverage_Price;menusize = Beverages_size;break;
    case 5: menuitems =Kidsmenu_items;menuprices= Kidsmenu_Price;menusize = Kidsmenu_size;break;
    case 6: menuitems  = Chefspecial_items;menuprices = Chefspecial_Price;menusize = Chefspecial_size;break;

    default :
        cout<<"Invalied Selection. Please try Again"<<endl;
        return;
    }
    cout<<endl<<"Available items:"<<endl;
    for (int i = 0; i < menusize; i++)
    {
        cout<<i+1<<"."<<menuitems[i]<<"-RM "<<menuprices[i]<<endl;
    }
    cout<<"Enter item number:";
    cin>>itemindex;
    if (itemindex<1 || itemindex> menusize)
    {
       cout<<"Invaild item Selection."<<endl;
       return;
    }
    cout <<"Enter No of packages need :";
    cin>>quantity;
    if (quantity<1)
    {
        cout<<"quantity must be at least 1."<<endl;
        return;
    }
    double cost = menuprices[itemindex - 1]* quantity;
    addToTotalSales(cost);
OrderCount++;

cout<<endl<<"Order Registered:"<<endl;
cout<<"Item: " <<menuitems[itemindex - 1]<<" * "<<quantity <<"=Rm"<< cost<<endl;
}

void processPayment()
{
    double cashGiven;
    int paymentMethod;

    cout<<endl<<"Total Amount to pay: RM" << fixed<<setprecision(2)<<TotalSalesPerDay<<endl;
    cout<<"select payment Method:\n1. Cash\n2. Card\nEnter choice: ";
    cin >> paymentMethod;

    if (paymentMethod == 1) {
        cout << "Enter cash amount: ";
        cin >> cashGiven;
        if (cashGiven >= TotalSalesPerDay) {
            cout << "Payment successful! Change: RM" << fixed << setprecision(2) << (cashGiven - TotalSalesPerDay) << endl;
        } else {
            cout << "Insufficient cash. Transaction failed.\n";
        }
    } else if (paymentMethod == 2) {
        string cardNumber;
        cout << "Enter card number: ";
        cin >> cardNumber;
        if (cardNumber.length() == 16) {
            cout << "Processing payment... Payment successful!\n";
        } else {
            cout << "Invalid card number. Payment failed.\n";
        }
    } else {
        cout << "Invalid payment method. Transaction failed.\n";
    }
 
    generateReceipt(TotalSalesPerDay, paymentMethod);
}

int main()
{
    cout<<"WELCOME MOONBUCKS"<<endl;
    cout<<"Savour the flavour,Every Bites a Delight"<<endl;
    displaymenu("Appetizer",Appertizer_items,Apppertizer_Price,Appetizer_size);
    displaymenu("Main Course",Main_Course_items,Main_Course_Price,Main_Course_size);
    displaymenu("Desserts",Desserts_items,Desserts_Price,Desserts_size);
    displaymenu("Beverages",Beverage_items,Beverage_Price,Beverages_size);
    displaymenu("Kids Menu",Kidsmenu_items,Kidsmenu_Price,Kidsmenu_size);
    displaymenu("chef's Special",Chefspecial_items,Chefspecial_Price,Chefspecial_size);

    int table_number,num_people;
    char ordermore;

    cout<<endl<<"Insert you table number:";
    cin>>table_number;
    cout<<"Insert the number of individuals :";
    cin>>num_people;
    do
    {
        takeoders();
        cout<<"Do you desire to order more?(y/n):";
        cin>>ordermore;
    } while (ordermore=='y'|| ordermore=='Y');

    processPayment();
    cout << "\nTotal Sales for Today: RM" << TotalSalesPerDay << endl;
    cout << "Total Sales for This Month: RM" << TotalSalesPerDay << endl;
    

    cout << "Thank you for visiting Moonbucks! Have a great day!\n";
    return 0;

    
   

    
    


}



  

