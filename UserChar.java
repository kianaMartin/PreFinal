package MonsterHunter;

public class UserChar{
    int attacked(int playerHP, int monttack){

    playerHP -= monttack;
    return playerHP;
    }
    int heal(int playerHP){
        playerHP += 100;
        return playerHP;
    }
}