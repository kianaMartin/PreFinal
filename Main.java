package MonsterHunter;
public class Main {
    public static void main(String[] args) {
    	while(true) {
        Monster monster = new Dragon();
        GameInterface gameInterface = new ConsoleGameInterface();
        UserInput userInput = new ConsoleUserInput();
        MonsterHunterGame game = new MonsterHunterGame(monster, gameInterface, userInput);
        gameInterface.displayMessage("Enter your name: ");
        String name = userInput.getInput();
        gameInterface.displayMessage("Welcome to Monster Hunter!");
        gameInterface.displayMessage("Choose a mode:");
        gameInterface.displayMessage("1. Story Mode");
        gameInterface.displayMessage("2. Survival Mode");
        String input = userInput.getInput();
        gameInterface.displayMessage("Press P to start playing, " + name + ".");
        char play = userInput.getInput().toUpperCase().charAt(0);
        if(play == 'P'){
        if (input.equals("1")) {
            game.playStoryMode();
        } else if (input.equals("2")) {
            game.playSurvival();

        } else {
            gameInterface.displayMessage("Invalid input.");
        }
        gameInterface.displayMessage("Continue playing, Press y for yes, any key for no. ");
        char playcontinue = userInput.getInput().toUpperCase().charAt(0);
        if(playcontinue != 'Y'){
        gameInterface.displayMessage("Game exited. Thank you for playing.");
        break;
        }
    	}
    }
}
}