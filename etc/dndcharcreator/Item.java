public class Item extends Object
{
    private String itemName;
	private int itemAmount;
	private double itemWeight;
	
	private double itemTotalWeight;
	
	public Item(String itemName, int itemAmount, double itemWeight){
		this.itemName = itemName;
		this.itemAmount = itemAmount;
		this.itemWeight = itemWeight;
	}
	
	//get-set
	public String getItemName(){
		return this.itemName;
	}
	public int getItemAmount(){
		return this.itemAmount;
	}
	public double getItemWeight(){
		return this.itemWeight;
	}
	
	
	//Item methods
	public double calculateItemWeight()
	{
		this.itemTotalWeight = this.itemWeight * itemAmount;
		return this.itemTotalWeight;
	}
	
	public void addItemAmount(int amount)
	{
		this.itemAmount += amount;
		calculateItemWeight();
	}
	
	@Override
	public String toString()
	{
		return String.format("%-10s\tAmount:%d\tWeight:%.2f\tWeightT:%.0f",
		this.itemName, 
		this.itemAmount,
		this.itemWeight, 
		this.itemTotalWeight);
	}
    
}
