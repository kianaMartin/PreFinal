package MonsterHunter;

import java.util.Random;

public class Dragon implements Monster {
    private int healthPoints;

    public Dragon() {
        this.healthPoints = 1000;
    }
public int hp(){
    return this.healthPoints;
}
    public int attack() {
        Random random = new Random();
    int playerttack = random.nextInt(600 - 200) + 200;
    healthPoints -= playerttack;
    return playerttack;
    }

    public boolean isDefeated() {
        return healthPoints <= 0;
    }
}
