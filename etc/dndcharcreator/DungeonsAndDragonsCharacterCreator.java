public class DungeonsAndDragonsCharacterCreator
{
	public static void main(String[] args){
		Item item = new Item("sword", 1, 2.5);
		item.calculateItemWeight();
		item.toString();

	}
}

class Character
{
	public static final String[] ABILITY_HEADINGS = {"Strength", "Dexterity", "Constitution", "Intelligence", "Wisdom", "Charisma"};
	public static final int[] EXP_PROGRESSION = {300, 900, 2700, 6500, 14000, 23000, 34000, 48000, 64000, 85000, 100000, 120000, 140000, 165000, 195000, 225000, 265000, 305000, 355000};

	private String characterName;
	private String characterClass;
	private String characterRace;

	private int characterHealth;
	private int maxHealth;
	private int characterExp = 0;
	private int characterLevel = 1;
	
	private Item[] characterInventory;
	private int[] characterAbilityScores;

	public Character(String characterName, String characterClass, String characterRace)
	{
		this.characterName = characterName;
		this.characterClass = characterClass;
		this.characterRace = characterRace;

	}
	 
	
	
}
class Item extends Object
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