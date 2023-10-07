import objects.*;

public class Main {
    public static void main(String[] args) {
        Player player = new Player("Player", 25, 20, 100, 10, 20);
        Monster monster = new Monster("Monster", 20, 15, 80, 8, 18);

        // Пример использования методов для боя между игроком и монстром
        while (player.isAlive() && monster.isAlive()) {
            player.attack(monster);
            if (monster.isAlive()) {
                monster.attack(player);
            }
        }

        if (player.isAlive()) {
            System.out.println("Игрок выиграл!");
        } else {
            System.out.println("Монстр победил!");
        }
    }
}
