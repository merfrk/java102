package AdventureGame;

import java.util.Random;

public class BattleLoc extends Location{
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;
    public BattleLoc(Player player , String name, Obstacle obstacle, String award, int maxObstacle){
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }

    @Override
    public boolean onLocation(){
        int obsNumber = this.randomObstacleNumber();
            if(this.getObstacle().getId() == 4){
                Random rand = new Random();
                int x = rand.nextInt(4) + 3;
                this.getObstacle().setDamage(x);
            }
        System.out.println("Suan buradasınız --> "+this.getName());
        System.out.println("Dikkatli Ol ! Burada "+obsNumber+" tane "+this.getObstacle().getName()+" yaşıyor !");
        System.out.print("<S>avaş veya <K>aç : ");
        String selectCase = input.nextLine();
        selectCase = selectCase.toUpperCase();
        if(selectCase.equals("S")){
            if(combat(obsNumber)) {
                System.out.println(this.getName()+" içindeki tüm düşmanları yendiniz");

                switch (this.getObstacle().getId()){
                    case 1:
                        this.getPlayer().getInventory().setFood(true);
                        break;
                    case 2:
                        this.getPlayer().getInventory().setFirewood(true);
                        break;
                    case 3:
                        this.getPlayer().getInventory().setWater(true);
                        break;
                    default:
                        break;
                }
                return true;
            }
        }
        if(this.getPlayer().getHealth() <= 0){
            System.out.println("Öldünüz");
            return false;
        }
        return true;
    }
    public boolean combat(int obsNumber){
        for (int i = 1; i <= obsNumber; i++) {
            this.getObstacle().setHealth(this.getObstacle().getOrgHealth());
            playerStats();
            obstacleStats(i);
            while(this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0){
                System.out.print("<V>ur veya <K>aç : ");
                String selectCombat = input.nextLine().toUpperCase();
                Random r = new Random();
                if(r.nextBoolean()){
                    if(selectCombat.equals("V")){
                        System.out.println("Siz vurdunuz !");
                        this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
                        afterHit();
                        if(this.getObstacle().getHealth() > 0){
                            System.out.println();
                            System.out.println("Canavar size vurdu");
                            int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                            if(obstacleDamage < 0) {
                                obstacleDamage = 0;
                            }
                            this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                            afterHit();
                        } else {
                            System.out.println("Canavarı öldürdünüz");
                            snakeItems();
                            System.out.println("###############");
                        }
                    }else {
                        return false;
                    }
                } else{
                    if(selectCombat.equals("V")){
                        if(this.getObstacle().getHealth() > 0){
                            System.out.println("Canavar size vurdu");
                            int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                            if(obstacleDamage < 0) {
                                obstacleDamage = 0;
                            }
                            this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                            afterHit();
                        }
                        System.out.println("Siz vurdunuz !");
                        this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
                        afterHit();
                        if(this.getObstacle().getHealth() == 0){
                            System.out.println("Canavarı öldürdünüz");
                            snakeItems();
                            System.out.println("###############");
                        }
                    }  else {
                        return false;
                    }
                }

            }
                if(this.getObstacle().getHealth() < this.getPlayer().getHealth()){
                    System.out.println("Düşmanı yendiniz !");
                    System.out.println(this.getObstacle().getAward()+" para kazandınız");
                    this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
                    System.out.println("Güncel paranız : "+this.getPlayer().getMoney());
                }else {
                    return false;
                }
        }
        return true;
    }
    public void snakeItems(){
        if(this.getObstacle().getId() == 4){
            Random rnd = new Random();
            int x = rnd.nextInt(100) + 1;
            if(x <= 15){
                int y = rnd.nextInt(100) + 1;
                if(y <= 20){
                    System.out.println("Yılandan Tüfek düştü");
                    this.getPlayer().getInventory().setWeapon(Weapon.getWeaponObjByID(3));
                }
                else if(y <= 50){
                    System.out.println("Yılandan Kılıç düştü");
                    if(this.getPlayer().getInventory().getWeapon().getId() != 3){
                        this.getPlayer().getInventory().setWeapon(Weapon.getWeaponObjByID(2));
                    }
                }
                else{
                    System.out.println("Yılandan Tabanca düştü");
                    if(this.getPlayer().getInventory().getWeapon().getId() == -1){
                        this.getPlayer().getInventory().setWeapon(Weapon.getWeaponObjByID(1));
                    }
                }
            }
            else if(x <= 30){
                int z = rnd.nextInt(100) + 1;
                if(z <= 20){
                    System.out.println("Yılandan Ağır Zırh düştü");
                    this.getPlayer().getInventory().setArmor(Armor.getArmorObjByID(3));
                }
                else if(z <= 50){
                    System.out.println("Yılandan Orta Zırh düştü");
                    if(this.getPlayer().getInventory().getArmor().getId() != 3){
                        this.getPlayer().getInventory().setArmor(Armor.getArmorObjByID(2));
                    }
                }
                else{
                    System.out.println("Yılandan Hafif Zırh düştü");
                    if(this.getPlayer().getInventory().getArmor().getId() == -1){
                        this.getPlayer().getInventory().setArmor(Armor.getArmorObjByID(1));
                    }
                }
            }
            else if(x <= 55){
                int a = rnd.nextInt(100) + 1;
                if(a <= 20){
                    System.out.println("Yılandan 10 para düştü");
                    this.getPlayer().setMoney(this.getPlayer().getMoney() + 10);
                }
                else if(a <= 50){
                    System.out.println("Yılandan 5 para düştü");
                    this.getPlayer().setMoney(this.getPlayer().getMoney() + 5);
                }
                else{
                    System.out.println("Yılandan 1 para düştü");
                    this.getPlayer().setMoney(this.getPlayer().getMoney() + 1);
                }
            }
            else {
                System.out.println("Yılandan hiçbir şey düşmedi :(");
            }
        }
    }
    public void afterHit(){
        System.out.println("Canınız : "+this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName()+" Canı "+this.getObstacle().getHealth());
        System.out.println("--------------");
    }
    public void playerStats(){
        System.out.println("Oyuncu Değerleri");
        System.out.println("---------------");
        System.out.println("Sağlık : "+this.getPlayer().getHealth());
        System.out.println("Silah : "+this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Hasar : "+this.getPlayer().getTotalDamage());
        System.out.println("Zırh : "+this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Blocklama : "+this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Para : "+this.getPlayer().getMoney());
    }
    public void obstacleStats(int i){
        System.out.println(i+". "+this.getObstacle().getName()+" Değerleri");
        System.out.println("-----------------------------");
        System.out.println("Sağlık : "+this.getObstacle().getHealth());
        System.out.println("Hasar : "+this.getObstacle().getDamage());
        System.out.println("Ödül : "+this.getObstacle().getAward());
    }

    public int randomObstacleNumber(){
        Random r = new Random();
        return r.nextInt(this.getMaxObstacle()) + 1;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
}
