public class Character 
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
