import structures.*;

public class TestMain {
    
    static DataBaseAccess myGameDataBase = new DataBaseAccess();
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

        myGameDataBase.database.removeNodeWithData(new VideoGame("the witcher 3", 70));
        myGameDataBase.database.removeNodeWithData(new VideoGame("Darksouls", 35));
        myGameDataBase.database.removeNodeWithData(new VideoGame("Skyrim", 90));
        myGameDataBase.database.removeNodeWithData(new VideoGame("Minecraft", 27));
        myGameDataBase.database.removeNodeWithData(new VideoGame("Dark tide", 40));
        myGameDataBase.database.removeNodeWithData(new VideoGame("osu", 0));
        myGameDataBase.database.removeNodeWithData(new VideoGame("Fallout", 100));

        System.out.println("");
        System.out.println(myGameDataBase.database.toString());

        myGameDataBase.database.removeNodeWithData(new VideoGame("Elden ring", 69));

        System.out.println(myGameDataBase.database.isEmpty());
        System.out.println(myGameDataBase.database.toString());
       
        
    }
    
}
