import java.util.ArrayList; //importing ArrayList class from java.util package
import java.util.Scanner; //importing Scanner class from java.util package
/*This Class is used for testing the usecases, User can check the use cases by giving the inputs and he can check the appropriate output.
*If there is any need for modification then the user can change the code by checking the outputs to the given inputs
*/
public class StocklevelTest {

	//fields
	static String name; //field to store the name of the product
	static int itemId; // field to store the id of the product
    int quantity;  // field to store the quantity of the product
    static String Ordered_product; // field to store the name of ordered product.
    static String response; // field to store User response to order to continue ordering or not.
    boolean Product_exists=false; // flag to check product exists or not
    static String new_item; // response of user to add new items or not
    static int order_option; // field stores the values of order option
    int sc_count=0; // scanner count
    int sc_add_items=0; // scanner count  for add items
    int minimum_stock_level=0; // field to store minimum stock level value
   
    //ArrayList to store each data of the stock item
    ArrayList<Stocklevel> stock_items = new ArrayList<Stocklevel>();
    //Scanner class to take the response of the user from the keyboard
    static Scanner sc = new Scanner(System.in);
    
    // Default Constructor
    //Constructor used to initialise the values into the arraylist
    public StocklevelTest() 
    {
    	// Adding the item into the ArrayList object
    	// Hardcoding few items into the ArrayList
    	// Parameters are passed to the Parameterised constructor of the StockLevel class
    	//parameters are item name, item id, item quantity, minimum stock level
        this.stock_items.add(new Stocklevel("Monitor", 1,50,5));
        this.stock_items.add(new Stocklevel("Mouse", 2,60,6));
    }	
    
    
	/** decreaseQuantity function takes item name as parameter
	 * It checks the given item name with item name from ArrayList, when both string matches then 
	 * 
	 * it checks whether the minimum stock level is reached or not
	 * if it reaches the minimum stock quantity then it will ask to reorder the stock
	 * 
	 * if stocks is greater than minimum stock level then the given item quantity is decremented
	 * 
	 * if there is insufficient stock, then system will pop to reorder the stock by certain amount of quantity
	 * Once the stock is filled then it will ask the user to order for required quantity
	 */    
    public void decreaseQuantity(String itemName) 
    {    	
        for (Stocklevel item : this.stock_items) 
        {
            if (itemName.equalsIgnoreCase(item.getName())) 
            {
            	int quantity_of_order=0;
            	
            	if(item.getminimum_stock_level()>=item.getQuantity())
            	{
            		System.out.println("Product reached minimum stock level	for item	: "+item.getName());
            		System.out.println("Please reorder some quantity to refill the stock	: ");
            		quantity_of_order=sc.nextInt();
                	item.reorder(quantity_of_order);
                	printStock();
            	}
            	
            	System.out.println("Enter the quantity to order	:");
                quantity_of_order=sc.nextInt();             
                  if (item.getQuantity()>=quantity_of_order ) 
                  {
                    item.remove(quantity_of_order);                   
                  }
                  else
                  {
                	int insufficient_quantity= quantity_of_order-item.getQuantity();
                	System.out.println("Insufficient stock, only "+item.getQuantity()+" items are available in stock....!");                	  
                	System.out.println("Reorder "+ insufficient_quantity+" items to make an order	:");
                	System.out.println("Enter the quantity to reorder	:");
                	quantity_of_order=sc.nextInt();
                	item.reorder(quantity_of_order);
                  }
                return;
            }
        }      
    }
    
    /**createItem method is used to add new item into the stock
     * 
     * @param name, it is the name of the item
     * @param itemId, it is the item id
     * @param quantity, it is amount of quantity to be added
     * @param minimum_stock_level, it is minimum stock amount of each stock
     */
    public void createItem(String name, int itemId,int quantity,int minimum_stock_level) 
    {
        this.stock_items.add(new Stocklevel(name,itemId,quantity,minimum_stock_level));
    }
    
    /** Returns a text format of the stock.
	 * 
	 * @return a text format of the stock.
	 */
    @Override
    public String toString() 
    {
        String s="";
        s=s+"Stock contains:\n";
        for (Stocklevel item:this.stock_items) 
        {
            s+='\n'+item.toString();
        }
        return s;
    }
    
    /**It returns the item name which user wants to order
     * 
     * @return Item_name, this is item name user wants to order
     */
    public String User_response()
    {    	sc_count++;
    	System.out.println("Which item you want to Order?");
    	if(sc_count>1)
    	{
 //   		sc.nextLine();
    	}
    	else
    	{
    		sc.nextLine();
    	}
    	
    	String Item_name=sc.nextLine();
		return Item_name;
		
    }
    
    /**It prints the stock items in a textual format 
     * 
     */
    public void printStock() {
        System.out.println(this.toString());
    }
    
    /**This method will check whether item name exists in arraylist or not 
     * if item is not found then, boolean variable Product_exists is set to false
     * 
     * if item name is not found then, it recalls the method until user correct product name is entered
     *  if item is found then, boolean variable Product_exists is set to true
     */
    public void select_order() 
    {

		Ordered_product=User_response();		
		for (Stocklevel item : this.stock_items) 
        {
            if (Ordered_product.equalsIgnoreCase(item.getName())) 
            {
            	
            	Product_exists=true;
            }           
        }
		if(!Product_exists==true)
		{
			System.out.println("\nProduct doesn't exist....!");
			select_order();
		}
    }
    
