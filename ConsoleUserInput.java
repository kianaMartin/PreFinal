package MonsterHunter;
import java.util.Scanner;
public class ConsoleUserInput implements UserInput {
    Scanner scanner = new Scanner(System.in);

    public String getInput() {
        return scanner.nextLine();
    }
}