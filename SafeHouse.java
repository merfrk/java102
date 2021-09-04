package AdventureGame;

public class SafeHouse extends NormalLoc{
    public SafeHouse(Player player){
        super(player,"Güvenli Ev");
    }

    @Override
    boolean onLocation() {
        if(this.getPlayer().getInventory().isWater() && this.getPlayer().getInventory().isFirewood() && this.getPlayer().getInventory().isFood()){
            System.out.println("Tebrikler ! tüm ödülleri toplayıp güvenli eve dönerek Oyunu kazandınız !");
            return false;
        }
        System.out.println("Güvenli Evdesiniz !");
        this.getPlayer().setHealth(this.getPlayer().getOrgHealth());
        System.out.println("Canınız yenilendi !");
        return true;
    }
}