    /**This method is used to reorder the item from the stock
     * It asks the user to enter item name and quantity of order which user want to reorder
     */
    public void Reorder_item()
    {
    	String Item_name;
    	System.out.println("Enter which item you want to reorder.........!");
    	sc.nextLine();
		Item_name=sc.nextLine();
		
		for (Stocklevel item : stock_items) 			
        {			
            if (Item_name.equalsIgnoreCase(item.getName())) 
            {
                	System.out.println("Enter the quantity to reorder	:");
                	int quantity_of_order=sc.nextInt();
                	item.reorder(quantity_of_order);
             }            
          }
       }
	
    /**This method checks whether the item name is empty or not
     * 
     */
    public void order_checks() 
    {
       		
    	if(Ordered_product.isEmpty())
		{
    		select_order();
		}	
    }
    
    /**This method takes the user response, do they want to order more
     * 
     * This method will be called where appropriate it is required until program execution is stopped
     */
    public void order_more() 
    {
    	System.out.println("Would you like to order more? (yes/no)");
    	sc.nextLine();
		response=sc.nextLine();	  
    }
    
    /**This method is used to add new items into the stock
     * 
     */
    public void add_items() 
    {	sc_add_items++;
    	if(sc_add_items>1)
    	{
   // 		sc.nextLine();
    	}
    	else
    	{
    		sc.nextLine();
    	}
    	
		System.out.println("Enter Item Name	:");
		name=sc.nextLine();
		
		System.out.println("Enter Item id	:");
		itemId=sc.nextInt();
		
		System.out.println("Enter Item quantity	:");
		quantity=sc.nextInt();
		
		System.out.println("Enter Item minimum stock level	:");
		minimum_stock_level=sc.nextInt();
		
		createItem(name, itemId,quantity,minimum_stock_level);   	
    }
    
    /**This method takes the user response, do they want to create more new items into the stock
     * 
     */
    public void add_items_response() 
    {	
    	System.out.println("Do you want to add more new items to stocks? (y/n)");
		sc.nextLine();
		new_item=sc.nextLine();		
    }
    
    /**This method will display user with instructions they can perform
     * 
     */
    public void User_options() 
    {	
    	 	System.out.println("======================================================");
    		
    		System.out.println("Select an action you want to perform	:\n");
    		System.out.println("Select 0 to Stop shopping	:");
    		System.out.println("Select 1 to order item from stock	:");
    		System.out.println("Select 2 to reorder the stock item	:");
    		System.out.println("Select 3 to add new items to stock	:");    		
    		
    		System.out.println("======================================================");
    		order_option=sc.nextInt();	 
    }       
    
	public static void main(String[] args) 
	{			    
		//It creates an object and calls StocklevelTest() constructor
		StocklevelTest StocklevelTest_obj=new StocklevelTest();
		
		// Prints all the stock items available
		StocklevelTest_obj.printStock();		
		
		// calls the User_options() method for displaying options
		StocklevelTest_obj.User_options();
		
		// iterates until order_option variable value is set to 0 
		while(order_option>0)
		{
			/*When user enters the option 1 
			 * 
			 * sequence of method executions are:
			 * 
			 * It displays the user what all stock items are present
			 * It takes user response which iten they want to order
			 * given item is decremented from the stock by some amount
			 * It asks whether user wants to order more
			 * it keeps on iterating and keeps on ordering until user enter "no"
			 */
			if(order_option==1)
			{			
				StocklevelTest_obj.select_order();
				StocklevelTest_obj.order_checks();				
				StocklevelTest_obj.decreaseQuantity(Ordered_product);
				StocklevelTest_obj.printStock();				
				StocklevelTest_obj.order_more();
				while (response.equals("yes"))
				{				
					StocklevelTest_obj.printStock();
					StocklevelTest_obj.select_order();
					StocklevelTest_obj.order_checks();	
					StocklevelTest_obj.decreaseQuantity(Ordered_product);
					StocklevelTest_obj.printStock();
					StocklevelTest_obj.order_more();					
				}
				StocklevelTest_obj.User_options();
			}
			/*When user enters the option  2
			 * 
			 * sequence of method executions are:
			 * 
			 * It asks the user to reorder the stock
			 * Once the reorder is done then it prints the new stock quantity 
			 * It displays user with the user operation again 
			 */
			else if(order_option==2)
			{
				StocklevelTest_obj.Reorder_item();
				StocklevelTest_obj.printStock();
				StocklevelTest_obj.User_options();				
			}
			/*When user enters the option  3
			 * 
			 * sequence of method executions are:
			 * 
			 * It asks the user to add new items into the stock
			 * It asks the user whether they want to add more items into stock or not
			 * If user wants to add more then it keeps on iterating until "n" is entered
			 * It prints the items with new stock items
			 * It displays user with the user operation again 
			 */
			else if(order_option==3)
			{							
				StocklevelTest_obj.add_items();
				StocklevelTest_obj.add_items_response();
				while (new_item.equals("y"))
				{				
					StocklevelTest_obj.add_items();	
					StocklevelTest_obj.add_items_response();
				}
				StocklevelTest_obj.printStock();
				StocklevelTest_obj.User_options();
			}
			/*If user enters none of the options then it executes the following code
			 */
			else
			{
				System.out.println("Please choose an option from the list...........!");
				StocklevelTest_obj.User_options();
			}
		}		
		StocklevelTest_obj.printStock();
	}
}
