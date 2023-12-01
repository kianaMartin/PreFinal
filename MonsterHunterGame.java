package MonsterHunter;

import java.util.Random;

public class MonsterHunterGame extends UserChar{
    private Monster monster;
    private GameInterface gameInterface;
    private UserInput userInput;
    int playerHP = 1000;
    Random random = new Random();

    
    public MonsterHunterGame(Monster monster, GameInterface gameInterface, UserInput userInput) {
        this.monster = monster;
        this.gameInterface = gameInterface;
        this.userInput = userInput;
    }
    
    public void playSurvival() {
        initializeGame();

        while (!monster.isDefeated()) {
            int monttack = random.nextInt(400 - 200) + 200;
            System.out.println("Your HP is now: " + this.playerHP);
            gameInterface.displayMessage("What would you like to do? (1 - Attack, 2 - Heal)");
            String input = userInput.getInput();

            if (input.equals("1")) {
                int playerttack = monster.attack();
                gameInterface.displayMessage("The monster attacked you! You lost " + monttack + "HP");
                playerHP = attacked(this.playerHP, monttack);
                if (playerHP <= 0) {
                gameInterface.displayMessage("You died!");
                break;
            } 
                gameInterface.displayMessage("You attacked the monster! It lost " + playerttack + "HP");
                if (monster.isDefeated()) {
                gameInterface.displayMessage("Congratulations! You defeated the monster!");
                break;
            } 
                System.out.println("Monster's HP: " + monster.hp());
            } else if (input.equals("2")) {
                playerHP = heal(playerHP);
                gameInterface.displayMessage("You healed yourself. You regained 100HP. Your total HP"
                + " is now " + playerHP);
            } else {
                gameInterface.displayMessage("Invalid input. Please try again.");
                continue;
            }
        }
    }

    public void playStoryMode(){
         gameInterface.displayMessage("You are a brave hunter in a world filled with dangerous monsters.");
                gameInterface.displayMessage("Your village is under threat from a fearsome dragon known as Rathalos.");
                gameInterface.displayMessage("Your mission is to defeat Rathalos and save your village.");

                gameInterface.displayMessage("Before you embark on your journey, you must choose your weapon.");
                gameInterface.displayMessage("1. Great Sword");
                gameInterface.displayMessage("2. Long Sword");
                gameInterface.displayMessage("3. Bow");
                gameInterface.displayMessage("4. Dual Blades");

                String input = userInput.getInput();
                String weapon = "";
                switch (input) {
                    case "1":
                        weapon = "Great Sword";
                        break;
                    case "2":
                        weapon = "Long Sword";
                        break;
                    case "3":
                        weapon = "Bow";
                        break;
                    case "4":
                        weapon = "Dual Blades";
                        break;
                    default:
                        weapon = "Fists";
                        break;
                }
                gameInterface.displayMessage("You have chosen the " + weapon + " as your weapon of choice.");

                gameInterface.displayMessage("\nYou found a merchant as you were walking in the woods.");
                gameInterface.displayMessage("Merchant: Battle items for sale! Battle items for sale!");
                gameInterface.displayMessage("Will you approach the merchant or not? Press Y for yes and any other key for no.");
                char yesno = userInput.getInput().toUpperCase().charAt(0);
                
                if(yesno == 'Y'){
                gameInterface.displayMessage("Merchant: Welcome, Hunter! Browse my excellent items!"
                + " I will give one of them to you for free as thanks for your courage. \nChoose wisely!\nItems:");
                gameInterface.displayMessage("1. Lucky Charm");
                gameInterface.displayMessage("2. Love Potion");
                gameInterface.displayMessage("3. Can't-be-lost Compass");
                gameInterface.displayMessage("4. Map of Atlantis");
                String input2 = userInput.getInput();
                String item = "";
                switch (input2) {
                    case "1":
                        item = "Lucky Charm";
                        break;
                    case "2":
                        item = "Love Potion";
                        break;
                    case "3":
                        item = "Can't-be-lost Compass";
                        break;
                    case "4":
                        item = "Map of Atlantis";
                        break;
                    default:
                        gameInterface.displayMessage("You declined.");
                        break;
                }
                gameInterface.displayMessage("You have chosen the " + item + " as your weapon of choice.");
            }
            gameInterface.displayMessage("Having everything you need, "
            + "you set out on your quest to find Rathalos.");
    }
       
    private void initializeGame() {
        gameInterface.displayMessage("Welcome to Monster Hunter! A fearsome dragon lies ahead.");
        gameInterface.displayMessage("Your goal is to defeat the dragon before it defeats you.");
        gameInterface.displayMessage("Prepare yourself!");

        gameInterface.displayMessage("Let's begin the hunt!");
    }
}
