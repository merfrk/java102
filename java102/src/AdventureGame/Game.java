package AdventureGame;

import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);

    public void start(){
        System.out.println("Hoşgeldiniz !");
        System.out.print("İsim giriniz : ");
        String playerName = input.nextLine();
        Player player = new Player(playerName);
        System.out.println("Bu karanlık ormana hoşgeldin "+playerName);
        player.selectChar();
    }
}
