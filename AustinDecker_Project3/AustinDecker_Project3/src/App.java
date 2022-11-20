import java.util.Scanner;

public class App{
    private static DataBaseAccess gameDataBase = new DataBaseAccess();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        
        boolean running = true;
        do {
            System.out.printf("----------------------------------------------------------------------------%n%n%n");
            System.out.printf("Options:%n");
            System.out.printf("\t0:Exit application%n");
            System.out.printf("\t1:Add new video game to database%n");
            System.out.printf("\t2:Remove video game from database%n");
            System.out.printf("\t3:Search database for video game%n");
            System.out.printf("\t4:Save database to file%n");
            System.out.printf("\t5:Load previously saved database from file%n");
            System.out.printf("%n%n%n----------------------------------------------------------------------------%n");
            
            switch (scanner.nextLine()) {
                case "0":
                    running = false;
                    break;
                case "1":
                    addNewGame();
                    break;
                case "2":
                    removeGame();
                    break;
                case "3":
                    searchDataBase();
                    break;
                case "4":
                    saveDataBaseToFile();
                    break;
                case "5":
                    loadDataBaseFromFile();
                    break;
                default:
                    System.out.println("The inputted value did not match any of the possible options listed above.");
                    break;
            }
        } 
        while (running);
        System.out.printf("Application will now close.%n");
        scanner.close();
    }
    private static void addNewGame(){

        String exitString = "";
        do{
            int videoGamePrice = 0;
            String videoGameName = "";
            boolean validPrice = false, validName = false;
            while(!(validPrice && validName)){
                System.out.println("What is the name of the video game that is to be added?");
                videoGameName = scanner.nextLine();
    
                if(!videoGameName.equals("")){
                    validName = true;
                }
                else{
                    System.out.println("That is not a valid value");
                }
    
                System.out.println("What is the price of the video game?");
                try {
                    videoGamePrice = Integer.parseInt(scanner.nextLine());
                    validPrice = true;
                }
                catch (NumberFormatException nfe) {
                    System.out.println("That is not a valid value.");
                }
            }
            VideoGame game = new VideoGame(videoGameName, videoGamePrice);
            gameDataBase.addEntry(game);

            System.out.printf("The new video game: %s has been added to the game database.%n", game.getName());
            System.out.println("Do you wish to add another game to the database? (Y/N)");
            exitString = scanner.nextLine().toUpperCase();

            if(!exitString.equals("Y"))
                exitString = "N";
        }while(exitString.equals("Y"));
        System.out.println("Returning to main menu.");
    }

    private static void removeGame(){
        do{
            String videoGameTitle = "";
            int videoGamePrice = 0;
            boolean validPrice = false, validName = false;

            while(!(validPrice && validName)){
                System.out.println("What is the name of the video game?");
                videoGameTitle = scanner.nextLine();
    
                System.out.println("What is the price of the video game?");
                try {
                    videoGamePrice = Integer.parseInt(scanner.nextLine());
                    if(videoGamePrice >= 0)
                        validPrice = true;
                    else
                        System.out.println("please put in a value greater than 0.");    
                } 
                catch (NumberFormatException nfe) {
                    System.out.println("The video game price was invalid.");
                }
    
                if(!videoGameTitle.equals(""))
                    validName = true;
                else{
                    System.out.println("Please put in something other than an empty string.");
                }
            }
            gameDataBase.removeEntry(new VideoGame(videoGameTitle, videoGamePrice));

            System.out.println("Would you like to remove another game from the database? (Y/N)");
            char ans = scanner.nextLine().toUpperCase().charAt(0);
            if(ans != 'Y')
                break;

        }while(true);
        
    }

    private static void searchDataBase(){
        //TODO
    }

    private static void saveDataBaseToFile(){
        //TODO
    }

    private static void loadDataBaseFromFile(){
        //TODO
    }
    
}
