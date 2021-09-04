package AdventureGame;

import java.util.Scanner;

public class Player {
  private int damage;
  private int health;
  private int orgHealth;
  private int money;
  private String name;
  private String charName;
  protected Scanner input = new Scanner(System.in);
  private Inventory inventory;

  public Player(String name){
      this.name = name;
      this.inventory = new Inventory();
  }
  public void selectChar(){
      GameChars[] charList = {new Samurai(), new Archer(), new Knight()};
      System.out.println("Karakterler");
      System.out.println("----------------------------------------------------------------");
        for (int i = 0; i < charList.length; i++) {
          System.out.println((i+1)+". "+charList[i].getName()+
                  "\t\t Hasar : "+charList[i].getDamage()+
                  "\t\t Sağlık : "+charList[i].getHealth()+
                  "\t\t Para : "+charList[i].getMoney());
        }
        System.out.println("----------------------------------------------------------------");
        System.out.print("Lütfen bir karakter giriniz : ");
        int selectChar = input.nextInt();
        switch (selectChar){
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
                break;
        }
     // System.out.println("Karakter : "+this.getCharName()+" Hasar : "+this.getDamage()
       //       +" Sağlık : "+this.getHealth()+" Para : "+this.getMoney());
  }
  public void initPlayer(GameChars gameChar){
      this.setDamage(gameChar.getDamage());
      this.setHealth(gameChar.getHealth());
      this.setOrgHealth(gameChar.getHealth());
      this.setMoney(gameChar.getMoney());
      this.setCharName(gameChar.getName());
  }
    public void printStatus(){
        System.out.println("Silah : "+this.getInventory().getWeapon().getName()+
                ", Zırh : "+this.getInventory().getArmor().getName()+
                ", Block : "+this.getInventory().getArmor().getBlock()+
                ", Hasarınız : "+this.getTotalDamage() +
                ", Sağlık : "+this.getHealth()+
                ", Para : "+this.getMoney());
    }
    public int getTotalDamage(){
        return damage +this.getInventory().getWeapon().getDamage();
    }
    public int getDamage() {
        return damage ;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
      if(health < 0 ){
          health = 0;
      }
      this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }

    public String getCharName() {
        return charName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public int getOrgHealth() {
        return orgHealth;
    }

    public void setOrgHealth(int orgHealth) {
        this.orgHealth = orgHealth;
    }
}
