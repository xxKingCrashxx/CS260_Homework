import structures.*;

public class TestMain {
    
    static DataBaseAccess myGameDataBase = new DataBaseAccess();
    static DataBaseAccess myGameDataBase2 = new DataBaseAccess();
    public static void main(String[] args){
        myGameDataBase.addEntry(new VideoGame("the witcher 3", 70));
        myGameDataBase.addEntry(new VideoGame("Darksouls", 35));
        myGameDataBase.addEntry(new VideoGame("Skyrim", 90));
        myGameDataBase.addEntry(new VideoGame("Minecraft", 27));
        myGameDataBase.addEntry(new VideoGame("Dark tide", 40));
        myGameDataBase.addEntry(new VideoGame("osu", 0));
        myGameDataBase.addEntry(new VideoGame("Fallout", 100));
        myGameDataBase.addEntry(new VideoGame("Elden ring", 69));

        System.out.println(myGameDataBase.database.toString());
        myGameDataBase.database.printTreeDiagram();

        DataBaseAccess.saveDataBaseToFile(myGameDataBase);
        DataBaseAccess.loadDataBaseFromFile(myGameDataBase2);

        myGameDataBase.removeEntry(new VideoGame("Elden ring", 69));

        myGameDataBase2.database.printTreeDiagram();
        System.out.println(myGameDataBase2.database.toString());

        
       
        
    }
    
}
