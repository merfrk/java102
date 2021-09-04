package AdventureGame;

import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);

    public void start(){
        System.out.println("Hoşgeldiniz !");
        System.out.print("İsim giriniz : ");
        String playerName = input.nextLine();
        Player player = new Player(playerName);
        System.out.println("Bu karanlık adaya hoşgeldin "+playerName);
        player.selectChar();

        Location location = null;
        while(true){
            player.printStatus();
            System.out.println();
            System.out.println("############ Bölgeler ############");
            System.out.println();
            System.out.println("1 - Güvenli Ev --> Burası sizin için güvenli bir ev, burada düşman yok !");
            System.out.println("2 - Eşya Dükkanı --> Buradan silah veya zırh satın alabilirsiniz !");
            System.out.println("3 - Mağara --> Ödül <yemek>, Dikkatli ol zombi çıkabilir !");
            System.out.println("4 - Orman --> Ödül <odun>, Dikkatli ol karşına vampir çıkabilir !");
            System.out.println("5 - Nehir --> Ödül <su>, Dikkatli ol karşına ayı çıkabilir !");
            System.out.println("0 - Çıkış Yap --> Oyunu sonlandır !");
            System.out.print("Lütfen gitmek istediğiniz bölgeyi seçiniz : ");
            int selectCase = input.nextInt();
            switch (selectCase){
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    if(player.getInventory().isFood()){
                        System.out.println("Mağara bölgesini zaten tamamladınız lütfen başka bir bölge seçiniz !");
                        continue;
                    }
                    location = new Cave(player);
                    break;
                case 4:
                    if(player.getInventory().isFirewood()){
                        System.out.println("Orman bölgesini zaten tamamladınız lütfen başka bir bölge seçiniz !");
                        continue;
                    }
                    location = new Forest(player);
                    break;
                case 5:
                    if(player.getInventory().isWater()){
                        System.out.println("Nehir bölgesini zaten tamamladınız lütfen başka bir bölge seçiniz !");
                        continue;
                    }
                    location = new River(player);
                    break;
                default:
                    System.out.println("Lütfen geçerli bir bölge giriniz !");
                    break;
            }
            if(location == null){
                System.out.println("Oyun bitti görüşmek üzere.");
                break;
            }
            if(!location.onLocation()){
                if(location.getName().equals("Güvenli Ev")){
                    break;
                }
                System.out.println("Game Over!");
                break;
            }
        }
    }
}
