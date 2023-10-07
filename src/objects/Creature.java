package objects;

import java.util.Random;

class Creature {
    private String name;
    private int attack;
    private int defense;
    private int maxHealth;
    private int health;
    private int minDamage;
    private int maxDamage;

    public Creature(String name, int attack, int defense, int maxHealth, int minDamage, int maxDamage) {
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
    }

    public int calculateAttackModifier(Creature target) {
        return this.attack - target.defense + 1;
    }

    public boolean isSuccessfulAttack(int attackModifier) {
        Random random = new Random();
        int numDice = Math.max(1, attackModifier);
        for (int i = 0; i < numDice; i++) {
            int roll = random.nextInt(6) + 1;
            if (roll >= 5) {
                return true;
            }
        }
        return false;
    }

    public void receiveDamage(int damage) {
        this.health = Math.max(0, this.health - damage);
    }

    public boolean isAlive() {
        return this.health > 0;
    }

    public void heal() {
        int maxHeal = (int) (0.3 * this.maxHealth);
        int healAmount = new Random().nextInt(maxHeal) + 1;
        this.health = Math.min(this.maxHealth, this.health + healAmount);
    }

    public void attack(Creature target) {
        int attackModifier = calculateAttackModifier(target);
        if (isSuccessfulAttack(attackModifier)) {
            int damage = new Random().nextInt(maxDamage - minDamage + 1) + minDamage;
            target.receiveDamage(damage);
        }
    }
}
