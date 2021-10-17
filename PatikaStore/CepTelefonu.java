package PatikaStore;

public class CepTelefonu extends Urun {
    private int pilGucu;
    private String renk;
    private int kamera;
    public CepTelefonu(int ID, double fiyat, double indirimOrani, int stokMiktari, String urunAdi, String markaAdi, int depolama, double ekranBoyutu, int ram, int pilGucu, String renk, int kamera) {
        super(ID, fiyat, indirimOrani, stokMiktari, urunAdi, markaAdi, depolama, ekranBoyutu, ram);
        this.pilGucu = pilGucu;
        this.renk = renk;
        this.kamera = kamera;
    }

    public int getPilGucu() {
        return pilGucu;
    }

    public void setPilGucu(int pilGucu) {
        this.pilGucu = pilGucu;
    }

    public String getRenk() {
        return renk;
    }

    public void setRenk(String renk) {
        this.renk = renk;
    }

    public int getKamera() {
        return kamera;
    }

    public void setKamera(int kamera) {
        this.kamera = kamera;
    }
}
