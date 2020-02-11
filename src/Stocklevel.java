/**
 * Stocklevel has item name, item id,item quantity,item minimum stock level 
 * values are set to the defined variables and it performs different operations  
 * based upon the user requirements like ordering stock,removing stock, 
 * getting minimum stock level of specific item based upon the user input.	
 */
public class Stocklevel {
	
	//fields
	private String name; //field to store the name of the product.
    private int itemId; // field to store the product id .
    private int quantity; // field to store the number of quantity .
    private int minimum_stock_level; // field to store the minimum stock level of each product.
    
	// Parameterised Constructor
	/**
	 * Parameterised constuctor used to set the values for global variables name,itemid,
	 * quantity and minimum stock level of each product.
	 * 
	 * @param name, the name of the product.
	 * @param itemId, the id of a single product.
	 * @param quantity, the quantity of the product to be set.
	 * @param minimum_stock_level, the minimum stock value for each product.
	 */
    
	public Stocklevel(String name, int itemId,int quantity,int minimum_stock_level)
	{
		this.name=name;
        this.itemId=itemId;
        this.quantity=quantity;
        this.minimum_stock_level=minimum_stock_level;
	}
	
	//Methods
	
	/** Increments the stock of specified product by a given value. 
	 * present quantity  + new quantity to be added.
	 * 
	 * @param quantity_of_order, the amount of quantity need to be added.
	 */
	public void reorder(int quantity_of_order) 
	{
        this.quantity=this.quantity+quantity_of_order;
    }
	
	/** Decrements the stock of specified product by a given value. 
	 * present quantity  - quantity ordered.
	 * 
	 * @param quantity_of_order, the amount of quantity need to be removed.
	 */
    public void remove(int quantity_of_order) 
    {
        this.quantity=this.quantity-quantity_of_order;
    }
    
	/** Returns the name of the product                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               he product.
	 * 
	 * @return the name of the current product.
	 */
    public String getName() {
        return this.name;
    }
    
	/** Returns the id of the product.
	 * 
	 * @return the id of the current product.
	 */
    public int getItemId() {
        return this.itemId;
    }

	/** Returns the quantity of the product.
	 * 
	 * @return the quantity of the current product.
	 */
    public int getQuantity() {
        return this.quantity;
    }
    
	/** Returns the minimum stock level value of the product.
	 * 
	 * @return the specified product minimum stock level value from the ArrayList.
	 */
    public int getminimum_stock_level() {
        return this.minimum_stock_level;
    }
    
	/** Returns a string of the output. 
	 * 
	 * @return a string format of the output to be displayed to the user.
	 */
    @Override
    public String toString() {
        String s="";
        s+=" name = "+this.name;
        s+=" , id = "+this.itemId;
        s+=" , quantity = "+this.quantity;
        return s;
    }
    
}
